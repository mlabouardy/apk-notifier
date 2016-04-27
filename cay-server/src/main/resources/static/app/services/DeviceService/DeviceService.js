var DeviceService = function(Restangular) {
  	this.getDevices = function(){
  		return Restangular.all('devices').getList();
  	};
};

angular.module('cayDashboard.services')
       .service('DeviceService', ['Restangular', DeviceService]);
