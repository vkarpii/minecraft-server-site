const popUp = document.getElementById('pop-up' );
var id;
var name;

function onClick(id,num){//num=0 - prem num=1 - c
    popUp.classList.add('active');
    if (parseInt(num) === 0){
        name = "privilege";
    } else {
        name = "case";
    }

    let el = document.getElementById(parseInt(num)+'block'+parseInt(id) );
    document.getElementById('pop-name').innerHTML = "Назва : " + el.innerHTML;

    el = document.getElementById(parseInt(num)+'desc'+parseInt(id) );
    document.getElementById('pop-desc').innerHTML = "Опис : " + el.innerHTML;

    el = document.getElementById(parseInt(num)+'cost'+parseInt(id) );
    document.getElementById('pop-cost').innerHTML = "Ціна : " + el.innerHTML;
    this.id = id;
}
function clickClose(){
    popUp.classList.remove('active');
}

function submitPopUp(form){
    form.action = "/buy/" + name + "/" + parseInt(id);
}
