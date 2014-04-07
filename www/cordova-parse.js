/// <reference path="cordova-parse.d.ts"/>
var CC;
(function (CC) {
    var CordovaParse = (function () {
        function CordovaParse() {
        }
        CordovaParse.prototype.getInstallationId = function (successcb, failcb) {
            if (!window.cordova) {
                if (failcb)
                    failcb("no cordova");
                return;
            }
            window.cordova.exec(function (response) {
                successcb(response);
            }, function (err) {
                console.log("getAppVersion call failed with error: " + err);
                if (failcb)
                    failcb(err);
            }, "CordovaParse", "getInstallationId", []);
        };

        CordovaParse.prototype.setKeyValue = function (key, value, successcb, failcb) {
            if (!window.cordova) {
                if (failcb)
                    failcb("no cordova");
                return;
            }
            window.cordova.exec(function (response) {
                successcb();
            }, function (err) {
                console.log("setKeyValue call failed with error: " + err);
                if (failcb)
                    failcb(err);
            }, "CordovaParse", "setKeyValue", [key, value]);
        };
        return CordovaParse;
    })();
    CC.CordovaParse = CordovaParse;
})(CC || (CC = {}));

module.exports = CC;
