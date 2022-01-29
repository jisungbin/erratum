<img src="https://user-images.githubusercontent.com/40740128/135403661-6942d23f-57be-48ba-84c6-01cd253253e3.png" align="right" width="12%"/>

# Erratum

Powerful Error Detector for Android

# Preview

If an **unexpected** exception is detected, the exception activity is automatically launched. This activity also contains a button to return to the activity before the exception is thrown.

<img src="https://user-images.githubusercontent.com/40740128/151650056-36271d87-7568-4c6c-b04c-b8ec32f681dd.png" width="20%" />

---

# Download [![](https://img.shields.io/maven-central/v/land.sungbin/erratum)](https://search.maven.org/artifact/land.sungbin/erratum)

```groovy
implementation "land.sungbin:erratum:${version}"
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

You can customize the exception activity. In this case, you should make your own exception activity extend `ErratumExceptionActivity`.

```kotlin
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Erratum.setup(
            application = this,
            registerExceptionActivityIntent = { thread, throwable, lastActivity ->
                Intent(lastActivity, ErrorActivity::class.java) // should return custom exception activity intent
            }
        )
    }
}
```

> registerExceptionActivityIntent example
>
> ```kotlin
> Intent(lastActivity, ExceptionActivity::class.java).apply {
>     putExtra(ErratumExceptionActivity.EXTRA_EXCEPTION_STRING, throwable.toString())
>     putExtra(ErratumExceptionActivity.EXTRA_LAST_ACTIVITY_INTENT, lastActivity.intent)
> }
> ```

You can use the this method in `ErratumExceptionActivity`.

```kotlin
val exceptionString: String // get exception message
fun openLastActivity() // Closes the current activity and opens the activity before an exception is thrown.
```

---

# Happy Coding :)
