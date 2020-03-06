#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(Osc, NSObject)

RCT_EXTERN_METHOD(createServer:(NSString *)name location:(NSString *)location date:(nonnull NSNumber *)date)
RCT_EXTERN_METHOD(sendMessage:(NSString *)name location:(NSString *)location date:(nonnull NSNumber *)date)
@end

