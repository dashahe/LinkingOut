


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
        }
    };
    var content = new FormData();
    content.append("content", document.getElementsByName("content")[0].value);
    content.append("type", id);
    xmlhttp.open("post", "/", true);
    xmlhttp.send(content);
}