const app = angular.module("app", ['ui.router']);

app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider
        .when('/', '/menu')
        .otherwise('/menu');

    $stateProvider
        .state("menu", {
            url: '/menu',
            templateUrl: "menu.html"
        })
        .state("polisa", {
            url: '/polisa',
            templateUrl: "rejestracjapolisy.html"
        })
       .state("szukaj", {
            url: '/szukaj',
            templateUrl: "wyszukiwaniepolis.html"
        });
});