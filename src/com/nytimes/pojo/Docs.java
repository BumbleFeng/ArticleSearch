package com.nytimes.pojo;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Docs {
	private String web_url;
	private String snippet;
	@SerializedName("abstract")
	private String brief;
	private String lead_paragraph;
	private String print_page;
	private String source;
	private Blog blog;
	private Headline headline;
	private ArrayList<Keywords> keywords;
	private String pub_date;
	private String document_type;
	private String news_desk;
	private String section_name;
	private String subsection_name;
	private Byline byline;
	private String type_of_material;
	private String _id;
	private int word_count;
	private Double score;
	private String uri;
	private String slideshow_credits;
	private ArrayList<Multimedia> multimedia;

	public Docs() {
	}

	public String getWeb_url() {
		return web_url;
	}

	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getLead_paragraph() {
		return lead_paragraph;
	}

	public void setLead_paragraph(String lead_paragraph) {
		this.lead_paragraph = lead_paragraph;
	}

	public String getPrint_page() {
		return print_page;
	}

	public void setPrint_page(String print_page) {
		this.print_page = print_page;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Headline getHeadline() {
		return headline;
	}

	public void setHeadline(Headline headline) {
		this.headline = headline;
	}

	public ArrayList<Keywords> getKeywords() {
		return keywords;
	}

	public void setKeywords(ArrayList<Keywords> keywords) {
		this.keywords = keywords;
	}

	public String getPub_date() {
		return pub_date;
	}

	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public String getNews_desk() {
		return news_desk;
	}

	public void setNews_desk(String news_desk) {
		this.news_desk = news_desk;
	}

	public String getSection_name() {
		return section_name;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public String getSubsection_name() {
		return subsection_name;
	}

	public void setSubsection_name(String subsection_name) {
		this.subsection_name = subsection_name;
	}

	public Byline getByline() {
		return byline;
	}

	public void setByline(Byline byline) {
		this.byline = byline;
	}

	public String getType_of_material() {
		return type_of_material;
	}

	public void setType_of_material(String type_of_material) {
		this.type_of_material = type_of_material;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int getWord_count() {
		return word_count;
	}

	public void setWord_count(int word_count) {
		this.word_count = word_count;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getSlideshow_credits() {
		return slideshow_credits;
	}

	public void setSlideshow_credits(String slideshow_credits) {
		this.slideshow_credits = slideshow_credits;
	}

	public ArrayList<Multimedia> getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(ArrayList<Multimedia> multimedia) {
		this.multimedia = multimedia;
	}

}