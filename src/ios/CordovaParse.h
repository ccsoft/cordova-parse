#import <Foundation/Foundation.h>
#import <Cordova/CDVPlugin.h>

@interface CordovaParse : CDVPlugin {

}

- (void) getInstallationId:(CDVInvokedUrlCommand*)command;
- (void) setKeyValue:(CDVInvokedUrlCommand*)command;

@end
