
<script type="text/javascript" src="../assets/global/plugins/bootbox/bootbox.min.js"></script>
<script type="text/javascript"src="../static/assets/js/common/modalcontrol.js"></script>

function showModal(id,url) {
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
                var data;
                $.ajax({
                    type:"POST",
                    url : url,
                    data : {
                        id: id
                    },
                    async: false,
                    success : function(response) {
                        data = response;
                        return response;
                    },
                    error: function() {
                        alert('Error occured');
                    }
                });
                $('.modal.in .modal-dialog').hide();
                $(".modal.in .modal-dialog .btn").off("click");

            }else{
                $('.modal.in .modal-dialog').hide();
                $(".modal.in .modal-dialog .btn").off("click");
            }

        }
    });

}