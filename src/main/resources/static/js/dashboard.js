$(document).ready(function () {
    let dashboardInfoIntro = introJs();
    let dashboardOptions = {
        steps: [
            {
                element: '#test-button',
                intro: 'Press here to test your knowledge on 3 English chapters.'
            },
            {
                element: '#stat-button',
                intro: 'Press here to see your stats.'
            },
            {
                element: '#dropdownStudentChapterButton',
                intro: 'Choose the chapter you want to study.'
            },
            {
                element: '#add-question',
                intro: 'Press here to add questions.'
            },
            {
                element: '#dropdownChapterEditButton',
                intro: 'Press here to edit or delete questions'
            },
            {
                element: '#dropdownChapterButton',
                intro: 'Press here to edit the theory of a chapter.'
            },
        ]
    };

    dashboardInfoIntro.setOptions(dashboardOptions);
    $("#intro-information").on("click", function (e) {
        dashboardInfoIntro.start();
    });

});