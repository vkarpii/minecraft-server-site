const targetDiv = document.getElementById("mainPartTwo");
const btn = document.getElementById("cases");

const targetDiv2 = document.getElementById("mainPartCases");
const btn2 = document.getElementById("privileges");
btn.onclick = function () {
    targetDiv.style.visibility = 'hidden ';
    targetDiv2.style.visibility = 'visible ';
};
btn2.onclick = function () {
    targetDiv2.style.visibility = 'hidden ';
    targetDiv.style.visibility = 'visible ';
};
