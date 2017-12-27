    <link href="../assets/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
    <link href="../assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />

    <link href="../assets/global/plugins/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/jquery-multi-select/css/multi-select.css" rel="stylesheet" type="text/css" />
    <!-- Include the plugin's CSS and JS: -->
    <link rel="stylesheet" href="../assets/css/bootstrap-multiselect.css" type="text/css"/>

<html>

<select name="appid[]" id="multiple" class="form-control select2-multiple" multiple>
        <c:forEach var="app" items="${app}">
            <option value="${app.getId()}">
                ${app.getNameBng()}
            </option>
		</c:forEach>
</select>
												
												
</html>




<script>
                    var $select = $('#multiple');
					
					//------------------------new option add for mutiselect
					// save current config. options
                    var options = $select.data('select2').options.options;

					// delete all items of the native select element
                    $select.html('');

					// build new items
                    var items = ['a'];
                    for (var i = 0; i < items.length; i++) {


                    //     items.push({
                    //            "id": '1',
                    //        "text": 'jihi'
                    //});

                        $select.append('<option value="' + '1' + '" selected="selected">' + 'jihi' + '</option>');
                    }

					// add new items
                    options.data = items;
                    $select.select2(options);
					
					//---------------------------###--------------------------
					
					//--------------------------programmmatically select a option with value 4005

                    $select.val('4005').trigger('change');
					
					//---------------------------###----------------------------

</script>


<script src="../assets/global/plugins/respond.min.js"></script>
<script src="../assets/global/plugins/excanvas.min.js"></script>
<![endif]-->

<script src="../assets/global/plugins/select2/js/select2.full.js" type="text/javascript"></script>
<script src="../assets/global/scripts/app.min.js" type="text/javascript"></script>
<script src="../assets/pages/scripts/components-select2.js" type="text/javascript"></script>

<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="../assets/global/plugins/bootstrap-select/js/bootstrap-select.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/jquery-multi-select/js/jquery.multi-select.js" type="text/javascript"></script>

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="../assets/pages/scripts/components-multi-select.min.js" type="text/javascript"></script>
<script type="text/javascript" src="../assets/global/plugins/bootstrap-multiselect.js"></script>