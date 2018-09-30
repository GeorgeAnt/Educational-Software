$(function () {
    $('.correct-answer-group').on('change', function () {
        $('.correct-answer-group').not(this).prop('checked', false).removeAttr('required');
        $(this).attr('required', 'required')
    });

    let dashboardInfoIntro = introJs();
    let dashboardOptions = {
        steps: [
            {
                element: '#questionText',
                intro: 'Add your question.'
            },
            {
                element: '#answerText',
                intro: 'Add your answers.'
            },
            {
                element: '#isAnswer2Correct1',
                intro: 'Check the correct answer.'
            },
            {
                element: '#chapter-selection',
                intro: 'Select the chapter this question belongs to.'
            },
            {
                element: '#addQuiz',
                intro: 'Submit your question.'
            },
        ]
    };

    dashboardInfoIntro.setOptions(dashboardOptions);
    $("#intro-information").on("click", function (e) {
        dashboardInfoIntro.start();
    });
});