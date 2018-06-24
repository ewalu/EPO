app.controller('menuCtrl', function ($state, $scope) {

    const scope = $scope;

    scope.doPolisy = () => {
        $state.go('polisa');
    }

    scope.szukajPolise = () => {
        $state.go('szukaj');
    }

    scope.doOsoby = () => {
        $state.go('osoba');
    }

    scope.init = () => {
        console.log('Menu INIT');
    }

});