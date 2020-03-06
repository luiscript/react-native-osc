/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React from 'react';

import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  StatusBar,
  Slider,
  NativeModules
} from 'react-native';

var osc = NativeModules.Osc;
osc.createServer("192.168.1.64", 9090);
osc.sendMessage("/test/", 1.0);

const App: () => React$Node = () => {
  return (
    <View style={{flex: 1, alignItems: 'center', justifyContent:'center'}}>
      <Text>
        react-native-osc
      </Text>
      <Slider
        style={{width: 200, height: 40}}
        minimumValue={0}
        maximumValue={1}
        minimumTrackTintColor="#FFFFFF"
        maximumTrackTintColor="#000000"
        onValueChange={value => osc.sendMessage("/test/", value)}
      />
    </View>
  );
};

export default App;
