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

package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import java.net.*;
import java.util.*;


public class OscModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    /*private String ipAddress = "localhost";
    private int portNumber = 9000;

    private OSCPortOut client;
    private OSCPortIn server;*/

    public OscModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "Osc";
    }

    @ReactMethod
    public void createClient(String address, int port){
       /* ipAddress = address;
        portNumber = port;

        try {
            client = new OSCPortOut(InetAddress.getByName(ipAddress), portNumber);
        } catch(UnknownHostException e) {

            return;
        } catch(Exception e) {

            return;
        }*/

    }

    @ReactMethod
    public void sendMessage(String address, float value){
        /*Object[] dataToSend = new Object[1];
        dataToSend[0] = value;
        OSCMessage message = new OSCMessage(ipAddress, dataToSend);
        client.send(message);*/
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }
}
