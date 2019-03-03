package com.nytimes.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.nytimes.DAO.ArticlesDAO;
import com.nytimes.pojo.Articles;

@Controller
public class MainController {
	private Articles articles;
	private ArrayList<NameValuePair> nvps;
	private HashMap<String, String> params;
	@Autowired
	private ArticlesDAO articlesDAO;

	@RequestMapping("/search")
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		nvps = new ArrayList<>();
		params = new HashMap<String, String>();
		String q = request.getParameter("q");
		BasicNameValuePair param;
		if (q != "") {
			param = new BasicNameValuePair("q", q);
			nvps.add(param);
			params.put("q", q);
		}
		String fq = request.getParameter("fq");
		if (fq != "") {
			param = new BasicNameValuePair("fq", fq);
			nvps.add(param);
			String fq1 = fq.replaceAll("\"", "&quot;");
			params.put("fq", fq1);
		}
		String begin_date = request.getParameter("begin_date");
		if (begin_date != "") {
			param = new BasicNameValuePair("begin_date", begin_date);
			nvps.add(param);
			params.put("begin_date", begin_date);
		}
		String end_date = request.getParameter("end_date");
		if (end_date != "") {
			param = new BasicNameValuePair("end_date", end_date);
			nvps.add(param);
			params.put("end_date", end_date);
		}

		String sort = request.getParameter("sort");
		param = new BasicNameValuePair("sort", sort);
		nvps.add(param);
		params.put("sort", sort);

		String page = request.getParameter("page");
		if (page == "") {
			page = "0";
		}
		param = new BasicNameValuePair("page", page);
		nvps.add(param);
		params.put("page", page);

		param = new BasicNameValuePair("api-key", "urmfpagVIGLQH8Sg3iqYP6lfE3ImmjGB");
		nvps.add(param);

		getArticles();
		HttpSession session = request.getSession();
		session.setAttribute("params", params);
		articlesDAO.addArticles(articles);
		return new ModelAndView("search", "articles", articles);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/page")
	public ModelAndView pageRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		nvps = new ArrayList<>();
		HttpSession session = request.getSession();
		params = (HashMap<String, String>) session.getAttribute("params");
		BasicNameValuePair param;
		for (String key : params.keySet()) {
			if (key.equals("page")) {
				if (request.getParameter("a").equals("p")) {
					int p = Integer.parseInt(params.remove(key));
					params.put(key, String.valueOf(p - 1));
				}
				if (request.getParameter("a").equals("n")) {
					int p = Integer.parseInt(params.remove(key));
					params.put(key, String.valueOf(p + 1));
				}
			}
			param = new BasicNameValuePair(key, params.get(key));
			nvps.add(param);
		}
		param = new BasicNameValuePair("api-key", "urmfpagVIGLQH8Sg3iqYP6lfE3ImmjGB");
		nvps.add(param);
		getArticles();
		session.setAttribute("params", params);
		articlesDAO.addArticles(articles);
		return new ModelAndView("search", "articles", articles);
	}

	public void getArticles() {
		StringBuffer result = new StringBuffer();
		try {
			URIBuilder uri = new URIBuilder("http://api.nytimes.com/svc/search/v2/articlesearch.json");
			CloseableHttpClient httpclient = HttpClients.createDefault();
			uri.setParameters(nvps);
			System.out.println(uri.build());
			HttpGet httpGet = new HttpGet(uri.build());
			CloseableHttpResponse response = httpclient.execute(httpGet);
			System.out.println(response.getStatusLine());
			HttpEntity entity = response.getEntity();
			if (null != entity) {
				InputStream in = entity.getContent();
				InputStreamReader inreader = new InputStreamReader(in);
				BufferedReader reader = new BufferedReader(inreader);
				String s;
				while (((s = reader.readLine()) != null)) {
					result.append(s);
				}
				reader.close();
				Gson gson = new Gson();
				articles = gson.fromJson(result.toString(), Articles.class);
			}
			EntityUtils.consume(entity);
			response.close();
			httpclient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}