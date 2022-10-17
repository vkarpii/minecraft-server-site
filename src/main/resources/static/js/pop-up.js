const openPopUp = document.getElementById('open-pop-up');
const closePopUp = document.getElementById('pop-up-close' );
const popUp = document.getElementById('pop-up' );

openPopUp.addEventListener('click', function(e){
    e.preventDefault();
    popUp.classList.add('active');
})

closePopUp.addEventListener('click', () => {
    popUp.classList.remove('active');
})

function onClick(){
    popUp.classList.add('active');
}
function clickClose(){
    popUp.classList.remove('active');
}
