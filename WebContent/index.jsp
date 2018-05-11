<%@ page language="java"
	import="java.util.HashMap,com.nytimes.pojo.Articles"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Article Search</title>
<!-- Framework CSS -->
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
	width: 500px;
	display: block;
}

.center {
	text-align: center;
}

label {
	display: inline-block;
	width: 140px;
	text-align: right;
}
</style>
</head>
<body>
	<div class="container" style="padding: 50px 80px 20px;">
		<div class="span-20">
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
	</div>
</body>
</html>