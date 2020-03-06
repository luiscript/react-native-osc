import Foundation
import SwiftOSC

@objc(Osc) class Osc: NSObject {
    
    var client:OSCClient!
    var server:OSCServer!
    
    @objc(createServer:port:)
    func createServer(name: String, port: NSNumber) -> Void {
        client = OSCClient(address: name, port: port.intValue)
    }
    
    @objc(sendMessage:value:)
    func sendMessage(name: String, value: NSNumber) -> Void {
        let message = OSCMessage(
            OSCAddressPattern(name),
            value.floatValue
        )
        client.send(message)
    }
    
    @objc(addEvent:location:date:)
    func addEvent(name: String, location: String, date: NSNumber) -> Void {
        
    }

    @objc
    func constantsToExport() -> [String: Any]! {
      return ["someKey": "someValue"]
    }
    
    
    @objc func createServer() -> Void {
        
    }
}



