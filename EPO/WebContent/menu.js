app.controller('menuCtrl', function ($state, $scope) {

    const scope = $scope;

    scope.doPolisy = () => {
        $state.go('rejestracjapolisy');
    }

    scope.szukajPolise = () => {
        $state.go('wyszukiwaniepolis');
    }

    scope.init = () => {
        //$state.go('rejestracjapolisy');
        console.log('Menu INIT');
    }

});