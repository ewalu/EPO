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
        premium : null,
        signDate : null,
        status : null,
        insuranceStartDate: null,
        insuranceEndDate: null,
        insured: null
    }

    scope.modelosoby = {
        id : null,
        firstName : null,
        lastName : null,
        pesel : null,
        birthDate : null
    }

    scope.osoby = [];

    scope.zapiszOsobePost = () =>{
        $http({
            method: 'POST',
            url: 'http://localhost:8080/EPO-0.0.1-SNAPSHOT/api/ubezpieczony/',
            data: scope.modelosoby,
            headers: { 'Content-Type': 'application/json' }
        }).
            then((response) => {
                isSave = true;
                alert(`Poprawnie zapisano dane osoby. Id: ${response.data.id}`);
            }, (response) => {
                alert('Błąd zapisu danych: ' + response.data);
            });
    }

    scope.wyszukajOsoby = () => {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/EPO-0.0.1-SNAPSHOT/api/ubezpieczony/find/getpersons',
            headers: { 'Content-Type': 'application/json ' }
        }).
            then((response) => {
                scope.osoby = response.data;
                console.log('ewa666'+response);
            }, (response) => {
                alert('Błąd podczas próby odczytu danych: ' + response.data);
                console.log('ewa666'+response);
});
    }
    
    scope.wyszukajOsobyPesel = () => {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/EPO-0.0.1-SNAPSHOT/api/ubezpieczony/find/getperson/'+scope.modelosoby.pesel,
            headers: { 'Content-Type': 'application/json ' }
        }).
            then((response) => {
                scope.osoby = response.data;
                scope.modelpolisy.insured = response.data[0];
                console.log('ewa666'+response);
            }, (response) => {
                alert('Błąd podczas próby odczytu danych: ' + response.data);
                console.log('ewa666'+response);
});
    }


    scope.zapiszPolisePost = () =>{
        $http({
            method: 'POST',
            url: 'http://localhost:8080/EPO-0.0.1-SNAPSHOT/api/polisa/',
            data: scope.modelpolisy,
            headers: { 'Content-Type': 'application/json' }
        }).
            then((response) => {
                isSave = true;
                alert(`Poprawnie zapisano dane polisy. Id: ${response.data.id}`);
            }, (response) => {
                alert('Błąd zapisu danych: ' + response.data);
            });
    }


    scope.zapiszPolise = () =>{
        $http(
            {
                method: 'GET',
                //params: scope.modelpolisy,
                url: 'http://localhost:8080/EPO-0.0.1-SNAPSHOT/api/polisa/create/'+scope.modelpolisy.policyNumber+'/'+scope.modelpolisy.signDate+'/'+scope.modelpolisy.premium+'/'+scope.modelpolisy.status,
                //params: {"numerPolisy": model.numerPolisy, "ubezpieczajacy": model.ubezpieczajacy, "skladka": model.sklad.ka},
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

    scope.wyszukajPolisyNumer = () => {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/EPO-0.0.1-SNAPSHOT/api/polisa/find/getpolicies/'+scope.modelpolisy.policyNumber,
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

