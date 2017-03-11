angular.module("BDRApp", [])
        .value('urlBase', 'http://localhost:8084/bdr-locadora/rest/')
        .controller("CarroController", function ($http, urlBase) {
            var self = this;

            self.carros = [];
            self.carro = undefined;

            self.novo = function () {
                self.carro = {};
            };

            self.salvar = function () {
                var metodo = 'POST';
                if (self.carro.id) {
                    metodo = 'PUT';
                }

                $http({
                    method: metodo,
                    url: urlBase + 'carros/',
                    data: self.carro
                }).then(function successCallback(response) {
                    self.atualizarTabela();
                }, function errorCallback(response) {
                    self.ocorreuErro();
                });
            };

            self.alterar = function (carro) {
                self.carro = carro;
            };

            self.deletar = function (carro) {
                self.carro = carro;

                $http({
                    method: 'DELETE',
                    url: urlBase + 'carros/' + self.carro.id + '/'
                }).then(function successCallback(response) {
                    self.atualizarTabela();
                }, function errorCallback(response) {
                    self.ocorreuErro();
                });
            };

            self.ocorreuErro = function () {
                alert("Ocorreu um erro inesperado!");
            };

            self.atualizarTabela = function () {
                $http({
                    method: 'GET',
                    url: urlBase + 'carros/'
                }).then(function successCallback(response) {
                    self.carros = response.data;
                    self.carro = undefined;
                }, function errorCallback(response) {
                    self.ocorreuErro();
                });
            };

            self.activate = function (){
                self.atualizarTabela();
            };
            self.activate();
        });