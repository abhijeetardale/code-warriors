
$(document).ready(function(){

  if ( $( "#home" ).length ) {

       $('nav a').removeClass("current-page-item");
       $('#homeLink').addClass("current-page-item");

  }

  if ( $( "#league" ).length ) {

       $('nav a').removeClass("current-page-item");
       $('#leagueLink').addClass("current-page-item");

  }

   if ( $( "#profile" ).length ) {

       $('nav a').removeClass("current-page-item");
       $('#profileLink').addClass("current-page-item");

  }

});

