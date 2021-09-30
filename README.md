<img src="https://user-images.githubusercontent.com/40740128/135403661-6942d23f-57be-48ba-84c6-01cd253253e3.png" align="right" width="12%"/>

# Erratum

Powerful Error Detector for Android

# Preview

If an exception is detected, the exception activity is automatically launched. This activity also contains a button to return to the activity before the exception is thrown.

<img src="https://user-images.githubusercontent.com/40740128/135406648-31d39c80-ada5-4789-8fb2-ecd778cf8b1d.png" width="25%" />

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

# Customize

You can customize the exception activity. In this case, you must unconditionally make your own exception activity extend `ErratumExceptionActivity`.

```kotlin
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Erratum.setup(
            application = this,
            registerExceptionActivityIntent = { thread, throwable, lastActivity -> // added
                Intent(lastActivity, ErrorActivity::class.java)
            }
        )
    }
}
```

You can use the following method in `ErratumExceptionActivity`.

```kotlin
val exceptionString // get exception message

fun openLastActivity() // Closes the current activity and opens the activity before an exception is thrown.
```
