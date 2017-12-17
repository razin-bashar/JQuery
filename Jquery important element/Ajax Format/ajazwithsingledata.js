
var formdata = new FormData();

formdata.append("file", file);
                    
$.ajax({
        type: "POST",
        processData: false,
        contentType: false,
        url: "<%=request.getContextPath()%>/imagechange",
        data: formdata,
        async: false,
        success: function (response) {
                alert("sucess");
        },
        error: function () {
                alert('Error occured');
        }
});