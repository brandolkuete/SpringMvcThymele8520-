$(document).ready(function () {
    var btnModif = document.querySelector("#btnModif");
    if (btnModif){
        btnModif.addEventListener("click", function (evt) {
            evt.preventDefault();
            var form = btnModif.parentElement.parentElement;
            for (var i=2; i<form.elements.length; i++){
                form.elements[i].disabled = false;
            }
            this.remove();
        });
    }

    var forms = document.querySelectorAll(".confirmDeleteData");
    for (var i=0; i<forms.length; i++){
        forms[i].addEventListener("click", function (e) {
            if (confirm("Êtes vous sûr de vouloir supprimer cette information ?") === false){
                e.preventDefault();
            }
        })
    }

    $("#locales").change(function () {
        var selectedOption = $('#locales').val();
        if (selectedOption != ''){
            var cheminComplet = document.location.href;
            window.location.replace(cheminComplet+'?lang=' + selectedOption);
        }
    });
});
