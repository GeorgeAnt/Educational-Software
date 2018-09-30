$(document).ready(function () {
    let dashboardInfoIntro = introJs();
    let dashboardOptions = {
        steps: [
            {
                element: '#finished',
                intro: 'Press finished Theory when you think you are ready to take on the tests.'
            },
        ]
    };

    dashboardInfoIntro.setOptions(dashboardOptions);
    $("#intro-information").on("click", function (e) {
        dashboardInfoIntro.start();
    });

});