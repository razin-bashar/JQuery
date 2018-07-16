<%--
  Created by IntelliJ IDEA.
  User: reve
  Date: 7/15/2018
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>Upload</title>
    <!-- production -->
    <script type="text/javascript" src="assets/js/fileupload/plupload.full.min.js"></script>
    <!-- debug
    <script type="text/javascript" src="../js/moxie.js"></script>
    <script type="text/javascript" src="../js/plupload.dev.js"></script>
    -->
</head>
<body style="font: 13px Verdana; background: #eee; color: #333">
<div id="filelist"></div>
<br />
<button id="pickfiles" >Select file</button>
<button id="uploadfiles" >Upload</button>
<div id="container">
</div>
<br />
<pre id="console"></pre>
<script type="text/javascript">
    // Custom example logic
    var uploader = new plupload.Uploader({
        runtimes : 'html5',
        browse_button : 'pickfiles', // you can pass an id...
        container: document.getElementById('container'), // ... or DOM Element itself
        url : '/UploadFile',//upload.php
        chunk_size : '1mb',
        method:'POST',
        flash_swf_url : 'js/Moxie.swf',
        silverlight_xap_url : 'js/Moxie.xap',

        filters : {
            max_file_size : '100gb',
            mime_types: [
                {title : "Image files", extensions : "jpg,gif,png"},
                {title : "Zip files", extensions : "zip,txt,vmdk"}
            ]
        },
        init: {
            PostInit: function() {
                document.getElementById('filelist').innerHTML = '';
                document.getElementById('uploadfiles').onclick = function() {
                    uploader.start();
                    return false;
                };
            },
            FilesAdded: function(up, files) {
                plupload.each(files, function(file) {
                    document.getElementById('filelist').innerHTML += '<div id="' + file.id + '">' + file.name + ' (' + plupload.formatSize(file.size) + ') <b></b></div>';
                });
            },
            UploadProgress: function(up, file) {
                document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
            },
            Error: function(up, err) {
                document.getElementById('console').appendChild(document.createTextNode("\nError #" + err.code + ": " + err.message));
            }
        }
    });
    uploader.init();
</script>
</body>
</html>
