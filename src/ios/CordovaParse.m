#import "CordovaParse.h"
#import <Cordova/CDV.h>

@implementation CordovaParse

- (void)getInstallationId:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    PFInstallation *currentInstallation = [PFInstallation currentInstallation];
    if(currentInstallation == nil) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"no parse installation found"];
    }
    else {
        NSString* value = [currentInstallation installationId];
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:value];
    }
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)setKeyValue:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    NSString* key = [command.arguments objectAtIndex:0];
	NSString* value = [command.arguments objectAtIndex:1];
    
    if (key != nil && value != nil) {
        PFInstallation *installation = [PFInstallation currentInstallation];
        [installation setObject:value forKey:key];
        [installation saveEventually];
        
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    } else { 
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"parse params are nil"];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
