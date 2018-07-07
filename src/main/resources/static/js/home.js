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
    xmlhttp.onreadystatechange = function (ev) {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            alert("发送成功");
        }
        else {
            alert("发送失败");
        }
    }
    xmlhttp.open("get", "/", true);
    xmlhttp.send();
}