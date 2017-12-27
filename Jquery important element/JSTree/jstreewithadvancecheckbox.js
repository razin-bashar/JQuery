    var previousState = [];
        var previousMenuList = [];
        var previousAppList =[];
        var state = 1;

        $('#jstree').jstree({
            'core' : {
                'data': {
                    'method':'POST',
                    'url': function (node) {

                        return   '<%=request.getContextPath()%>/menutree';
                    },
                    'data': function (node) {

                        return {'id': 1, "li_attr": "", "a_attr": ""};

                    }

                },
                'themes' : {
                    'responsive': false
                }
            },'types' : {
                'default' : {
                    'icon' : 'fa fa-folder icon-state-warning icon-lg'
                },
                'file' : {
                    'icon' : 'fa fa-file icon-state-warning icon-lg'
                }
            },
            'checkbox' : {
                'keep_selected_style': false,
                'three_state': false,
                'cascade': ''
            },
            'plugins' : [ 'types','checkbox' ]
        });

        var OKtoCascadeUp = 0;
        var OKtoCascadeDown = 0;
        var propagtionLevel = 0;
        var propagate = true;


        function CascadeUp(inNode, inCommand) {
            if (OKtoCascadeUp < 1) {
                ParentNode = $('#jstree').jstree('get_parent', inNode);
                if(ParentNode !='#' && state ==1) previousMenuList["#_"+ParentNode] = 1;
                $('#jstree').jstree(inCommand, ParentNode);
            }
        }

        function CascadeUpBack(inNode, inCommand) {
            if (propagtionLevel <= 1) {
                ParentNode = $('#jstree').jstree('get_parent', inNode);
                ChildrenNodes = jQuery.makeArray($('#jstree').jstree('get_children_dom', ParentNode));


                for(var i=0;i<ChildrenNodes.length;i++)
                {
                    var value = ChildrenNodes[i].attributes[1].nodeValue;
                    if(value == "true"){
                        propagate = false;
                    }
                }
                if(propagate){
                    propagtionLevel -=2;
                    $('#jstree').jstree(inCommand, ParentNode);
                }

            }
        }

        function CascadeDown(inNode, inCommand) {
            if (OKtoCascadeDown < 1) {
                ChildrenNodes = jQuery.makeArray($('#jstree').jstree('get_children_dom', inNode));
                if(ChildrenNodes.length !=0) $('#jstree').jstree(inCommand, ChildrenNodes);
            }
        }
        $('#jstree').on("select_node.jstree", function (e, data) {
            $('#jstree').jstree('open_node', data.node);
            OKtoCascadeDown++;
            CascadeUp(data.node, 'select_node');
            OKtoCascadeDown--;
            if(OKtoCascadeDown<1)
            {
                CascadeDown(data.node, 'open_node');
                CascadeDown(data.node, 'select_node');
            }
        });

        // Deselection Actions
        $('#jstree').on("deselect_node.jstree", function (e, data) {
            $('#jstree').jstree('open_node', data.node); //need this to have it deselect hidden nodes
            propagtionLevel ++;
            if(propagtionLevel >=1) {
                CascadeDown(data.node, 'open_node');
                CascadeDown(data.node, 'deselect_node');
            }
            if(propagate == true)CascadeUpBack(data.node, 'deselect_node');
            propagate = true;
            propagtionLevel = 0;
            // CascadeDown(data.node, 'close_node');
            // $('#jstree').jstree('close_node', data.node); //need this to have it deselect hidden nodes
        });



        $('#organogramdropdown').change(function () {
            previousMenuList =[];

            $.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/selectedapp",
                data: {
                    desigid: $('#organogramdropdown').val()
                },
                async: false,
                success: function (response) {
                    var $select = $('#multiple');
                    $select.val(response).trigger('change');
                    for(var i=0;i<response.length;i++){
                        previousAppList["#_"+response[i]] =1;
                    }
                },
                error: function () {
                    alert('Error occured');
                }
            });


            for(var i=0;i<previousState.length;i++){
              $('#jstree').jstree('deselect_node', "#"+previousState[i]);
            }
                $.ajax({
                    type: "POST",
                    url: "<%=request.getContextPath()%>/leaf",
                    data: {
                        desigid: $('#organogramdropdown').val()
                    },
                    async: false,
                    success: function (response) {
                        data = response;
                        for(var i=0;i<response.length;i++) {
                            $('#jstree').jstree('select_node', "#"+response[i]);
                            previousMenuList["#_"+response[i]] =1;
                        }
                        state =0;
                        previousState = response;
                    },
                    error: function () {
                        alert('Error occured');
                    }
                });

//            });
        });


        $("#form").submit(function () {

            var deletedMenuList =[],insertedMenuList =[],deletedAppList = [],insertedAppList =[];
            var checked_ids = [];
            checked_ids = $("#jstree").jstree("get_selected");
            for(var i=0;i<checked_ids.length;i++){
                if(previousMenuList["#_"+checked_ids[i]] == undefined)insertedMenuList.push(checked_ids[i]);
                else if(previousMenuList["#_"+checked_ids[i]] == 1)previousMenuList["#_"+checked_ids[i]] = 0;
            }

            for (var k in previousMenuList){
                var x = k.split("_");
                if(previousMenuList[k]==1)deletedMenuList.push(x[1]);
            }

            var selectedApp = [];
            selectedApp = $('#multiple').val();
            for(var i=0;i<selectedApp.length;i++){
                if(previousAppList["#_"+selectedApp[i]] == undefined)insertedAppList.push(selectedApp[i]);
                else if(previousAppList["#_"+selectedApp[i]] == 1)previousAppList["#_"+selectedApp[i]] = 0;
            }

            for (var k in previousAppList){
                var x = k.split("_");
                if(previousAppList[k]==1)deletedAppList.push(x[1]);
            }

            $('#insertedMenu').val(insertedMenuList);
            $('#deletedMenu').val(deletedMenuList);
            $('#insertedApp').val(insertedAppList);
            $('#deletedApp').val(deletedAppList);






        });