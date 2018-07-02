$(function () {
    $('.correct-answer-group').on('change', function () {
        $('.correct-answer-group').not(this).prop('checked', false).removeAttr('required');
        $(this).attr('required', 'required')
    });
});