function request() {
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject();
    }
    xmlhttp.open("get", "./edit", true);
    xmlhttp.send();
}