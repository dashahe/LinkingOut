


function message(id) {
    var xmlhttp;
    if(window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            alert("发送成功");
            location.reload(true);
        }
    };
    var content = new FormData();
    content.append("title", document.getElementsByName(id)[0].value);
    content.append("content", document.getElementsByName(id)[1].value);
    content.append("type", id);
    xmlhttp.open("post", "/", true);
    xmlhttp.send(content);
}


function star(aid) {
    var xmlhttp;
    if(window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("");
    }
    xmlhttp.onreadystatechange = function () {
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            location.reload(true);
        }
    };
    var star = new FormData();
    star.append("aid", aid);
    xmlhttp.open("post", "/star", true);
    xmlhttp.send(star);
}

