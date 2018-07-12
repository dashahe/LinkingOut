function selectac(i, j) {
    var a = document.getElementsByClassName("fade")[0];
    a.id = i;
    var b = document.getElementsByClassName("modal-title")[0];
    b.innerText = j;
    var c;
    if(i === "rc") {
        c = 1;
    }
    if(i === "es") {
        c = 2;
    }
    if(i === "zp") {
        c = 3;
    }
    if(i === "jz") {
        c = 4;
    }


    switch (c) {
        case 1:
            document.getElementsByName("content")[0].innerHTML = "#Daily# ";
            break;
        case 2:
            document.getElementsByName("content")[0].innerHTML = "#Second Hand# ";
            break;
        case 3:
            document.getElementsByName("content")[0].innerHTML = "#Hire# ";
            break;
        case 4:
            document.getElementsByName("content")[0].innerHTML = "#Part-time Job# ";
            break;

    }
}

function message(id) {
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
    content.append("type", type);
    xmlhttp.open("post", "/", true);
    xmlhttp.send(content);
}