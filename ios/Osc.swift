import Foundation
import SwiftOSC

@objc(Osc) class Osc: NSObject {
    
    var client:OSCClient!
    
    @objc(createServer:location:port:)
    func createServer(name: String, location: String, port: NSNumber) -> Void {
        client = OSCClient(address: name, port: port.intValue)
        
        print(name + "-" + port.stringValue);
    }
    
    @objc(sendMessage:location:date:)
    func sendMessage(name: String, location: String, date: NSNumber) -> Void {
        let message = OSCMessage(
            OSCAddressPattern("test"),
            0.1,
            0.2,
            0.3,
            0.4,
            0.5,
            0.6,
            0.7,
            0.8,
            0.9,
            1.0
        )
        client.send(message)
        print("message enviado chingón");
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



