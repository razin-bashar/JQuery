 $.ajax({
    type:"POST",
    url : "<%=request.getContextPath()%>/upazillalistbydistrictid",
    data : {
        id: $(this).val()
    },
    async: false,
    success : function(response) {
        data = response;
        return response;
    },
    error: function() {
        alert('Error occured');
    }
});