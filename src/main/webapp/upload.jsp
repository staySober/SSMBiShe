<%--
  Created by IntelliJ IDEA.
  User: sober
  Date: 2017/3/10
  Time: 上午9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- release v4.3.6, copyright 2014 - 2017 Kartik Visweswaran -->
<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <title>Sober GalleryBackend</title>
        <link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/default.css">
        <link href="./css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
        <script src="./js/jquery.js" type="text/javascript"></script>
        <script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
        <script src="./js/fileinput.js" type="text/javascript"></script>
        <!--简体中文-->
        <script src="./js/locales/zh.js" type="text/javascript"></script>
        <!--繁体中文-->
        <script src="./js/locales/zh-TW.js" type="text/javascript"></script>
        <script src="http://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
            <div class="htmleaf-container">
                <header class="htmleaf-header">
                    <h1>基于Bootstrap Sober Gallery upload Center </h1>
                </header>
                <div class="container kv-main">
                    <div class="page-header">
                    <hr>
                    <h4>支持多种语言</h4>
                    <form enctype="multipart/form-data" method="post">
                        <label>简体中文</label>
                        <input id="file-zh" name="uploadFile" type="file" multiple>
                        <div>标题摘要:<input type="text" name="title"/></div>
                        <div>照片描述:<input type="text" name="description"></div>
                        <hr style="border: 2px dotted">
                        <label>繁体中文</label>
                        <input id="file-zh-TW" name="uploadFile" type="file" multiple>
                    </form>
                    <hr>
                    <br>
                    </div>
                 </div>
            </div>
    </body>
	<script>
    $('#file-zh').fileinput({
        language: 'zh',
        uploadUrl: '${pageContext.request.contextPath}/image/upload',
        allowedFileExtensions : ['jpg', 'png','gif'],
    });
    $('#file-zh-TW').fileinput({
        language: 'zh-TW',
        uploadUrl: '${pageContext.request.contextPath}/image/upload',
        allowedFileExtensions : ['jpg', 'png','gif'],
    });
    $(document).ready(function() {
        $("#test-upload").fileinput({
            'showPreview' : false,
            'allowedFileExtensions' : ['jpg', 'png','gif'],
            'elErrorContainer': '#errorBlock'
        });
    });
	</script>
</html>