const app = angular.module("app",['ui.router']);

app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider
        .when('/', '/szukaj')
        .otherwise('/szukaj');

    $stateProvider
        .state("polisa", {
            url: '/polisa',
            templateUrl: "rejestracjapolisy.html"
        })
       .state("szukaj", {
            url: '/szukaj',
            templateUrl: "wyszukiwaniepolis.html"
        })
        .state("osoba", {
            url: '/osoba',
            templateUrl: "rejestracjaosoby.html"
        });
});