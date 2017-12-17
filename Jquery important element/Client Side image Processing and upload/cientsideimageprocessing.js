 var input = $("#uploadimage");
        input.on('change', handleFiles);

        function handleFiles(e) {
            var img = new Image;
            img.src = URL.createObjectURL(e.target.files[0]);
            img.onload = function() {
                resizeImgSimple(img, 240, 240, 30,'jpeg',function (base64String) {
                    var blobBin = atob(base64String.split(',')[1]);
                    alert(blobBin.length);
                    var array = [];
                    for(var i = 0; i < blobBin.length; i++) {
                        array.push(blobBin.charCodeAt(i));
                    }
                    var file=new Blob([new Uint8Array(array)], {type: 'image/jpeg'});


                    var formdata = new FormData();
                    formdata.append("file", file);
                    $.ajax({
                        type: "POST",
                        processData: false,
                        contentType: false,
                        url: "<%=request.getContextPath()%>/imagechange",
                        data: formdata,
                        async: false,
                        success: function (response) {
                            alert("sucess");
                        },
                        error: function () {
                            alert('Error occured');
                        }
                    });
                });


            }
        }



        function resizeImgSimple(img, width, height, compressionquality, output_format,callback){
			// less the compressionquality == high the compression 
            var mime_type;
            if(output_format==="png"){
                mime_type = "image/png";
            } else if(output_format==="webp") {
                mime_type = "image/webp";
            } else {
                mime_type = "image/jpeg";
            }

            //converting to jpeg

            var canvasforjpeg =document.createElement('canvas');// document.getElementById("canvasEl");
            var ctx = canvasforjpeg.getContext('2d');
            canvasforjpeg.height = img.naturalHeight;
            canvasforjpeg.width = img.naturalWidth;
            ctx.fillStyle = '#fff';
            ctx.fillRect(0,0,canvasforjpeg.width, canvasforjpeg.height);
            ctx.drawImage(img,0,0,canvasforjpeg.width, canvasforjpeg.height);
            var image = new Image;
            image.src = canvasforjpeg.toDataURL('image/jpeg');
            image.onload = function () {
                //resizing and compressionquality changing
                var canvas = document.createElement('canvas');

                var  heightratio ,widthration;

                heightratio = height/img.height;
                widthratio = width/img.width;

                canvas.width = img.width*widthratio;
                canvas.height = img.height*heightratio;
                canvas.getContext("2d").drawImage(image, 0, 0, img.width*widthratio, img.height*heightratio);

                var newImageData = canvas.toDataURL(mime_type, compressionquality/100);

                callback(newImageData);


            };


        }