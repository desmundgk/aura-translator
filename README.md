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
   dependencies { implementation 'com.github.desmundgk:aura-translator:1.1.0' }
   ```

   For `build.gradle.kts`:

   ```kotlin
   dependencies { implementation ("com.github.desmundgk:aura-translator:1.1.0") }
   ```

## How to use

```kotlin
fun main() {
  val input = "8618B51A6234A3DEF90000F90000181C1850"
 
  val dataPoints = Translator.toDataPoints(input)
  /* output
  DataPoint(index=181, timestamp=1647616990, meterReading=0.0, meterConsumptions=0.0, temperature=28, batteryLevel=80)
  */
  
  val nodes = Translator.toNodes(input)
  /* output
  [181,1647616990,0.0,0.0,28,80]
  */
}
```
