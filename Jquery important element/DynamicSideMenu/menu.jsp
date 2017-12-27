<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- BEGIN SIDEBAR MENU -->
<!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
<!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
<!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
<!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
<!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
<ul class="page-sidebar-menu " id = "sidebar" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
    <!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
    <li class="sidebar-toggler-wrapper">
        <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
        <div class="sidebar-toggler">
        </div>
        <!-- END SIDEBAR TOGGLER BUTTON -->
    </li>
    <li id="configDashboardMenu" style="background-color: #9DCE5B;margin-top: -10px"><a
            href="<%=request.getContextPath()%>/userdashboard" style="background-color: inherit">
        <i
            class="fa fa-th-large" ></i>
        <span class="title" style="color: White"><b> Dashboard</b> </span><span
            class="selected"></span></a>
    </li>
    <%--<li id="officeTypeMenu">--%>
        <%--<a href="#"><span class="gen-headoffice2"></span><span class="title"> Ministry / Division  </span><span--%>
                <%--class="arrow "></span></a>--%>
        <%--<ul class="sub-menu">--%>

            <%--<li id="searchOfficeTypeSubmenu">--%>
                <%--<a href="<%=request.getContextPath()%>/MinistryShow"><i class="fa fa-list"></i> Ministry / Division List--%>
                <%--</a>--%>
            <%--</li>--%>
        <%--</ul>--%>
    <%--</li>--%>
    <%--<li id="officeMenu" class="sidebar-toggler-wrapper">--%>
        <%--<a href="#"><span class="gen-office1"></span><span class="title"> Office  </span><span--%>
                <%--class="arrow "></span></a>--%>
        <%--<ul class="sub-menu">--%>


            <%--<li id="searchOfficeSubmenu">--%>
                <%--<a href="<%=request.getContextPath()%>/Office_LayerShow"><i class="fa fa-list"></i> Office List </a>--%>
            <%--</li>--%>


            <%--<li id="officeDesignationSubmenu">--%>
                <%--<a href="../office/designationTemplateToOffice.jsp"><span class="gen-edit"></span> Organogram Edit </a>--%>
            <%--</li>--%>

            <%--<li id="officeLocalAdminSubmenu">--%>
                <%--<a href="../office/selectOffice.jsp"><i class="fa fa-list"></i> Office's Local Admin </a>--%>
            <%--</li>--%>


            <%--<li id="assignOfficerToOfficeSubmenu">--%>
                <%--<a href="../office/selectOffice.jsp"><i class="fa fa-list"></i>Officer Assign </a>--%>
            <%--</li>--%>

        <%--</ul>--%>
    <%--</li>--%>
    <%--<li id="Employee">--%>
        <%--<a href="#"><span class="gen-office1"></span><span class="title"> Employee  </span><span--%>
                <%--class="arrow "></span></a>--%>
        <%--<ul class="sub-menu">--%>

            <%--<li id="add">--%>
                <%--<a href="<%=request.getContextPath()%>/empadd"><i class="fa fa-edit"></i> Employee Add </a>--%>
            <%--</li>--%>

            <%--<li id="list">--%>
                <%--<a href="<%=request.getContextPath()%>/empshow"><i class="fa fa-edit"></i> Employee List</a>--%>
            <%--</li>--%>


        <%--</ul>--%>
    <%--</li>--%>
    <%--<li id="AppMenu">--%>
        <%--<a href="#"><span class="gen-office1"></span><span class="title"> Application Registration  </span><span--%>
                <%--class="arrow "></span></a>--%>
        <%--<ul class="sub-menu">--%>

            <%--<li id="addSubmenu">--%>
                <%--<a href="<%=request.getContextPath()%>/appregistration"><i class="fa fa-edit"></i> Application Add </a>--%>
            <%--</li>--%>

            <%--<li id="addApprovemenu">--%>
                <%--<a href="<%=request.getContextPath()%>/approval"><i class="fa fa-edit"></i> Application Approve</a>--%>
            <%--</li>--%>


            <%--<li id="assignOfficeoOfficeSubmenu">--%>
                <%--<a href="<%=request.getContextPath()%>/list"><i class="fa fa-list"></i> Application List </a>--%>
            <%--</li>--%>

        <%--</ul>--%>
    <%--</li>--%>
    <%--<li id="GeoMenu">--%>
        <%--<a href="#"><span class="gen-office1"></span><span class="title"> Geo  </span><span class="arrow "></span></a>--%>
        <%--<ul class="sub-menu">--%>

            <%--<li id="addSublistmenu"><a href="#"><span class=""></span><i class="fa fa-th-large"></i><span class="title"> Division </span><span--%>
                    <%--class="arrow "></span></a>--%>
                <%--<ul class="sub-menu">--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/divisionlist"><i class="fa fa-edit"></i> Division List--%>
                        <%--</a></li>--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/divisionadd"><i class="fa fa-edit"></i> Division Add--%>
                        <%--</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>

            <%--<li id="addSublistdismenu"><a href="#"><span class=""></span><i class="fa fa-th-large"></i><span class="title"> District </span><span--%>
                    <%--class="arrow "></span></a>--%>
                <%--<ul class="sub-menu">--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/getdistrictlist"><i class="fa fa-edit"></i> District List--%>
                        <%--</a></li>--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/districtadd"><i class="fa fa-edit"></i> District Add--%>
                        <%--</a></li>--%>
                    <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<a href="<%=request.getContextPath()%>/upazillaassign"><i class="fa fa-edit"></i> Upazilla  Assign&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</a></li>&ndash;%&gt;--%>
                <%--</ul>--%>
            <%--</li>--%>

            <%--<li id="thana"><a href="#"><span class=""></span><i class="fa fa-th-large"></i><span class="title"> Thana </span><span--%>
                    <%--class="arrow "></span></a>--%>
                <%--<ul class="sub-menu">--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/thanalistview"><i class="fa fa-edit"></i> Thana List--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/addthanaview"><i class="fa fa-edit"></i> Add Thana--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>


            <%--<li id="upazilla"><a href="#"><span class=""></span><i class="fa fa-th-large"></i><span class="title"> Upazilla </span><span--%>
                    <%--class="arrow "></span></a>--%>
                <%--<ul class="sub-menu">--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/upazillalistview"><i class="fa fa-edit"></i> Upazilla List--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/addupazillaview"><i class="fa fa-edit"></i> Add Upazilla--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li id="postoffice"><a href="#"><span class=""></span><i class="fa fa-th-large"></i><span class="title"> Post Office </span><span--%>
                    <%--class="arrow "></span></a>--%>
                <%--<ul class="sub-menu">--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/postofficelistview"><i class="fa fa-edit"></i> Post Office List--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/addpostofficeview"><i class="fa fa-edit"></i> Add Post Office--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li id="addSublistcitymenu"><a href="#"><span class=""></span><i class="fa fa-th-large"></i><span class="title"> City Corporation </span><span--%>
                    <%--class="arrow "></span></a>--%>
                <%--<ul class="sub-menu">--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/getcitylist"><i class="fa fa-edit"></i> City Corporation List--%>
                        <%--</a></li>--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/addcity"><i class="fa fa-edit"></i> City Corporation Add--%>
                        <%--</a></li>--%>
                    <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<a href="<%=request.getContextPath()%>/upazillaassign"><i class="fa fa-edit"></i> Ward Assign&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</a></li>&ndash;%&gt;--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li id="addSublistcitywardmenu"><a href="#"><span class=""></span><i class="fa fa-th-large"></i><span class="title"> City Corporation Ward </span><span--%>
                    <%--class="arrow "></span></a>--%>
                <%--<ul class="sub-menu">--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/getwardlist"><i class="fa fa-edit"></i> City Corporation Ward List--%>
                        <%--</a></li>--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/addward"><i class="fa fa-edit"></i> City Corporation Ward Add--%>
                        <%--</a></li>--%>


                <%--</ul>--%>
            <%--</li>--%>

            <%--<li id="union"><a href="#"><span class=""></span><i class="fa fa-th-large"></i><span class="title"> Union </span><span--%>
                    <%--class="arrow "></span></a>--%>
                <%--<ul class="sub-menu">--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/unionlistview"><i class="fa fa-edit"></i> Union List--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/addunionview"><i class="fa fa-edit"></i> Add Union--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>

            <%--<li id="municipality"><a href="#"><span class=""></span><i class="fa fa-th-large"></i><span class="title"> Municipality </span><span--%>
                    <%--class="arrow "></span></a>--%>
                <%--<ul class="sub-menu">--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/municipalitylistview"><i class="fa fa-edit"></i> Municipality List--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/addmunicipalityview"><i class="fa fa-edit"></i> Add Municipality--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>

            <%--<li id="municipalityward"><a href="#"><span class=""></span><i class="fa fa-th-large"></i><span class="title"> Municipality Ward </span><span--%>
                    <%--class="arrow "></span></a>--%>
                <%--<ul class="sub-menu">--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/municipalitywardlistview"><i class="fa fa-edit"></i> Municipality Ward List--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="<%=request.getContextPath()%>/addmunicipalitywardview"><i class="fa fa-edit"></i> Add Municipality Ward--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>
        <%--</ul>--%>
    <%--</li>--%>

    ${sidemenu}




    <%--<li id="frameMenu">--%>
    <%--<a href="#"><span class="gen-office1"></span><span class="title"> Framework Registration  </span><span class="arrow "></span></a>--%>
    <%--<ul class="sub-menu">--%>

    <%--<li id="addfSubmenu">--%>
    <%--<a href="<%=request.getContextPath()%>/appregistration"><i class="fa fa-edit"></i> Framework Add </a>--%>
    <%--</li>--%>


    <%--<li id="assignfOfficeoOfficeSubmenu">--%>
    <%--<a href="<%=request.getContextPath()%>/edit"><i class="fa fa-list"></i> Framework List</a>--%>
    <%--</li>--%>

    <%--</ul>--%>
    <%--</li>--%>

    <%--<li id="OfficerMenu">--%>
        <%--<a href="#"><span class="gen-officer1"></span><span class="title"> Service Catalog </span><span--%>
                <%--class="arrow "></span></a>--%>
        <%--<ul class="sub-menu">--%>

            <%--<li id="searchOfficerSubmenu"><a href="../ViewOfficer.do"><i class="fa fa-list"></i> Catalog List </a></li>--%>

        <%--</ul>--%>
    <%--</li>--%>


    <input type="hidden" name="orgid" id="orgId" value="${sessionScope.organogramId}">


</ul>


<script>
    var data = [];
    function getchildbyparentid(id) {
        var databyid=[];
        for( i=0;i<data.length;i++){
            if(data[i].parentId == id)databyid[i]=data[i];
        }
        return databyid;
    }

    var level = 0;
    function  makeSideMenu( id){
        var sideMenu = "";
        var clist=[];
        clist = getchildbyparentid(id);

        if(clist.length ==0)return "</a>\n";
        else if((level+1) !=1)sideMenu = " <span\n" +
            "                        class=\"arrow \"></span></a>\n";

        level++;
        if(level !=1)sideMenu += "\n<ul class=\"sub-menu\">\n";

        clist.forEach(function (currentvalue,index,clist) {
            if(level ==1){
                sideMenu += "\t\n<li id=\""+currentvalue.id+"\"> \t<a href=\"#\"><span class=\"gen-office1\"></span><span class=\"title\"> "+currentvalue.nameBng+"  </span>"+makeSideMenu(currentvalue.id)+"\n</li>";
            }
            else{
                sideMenu += "\t\n <li id=\""+currentvalue.id+"\">\n" +
                    "                        \t<a href=\"<%=request.getContextPath()%>/"+currentvalue.url+"?menuid="+currentvalue.id+"\"><i class=\"fa fa-edit\"></i> "+currentvalue.nameBng+makeSideMenu(currentvalue.id)+"\n</li>";
            }
        });
        if(level !=1)sideMenu +="\n</ul>\n";
        level--;
        return sideMenu;
    }

    function  makeAppMenu( id){



        var sideMenu = "";
        var plist=[];
        var clist=[];
        plist = getchildbyparentid(id);

        if(plist.length!=0) {
            sideMenu +=sideMenu += "\t\n<li id=\"application\"> \t<a href=\"#\"><span class=\"gen-office1\"></span><span class=\"title\"> Application  </span> <span\n" +
                "                        class=\"arrow \"></span></a>\n<ul class=\"sub-menu\">\n";
            plist.forEach(function (currentvalue, index, clist) {
                clist = getchildbyparentid(currentvalue.id);
                if (clist.length == 0)
                    sideMenu += "\t\n <li id=\"" + currentvalue.id + "\" icon = "+currentvalue.iconUrl+">\n" +
                        "                        \t<a  href=\"" + currentvalue.url + "\"target='_blank'><i class=\"fa fa-edit\"></i> " + currentvalue.nameBng + "</a></li>";

                else {
                    sideMenu += "\t\n <li id=\"" + currentvalue.id + "\" icon = "+currentvalue.iconUrl+">\n" +
                        "                        \t<a href=\"" + currentvalue.url + "\" target='_blank'><i class=\"fa fa-edit\"></i> " + currentvalue.nameBng + " <span\n" +
                        "                        class=\"arrow \"></span></a>\n<ul class=\"sub-menu\">\n";

                    sideMenu += "\t\n <li id=\"" + currentvalue.id +"home" + "\">\n" +
                        "                        \t<a href=\"" + currentvalue.url + "\" target='_blank'><i class=\"fa fa-edit\"></i> Home </a>\n</li>";
                    clist.forEach(function (cvalue, index, plist) {
                        sideMenu += "\t\n <li id=\"" + cvalue.id + "\">\n" +
                            "                        \t<a href=\"" + cvalue.url + "\" target='_blank'><i class=\"fa fa-edit\"></i> " + cvalue.nameBng + "</a>\n</li>";
                    });
                    sideMenu += "</ul>\n</li>";
                }

            });
            sideMenu +="</ul>\n</li>";
        }

        return sideMenu;
    }

    function storeValue(key, value) {
        if (localStorage) {
            localStorage.setItem(key, value);
        } else {
            $.cookies.set(key, value);
        }
    }

    function getStoredValue(key) {
        if (localStorage) {
            return localStorage.getItem(key);
        } else {
            return $.cookies.get(key);
        }
    }


    $(document).ready(function(){

        var orgID=$('#orgId').val();
        var app = "",side = "";
        localStorage.clear();
        var key = "sidemenu"+1;
       // window.localStorage.clear();
        var menu = getStoredValue(key);
        if(menu!=null){
            $("#sidebar").append(menu);
        }
        else {
            $.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/getappdata",
                data: {
                    id: orgID
                },
                async: false,
                success: function (response) {
                    data = response;
                    var s = makeAppMenu(-1);
                    $("#sidebar").append(s);
                    app = s;
                    return response;
                },
                error: function () {
                    alert('Error occured');
                }
            });

            $.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/getsidemenudata",
                data: {
                    id: orgID
                },
                async: false,
                success: function (response) {
                    data = response;
                    var s = makeSideMenu(-1);
                    $("#sidebar").append(s);
                    side = s;
                    return response;
                },
                error: function () {
                    alert('Error occured');
                }
            });

            storeValue(key,app+"\n"+side);


        }

    });
</script>
<!-- END SIDEBAR MENU -->