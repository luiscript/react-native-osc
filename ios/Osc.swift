/*
Copyright (C) 2020 Luis Fernando Garcia Perez
contacto@luiscript.com

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/


import Foundation
import SwiftOSC

@objc(Osc) class Osc: NSObject {
    
    var client:OSCClient!
    var server:OSCServer!
    
    @objc(createClient:port:)
    func createClient(name: String, port: NSNumber) -> Void {
        client = OSCClient(address: name, port: port.intValue)
        print("clientacho created")
    }
    
    @objc(sendMessage:data:)
    func sendMessage(name: String, data: NSArray) -> Void {
        let message = OSCMessage(OSCAddressPattern(name))
        
        for value in data {
            switch value {
                case let someInt as Int:
                    message.add(someInt)
                case let someDouble as Double where someDouble > 0:
                    message.add(someDouble)
                case let someBool as Bool:
                    message.add(someBool)
                default:
                    print("data not supported")
            }
        }
        client.send(message)
    }
    
    @objc func createServer() -> Void {
        
    }
}



