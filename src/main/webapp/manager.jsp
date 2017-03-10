<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sober
  Date: 2017/3/6
  Time: 下午5:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gallery管理中心</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
</head>
<body>
    <center>
        <div>
            <a href="${pageContext.request.contextPath}/upload.jsp">上传图片到相册请点这里<--</a>
        </div>
                </br>
                </br>
                </br>
        <div>
            <c:forEach items="${imageList}" var="image">

                <div>
                    <form action="${pageContext.request.contextPath}/image/update" method="get">
                    <span>
                       <img src="${pageContext.request.contextPath}/${image.url}" alt="" width="220" height="160"/>
                    </span>
                    <span>
                        <div>图片标题:   <input type="text" id="title" name="title" value="${image.title}"></div>
                        <div>图片描述:   <input type="text" id="desc" name="description" value="${image.description}"></div>
                        <div><a>图片名称:   <input type="text" name="name" value="${image.name}"></a></div>
                        <input type="hidden" name="id" value="${image.id}">
                        &nbsp;<input type="submit" value="修改"/>
                        &nbsp;<a href="${pageContext.request.contextPath}/image/delete?id=${image.id}" >删除</a>
                    </span>
                </form>

                </div>

            </c:forEach>
        </div>
</center>
</body>
</html>
