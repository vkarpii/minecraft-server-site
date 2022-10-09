const targetDiv = document.getElementById("mainPartTwo");
const btn = document.getElementById("cases");

const targetDiv2 = document.getElementById("mainPartCases");
const btn2 = document.getElementById("privileges");
btn.onclick = function () {
    targetDiv.style.display = "none";
    targetDiv2.style.display = "flex";
};
btn2.onclick = function () {
    targetDiv2.style.display = "none";
    targetDiv.style.display = "flex";
};
