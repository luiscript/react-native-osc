# react-native-osc

WIP: Open Sound Control for React Native. (iOS only at the moment)

## Getting started:

`$ npm install react-native-osc --save`

`$ cd ios && pod install`

## Usage:
```javascript
import osc from 'react-native-osc';

osc.createClient("localhost", 9090);
osc.sendMessage("/address/", [1.0, 0.0]);

//see example folder for more details.
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




