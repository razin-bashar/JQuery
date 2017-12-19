 
 
 //html
  <table class="table  table-striped table-bordered table-hover" id="sample_1">

  </table>
 
 //javascript
 var table = $('#sample_1').dataTable({
        "bServerSide": true,
        "sDom": '<"row header"<" col-md-8 pull-left" <"displayinline"l><"displayinline"i>><"col-md-4 pull-right toolbar">><"minheight"t><"row footer"<"text-center"p>>',
        "sPaginationType": "full_numbers",
        "sEcho": 1,
        "language":{
            "decimal":        "১",
            "emptyTable":     "ইউনিয়ন খুজে পাওয়া যায় নাই",
            "info":           " মোট _TOTAL_ ইউনিয়ন এর মধ্যে _START_ থেকে _END_ পর্যন্ত দেখানো হচ্ছে",
            "infoEmpty":      "ইউনিয়ন খুজে পাওয়া যায় নাই",
            "infoFiltered":   "(filtered from _MAX_ total entries)",
            "infoPostFix":    "",
            "thousands":      ",",
            "lengthMenu":     "_MENU_",
            "loadingRecords": "Loading...",
            "processing":     "Processing...",
            "search":         "Search:",
            "zeroRecords":    "ইউনিয়ন খুজে পাওয়া যায় নাই",
            "paginate": {
                "first":      "প্রথম",
                "last":       "শেষ",
                "next":       "পরে",
                "previous":   "আগে"
            },
            "aria": {
                "sortAscending":  ": activate to sort column ascending",
                "sortDescending": ": activate to sort column descending"
            }
        },
         <%--"ajax": {--%>
             <%--"url": "<%=request.getContextPath()%>/unionpage",--%>
             <%--"type": "GET",--%>
             <%--"data": {--%>
                <%--// "para":"para"--%>
             <%--}--%>
         <%--},--%>
        "sAjaxSource": "<%=request.getContextPath()%>/unionpage",
        "iDisplayLength": 10,
        //We will use below variable to track page number on server side(For more information visit: http://legacy.datatables.net/usage/options#iDisplayStart)
        "iDisplayStart": 0,
        "aoColumnDefs": [
            {
                "sTitle": "id",
                "mRender": function ( data, type, row ) {
                    return row.id +' ';
                },
                "aTargets": [ 0 ],
                "sType": "numeric",
                "sSortDataType": "dom-select",
                "sWidth": "80px",
//                "sClass": "ClickClass supplier-col",
                "bSearchable": false,
//                "bVisible": false
            },
            {
                "sTitle": "geoDivisionId",
                "mRender": function ( data, type, row ) {
                    return row.geoDivisionId +' ';
                },
                "aTargets": [ 1 ],
                "sType": "numeric",
                "sSortDataType": "dom-select",
                "sWidth": "80px",
//                "sClass": "ClickClass supplier-col",
                "bSearchable": false,
//                "bVisible": false
            }
        ]


    });

    $("div.toolbar").html($('#advancesearch'));


    $('.dropdown-menu.advanced-file-search').click(function (event) {
        event.stopPropagation();
    });

    $('#AdvancedSearchSubmit').click(function () {
        //  if($('#divisiondropdown').val()!=-1){
        var searchKey = $('input[name = unionname]').val() + ";" + $('input[name = unionbbscode]').val() + ";" + $('#divisiondropdown').val() + ";" + $('#districtdropdown').val() + ";" + $('#upazilladropdown').val();
        table.fnFilter(searchKey);
        $('div.dropdown.dropdown-lg').removeClass("open");
        $('#districtdropdown').empty();
        $('#upazilladropdown').empty();


    });

    $('#searchFileMessage').keyup(function () {
        var searchKey = $(this).val() + ";";
        table.fnFilter(searchKey);
        $('div.dropdown.dropdown-lg').removeClass("open");

    });

    $('#advancesearchoption').click(function () {
        $('#searchFileMessage').val("");
        //table.fnFilter(";");
        if ($('#divisiondropdown option').size() > 2) {
            return;
        }
        else {
            var data = "";
            $.ajax({
                type: "GET",
                url: "<%=request.getContextPath()%>/divisiondata",
                data: {},
                async: false,
                success: function (response) {
                    data = response;
                    return response;
                },
                error: function () {
                    alert('Error occured');
                }
            });

            var select = $('#divisiondropdown');
            select.empty();
            select.append($('<option></option>').val(-1).html('...'));
            $.each(data, function (index, value) {
                select.append(
                    $('<option></option>').val(value.id).html(value.divisionNameBng).attr('bbs', value.bbsCode)
                );
            });
        }
    });