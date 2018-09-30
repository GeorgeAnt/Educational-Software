$(document).ready(function () {
    let dashboardInfoIntro = introJs();
    let dashboardOptions = {
        steps: [
            {
                element: '#test-form',
                intro: 'Choose category, overall includes questions from all chapters.'
            },
        ]
    };

    dashboardInfoIntro.setOptions(dashboardOptions);
    $("#intro-information").on("click", function (e) {
        dashboardInfoIntro.start();
    });

});