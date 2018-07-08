function follow(uid) {
    var xmlhttp;
    if(window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject();
    }
    xmlhttp.onreadystatechange = function() {
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            alert("关注成功");
        }
    }
    xmlhttp.open("post", "/follow/process", true);
    var formdata = new FormData();
    formdata.append("staruid", document.getElementById(uid).type);
    xmlhttp.send(formdata);
}