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
        var form = new FormData($('form#form')[0]);
    xmlhttp.open("post", "/", true);
    xmlhttp.send(form);
}