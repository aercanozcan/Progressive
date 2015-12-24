# Progressive

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Progressive-green.svg?style=true)](https://android-arsenal.com/details/1/2934)

Simple Progress indicator helper. But why?
Are you sick of changing layouts and wrapping views in ViewGroups just to show a stupid progress bar? Progressive eliminates that burden as much as possible. Feel free to contribute!



Show/Hide indicators with simple static methods:
```java
Progressive.showProgress(view);

Progressive.hideProgress(view);
```
Custom views are supported :
```java
Progressive.showProgress(view,R.layout.your_indicator);
```

Gradle import :
```gradle
repositories { 
        jcenter()
        maven { url "https://jitpack.io" }
   }
   dependencies {
          compile 'com.github.aercanozcan:Progressive:v1.0.1'
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
