# react-native-osc

Native Open Sound Control support for React Native (iOS & Android).

[JavaOSC](https://github.com/hoijui/JavaOSC/) for Android & 
[SwiftOSC](https://github.com/ExistentialAudio/SwiftOSC) for iOS.


## Getting started:

`$ npm install react-native-osc --save`

In ios/Podfile add: `use_frameworks!` 

`$ cd ios && pod install`

## Features:

Send OSC messages in iOS.

~~Receive OSC messages in IOS.~~

Send OSC messages in Android.

Receive OSC messages in Android.


## Usage:
```javascript
import osc from 'react-native-osc';

//To send messages:
osc.createClient("localhost", 9090);
osc.sendMessage("/address/", [1.0, 0.0]);


//To receive messages (Android only):
const eventEmitter = new NativeEventEmitter(osc);
eventEmitter.addListener('GotMessage', (newMessage) => {
  console.log("New OSC message: ", newMessage);
});
osc.createServer(9999);
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

MIT

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
