
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



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
    <%@ include file="../includes/head.jsp" %>

    <style type="text/css">

        .dashboard-stat ul li {
            margin-left: -20px;
        }


        .portlet:not(.light):not(.box):not(.solid){
            padding: 0px;
        }
        /*body{*/
        /*height: -webkit-fill-available;*/
        /*}*/
        /*.page-footer{*/
        /*position: fixed;*/
        /*bottom: 0px;*/
        /*}*/

    </style>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo page-footer-fixed">
<!-- BEGIN HEADER -->
<div class="page-header -i navbar navbar-fixed-top">
    <%@ include file="../includes/header.jsp" %>
</div>
<!-- END HEADER -->
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<canvas id="mycanvas" style="z-index:1">
</canvas>
<div class="page-container" style="z-index:2; position:absolute; top:0; left:0;width:100%;">
    <!-- BEGIN SIDEBAR -->
    <div class="page-sidebar-wrapper" style="margin-top: 20px">
        <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
        <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
        <div class="page-sidebar navbar-collapse collapse">
            <%@ include file="../includes/menu.jsp" %>
        </div>
    </div>
        <!-- END SIDEBAR -->
        <!-- BEGIN CONTENT -->
        <div class="page-content-wrapper">

            <div class="page-content">

                <div id="savediv" class="row" style="margin: 0px 50px 25px 50px">
                    <button id="dashboardsave" type="button" class="btn red pull-right">Save</button>
                </div>
                <div class="row" id="sortable_portlets">
                    <div  id="column1" class="col-lg-3 col-md-3 col-sm-6 col-xs-12 column sortable">
                        <div class="portlet portlet-sortable-empty"> </div>
                    </div>
                    <div id="column2" class="col-lg-3 col-md-3 col-sm-6 col-xs-12 column sortable">
                        <div class="portlet portlet-sortable-empty"> </div>
                    </div>
                    <div id="column3" class="col-lg-3 col-md-3 col-sm-6 col-xs-12 column sortable">
                        <div class="portlet portlet-sortable-empty"> </div>
                    </div>
                    <div id="column4" class="col-lg-3 col-md-3 col-sm-6 col-xs-12 column sortable">
                        <div class="portlet portlet-sortable-empty"> </div>
                    </div>
                </div>
            </div>
            <!-- END CONTENT BODY -->
            <div id ="app" class="dashboard-stat  portlet portlet-sortable" style="display: none;box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.22)">
                <div class="portlet-title ui-sortable-handle">
                    <div class="row caption" style="float:inherit;font-size: large ;color: white; margin-left: 5px;">
                        <i class="fa fa-anchor" aria-hidden="true" style="color: red"></i>
                        <a  href="" target="_blank" style="color: white">......</a>
                    </div>
                    <button type="button" class="btn pull-right" style=" background-color: Transparent;background-repeat:no-repeat;border: none;cursor:pointer;overflow: hidden;outline:none;"><i class="fa fa-times" aria-hidden="true"></i></button>

                </div>

                <div class="row" style="min-height: 55px;margin-left: 5px;">
                    <div class="col-md-6">
                        <img  class="dashboadicon" style="margin-top: -10px;margin-left: -5px;" src="" alt="HTML5 Icon" >
                    </div>
                    <div class="col-md-6">

                        <ul  style="margin-top: -10px;margin-left: -20px">

                        </ul>

                    </div>
                </div>

                <a class="more" style="color: rgb(255, 255, 255);opacity: 1;text-transform: none;font-size: 13px;font-weight: 400;padding: 0px 10px" href="javascript:;"> <span style="display:inline; width: 0px;">View more</span>
                    <i class="m-icon-swapright m-icon-white" style="margin-top: 2px;"></i>
                </a>

            </div>
        </div>
        <!-- END CONTENT -->

    </div>
<!-- BEGIN FOOTER -->
<div class="page-footer">
    <%@ include file="../includes/footer.jsp" %>
</div>
<%@ include file="../includes/includes.jsp" %>





<script src="../assets/js/AnimationPractice.js" type="text/javascript"></script>
<script src="../assets/js/menu.js" type="text/javascript"></script>
<script src="/assets/pages/scripts/portlet-draggable.min.js" type="text/javascript"></script>
<script type="text/javascript" src="../assets/global/plugins/bootbox/bootbox.min.js"></script>
<script type="text/javascript" src="../assets/pages/scripts/ui-bootbox.min.js"></script>

<script th:inline="javascript">
    var postLink;

    function loginWithToken(token) {
        $("#token").val(token.trim());
        //$("#oisfForm").attr("action","http://162.222.186.235/billing/oisf/testOisf.jsp");
        //$("#oisfForm").attr("action","http://localhost/projapoti_framework/login");
        $("#oisfForm").attr("action", postLink);
        $("#oisfForm").submit();
    }

    $(document).ready(function () {
        $(".link").click(
            function () {
                postLink = $(this).attr("data-id");
                searchText($(this).attr("data-id"));
            }
        )
    });

</script>

<!-- END THEME LAYOUT SCRIPTS -->

<script>




    var bool =0;
    var colorPattern ;
    var initialstate = [];
    var deleteditem = [];

    function showModal(appid) {
        var idpart = appid.split("_");
        var  actualid = parseInt(idpart[1]);
        bootbox.confirm({
            message: '<p class="text-center">Do you want to delete</p>',
            title: "Custom title",
            size:"small",
            buttons: {
                confirm: {
                    label: 'Yes',
                    className: 'btn-success'
                },
                cancel: {
                    label: 'No',
                    className: 'btn-danger'
                }
            },
            callback: function (result) {

                if(result == true){
                    $('#savediv').show();
                    deleteditem.push(actualid);
                    $("#"+appid).remove();
                    $('.modal.in .modal-dialog').hide();
                    $(".modal.in .modal-dialog .btn").off("click");

                }else{
                    $('#savediv').hide();
                    $('.modal.in .modal-dialog').hide();
                    $(".modal.in .modal-dialog .btn").off("click");
                }

            }
        });

    }
    function getChild(child) {

        var s="";
        for(i=0;i<child.length;i++){
            var url=child[i].url,nameBng = child[i].nameBng;

            s+="<li><a href=\""+url+"\" target=\"_blank\" style=\"color:white;\">"+nameBng+"</a></li>\n";
        }
        return s;
    }

    function createPortlet(url, namebng, iconurl,children) {
        var port="<div class=\"portlet  portlet-sortable\"  style=\"display: block; height: 130px;\">\n" +
            "                            <div class=\"portlet-title ui-sortable-handle details detailsextra\">\n" +
            "                                <div class=\"caption\" style=\"float:inherit;font-size: large ;color: white\">\n" +
            "                                    <i class=\"fa fa-anchor\" aria-hidden=\"true\" style=\"color: red\"></i>\n" +
            "                                    <a href=\""+url+"\" target=\"_blank\" style=\"color: white\">"+namebng+"</a>\n" +
            "                                </div>\n" +
            "\n" +
            "                            </div>\n" +
            "                            <div class=\"portlet-body\">\n" +
            "                                <div class=\"row\">\n" +
            "                                    <div class=\"col-md-6\">\n" +
            "                                        <div class=\"\">\n" +
            "                                            <img class=\"dashboadicon\" src=\""+iconurl+"\"\n" +
            "                                                 alt=\"HTML5 Icon\" style=\"margin-bottom: 15px\">\n" +
            "                                        </div>\n" +
            "\n" +
            "                                    </div>\n" +
            "                                    <div class=\"col-md-6\">\n" +
            "                                        <%--<h6>Modules</h6>--%>\n" +
            "                                        <ul style=\"margin-top: -10px;margin-left: -20px\">\n" +getChild(children) +
            "                                        </ul>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "\n" +
            "                                <div class=\"row\" style=\"margin-left: -10px;margin-right: -10px;\">\n" +
            "                                <div class=\"row\" style=\"margin-left: -10px;margin-right: -10px;\">\n" +
            "                                    <div class=\"col-md-12\" style=\" color: #ffffff; opacity: 1;\n" +
            "\">\n" +
            "                                        <a style=\"color:#ffffff\"> View more\n" +
            "                                            <i class=\"m-icon-swapright m-icon-white\" style=\"float: right\"></i>\n" +
            "                                        </a>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "\n" ;

        return port;
    }
    function createPortletFromTemplate(id,url, namebng, iconurl,children) {
        var genportlet = $("#app").clone();
        var applink = $("div > a",genportlet);
        var appicon = $("div>div>img",genportlet);
        var appmodule = $("div>ul",genportlet);

        genportlet.css("display","block")
        genportlet.attr("id","app_"+id);
        applink.prop("href", url);
        applink.text(namebng);

        appicon.attr("src",iconurl);
        appmodule.append(getChild(children));
        return genportlet;


        
    }
    function createDashBoard(data) {
        var column=["#column1","#column2","#column3","#column4"];
        for( j=0;j<data.length;j++){
            var s =  createPortletFromTemplate(data[j].id+"",data[j].url,data[j].nameBng,data[j].logoUrl,data[j].child);
            var id  = column[data[j].columnId-1]+" .portlet-sortable-empty";
            var ele = $(id);
            ele.before(s);

            var key = "app_"+data[j].id;
            initialstate[key] = {
                row:data[j].rowId,
                column:data[j].columnId
            };
        }

    }

    function create2DArray(rows) {
        var arr = [];

        for (var i=0;i<rows;i++) {
            arr[i] = [];
        }

        return arr;
    }

    function getColor() {
        var color, scolor;
        if(bool ==1){color ="#693293" ;scolor="#7F51A3", bool=0}
        else {color ="#8CC63E" ;scolor="#9DCE5B" ;bool =1;}

        var C ={
            c : color,
            s : scolor
        };
        return C;
    }

    function createColorPattern() {
        colorPattern = create2DArray(100);
        for(row=0;row<100;row++){
            bool = 1-bool;
            for(column=0;column<4;column++){

                colorPattern[row][column] = getColor();
            }
        }
    }

    function colorRefresh() {
        var s= $('#sortable_portlets .portlet-sortable');
        bool = 1;



        s.each(function () {

            var pp = $(this).parent();
            var bf = $(this).prevUntil(pp);
            var r = bf.length;
            var c = parseInt(pp[0].id.slice(-1))-1;
            color = colorPattern[r][c];
            $(this).css("background-color",color.c);
            $('.more',this).css("background-color",color.s);

        });
    }
    $(document).ready(function () {

        var orgID=$('#orgId').val();

        $('#savediv').hide();


        createColorPattern();



        $.ajax({
            type: "POST",
            url: "<%=request.getContextPath()%>/dashitem",
            data: {
                id: orgID
            },
            async: false,
            success: function (response) {
                createDashBoard(response);
            },
            error: function () {
                alert('Error occured');
            }
        });

        $('#sortable_portlets').sortable({
            scroll: true,
            scrollSensitivity: 100,
            scrollSpeed: 100,
            update:function () {
                colorRefresh();
                $('#savediv').show();
            }

        });

        $("#application ul li").draggable({
                helper: 'clone'
            }
        );


        $('#sortable_portlets').droppable(
            {
                accept:'#application ul li',
                drop:function (ev,ui) {
                    var droppedItem = $(ui.draggable).clone();
                    var id = droppedItem[0].id;
                    var list = $("#sortable_portlets");
                    var check = $("#app_"+id,list);
                    if(check.length==0) {

                        $('#savediv').show();
                        deleteditem = jQuery.grep(deleteditem, function(value) {
                            return value != id;
                        });
                        var url = droppedItem[0].firstElementChild.href,
                            nameBng = droppedItem[0].firstElementChild.innerText, logoUrl = droppedItem.attr("icon"), child = [],
                            childArray = [];
                        child = $('#' + id + ' ul').children();
                        var yes = false;
                        child.each(function (value, current_element) {
                            if(yes) {
                                var url = current_element.firstElementChild.href,
                                    nameBng = current_element.firstElementChild.innerText;
                                childArray.push({
                                    url: url,
                                    nameBng: nameBng
                                })
                            }
                            else yes = true;

                        });
                        var pos = ui.draggable.offset(), dPos = $(this).offset();
                        var width = list.width();
                        var column = Math.floor((ev.pageX - list.parent().offset().left) / (width * .25)) + 1;


                        var s = createPortletFromTemplate(id, url, nameBng, logoUrl, childArray);
                        var ele = $("#column" + column + " > .portlet-sortable-empty");
                        ele.before(s);
                        colorRefresh();
                    }
                    else{
                        alert("app already exist");
                    }
                }
            }
        );

        colorRefresh();


        $("#dashboardsave").click(function () {
            $('#savediv').hide();
            var changeditem =[];
            var createditem =[];
            var s= $('#sortable_portlets .portlet-sortable');

            s.each(function () {

                var pp = $(this).parent();
                var bf = $(this).prevUntil(pp);
                var r = bf.length;
                var c = parseInt(pp[0].id.slice(-1))-1;

                var app = initialstate[this.id];
                var idpart = this.id.split("_");
                var  actualid = parseInt(idpart[1]);
                if($.isEmptyObject(app))createditem.push({
                    id:actualid,
                    row:r+1,
                    column:c+1
                });
                else{
                    if(!((app.row == r+1)&&(app.column == c+1))){
                        changeditem.push({
                            id:actualid,
                            row:r+1,
                            column:c+1
                        });
                    }
                }


            });

            //post change list and deleted list
            var data = {
                "updated" : changeditem,
                "created" :createditem,
                "deleted" :deleteditem,
                "desid":orgID
            };

            $.ajax({
                type: "POST",
                contentType : 'application/json; charset=utf-8',
                dataType : 'json',
                url: "<%=request.getContextPath()%>/savedashboard",
                data: JSON.stringify(data),
                async: false,
                success: function (response) {
                    createDashBoard(response);
                },
                error: function () {
                    alert('Error occured');
                }
            });


        });

        $("#sortable_portlets").on('click',".portlet-sortable > .portlet-title> .btn",function (e) {

            var app = $(this).parents(".portlet-sortable");
            var id =app[0].id;
            showModal(id);
        });



    });




</script>
<style>
    .image {
        width: 80px;
        height: 80px;
        display: block;
        float: left;
        padding-top: 10px;
        padding-left: 15px;
        margin-bottom: 15px;
        font-size: 35px;
        line-height: 35px;
    }
    #throbble { display: none }
</style>

</body>

</html>