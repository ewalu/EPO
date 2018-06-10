app.controller('mojCtrl', function($scope, $http){
    const scope = $scope;
    scope.mojTekst = 'test';

    scope.isSave = 'false';

    scope.statusy=[
        'ZATWIERDZONA',
        'ZAWIESZONA',
        'ROZWIAZANA'

    ];

    scope.symbole=[
        'AC',
        'OC',
        'NNW',
        'H04'
    ];

    scope.modelpolisy = {
        policyNumber : null,
        ubezpieczajacy : null,
        skladka : null,
        signDate : null,
        statusPolisy : null,
        symbolubezpieczenia : null
    }

    scope.polisy = [];


    scope.zapiszPolise = () =>{
        $http(
            {
                method: 'GET',
                //params: scope.modelpolisy,
                url: 'http://localhost:8080/EPO-0.0.1-SNAPSHOT/api/polisa/create/'+scope.modelpolisy.policyNumber+'/'+scope.modelpolisy.ubezpieczajacy+'/'+scope.modelpolisy.skladka+'/'+scope.modelpolisy.statusPolisy,
                //params: {"numerPolisy": model.numerPolisy, "ubezpieczajacy": model.ubezpieczajacy, "skladka": model.skladka},
                //data: scope.modelpolisy,
                headers: {'Content-Type': 'application/json '},
                withCredentials: true
            }
        ).then(
            (response) => {
            isSave = true;
           alert(`Poprawnie zapisano dane polisy: ${response.data.policyNumber}`);
           console.log('ewa666'+response);
        }, (response) => {
            alert('Błąd zapisu danych dla: ' + scope.modelpolisy.policyNumber);
            console.log('ewa666'+response);
        }
    );
    }

    scope.wyszukajPolisy = () => {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/EPO-0.0.1-SNAPSHOT/api/polisa/find/getpolicies',
            headers: { 'Content-Type': 'application/json ' }
        }).
            then((response) => {
                scope.polisy = response.data;
                console.log('ewa666'+response);
            }, (response) => {
                alert('Błąd podczas próby odczytu danych: ' + response.data);
                console.log('ewa666'+response);
});
    }
});

