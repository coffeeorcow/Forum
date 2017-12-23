
// 显示系统当前时间
function mytime() {
    var a = new Date();
    var b = a.toLocaleTimeString();
    var c = a.toLocaleDateString();
    document.getElementById("mytime").innerHTML = c + "&nbsp" + b;
}
setInterval(function () {
    mytime()
}, 1000);