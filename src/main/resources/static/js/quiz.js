$(function () {
    $('#quizForm').on("submit", function (event) {
        let numberOfQuestions = $('.list-group-item').length;
        let numberOfCheckedGroups = $("input:checked").length;
        if (numberOfCheckedGroups < numberOfQuestions) {
            event.preventDefault();
            $('#error-incomplete-quiz').toggle()
        }
    });
});