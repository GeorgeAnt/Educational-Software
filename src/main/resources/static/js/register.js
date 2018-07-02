$(document).ready(function(){
    const alphaRegex = /^[a-zA-Z]+$/;
    $( "#password,#passwordConfirm").on('keyup', function () {
        let password = $("#password").val();
        let confirm = $("#passwordConfirm").val();
        if(password.length>2){
            if(confirm !== password){
                $(this).removeClass("match").addClass("mismatch");
                $(this)[0].setCustomValidity("Please enter matching passwords");
            }else{
                $(this).removeClass("mismatch").addClass("match");
                $(this)[0].setCustomValidity("");
            }
        }else{
            $(this).removeClass("mismatch , match");
        }
    });

    $( "#name,#surname").on('keyup', function () {
        $(this).val().match(alphaRegex) ? $(this)[0].setCustomValidity("") : $(this)[0].setCustomValidity("Please enter only English characters") ;
    });
});