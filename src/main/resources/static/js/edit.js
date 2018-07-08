function request() {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject("m");
    }
    xmlhttp.open("get", "./edit", true);
    xmlhttp.send();
}