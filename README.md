# react-native-osc

Native Open Sound Control support for React Native (iOS & Android).

## Getting started:

`$ npm install react-native-osc --save`

In ios/Podfile add: `use_frameworks!` 

`$ cd ios && pod install`

## Features:

Send OSC messages in iOS.

~~Receive OSC messages in IOS.~~

Send OSC messages in Android.

~~Receive OSC messages in Android.~~


## Usage:
```javascript
import osc from 'react-native-osc';

osc.createClient("localhost", 9090);
osc.sendMessage("/address/", [1.0, 0.0]);

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




