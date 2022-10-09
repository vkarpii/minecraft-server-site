var element = document.getElementById('copy');
var text = element.innerText;

function copy(){
    navigator.clipboard.writeText(text)
        .then(() => {
            document.getElementById("copy").innerHTML = "  Скопійовано!  "
            })
        .catch(err => {
            console.log('Something went wrong', err);
        })
}
function outFunc() {
    element.innerHTML = text;
}