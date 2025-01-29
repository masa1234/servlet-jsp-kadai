<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>Servlet/JSPの基礎を学ぼう</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/link?name=侍太郎">名前「侍太郎」をServletに送信</a>
	<br>
	<%
	String name = (String) request.getAttribute("name");
	if (name != null) {
	%>
	Servletからデータを受信しました：<%=name%>さん、こんにちは!
	<%
	}
	%>
</body>
</html>