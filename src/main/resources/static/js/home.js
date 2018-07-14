


function message(id) {
    var xmlhttp;
    if(window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            swal({
                position: 'center',
                type: 'success',
                title: 'Your work has been saved',
                showConfirmButton: false,
                timer: 3000
            });
            setTimeout("location.reload(true)",3000)
            ;
        }
    };
    var content = new FormData();
    content.append("title", document.getElementsByName(id)[0].value);
    content.append("content", document.getElementsByName(id)[1].value);
    content.append("type", id);
    xmlhttp.open("post", "/", true);
    xmlhttp.send(content);
}

function changeColor(){
    document.getElementById("header").className = "mdl-layout__tab-bar mdl-js-ripple-effect mdl-color--blue-50";
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

