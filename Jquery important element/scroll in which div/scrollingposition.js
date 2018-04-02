$(document).scroll(function () {
						var doc = $(document);
						var win = $(window);
						var docTop = doc.scrollTop();
						var winheight = window.innerHeight;

						var scrollposition = (docTop<winheight)?docTop:(docTop+winheight);
						console.log(scrollposition);

});