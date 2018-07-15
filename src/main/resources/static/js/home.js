


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
                title: 'Your moment has been posted',
                showConfirmButton: false,
                timer: 2000
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

function changeColor(obj){
    var id = obj.id;

    var tab_color_value ;
    var header_color_value;

    switch (id){
        case "daily_tab":
            header_color_value = "purple-500";
            tab_color_value    = "purple-800";
            console.log(header_color_value +"\n"+tab_color_value);
            break;
        case "second_hand_tab":
            header_color_value = "indigo-500";
            tab_color_value    = "indigo-800";
            break;
        case "hire_tab":
            header_color_value = "blue-500";
            tab_color_value    = "blue-800";
            break;
        case "parttime_job_tab":
            header_color_value = "green-500";
            tab_color_value    = "green-800";
            break;
        case"news_tab":
            header_color_value = "teal-500";
            tab_color_value    = "teal-800";
            break;
            //todo change color
        case"question_tab":
            header_color_value = "blue-500";
            tab_color_value    = "blue-800";
            break;

    }
    var tabs_color =  "mdl-layout__tab-bar mdl-js-ripple-effect mdl-color--"+tab_color_value;
    var header_color = "mdl-layout__header mdl-layout__header--scroll mdl-color--"+header_color_value;

    // console.log(tabs_color + "\n"+header_color);
    document.getElementById("header_tabs").className = tabs_color;
    document.getElementById("header_container").className = header_color;
}

function showError(){
    swal({
        position: 'center',
        type: 'Error',
        title: 'Refresh Time out!',
        showConfirmButton: false,
        timer: 3000
    });
    setTimeout("location.reload(true)",3000);
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

