<img src="https://user-images.githubusercontent.com/40740128/135403661-6942d23f-57be-48ba-84c6-01cd253253e3.png" align="right" width="12%"/>

# Erratum
Powerful Error Detector for Android

---

# Download [![](https://img.shields.io/maven-central/v/io.github.jisungbin/erratum)](https://search.maven.org/artifact/io.github.jisungbin/erratum)

```groovy
implementation "io.github.jisungbin:erratum:${version}"
```

# Usage
```kotlin
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Erratum.setup(application = this)
    }
}
```

## Preview
If an exception is detected, the exception activity is automatically launched. This activity also contains a button to return to the activity before the exception is thrown.

<img src="https://user-images.githubusercontent.com/40740128/135404241-7a737778-e310-4bf3-9634-00192050ab09.png" width="33%" />
