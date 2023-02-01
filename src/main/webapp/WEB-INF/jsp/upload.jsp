<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Upload File Request Page</title>
    <link rel="stylesheet" href="/resources/css/dropzone.css">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container" style="margin-top: 60px;">
        <div class="col-md-6">
            <h2>Upload a file...</h2>
            <form:form action="uploadFile" method="post" enctype="multipart/form-data" cssClass="dropzone" id="my-awesome-dropzone">
                <div class="input-group">
                    <input type="file" name="file" class="form-control" id="" />
                </div>
                <br>
                <button type="submit" class="btn btn-info">Upload</button>
            </form:form>
        </div>
    </div>
    <script src="/resources/js/dropzone.js"></script>
        <script>
            Dropzone.options.myAwesomeDropzone = {
                maxFileSize: 3,
                acceptedFiles: "image/*",
                dictDefaultMessage: "Click hoặc kéo tjer file",
                dictInvalidFileType: "Tối đa 3MB"
            }
        </script>
</body>

</html>