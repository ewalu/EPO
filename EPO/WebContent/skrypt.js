const app = angular.module("app",[]);
app.controller('mojCtrl', function($scope, $http){
    const scope = $scope;
    scope.mojTekst = 'test';

    scope.model = {
        numerPolisy : null,
        ubezpieczajacy : null,
        sklaka : null
    }

    scope.test = () => {
        $http.post('http://localhost:8080/EJBSzkol/api/polisa',scope.model).
        
        then((response) => {
            alert('sukces');
        }, (response) => {
            alert('bład');
        })
    }
});