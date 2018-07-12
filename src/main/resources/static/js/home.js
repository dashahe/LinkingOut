function selectac(i, j) {
    var a = document.getElementsByClassName("fade")[0];
    a.id = i;
    var b = document.getElementsByClassName("modal-title")[0];
    b.innerText = j;

}

function message() {
    var xmlhttp;
    if(window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject(" ");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            alert("发送成功");
        }
    };
    var content = new FormData();
    content.append("content", document.getElementsByName("content")[0].value);
    var type = document.getElementsByClassName("fade")[0].id;
    switch (type) {
        case "rc":
            content.append("type", "rc");
            break;
        case "es":
            content.append("type", "es");
            break;
        case "zp":
            content.append("type", "zp");
            break;
        case "jz":
            content.append("type", "jz");
            break;
    }
    xmlhttp.open("post", "/", true);
    xmlhttp.send(content);
}