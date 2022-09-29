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
   dependencies { implementation 'com.github.GeorgeKentMalaysia:aura-translator:1.4.3' }
   ```

   For `build.gradle.kts`:

   ```kotlin
   dependencies { implementation ("com.github.GeorgeKentMalaysia:aura-translator:1.4.3") }
   ```

## How to use (Kotlin)

#### Reading

```kotlin
fun main() {
    val readingInput =
        "851901451A62C58674FAC020000018181863851901461A62C5867EFAC020000018181863851901471A62C58688FAC020000018181863851901481A62C58692FAC020000018181863851901491A62C5869CFAC0200000181818638519014A1A62C586A6FAC0200000181818638519014B1A62C586B0FAC0200000181818638519014C1A62C586BAFAC0200000181818638519014D1A62C586C4FAC0200000181818638519014E1A62C586CEFAC0200000181818638519014F1A62C586D8FAC020000018181863851901501A62C586E2FAC020000018181863851901511A62C586ECFAC020000018181863851901521A62C586F6FAC020000018181863851901531A62C58700FAC020000018181863851901541A62C5870AFAC020000018181863851901551A62C58714FAC020000018181863"

    val readings = ReadingTranslator.toObject(readingInput)
    println(readings)
    /** output
    [Reading(index=110, timestamp=1657206310, meterReading=7212.25, meterConsumptions=0.0, temperature=26, batteryLevel=99),
    Reading(index=111, timestamp=1657206320, meterReading=7212.25, meterConsumptions=0.0, temperature=26, batteryLevel=99),
    Reading(index=112, timestamp=1657206330, meterReading=7300.25, meterConsumptions=88.0, temperature=26, batteryLevel=99),
    ...]
     */

    val readingNodes = ReadingTranslator.toNodes(readingInput)
    println(readingNodes)
    /** output
    [[110,1657206310,7212.25,0.0,26,99],
    [111,1657206320,7212.25,0.0,26,99],
    [112,1657206330,7300.25,88.0,26,99],
    ...]
     */
}
```

#### Status

```kotlin
fun main() {
    val statusInput =
        "9826021A62C4144C09010000001954201915CA19050C195420000019FFFF00384B384C384D384B38433844384638430D0C0C0D2726272518EC18EE18E218F60300190CDB"

    val status = StatusTranslator.toObject(statusInput)
    println(status)
    /** output
    Status(index=2, timestamp=1657017420, noOfTransmission=9, noOfFailedTransmission=1, noOfAttachment=0, noOfDisattachment=0, noOfSimError=0, latency_ms=21536, avgLatency_ms=5578, minLatency_ms=1292, maxLatency_ms=21536, pingLatency_ms=0, avgPingLatency_ms=0, minPingLatency_ms=65535, maxPingLatency_ms=0, rsrp=-76, avgRsrp=-77, minRsrp=-78, maxRsrp=-76, rssi=-68, avgRssi=-69, minRssi=-71, maxRssi=-68, sinr=13, avgSinr=12, minSinr=12, maxSinr=13, rsrq=-8, avgRsrq=-7, minRsrq=-8, maxRsrq=-6, txPower=236, avgTxPower=238, minTxPower=226, maxTxPower=246, ceMode=3, ecl=0, batteryVoltage_mV=3291)
     */

    val statusNode = StatusTranslator.toNodes(input)
    println(statusNode)
    /** output
    [2, 1657017420, 9, 1, 0, 0, 0, 21536, 5578, 1292, 21536, 0, 0, 65535, 0, -76, -77, -78, -76, -68, -69, -71, -68, 13, 12, 12, 13, -8, -7, -8, -6, 236, 238, 226, 246, 3, 0, 3291]
     */
}
```

#### Alarm

```kotlin
fun main() {
    val alarmInput = "FB419A39EF5C000000"

    val alarm = AlarmTranslator.toObject(input)
    println(alarm)
    /** output
    Alarm(leakageDetection=true, noFlowDetection=true, burstDetection=false, backFlowDetection=false, batteryLow=false, faultySensor=true, wireCutDetection=true, tiltDetection=true, magnetTamper=true)
     */

    val alarmNode = AlarmTranslator.toNodes(input)
    println(alarmNode)
    /** output
    [1, 1, 0, 0, 0, 1, 1, 1, 1]
     */
}
```

## How to use (Java)

#### Reading

```java
void main() {
     String readingInput = "851901451A62C58674FAC020000018181863851901461A62C5867EFAC020000018181863851901471A62C58688FAC020000018181863851901481A62C58692FAC020000018181863851901491A62C5869CFAC0200000181818638519014A1A62C586A6FAC0200000181818638519014B1A62C586B0FAC0200000181818638519014C1A62C586BAFAC0200000181818638519014D1A62C586C4FAC0200000181818638519014E1A62C586CEFAC0200000181818638519014F1A62C586D8FAC020000018181863851901501A62C586E2FAC020000018181863851901511A62C586ECFAC020000018181863851901521A62C586F6FAC020000018181863851901531A62C58700FAC020000018181863851901541A62C5870AFAC020000018181863851901551A62C58714FAC020000018181863";

     List<Reading> readings = ReadingTranslator.INSTANCE.toObject(readingInput);
     List<JsonNode> readingNodes = ReadingTranslator.INSTANCE.toNodes(readingInput);
     /** output
      [Reading(index=110, timestamp=1657206310, meterReading=7212.25, meterConsumptions=0.0, temperature=26, batteryLevel=99),
      Reading(index=111, timestamp=1657206320, meterReading=7212.25, meterConsumptions=0.0, temperature=26, batteryLevel=99),
      Reading(index=112, timestamp=1657206330, meterReading=7300.25, meterConsumptions=88.0, temperature=26, batteryLevel=99),
      ...]
      */

     List<JsonNode> readingNodes = ReadingTranslator.INSTANCE.toNodes(readingInput);
     /** output
      [[110,1657206310,7212.25,0.0,26,99],
      [111,1657206320,7212.25,0.0,26,99],
      [112,1657206330,7300.25,88.0,26,99],
      ...]
      */
}
```

#### Status

```java
void main() {
     String statusInput = "9826021A62C4144C09010000001954201915CA19050C195420000019FFFF00384B384C384D384B38433844384638430D0C0C0D2726272518EC18EE18E218F60300190CDB";

     Status status = StatusTranslator.INSTANCE.toObject(statusInput);
     /** output
      Status(index=2, timestamp=1657017420, noOfTransmission=9, noOfFailedTransmission=1, noOfAttachment=0, noOfDisattachment=0, noOfSimError=0, latency_ms=21536, avgLatency_ms=5578, minLatency_ms=1292, maxLatency_ms=21536, pingLatency_ms=0, avgPingLatency_ms=0, minPingLatency_ms=65535, maxPingLatency_ms=0, rsrp=-76, avgRsrp=-77, minRsrp=-78, maxRsrp=-76, rssi=-68, avgRssi=-69, minRssi=-71, maxRssi=-68, sinr=13, avgSinr=12, minSinr=12, maxSinr=13, rsrq=-8, avgRsrq=-7, minRsrq=-8, maxRsrq=-6, txPower=236, avgTxPower=238, minTxPower=226, maxTxPower=246, ceMode=3, ecl=0, batteryVoltage_mV=3291)
      */

     JsonNode statusNodes = StatusTranslator.INSTANCE.toNodes(statusInput);
     /** output
      [2, 1657017420, 9, 1, 0, 0, 0, 21536, 5578, 1292, 21536, 0, 0, 65535, 0, -76, -77, -78, -76, -68, -69, -71, -68, 13, 12, 12, 13, -8, -7, -8, -6, 236, 238, 226, 246, 3, 0, 3291]
      */
}
```

#### Alarm
```java
void main() {
     String alarmInput = "FB419A39EF5C000000";

     Alarm alarm = AlarmTranslator.INSTANCE.toObject(alarmInput);
     /** output 
      Alarm(leakageDetection=true, noFlowDetection=true, burstDetection=false, backFlowDetection=false, batteryLow=false, faultySensor=true, wireCutDetection=true, tiltDetection=true, magnetTamper=true)
      */

     List<Integer> alarmNodes = AlarmTranslator.INSTANCE.toNodes(alarmInput);
     /** output
      [1, 1, 0, 0, 0, 1, 1, 1, 1]
      */
}
```
