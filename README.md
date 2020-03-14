# react-native-osc 0.0.3

Open Sound Control support for sending and receiving OSC messages in React Native (iOS & Android).

On the native side: 
[JavaOSC](https://github.com/hoijui/JavaOSC/) for Android & 
[SwiftOSC](https://github.com/ExistentialAudio/SwiftOSC) for iOS.

## Getting started:

`$ npm install react-native-osc --save`

In ios/Podfile add: `use_frameworks!` 

`$ cd ios && pod install`

## Usage

### Send OSC message (OSC client):
```javascript
import osc from 'react-native-osc';

var portOut = 9090;

//OSC server IP address like "192.168.1.80" or "localhost"
var address = "localhost"; 

//create the client only once in componentDidMount
osc.createClient(address, portOut);

//now you can send OSC messages like this (only after creating a client)
osc.sendMessage("/address/", [1.0, 0.5]);

//send any combination of integers, floats, bool & string values:
osc.sendMessage("/address/", ["string value", 1, false, 0.5]);
```

### Receive OSC messages (OSC server):
```javascript
import {
  NativeEventEmitter
} from 'react-native';

import osc from 'react-native-osc';

//create an event emiter sending the native osc module as parameter 
const eventEmitter = new NativeEventEmitter(osc);

var portIn = 9999;

//subscribe to GotMessage event to receive OSC messages
eventEmitter.addListener('GotMessage', (oscMessage) => {
  console.log("message: ", oscMessage);
});

//create the osc server to start listeing to OSC messages
osc.createServer(portIn);

//to receive OSC messages your client should be addressing your device IP address
```
## Supported types:

i Integer: two’s complement int32.

f Float: IEEE float32.

~~s NULL-terminated ASCII string.~~

~~b Blob, (aka byte array) with size.~~

T True.

F False.

~~N Null: (aka nil, None, etc).~~

~~I Impulse: (aka “bang”).~~

## Tested with:

Xcode:11.3.1 - iOS_SDK: 13 - RN: 0.61.5

## License

The MIT License (MIT)

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

## JavaOSC

Copyright (c) 2002-2014, Chandrasekhar Ramakrishnan / Illposed Software
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, this
  list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice,
  this list of conditions and the following disclaimer in the documentation
  and/or other materials provided with the distribution.

* Neither the name of the {organization} nor the names of its
  contributors may be used to endorse or promote products derived from
  this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

## SwiftOSC

The MIT License (MIT)

Copyright (c) 2017 Devin Roth (devin@devinrothmusic.com)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
