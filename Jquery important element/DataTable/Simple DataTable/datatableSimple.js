   
   //css
   
    .minheight{
            min-height: 300px;
        }
        .marginleft{
            margin-left: 2%;
        }
        .marginright{
            margin-right: 2%;
        }
        .margintop{
            margin-top: 22.5px;
        }

        #sample_1_length label{
            margin-top:5px;
        }
        .pagination{
            margin-top: 20px;
        }
        .pagination > li > a, .pagination > li > span {
            color: white !important;
            /*border: 1px solid #2980B9!important;*/
            /*background-color: #2980B9!important;*/
            /*background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #2980B9), color-stop(100%, #2980B9))!important;*/
            /*background: -webkit-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
            /*background: -moz-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
            /*background: -ms-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
            /*background: -o-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
            /*background: linear-gradient(to bottom, #2980B9 0%, #2980B9 100%)!important;*/
        }
        .pagination > li.active > a, .pagination > li.active > span{background-color:green}
        .pagination > .disabled > a, .pagination > .disabled > a:focus, .pagination > .disabled > a:hover, .pagination > .disabled > span, .pagination > .disabled > span:focus, .pagination > .disabled > span:hover{color: white !important;
            /*border: 1px solid #2980B9!important;*/
            /*background-color: #2980B9!important;*/
            /*background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #2980B9), color-stop(100%, #2980B9))!important;*/
            /*background: -webkit-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
            /*background: -moz-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
            /*background: -ms-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
            /*background: -o-linear-gradient(top, #2980B9 0%, #2980B9 100%)!important;*/
            /*background: linear-gradient(to bottom, #2980B9 0%, #2980B9 100%)!important;}*/

        .header{
            /*background: rgba(227,227,227,1);*/
            /*background: -moz-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: -webkit-gradient(left top, left bottom, color-stop(0%, rgba(227,227,227,1)), color-stop(100%, rgba(184,196,207,1)));*/
            /*background: -webkit-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: -o-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: -ms-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: linear-gradient(to bottom, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#d4e4ef', endColorstr='#86aecc', GradientType=0 );*/
        }

        .footer{
            /*background: rgba(227,227,227,1);*/
            /*background: -moz-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: -webkit-gradient(left top, left bottom, color-stop(0%, rgba(227,227,227,1)), color-stop(100%, rgba(184,196,207,1)));*/
            /*background: -webkit-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: -o-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: -ms-linear-gradient(top, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*background: linear-gradient(to bottom, rgba(227,227,227,1) 0%, rgba(184,196,207,1) 100%);*/
            /*filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#d4e4ef', endColorstr='#86aecc', GradientType=0 );*/
        }
        thead{
            /*background: rgba(184,196,207,1);*/
            /*background: -moz-linear-gradient(top, rgba(184,196,207,1) 40%, rgba(160,175,188,1) 50%, rgba(255,255,255,1) 51%, rgba(227,227,227,1) 100%);*/
            /*background: -webkit-gradient(left top, left bottom, color-stop(40%, rgba(184,196,207,1)), color-stop(50%, rgba(160,175,188,1)), color-stop(51%, rgba(255,255,255,1)), color-stop(100%, rgba(227,227,227,1)));*/
            /*background: -webkit-linear-gradient(top, rgba(184,196,207,1) 40%, rgba(160,175,188,1) 50%, rgba(255,255,255,1) 51%, rgba(227,227,227,1) 100%);*/
            /*background: -o-linear-gradient(top, rgba(184,196,207,1) 40%, rgba(160,175,188,1) 50%, rgba(255,255,255,1) 51%, rgba(227,227,227,1) 100%);*/
            /*background: -ms-linear-gradient(top, rgba(184,196,207,1) 40%, rgba(160,175,188,1) 50%, rgba(255,255,255,1) 51%, rgba(227,227,227,1) 100%);*/
            /*background: linear-gradient(to bottom, rgba(184,196,207,1) 40%, rgba(200,175,188,1) 50%, rgba(255,255,255,1) 51%, rgba(227,227,227,1) 100%);*/
            /*filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#e2e2e2', endColorstr='#fefefe', GradientType=0 );*/
        }
		
		

		
	//html	
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
								
								
	 <div id='advancesearch' style='display:none;'>
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
			
	//javascript 
	//clientSide data table
	 //working
        var example_table = $('#sample_1').DataTable({
            'ajax': {
                url: '<%=request.getContextPath()%>/getOffice_LayerShow',
                dataSrc: ''
            },
            'columns': [
                {data: 'id'},
                {data: 'office_ministry_id'},
                {data: 'layer_name_bng'},
                {data: 'layer_level'},
                {data: 'layer_sequence'}
            ]
        });
        example_table.ajax.reload()
    });

    //working
    var table = $('#sample_1').dataTable({
        'processing': true,
        'serverside': true,
        'ajax': {
            url: '<%=request.getContextPath()%>/getOffice_LayerShow',
            dataSrc: ''
        },
        'columns': [
            {data: 'id'},
            {data: 'office_ministry_id'},
            {data: 'layer_name_bng'},
            {data: 'layer_level'},
            {data: 'layer_sequence'}
        ]
    });
   //javascript
   //ServerSide Pagination using sql query
        var table = $('#sample_1').dataTable({
            "bServerSide": true,
            "sDom": '<"row header"<"pull-left marginleft" l><"pull-right marginright toolbar ">><"minheight"t><"row footer"<"pull-left marginleft margintop"i><"pull-right marginright"p>>',
            "sPaginationType": "full_numbers",
            "sEcho": 1,
           // "ajax": {
           //     "url": "<%=request.getContextPath()%>/unionpage",
           //     "type": "POST",
           //     "data": {
           //         "para":"para"
           //     }
           // },
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
                    }

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
            ]


        });

        // $("div.toolbar").html('<div style="display:flex;width: 20%; float:right" > <input type="password" style="flex:1"> <button class="fa fa-arrow-down" id="advancesearch" type="submit"></button></div>');


        $("div.toolbar").html($('#advancesearch'));
        //$('#search-inp').onclick(function(){
        // table.search($(this).val());
        //   table.fnFilter(1);
        // });


        $('.dropdown-menu.advanced-file-search').click(function (event) {
            event.stopPropagation();
        });

        $('#AdvancedSearchSubmit').click(function () {
          //  if($('#divisiondropdown').val()!=-1){
                var searchKey = $('input[name = unionname]').val()+";"+$('input[name = unionbbscode]').val()+";"+$('#divisiondropdown').val()+";"+$('#districtdropdown').val()+";"+$('#upazilladropdown').val();
                table.fnFilter(searchKey);
                $('div.dropdown.dropdown-lg').removeClass("open");
                $('#districtdropdown').empty();
                $('#upazilladropdown').empty();


            //}


        });

        $('#searchFileMessage').keyup(function () {
            var searchKey = $(this).val()+";";
            table.fnFilter(searchKey);
            $('div.dropdown.dropdown-lg').removeClass("open");

        });