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

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.net.*;
import java.util.*;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.illposed.osc.*;

import javax.annotation.Nullable;

public class OscModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    private String ipAddress = "localhost";
    private int portIn = 9000;
    private int portOut = 9001;

    private OSCPortOut client;
    private OSCPortIn server;

    public OscModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "Osc";
    }

    @ReactMethod
    public void createClient(String address, int port) {
        ipAddress = address;
        portOut = port;

        try { client = new OSCPortOut(InetAddress.getByName(ipAddress), portOut);
        } catch(UnknownHostException e) {

            return;
        } catch(Exception e) {

            return;
        }

    }

    @ReactMethod
    public void sendMessage(String address, ReadableArray args) {
        // OSCMessage msg = new OSCMessage(address, args.toArrayList());
        ArrayList arr = new ArrayList();
        for (int i = 0; i < args.size(); i++) {
            switch (args.getType(i)) {
                case Boolean:
                    arr.add(args.getBoolean(i));
                    break;
                case Number:
                    double dVal = args.getDouble(i);
                    int iVal = (int) dVal;
                    if (iVal == dVal) {
                        // we have an int
                        arr.add(iVal);
                    } else {
                        // we have a floating point number
                        arr.add((float) dVal);
                    }
                    break;
                case String:
                default:
                    arr.add(args.getString(i));
                    break;
            }
        }
        OSCMessage msg = new OSCMessage(address, arr);
        try {
            client.send(msg);
        } catch (Exception e) {
            WritableMap params = Arguments.createMap();
            params.putString("error", address + ":" + e.toString());
            sendEvent(reactContext, "GotMessage", params);
        }

    }

    @ReactMethod
    public void createServer(int port){
        portIn = port;

        try {
            server = new OSCPortIn(portIn);

            OSCListener listener = new OSCListener() {
                public void acceptMessage(java.util.Date time, OSCMessage message) {
                    WritableMap params = Arguments.createMap();
                    params.putString("address", message.getAddress());

                    WritableArray data = Arguments.createArray();
                    List<Object> arrayData  = message.getArguments();
                    for (Object arrayItem : arrayData) {
                        if (arrayItem instanceof Float){
                            Float val = (Float) arrayItem;
                            data.pushDouble(val);
                        } else if(arrayItem instanceof String){
                            String val = (String) arrayItem;
                            data.pushString(val);
                        } else if(arrayItem instanceof Integer){
                            Integer val = (Integer) arrayItem;
                            data.pushInt(val);
                        }
                    }
                    params.putArray("data", data);

                    sendEvent(reactContext, "GotMessage", params);
                }
            };


            server.addListener("/*", listener);
            server.startListening();

        } catch (Exception e){

        }


    }

    private void sendEvent(ReactContext reactContext,
                           String eventName,
                           @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }

}
