# Progressive
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
