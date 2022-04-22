## How to import this dependency into gradle (using JitPack)

You can import this dependency into your gradle projects by making the following changes to your
`build.gradle` or `build.gradle.kts` file.

1. Add this at the end of your `repositories` section.

   For `build.gradle`:

   ```groovy
   repositories {
     repositories { maven { url 'https://jitpack.io' } }
   }
   ```

   For `build.gradle.kts`:

   ```kotlin
   repositories {
     maven{
       url = uri("https://jitpack.io")
     }
   }
   ```

2. Add the dependency.

   For `build.gradle`:

   ```groovy
   dependencies { implementation 'com.github.desmundgk:aura-translator:1.0.0' }
   ```

   For `build.gradle.kts`:

   ```kotlin
   dependencies { implementation ("com.github.desmundgk:aura-translator:1.0.0") }
   ```

## How to use

```kotlin
fun main() {
  val input = "8518b51a6234a3defa00000000181c008518b61a6234a3e8fa00000000181c00"
  val dataPoints = Translator.translate(inputShort)
  
  // output
  /*
  DataPoint(index=181, timestamp=1647616990, meterReading=0.0, temperature=28, alarmStatus=0)
  DataPoint(index=182, timestamp=1647617000, meterReading=0.0, temperature=28, alarmStatus=0)
  */
}
```
