# Progressive

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Progressive-green.svg?style=true)](https://android-arsenal.com/details/1/2934)

Simple Progress indicator helper. But why?
Are you sick of changing layouts and wrapping views in ViewGroups just to show a stupid progress bar? Progressive eliminates that burden as much as possible. Feel free to contribute!



Show/Hide indicators with simple static methods:
```java
Progressive.showProgress(view);

Progressive.hideProgress(view);
```
<img src="https://cloud.githubusercontent.com/assets/2137007/12136806/f9d76818-b453-11e5-94f6-22df8c80f759.png" width="45%"></img> 

Custom views are supported :
```java
Progressive.showProgress(view,yourCustomView);
```
<img src="https://cloud.githubusercontent.com/assets/2137007/12136808/fd774dbc-b453-11e5-9e12-493120f5f1c2.png" width="45%"></img> 

Sample app is included in [app] module.

Gradle import :
```gradle
repositories { 
        jcenter()
        maven { url "https://jitpack.io" }
   }
   dependencies {
          compile 'com.github.aercanozcan:Progressive:v1.0.4'
   }
```

# License
```
Copyright 2015 Ali Ercan Özcan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
```

# Contributors
```
Ali Ercan Özcan
Tuna Karakaşoğlu
```



