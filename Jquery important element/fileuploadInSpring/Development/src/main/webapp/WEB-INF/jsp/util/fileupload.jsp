<%--
  Created by IntelliJ IDEA.
  User: reve
  Date: 7/15/2018
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="width:55%">
    <h1> Progress Bar</h1>
    <div id='progressBar' style='height: 20px; border: 2px solid green; margin-bottom: 20px'>
        <div id='bar' style='height: 100%; background: #33dd33; width: 0%'>
        </div>
    </div>
    <form style="margin-bottom: 20px">
        <input type="file" id="files" multiple style="margin-bottom: 20px"/><br/>
        <output id="selectedFiles"></output>
        <input type="text" id="topic">
        <input type="text" id="meeting">
        <input id="uploadButton" type="button" value="Upload" style="margin-top: 20px"/>
    </form>
    <div id='debug' style='height: 100px; border: 2px solid #ccc; overflow: auto'></div>

    <div>
        <div>Uploaded files:</div>
        <c:forEach var="fi" items="${files}">
            <div>
                    ${fi.getName()}
            </div>
        </c:forEach>

    </div>
</div>


<script>
    var totalFileLength, totalUploaded, fileCount, filesUploaded,percentageComplete,lastPercentageComplete;
    //To log everything on console
    function debug(s) {
        var debug = document.getElementById('debug');
        if (debug) {
            debug.innerHTML = debug.innerHTML + '<br/>' + s;
        }
    }

    //Will be called when upload is completed
    function onUploadComplete() {
        totalUploaded += document.getElementById('files').files[filesUploaded].size;
        filesUploaded++;
        lastPercentageComplete = percentageComplete;
        console.log(lastPercentageComplete);
        debug('complete ' + filesUploaded + " of " + fileCount);
        debug('totalUploaded: ' + totalUploaded);
        if (filesUploaded < fileCount) {
            uploadNext();
        } else {
            var bar = document.getElementById('bar');
            bar.style.width = '100%';
            bar.innerHTML = '100% complete';
            alert('Finished uploading file(s)');
        }
    }

    //Will be called when user select the files in file control
    function onFileSelect(e) {
        var files = e.target.files; // FileList object
        var output = [];
        fileCount = files.length;
        totalFileLength = 0;
        for (var i = 0; i < fileCount; i++) {
            var file = files[i];
            output.push(file.name, ' (', file.size, ' bytes, ', file.lastModifiedDate.toLocaleDateString(), ')');
            output.push('<br/>');
            debug('add ' + file.size);
            totalFileLength += file.size;
        }
        document.getElementById('selectedFiles').innerHTML = output.join('');
        debug('totalFileLength:' + totalFileLength);
    }

    //This will continueously update the progress bar
    function onUploadProgress(e) {
        if (e.lengthComputable) {
            percentageComplete = (e.loaded + totalUploaded) * 100 / totalFileLength;
            var bar = document.getElementById('bar');
            bar.style.width = percentageComplete + '%';
            bar.innerHTML = percentageComplete + ' % complete';
        } else {
            debug('unable to compute');
        }
    }

    //the Ouchhh !! moments will be captured here
    function onUploadFailed() {
     //   alert("Error uploading file");
        filesUploaded--;
        totalUploaded -= document.getElementById('files').files[filesUploaded].size;

        var bar = document.getElementById('bar');
        bar.style.width = lastPercentageComplete + '%';
        bar.innerHTML = lastPercentageComplete + ' % complete';
        uploadNext();
    }

    //Pick the next file in queue and upload it to remote server
    function uploadNext() {
        var xhr = new XMLHttpRequest();
        var fd = new FormData();
        var file = document.getElementById('files').files[filesUploaded];
        fd.append("multipartFile", file);
        fd.append("kope","kope");
        fd.append("hope","hope");
        xhr.upload.addEventListener("progress", onUploadProgress, false);
        xhr.addEventListener("load", onUploadComplete, false);
        xhr.addEventListener("error", onUploadFailed, false);
        xhr.open("POST", "save-file");
        xhr.timeout = 0;
        debug('uploading ' + file.name);
        xhr.send(fd);
    }

    //Let's begin the upload process
    function startUpload() {
        totalUploaded = filesUploaded = 0;
        uploadNext();
    }

    //Event listeners for button clicks
    window.onload = function() {
        document.getElementById('files').addEventListener('change', onFileSelect, false);
        document.getElementById('uploadButton').addEventListener('click', startUpload, false);
    }
</script>
</body>
</html>
