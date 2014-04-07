/// <reference path="cordova-parse.d.ts"/>

module CC {
    export class CordovaParse implements ICordovaParse {
        getInstallationId(successcb: (installationId: string) => void, failcb?: (error: string) => void) {
            if (!(<any>window).cordova) {
                if (failcb) failcb("no cordova");
                return;
            }
            (<any>window).cordova.exec(
                (response) => {                    
                    successcb(response);
                },
                (err) => {
                    console.log("getAppVersion call failed with error: " + err);
                    if (failcb) failcb(err);
                }, "CordovaParse", "getInstallationId", []);
        }

        setKeyValue(key, value, successcb?: () => void, failcb?: (err: string) => void) {
            if (!(<any>window).cordova) {
                if (failcb) failcb("no cordova");
                return;
            }
            (<any>window).cordova.exec(
                (response) => {
                    successcb();
                },
                (err) => {
                    console.log("setKeyValue call failed with error: " + err);
                    if (failcb) failcb(err);
                }, "CordovaParse", "setKeyValue", [key, value]);
        } 
    }
}
declare var module;
module.exports = CC;
