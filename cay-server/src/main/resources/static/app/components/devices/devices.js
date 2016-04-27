var DevicesCtrl = function(DeviceService){
  var self=this;
  DeviceService.getDevices().then(function(devices){
	  self.devices=devices.plain();
  });
};

var DevicesComponent = {
    controller:  DevicesCtrl,
    templateUrl: 'app/components/devices/devices.html'
};

angular.module('cayDashboard.components')
       .component('devices', DevicesComponent);
