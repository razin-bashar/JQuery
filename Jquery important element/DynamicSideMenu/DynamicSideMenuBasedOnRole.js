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
                sideMenu += "\t\n<li id=\""+currentvalue.nameBng+"\"> \t<a href=\"#\"><span class=\"gen-office1\"></span><span class=\"title\"> "+currentvalue.nameBng+"  </span>"+makeSideMenu(currentvalue.id)+"\n</li>";
            }
            else{
                sideMenu += "\t\n <li id=\""+currentvalue.nameBng+"\">\n" +
                    "                        \t<a href=\"<%=request.getContextPath()%>/"+currentvalue.url+"\"><i class=\"fa fa-edit\"></i> "+currentvalue.nameBng+makeSideMenu(currentvalue.id)+"\n</li>";
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
                        sideMenu += "\t\n <li id=\"" + cvalue.nameEng + "\">\n" +
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
        var app = "",side = "";
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
                    id: 1
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
                    id: 1
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