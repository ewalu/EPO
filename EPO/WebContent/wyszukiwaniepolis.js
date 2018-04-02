const app = angular.module("app",[]);
app.controller('mojCtrl', function($scope, $http){
    const scope = $scope;
    scope.mojTekst = 'test';

    scope.isSave = 'false';

    scope.symbole=[
        'AC',
        'OC',
        'NNW'
    ];
    
    scope.modelubezpieczenia = {
        symbolubezpieczenia : null
    }
});
