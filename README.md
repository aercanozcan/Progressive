# Progressive
Simple Progress indicator helper



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
