function selectac(i, j) {
    var a = document.getElementsByClassName("fade")[0];
    a.id = i;
    var b = document.getElementsByClassName("modal-title")[0];
    b.innerText = j;

}

function message() {
    if(window.XMLHttpRequest) {
        var xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject(" ");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            alert("发送成功");
        }
        else {
            alert("发送失败");
        }
    }
    xmlhttp.open("post", "/", true);
    xmlhttp.send();
}

function getUrl() {
    var uid = document.getElementById("uid").value;
    document.getElementById("form").action = "/" + uid + "/edit";
}

function goto(url) {
    window.open(url);
}