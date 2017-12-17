    
	
	//java code for json


    ArrayList<JSONObject> makeJsTree(int id,ArrayList<MenuDTO> childlist){
        ArrayList<MenuDTO> clist = getchildbyparentid(id, childlist);
        ArrayList<JSONObject> jsondata = new ArrayList<>();

        for (MenuDTO m: clist
                ) {
           JSONObject  js = new JSONObject();
           js.put("id",m.getId());
           js.put("text",m.getNameBng());
           js.put("children",makeJsTree(m.getId(),childlist));
            jsondata.add(js);
        }
        return jsondata;
    }
	
	  ArrayList<JSONObject> menuForJsTree(){
        ArrayList<JSONObject> js = null;
        ArrayList<MenuDTO> data = null;
        try {
            data = menuDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        js = makeJsTree(-1,data);
        return  js;

    }
	
	
	//html
	 <input type="hidden" name="menuids[]" id ="jstreeselectednode"/>
        <div class="form-group col-md-12" style="margin-top: 40px">

        <label class="control-label col-md-12" style="width: auto">Select menu</label>

        </div>
        <div class="form-group" style="height: 475px;">


        <div class=" col-md-offset-1 col-md-10" id="jstree" style="height: 475px;overflow-y: scroll;">

        </div>
    </div>
	
	
	//javascript
	
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
                $('#jstree').jstree(inCommand, ChildrenNodes);
            }
        }
        $('#jstree').on("select_node.jstree", function (e, data) {
            $('#jstree').jstree('open_node', data.node);
            OKtoCascadeDown++;
            CascadeUp(data.node, 'select_node');
            OKtoCascadeDown--;
            CascadeDown(data.node, 'open_node');
            CascadeDown(data.node, 'select_node');
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

        $("#form").submit(function () {

            var checked_ids = [];
            checked_ids = $("#jstree").jstree("get_selected");
            $("#jstreeselectednode").val(checked_ids);
        });