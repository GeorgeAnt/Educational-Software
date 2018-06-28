$(function () {
    $('.correct-answer-group').on('change', function () {
        $('.correct-answer-group').not(this).prop('checked', false);
        $('#editQuizSubmit').removeAttr('disabled')
    });

    $('#editQuizSubmit').on('click', function (e) {
        if ($(".correct-answer-group:checked").length === 0) {
            e.preventDefault();
            $(this).attr('disabled', 'disabled')
        } else {
            e.target.closest('form').submit()
        }
    });
    //TODO ADD VALIDATIONS
});