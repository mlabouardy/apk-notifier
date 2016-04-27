angular.module('cayDashboard.services',['restangular'])
       .config(function(RestangularProvider){
           RestangularProvider.setBaseUrl('/');
       });
