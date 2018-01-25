<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>

    <meta charset="utf-8"/>
    <title>Intranet | Dashboard</title>
    <%@ include file="../../includes/head.jsp" %>
    <link href="<%=request.getContextPath()%>/assets/css/common/datatablecustom.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="/assets/styles/inbox-details.css"/>
    <link rel="stylesheet" type="text/css" href="/assets/styles/styles.css"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo page-footer-fixed">
<!-- BEGIN HEADER -->
<div class="page-header -i navbar navbar-fixed-top">
    <%@ include file="../../includes/header.jsp" %>
</div>
<!-- END HEADER -->
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
    <!-- BEGIN SIDEBAR -->
    <div class="page-sidebar-wrapper" style="margin-top: 20px">
        <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
        <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
        <div class="page-sidebar navbar-collapse collapse">
            <%@ include file="../../includes/menu.jsp" %>
        </div>
    </div>
    <!-- END SIDEBAR -->
    <!-- BEGIN CONTENT -->
    <div class="page-content-wrapper">

        <div class="page-content">

            <div class="card">
                <div class="card-block">
                    <div class="portlet box " >
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-picture"></i>District List
                            </div>
                            <%--<div class="tools  hidden-print  " >--%>
                            <%--<a  href="<%=request.getContextPath()%>/divisionadd" title="" data-original-title="Division Add" >--%>
                            <%--<i class="fa fa-plus-square-o fa-2x"aria-hidden="true" ></i> </a>--%>
                            <%--<a title="" class="btn-print" data-original-title="Division Print">--%>
                            <%--<i class="fa fa-print fa-2x"></i> </a>--%>
                            <%--&lt;%&ndash;<a title="" style="color:white; font-size: 16px" href="/office_employees/index?print=1" data-original-title="দপ্তর কর্মকর্তা তালিকা এক্সপোর্ট">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<i class="fa fa-file-excel-o fa-2x"></i>  </a>&ndash;%&gt;--%>
                            <%--</div>--%>

                        </div>


                        <div class="portlet-body">
                            <div class=" pull-right" id="addassign" style="margin-bottom: 40px;margin-top: 10px">

                            </div>

                            <div class=" table-scrollable table-responsive">
                                <table class="table  table-striped  table-hover" id="datatable">

                                    <thead align="center">
                                    <th>District Name</th>
                                    <th>District Name(Bangla)</th>
                                    <th>BBS Code</th>
                                    <th style="width: 5px;"></th>
                                    <th style="width: 5px;"></th>
                                    <th style="width: 5px;"></th>
                                    </thead>



                                </table>
                            </div>


                        </div>
                    </div>

                </div>
            </div>
            <div style="display: none">
                <div id="edit">
                    <form  method="post">
                        <input type="hidden" name="id">
                        <input type="hidden" name="divnameeng">
                        <input type="hidden" name="divnamebng">
                        <input type="hidden" name="bbscode">
                        <input type="hidden" name="status">
                        <button type="submit" name="submit_param" value="submit_value" class="btn btn-icon-only">
                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                        </button>
                    </form>
                </div>
                <div id="history">
                    <form  method="post">
                        <input type="hidden" name="id">
                        <input type="hidden" name="name">
                        <button type="submit" name="submit_param" value="submit_value" class="btn btn-icon-only">
                            <i class="fa fa-info"></i>
                        </button>
                    </form>
                </div>
            </div>

            <input type="hidden" id="menuid" value="${menuid}">

            <div id='advancesearch'>
                <div class="inbox-header" >
                    <form id="file-search" class="form-inline" action="javascript:;">
                        <div class="input-group" style="width: auto !important;display:flex;width: 20%; float:right">
                            <input id="searchFileMessage" type="text" class="form-control" styles="heigth = 100%"
                                   placeholder="Search...">
                            <div class="dropdown dropdown-lg">
                                <button id="advancesearchoption"
                                        style="padding-bottom: 4px;height: 34px; border-radius:0px; box-shadow:none;"
                                        type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                        aria-expanded="true"><span class="md-click-circle md-click-animate"></span><span
                                        class="caret" style="margin-bottom:5px;"></span></button>
                                <div class="dropdown-menu dropdown-menu-right advanced-file-search" role="menu"
                                     style="background-color: #fffffe;margin-top: 2px; border: 1px solid lightgray!important; box-shadow: none!important;width: 387px;">
                                                <div>


                                                    <label class="control-label">Division<span
                                                            class="required" aria-required="true"> * </span></label>

                                                    <select class="form-control" name="divdata" id="divisiondropdown">
                                                    </select>
                                                </div>

                                    <div class="row" style="margin-top: 40px;">
                                        <div >
                                            <button id="AdvancedSearchCancel" name="AdvancedSearchCancel" type="reset"
                                                    class="btn btn-danger btn-sm pull-left"><span class="glyphicon glyphicon-"
                                                                                                  aria-hidden="true"></span>বাতিল
                                            </button>
                                            <button id="AdvancedSearchSubmit" name="AdvancedSearchSubmit" type="button"
                                                    class="btn btn-primary btn-sm pull-right"><span
                                                    class="glyphicon glyphicon-search" aria-hidden="true"></span>অনুসন্ধান
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>


        </div>
    </div>
    <!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="page-footer">
    <%@ include file="../../includes/footer.jsp" %>
</div>
<!-- END FOOTER -->
<%@ include file="../../includes/includes.jsp" %>

<script>

    var example_table;
    function reload() {
        example_table.ajax.reload();
    }
    function datatableInit(edi,del,his) {
        var evisible = false, dvisible = false, hvisible=false;
        if(edi!=undefined)evisible = true;
        if(del!=undefined)dvisible = true;
        if(his!=undefined)hvisible = true;

        example_table = $('#datatable').DataTable({
            "bServerSide" : false,
            "sPaginationType": "full_numbers",
            "sDom": '<"row" <"col-md-6 col-sm-12"l><"col-md-6 col-sm-12"<"toolbar">>><"table-scrollable"t><"row" <"col-md-5 col-sm-12"i><"col-md-7 col-sm-12"p>>',
           // "sDom": '<"row header"<" col-md-8 pull-left" <"displayinline"l><"displayinline"i>><"col-md-4 pull-right toolbar">><"minheight"t><"row footer"<"text-center"p>>',
            "sEcho": 1,
            "language":{
                "decimal":        "১",
                "emptyTable":     "জেলা খুজে পাওয়া যায় নাই",
                "info":           " মোট _TOTAL_ জেলার মধ্যে _START_ থেকে _END_ পর্যন্ত দেখানো হচ্ছে",
                "infoEmpty":      "জেলা খুজে পাওয়া যায় নাই",
                "infoFiltered":   "(filtered from _MAX_ total entries)",
                "infoPostFix":    "",
                "thousands":      ",",
                "lengthMenu":     "_MENU_",
                "loadingRecords": "Loading...",
                "processing":     "Processing...",
                "search":         "Search:",
                "zeroRecords":    "জেলা খুজে পাওয়া যায় নাই",
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
            "sAjaxSource" : "<%=request.getContextPath()%>/districtlistdata",
            "iDisplayLength": 10,
            "iDisplayStart": 0,
            "aoColumns"   :[
                {   "mData": 'districtNameEng',
                    "bSortable": false
                },
                {   "mData":'districtNameBng',
                    "bSortable": false
                },
                {   "mData":'bbsCode',
                    "bSortable": false
                },
                {
                    "mRender": function(data, type, full) {

                        var editdiv = $("#edit").clone();
                        var editbtn = $('form',editdiv);
                        editbtn.attr('action', "<%=request.getContextPath()%>/districtedit");
                        $('input[name="id"]',editbtn).val(full.id);
                        return editdiv.html();
                    },
                    "bVisible":evisible,
                    "bSortable": false
                },
                {
                    "mRender": function(data, type, full) {
                        return '<button class="btn btn-icon-only" style="background-color: black;color: white" onclick=showModal('+full.id+',\"/districtedelete\")>'+
                            ' <i class="fa fa-trash-o fa-lg"></i>'+
                            '</button>';
                    },
                    "bVisible":dvisible,
                    "bSortable": false
                },
                {
                    "mRender": function(data, type, full) {

                        <%--var historydiv = $("#history").clone();--%>
                        <%--var historybtn = $('form',historydiv);--%>
                        <%--historybtn.attr('action', "<%=request.getContextPath()%>/districthistory");--%>
                        <%--$('input[name="id"]',historybtn).val(full.id);--%>
                        <%--$('input[name="name"]',historybtn).val(full.districtNameBng);--%>

                        <%--return historydiv.html();--%>
                        var link = '<button class="btn btn-icon-only"><a href="/districthistory?id='+full.id+'&&name='+full.districtNameBng+'"><i class="fa fa-info" style="color: black"></i></a></button>';
                        return link;
                    },
                    "bVisible":hvisible,
                    "bSortable": false
                }


            ],
            "autoWidth": false,
            "fnInitComplete": function(oSettings, json) {

                   // alert('DataTables has finished its initialisation.');
               //     $("body > div.page-container > div.page-content-wrapper > div > div.card > div > div > div.portlet-body > div.table-scrollable.table-responsive").css('display','block');

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

        $("div.toolbar").html($('#advancesearch'));


        $('.dropdown-menu.advanced-file-search').click(function (event) {
            event.stopPropagation();
        });

        $('#AdvancedSearchSubmit').click(function () {
            //  if($('#divisiondropdown').val()!=-1){
           // var searchKey = $('input[name = unionname]').val() + ";" + $('input[name = unionbbscode]').val() + ";" + $('#divisiondropdown').val() + ";" + $('#districtdropdown').val() + ";" + $('#upazilladropdown').val();
           // example_table.fnFilter(searchKey);

//            var datatable = example_table.api();
//            datatable.clear();


            $.ajax({
                type: "GET",
                url: "<%=request.getContextPath()%>/districtlistdatabydivision",
                data: {
                    id:$('#divisiondropdown').val()
                },
                async: false,
                success: function (response) {

                    $('#datatable').dataTable().fnClearTable();
                    $('#datatable').dataTable().fnAddData(response.aaData);

                },
                error: function () {
                    alert('Error occured');
                }
            });
            $('div.dropdown.dropdown-lg').removeClass("open");



        });

        $('#searchFileMessage').keyup(function () {
            var searchKey = $(this).val();
            example_table.search(searchKey).draw();
            $('div.dropdown.dropdown-lg').removeClass("open");

        });

    }

    $(document).ready(function () {
      //  $("body > div.page-container > div.page-content-wrapper > div > div.card > div > div > div.portlet-body > div.table-scrollable.table-responsive").css('display','none');
        $.ajax({
            type:"POST",
            url : "/permission",
            data : {
                menuid: $("#menuid").val()
            },
            async: false,
            success : function(response) {
                var addassign = $("#addassign");
                var list = [];
                for(var i=0;i<response.length;i++){
                    var x = response[i].menuType;
                    list[x]=1;
                }
                if(list[2]==1)addassign.append('<button type="button" class="btn " style="margin-right: 30px; background-color: #b5b1b1"><a href="/districtadd">Add District</a></button>');
                if(list[5]==1)addassign.append('<button type="button" class="btn " style="margin-right: 30px; background-color: #b5b1b1"><a href="/districtassign">Assign Upa/Tha</a></button>');
                datatableInit(list[3],list[4],list[6]);
            },
            error: function() {
                alert('Error occured');
            }
        });
    });

</script>

<script type="text/javascript" src="/assets/global/plugins/select2/select2.min.js"></script>

<script src="/assets/pages/scripts/ui-bootbox.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
        src="/assets/global/plugins/datatables/extensions/TableTools/js/dataTables.tableTools.min.js"></script>
<script type="text/javascript"
        src="/assets/global/plugins/datatables/extensions/ColReorder/js/dataTables.colReorder.min.js"></script>
<script type="text/javascript"
        src="/assets/global/plugins/datatables/extensions/Scroller/js/dataTables.scroller.min.js"></script>
<script type="text/javascript"
        src="/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="/assets/admin/pages/scripts/table-advanced.js"></script>
<script src="../assets/admin/pages/scripts/table-advanced.js"></script>
<script type="text/javascript" src="../assets/global/plugins/bootbox/bootbox.min.js"></script>
<script type="text/javascript"src="../static/assets/js/common/modalcontrol.js"></script>
</body>
<!-- END BODY -->
</html>
