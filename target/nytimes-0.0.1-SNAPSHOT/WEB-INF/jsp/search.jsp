<%@ page language="java"
	import="java.util.ArrayList,com.nytimes.pojo.Articles,com.nytimes.pojo.Docs"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Article Search</title>
</head>
<body>
	<jsp:include page="/index.jsp" />
	<div class="container" style="padding: 0px 80px;">
		<div class="span-20">
			<c:if test="${requestScope.articles!=null}">
				<ul>
					<c:forEach items="${requestScope.articles.getResponse().getDocs()}"
						var="docs">
						<li><a href="${docs.getWeb_url()}">${docs.getHeadline().getMain()}</a></li>
						<b>Keywords: </b>
						<c:forEach items="${docs.getKeywords()}" var="keywords">${keywords.getValue()}&emsp;</c:forEach>
						<br />
						<b>Snippet: </b>${docs.getSnippet()}<br />
	      ${docs.getPub_date()} &emsp;&emsp; Source:&nbsp;${docs.getSource()}<br />
						<br />
					</c:forEach>
				</ul>
			</c:if>
			<c:if test="${sessionScope.params.get('page')!=0}">
				<a href="page.html?a=p">Previous</a>
			</c:if>
			<c:if
				test="${sessionScope.params.get('page')<(articles.getResponse().getMeta().getHits()/10)-1}">
				<a style="float: right" href="page.html?a=n">Next</a>
			</c:if>
		</div>
	</div>
</body>
</html>