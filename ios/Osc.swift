import Foundation
import SwiftOSC

@objc(Osc) class Osc: NSObject {
    
    var client:OSCClient!
    
    @objc(createServer:location:date:)
    func createServer(name: String, location: String, date: NSNumber) -> Void {
        client = OSCClient(address: "localhost", port: 9090)
        print("cliente creado");
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
        print("message enviado");
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



