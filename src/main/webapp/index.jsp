<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sober
  Date: 2017/3/6
  Time: 下午3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stay sober ---- gallery</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
    <noscript><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/noscript.css" /></noscript>
</head>

<body class="is-loading-0 is-loading-1 is-loading-2">
<iframe frameborder="no" border="0" marginwidth="0" marginheight="0"
        width=330 height=86 src="//music.163.com/outchain/player?type=2&id=33233915&auto=1&height=66"></iframe>
<!-- Main -->
<div id="main">

    <!-- Header -->
    <header id="header">
        <h1>Sober</h1>
        <p> <a href="http://www.waitsober.com">熬夜的瘾和遥远的你</a>-->blog</p>
        <ul class="icons">
            <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
            <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
            <li><a href="#" class="icon fa-github"><span class="label">Github</span></a></li>
            <li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
        </ul>
    </header>

    <!-- Thumbnail -->
    <section id="thumbnails">
        <c:forEach items="${imageList}" var="image">
            <article>
                <a class="thumbnail" href="${image.url}" data-position="left center"><img src="${image.url}" alt="" /></a>
                <h2>${image.title}</h2>
                <p>${image.description}</p>
            </article>
        </c:forEach>
    </section>

    <!-- Footer -->
    <footer id="footer">
        <ul class="copyright">
            <li>&copy; Untitled.</li><li>Design: <a href="http://www.waitsober.com">Sober</a>.</li>
        </ul>
        <ul class="copyright">
            <li><a href="${pageContext.request.contextPath}/image/manager">manager</a></li>
        </ul>
    </footer>

</div>

<!-- Scripts -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>

</body>
</html>