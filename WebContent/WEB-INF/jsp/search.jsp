<%@ page language="java"
	import="java.util.ArrayList,com.nytimes.pojo.Articles,com.nytimes.pojo.Docs"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Article Search</title>
<link rel="stylesheet" href="css/blueprint/screen.css" type="text/css"
	media="screen, projection">
<link rel="stylesheet" href="css/blueprint/print.css" type="text/css"
	media="print">
<link rel="stylesheet"
	href="css/blueprint/plugins/fancy-type/screen.css" type="text/css"
	media="screen, projection">
<style type="text/css">
table, th, td {
	border: 1px solid black;
}

.block {
	width: 470px;
	display: block;
}

.center {
	text-align: center;
}

label {
	display: inline-block;
	width: 130px;
	text-align: right;
}
</style>
</head>
<body>
	<div class="container" style="padding: 50px 0px 20px;">
		<div class="span-7">
			<form action="search.html" method="post">
				<div class="block">
					<label>Search query term:</label> <input type="text" name="q"
						value="${sessionScope.params.get('q')}" />
				</div>
				<div class="block">
					<label>Filtered search query:</label> <input type="text" name="fq"
						placeholder="Lucene syntax"
						value="${sessionScope.params.get('fq')}" />
				</div>
				<div class="block">
					<label>Begin Date:</label> <input type="text" name="begin_date"
						placeholder="YYYYMMDD"
						value="${sessionScope.params.get('begin_date')}" />
				</div>
				<div class="block">
					<label>End Date:</label> <input type="text" name="end_date"
						placeholder="YYYYMMDD"
						value="${sessionScope.params.get('end_date')}" />
				</div>
				<div class="block">
					<label>Sort:</label> <select name="sort">
						<option value="newest">Newest</option>
						<option value="oldest">Oldest</option>
					</select>
				</div>
				<div class="block">
					<label>Page:</label> <input type="text" name="page"
						value="${sessionScope.params.get('page')}" />
				</div>
				<div class="block center">
					<input type="submit" value="Search">
				</div>
			</form>
		</div>
		<div class="span-16">
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