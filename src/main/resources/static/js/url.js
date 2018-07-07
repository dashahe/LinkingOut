function getUrl() {
    var uid = document.getElementById("uid").value;
    document.getElementById("form").action = "/" + uid + "/edit";
}

function goto(url) {
    window.open(url);
}