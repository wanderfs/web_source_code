/* 
 * any js code that needs to appear right before the closing </head>
 */

// Google Analytics
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-19023826-1']);
_gaq.push(['_trackPageview']);

(function() {
    var ga = document.createElement('script');
    ga.type = 'text/javascript';
    ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(ga, s);
})();

// change browser url on the fly
function urlAnchorTo(tagId) {
    var url = document.location.href;
    var idx = url.indexOf('#c');
    if (idx != -1)
        url = document.location.href.substring(0, idx);

    url = url.replace(/#nogo/i, ""); // remove extra tags.

    if ($("#" + tagId).length > 0)
        document.location.href = url + "#c" + tagId;
    //alert(document.location.href);
}

$(document).ready(function(){
    var url = document.location.href;
    var click_start = url.indexOf('#c');
    var click_elems = new Array();
    click_elems = url.substring(click_start + 2).split('|');
    for (var i = 0; i < click_elems.length; ++i) {
        //alert(click_elems[i]);
        $("#" + click_elems[i]).click();
    }
});