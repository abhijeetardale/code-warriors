
$(document).ready(function(){
  $('nav a').click(function(){
  alert("this is is" + $('nav a').attr("id"));
    $('nav a').removeClass("current-page-item");
    $(this).addClass("current-page-item");
});
});