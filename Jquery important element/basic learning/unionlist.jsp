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
    <link rel="stylesheet" type="text/css" href="/assets/styles/inbox-details.css"/>
    <link rel="stylesheet" type="text/css" href="/assets/styles/styles.css"/>
    <style type="text/css">
        .minheight {
            min-height: 300px;
        }

        .marginleft {
            margin-left: 1.5%;
        }

        .marginright {
            margin-right: 1.5%;
        }

        .margintop {
            margin-top: 22.5px;
        }
        .displayinline,.displayinline >div{
            display: inline;
        }

        #sample_1_length label {
            margin-top: 5px;
        }

        .pagination {
            margin-top: 20px;
        }

        .pagination > li > a, .pagination > li > span {
            /*color: white !important;*/
            /*border: 1px solid #2980B9!important;*/
            /*background-color: #2980B9!important;*/
            /*background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #2980B9), color-stop(100%, #2980B9))!important;*/
            /*background: -webkit-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
            /*background: -moz-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
            /*background: -ms-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
            /*background: -o-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
            /*background: linear-gradient(to bottom, #2980B9 0%, #2980B9 100%)!important;*/
        }

        .pagination > li.active > a, .pagination > li.active > span {
            /*background-color: green*/
        }

        .pagination > .disabled > a, .pagination > .disabled > a:focus, .pagination > .disabled > a:hover, .pagination > .disabled > span, .pagination > .disabled > span:focus, .pagination > .disabled > span:hover {
            /*color: white !important;*/
        }



        /*border: 1px solid #2980B9!important;*/
        /*background-color: #2980B9!important;*/
        /*background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #2980B9), color-stop(100%, #2980B9))!important;*/
        /*background: -webkit-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
        /*background: -moz-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
        /*background: -ms-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
        /*background: -o-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
        /*background: linear-gradient(to bottom, #2980B9 0%, #2980B9 100%)!important;}*/

        .header {
            /*background: rgba(227,227,227,1);*/
            /*background: -moz-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: -webkit-gradient(left top, left bottom, color-stop(0%, rgba(227,227,227,1)), color-stop(100%, rgba(184,196,207,1)));*/
            /*background: -webkit-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: -o-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: -ms-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: linear-gradient(to bottom, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#d4e4ef', endColorstr='#86aecc', GradientType=0 );*/
        }

        .footer {
            /*background: rgba(227,227,227,1);*/
            /*background: -moz-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: -webkit-gradient(left top, left bottom, color-stop(0%, rgba(227,227,227,1)), color-stop(100%, rgba(184,196,207,1)));*/
            /*background: -webkit-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: -o-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: -ms-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: linear-gradient(to bottom, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#d4e4ef', endColorstr='#86aecc', GradientType=0 );*/
        }

        thead {
            /*background: rgba(184,196,207,1);*/
            /*background: -moz-linear-gradient(top, rgba(184,196,207,1) 40%, rgba(160,175,188,1) 50%, rgba(255,255,255,1) 51%, rgba(227,227,227,1) 100%);*/
            /*background: -webkit-gradient(left top, left bottom, color-stop(40%, rgba(184,196,207,1)), color-stop(50%, rgba(160,175,188,1)), color-stop(51%, rgba(255,255,255,1)), color-stop(100%, rgba(227,227,227,1)));*/
            /*background: -webkit-linear-gradient(top, rgba(184,196,207,1) 40%, rgba(160,175,188,1) 50%, rgba(255,255,255,1) 51%, rgba(227,227,227,1) 100%);*/
            /*background: -o-linear-gradient(top, rgba(184,196,207,1) 40%, rgba(160,175,188,1) 50%, rgba(255,255,255,1) 51%, rgba(227,227,227,1) 100%);*/
            /*background: -ms-linear-gradient(top, rgba(184,196,207,1) 40%, rgba(160,175,188,1) 50%, rgba(255,255,255,1) 51%, rgba(227,227,227,1) 100%);*/
            /*background: linear-gradient(to bottom, rgba(184,196,207,1) 40%, rgba(200,175,188,1) 50%, rgba(255,255,255,1) 51%, rgba(227,227,227,1) 100%);*/
            /*filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#e2e2e2', endColorstr='#fefefe', GradientType=0 );*/
        }

    </style>


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
                    <div class="portlet box ">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-picture"></i>Union List
                            </div>


                        </div>
                        <div class="portlet-body">
                            <div class=" table-scrollable table-responsive minheight"
                                 style="border:none; overflow-x: hidden;font-size: 14px;">
                                <table class="table  table-striped table-bordered table-hover" id="sample_1">


                                    <thead align="center">


                                    <tr>
                                        <th> id</th>
                                        <th> geo_division_id</th>
                                        <th> geo_district_id</th>
                                        <th> union_name_bng</th>
                                        <th> bbs_code</th>
                                        <th> edit</th>
                                        <th> delete</th>
                                        <th> History</th>

                                    </tr>

                                    </thead>


                                </table>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    </div>

    <div id='advancesearch'>
        <div class="inbox-header" style="margin-top:5px;">
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
                             style="background-color: #fffffe;margin-top: 2px;">
                            <table>
                                <thead>
                                <th></th>
                                <th></th>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>
                                        <label class="control-label">Union Name<span
                                                class="required" aria-required="true"> * </span></label>
                                    </td>
                                    <td style="padding-left:10px;padding-bottom:10px">
                                        <div class="">
                                            <div class="input-icon">
                                                <i class="fa fa-angle-double-right tooltips "
                                                   data-original-title="please write Union Name"
                                                   data-container="body"></i>
                                                <input style="padding-left:25px" type="text" data-required="1"
                                                       class="form-control"
                                                       name="unionname">
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label class="control-label">Union BBS Code<span
                                                class="required" aria-required="true"> * </span></label>
                                    </td>
                                    <td style="padding-left:10px;padding-bottom:10px">
                                        <div class="">
                                            <div class="input-icon">
                                                <i class="fa fa-angle-double-right tooltips "
                                                   data-original-title="please write Union BBS Code"
                                                   data-container="body"></i>
                                                <input style="padding-left:25px" type="text" data-required="1"
                                                       class="form-control"
                                                       name="unionbbscode">
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label class="control-label">Division<span
                                                class="required" aria-required="true"> * </span></label>
                                    </td>
                                    <td style="padding-left:10px;padding-bottom:10px">
                                        <select class="form-control" name="divdata" id="divisiondropdown">
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label class="control-label">District<span
                                                class="required" aria-required="true"> * </span></label>
                                    </td>
                                    <td style="padding-left:10px;padding-bottom:10px">
                                        <select class="form-control" name="disdata" id="districtdropdown">
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label class="control-label">Upazilla<span
                                                class="required" aria-required="true"> * </span></label>
                                    </td>
                                    <td style="padding-left:10px">
                                        <select class="form-control" name="upadata" id="upazilladropdown">
                                        </select>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="row" style="padding: 5px 0px;">
                                <div class="form-group pull-right col-xs-4">
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
    var example_table ;
    function reload() {
        example_table.ajax.reload();
    }
    function datatableInit(edi,del,his) {
        var evisible = false, dvisible = false, hvisible=false;
        if(edi!=undefined)evisible = true;
        if(del!=undefined)dvisible = true;
        if(his!=undefined)hvisible = true;



        example_table = $('#datatable').DataTable({
            "bServerSide" : true,
            "sPaginationType": "full_numbers",
            "sDom": '<"row" <"col-md-6 col-sm-12"l><"col-md-6 col-sm-12"<"toolbar">>><"table-scrollable"t><"row" <"col-md-5 col-sm-12"i><"col-md-7 col-sm-12"p>>',
            "sEcho": 1,
            "language":{
                "decimal":        "১",
                "emptyTable":     "উপজেলা খুজে পাওয়া যায় নাই",
                "info":           " মোট _TOTAL_ উপজেলার মধ্যে _START_ থেকে _END_ পর্যন্ত দেখানো হচ্ছে",
                "infoEmpty":      "উপজেলা খুজে পাওয়া যায় নাই",
                "infoFiltered":   "(filtered from _MAX_ total entries)",
                "infoPostFix":    "",
                "thousands":      ",",
                "lengthMenu":     "_MENU_",
                "loadingRecords": "Loading...",
                "processing":     "Processing...",
                "search":         "Search:",
                "zeroRecords":    "উপজেলা খুজে পাওয়া যায় নাই",
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
            "sAjaxSource" : "<%=request.getContextPath()%>/upazillapagedata",
            "iDisplayLength": 10,
            "iDisplayStart": 0,
            "aoColumns"   :[
                {   "mData": 'upazillaNameEng',
                    "bSortable": false
                },
                {   "mData":'upazillaNameBng',
                    "bSortable": false
                },
                {   "mData":'bbsCode',
                    "bSortable": false
                },
                {
                    "mRender": function(data, type, full) {

                        var editdiv = $("#edit").clone();
                        var editbtn = $('form',editdiv);
                        editbtn.attr('action', "<%=request.getContextPath()%>/upazillaedit");
                        $('input[name="id"]',editbtn).val(full.id);
                        $('input[name="upazillanameeng"]',editbtn).val(full.upazillaNameEng);
                        $('input[name="upazillanamebng"]',editbtn).val(full.upazillaNameBng);
                        $('input[name="upazillabbscode"]',editbtn).val(full.bbsCode);
                        $('input[name="divisionbbscode"]',editbtn).val(full.divisionBbsCode);
                        $('input[name="districtbbscode"]',editbtn).val(full.districtBbsCode);
                        $('input[name="divId"]',editbtn).val(full.geoDivisionId);
                        $('input[name="disId"]',editbtn).val(full.geoDistrictId);
                        return editdiv.html();
                    },
                    "bVisible":evisible,
                    "bSortable": false


                },
                {
                    "mRender": function(data, type, full) {
                        return '<button class="btn btn-icon-only" style="background-color: black;color: white" onclick=showModal('+full.id+',\"/upazilladelete\")>'+
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
                        <%--historybtn.attr('action', "<%=request.getContextPath()%>/upazillahistory");--%>
                        <%--$('input[name="id"]',historybtn).val(full.id);--%>
                        <%--$('input[name="name"]',historybtn).val(full.upazillaNameBng);--%>
//                        return historydiv.html();

                        var link = '<button class="btn btn-icon-only"><a href="/upazillahistory?id='+full.id+'&&name='+full.upazillaNameBng+'"><i class="fa fa-info" style="color: black"></i></a></button>';
                        return link;
                    },
                    "bVisible":hvisible,
                    "bSortable": false
                }


            ],
            "autoWidth":false
        });
    }
    
    function getcolumns() {
        $.ajax({
            type: "POST",
            url: "<%=request.getContextPath()%>/upazillalistbydistrictid",
            data: {
                id: $(this).val()
            },
            async: false,
            success: function (response) {
                data = response;
                return response;
            },
            error: function () {
                alert('Error occured');
            }
        });

    }
    $(document).ready(function () {
//        <"pull-left marginleft margintop"i>
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
        "aoColumns": [
            {"mData": "id"},
            {"mData": "geoDivisionId"},
            {"mData": "geoDistrictId"},
            {"mData": "unionNameBng"},
            {"mData": "bbsCode"},
            {
                "mRender": function (data, type, full) {
                    // return '<a href=<%=request.getContextPath()%>/unionpage/'+full.id+'>' + "Edit" + '</a>';

                    return '<form method="post" action="<%=request.getContextPath()%>/editunionview">' +
                        '<input type="hidden" name="id" value="' + full.id + '">' +
                        '<input type="hidden" name="unionnameeng" value="' + full.unionNameEng + '">' +
                        '<input type="hidden" name="unionnamebng" value="' + full.unionNameBng + '">' +
                        '<input type="hidden" name="unionbbscode" value="' + full.bbsCode + '">' +
                        '<input type="hidden" name="divisionbbscode" value="' + full.divisionBbsCode + '">' +
                        '<input type="hidden" name="districtbbscode" value="' + full.districtBbsCode + '">' +
                        '<input type="hidden" name="upazillabbscode" value="' + full.upazilaBbsCode + '">' +
                        '<input type="hidden" name="divId" value="' + full.geoDivisionId + '">' +
                        '<input type="hidden" name="disId" value="' + full.geoDistrictId + '">' +
                        '<input type="hidden" name="upaId" value="' + full.geoUpazilaId + '">' +
                        '<button type="submit" name="submit_param" value="submit_value" class="link-button">' +
                        "Edit" +
                        '</button>' +
                        '</form>';
                },
                "bVisible": $

            },
            {
                "mRender": function (data, type, full) {
                    // return '<a href=<%=request.getContextPath()%>/unionpage/'+full.id+'>' + "Edit" + '</a>';

                    return '<form method="post" action="<%=request.getContextPath()%>/deleteunion">' +
                        '<input type="hidden" name="id" value="' + full.id + '">' +
                        '<button type="submit" name="submit_param" value="submit_value" class="link-button">' +
                        "Delete" +
                        '</button>' +
                        '</form>';
                }
            },
            {
                "mRender": function (data, type, full) {
                    // return '<a href=<%=request.getContextPath()%>/unionpage/'+full.id+'>' + "Edit" + '</a>';

                    return '<form method="post" action="<%=request.getContextPath()%>/unionhistory">' +
                        '<input type="hidden" name="id" value="' + full.id + '">' +
                        '<input type="hidden" name="name" value="' + full.unionNameBng + '">' +
                        '<button type="submit" name="submit_param" value="submit_value" class="link-button">' +
                        "History" +
                        '</button>' +
                        '</form>';
                }
            }
        ],
        "autoWidth": false


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
    $('#divisiondropdown').change(function () {
        var data = "";
        $.ajax({
            type: "GET",
            url: "<%=request.getContextPath()%>/districtlistbydiv",
            data: {
                id: $(this).val()
            },
            async: false,
            success: function (response) {
                data = response;
                return response;
            },
            error: function () {
                alert('Error occured');
            }
        });

        var select = $('#districtdropdown');
        select.empty();
        select.append($('<option></option>').val(-1).html('...'));
        $.each(data, function (index, value) {
            select.append(
                $('<option></option>').val(value.id).html(value.districtNameBng).attr('bbs', value.bbsCode)
            );
        });

        var selected = $(this).find('option:selected');
        var extra = selected.data('bbs');
        $('input[name = divisionbbscode]').val(extra);

    });

    $('#districtdropdown').change(function () {
        var data = "";
        $.ajax({
            type: "POST",
            url: "<%=request.getContextPath()%>/upazillalistbydistrictid",
            data: {
                id: $(this).val()
            },
            async: false,
            success: function (response) {
                data = response;
                return response;
            },
            error: function () {
                alert('Error occured');
            }
        });

        var select = $('#upazilladropdown');
        select.empty();
        select.append($('<option></option>').val(-1).html('...'));
        $.each(data, function (index, value) {
            select.append(
                $('<option></option>').val(value.id).html(value.upazillaNameBng).attr('bbs', value.bbsCode)
            );
        });
        var selected = $(this).find('option:selected');
        var extra = selected.attr('bbs');
        $('input[name = districtbbscode]').val(extra);

    });

    $('#upazilladropdown').change(function () {

        var selected = $(this).find('option:selected');
        var extra = selected.attr('bbs');
        $('input[name = upazillabbscode]').val(extra);

    });

    })
    ;


</script>


<script type="text/javascript" src="/assets/global/plugins/select2/select2.min.js"></script>
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
</body>

</html>