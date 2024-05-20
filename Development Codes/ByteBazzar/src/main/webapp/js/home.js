document.addEventListener("DOMContentLoaded", function() {
    var checkbox = document.getElementById("click");
    var barsImg = document.getElementById("bars-img");
    var closeImg = document.getElementById("close-img");

    checkbox.addEventListener("change", function() {
        if (this.checked) {
            barsImg.style.display = "none";
            closeImg.style.display = "inline-block";
        } else {
            barsImg.style.display = "inline-block";
            closeImg.style.display = "none";
        }
    });
});
