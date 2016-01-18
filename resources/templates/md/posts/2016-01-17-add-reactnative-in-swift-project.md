{:title "Add React Native to an existing Swift project"
 :layout :post
 :tags ["iOS" "Swift" "React Native"]
 :navbar? false}

TL;DR Demo project source code can be found from [Github](https://github.com/tendant/ReactNativeSwiftDemo)

After hearing a lot good things about ReactNative recently, I finally got some time to play with ReactNative during last holiday season.

A little background about our iOS app, we started app around July 2015. By the time, ReactNative was just released with iOS support, and Swift 2.0 was just released in June. We built some prototypes to compare Swift with ReactNative, and decided to go with Swift. Since we are also building the web app using ReactJS, we have seen a lot benefit by using React way of building UI. However we already have a native app built with Swift, we want to try it with our existing app before committing to ReactNative. Hence I started to look at the way of introducing ReactNative.

A lot of steps came from [this gist](https://gist.github.com/boopathi/27d21956fefcb5b168fe), the original gist content is a little bit outdated, and things have been changed since then. It is still good for reference. I also forked and updated the [gist](https://gist.github.com/tendant/6a1ea9e363f5ca4d73a1).

Before start, make sure the ReactNative requirement is met. [ReactNative requirements](https://facebook.github.io/react-native/docs/getting-started.html#requirements)


### Create a project in XCode with default setting.
    iOS -> Application -> Single View Application
    Language: Swift

### Add ReactNative dependency.
1. Create package.json file in project directory
2. add dependecy `"react-native": "^0.17.0"`
3. run `npm install`

### Add ReactNative project to Linked Framework and Libraries.
    General settings -> Linked Framework and Library ->
    + -> Add Other... -> chose node_modules/react-native/React/React.xcodeproj

### Add ReactNative library in Linked Framework and Libraries again.
    + -> libReact.a


### Repeat previous two steps
Add and link other libraries from /node_modules/react-native/Libraries as needed.

Libraries I have added:
    libRCTActionSheet.a
    libRCTGeolocation.a
    libRCTImage.a
    libRCTLinking.a
    libRCTNetwork.a
    libRCTSettings.a
    libRCTText.a
    libRCTVibration.a
    libRCTWebSocket.a

### Update Build Setting
    Linking -> Other Linker Flags: Add `-all_load`
    Search Paths -> Header Search Paths -> "node_module/react-native/Libraries" with `recursive`
    Swift Compiler - Code Generation > Objective-C Bridging Header
        * Set to ProjectName/ProjectName-Bridging-Header.h, change ProjectName to actual name

### Create bridging file
Create a new header file `ProjectName/ProjectName-Bridging-Header.h`

### Project can be built and run from XCode now
* Try to run the code in simulator.
* It should start a terminal window with running `packager`.
* If everything works fine, it should show `React packager ready.` in terminal window.

### Add ReactNative Javascript code
* Create file index.ios.js and save to project root directory

```javascript
var React = require('react-native');
var {
    AppRegistry,
    Text,
    View
} = React;

var App = module.exports = React.createClass({
    render() {
        return (
            <View style={{flex: 1, alignItems: 'center', justifyContent: 'center', borderWidth: 2}}>
                <Text style={{alignSelf: 'center', alignItems: 'stretch', backgroundColor: 'green'}}>Hello World!</Text>
            </View>
        )
    }
});
                                             
AppRegistry.registerComponent('ReactNativeSwiftDemo', () => App);
```

Test packager by accessing below url:

    http://localhost:8081/index.ios.bundle?platform=ios&dev=true

### Add ReactNative View into iOS Application

1. Add two class variables into AppDelegate.swift

```swift
    var rootView: RCTRootView
    let jsCodeLocation = NSURL(string: "http://localhost:8081/index.ios.bundle?platform=ios&dev=true")
```

2. Add init() function in AppDelegate.swift
```swift
    override init() {
        // initialize the rootView to fetch JS from the dev server
        rootView = RCTRootView.init(bundleURL: jsCodeLocation!, moduleName: "ReactNativeSwiftDemo", initialProperties: nil, launchOptions: nil)
        super.init()
    }
```

3. Update application didFinishLaunchingWithOptions delegate function

```swift
    func application(application: UIApplication, didFinishLaunchingWithOptions launchOptions: [NSObject: AnyObject]?) -> Bool {
        // Override point for customization after application launch.
        
        // Initialize a Controller to use view as React View
        let rootViewController = ViewController()
        rootViewController.view = rootView
        
        // Set window to use rootViewController
        self.window = UIWindow(frame: UIScreen.mainScreen().bounds)
        self.window?.rootViewController = rootViewController
        self.window?.makeKeyAndVisible()

        return true
    }
```

### Enable access to http://localhost
1. Open Info.plist
2. Add key "NSAppTransportSecurity" with "Dictionary" type
3. Add key "NSAllowsArbitraryLoads" with value "true" in "NSAppTransportSecurity"

### Now you can try to build and run
