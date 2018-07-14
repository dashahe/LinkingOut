function follow() {
    var xmlhttp;
    if(window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("");
    }
    xmlhttp.onreadystatechange = function() {
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            alert("关注成功");
        }
    }
    // var form = new FormData($('p#uid')[0]);
    var form = new FormData();
    form.append("staruid", document.getElementById("uid").innerText);
    xmlhttp.open("post", "/follow/process", true);
    xmlhttp.send(form);
}