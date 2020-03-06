#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(Osc, NSObject)

RCT_EXTERN_METHOD(createServer:(NSString *)name port:(nonnull NSNumber *)port)
RCT_EXTERN_METHOD(sendMessage:(NSString *)name value:(nonnull NSNumber *)value)
@end

