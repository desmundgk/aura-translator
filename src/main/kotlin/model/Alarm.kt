package model

import model.AlarmParameter.NUMBER_OF_ALARMS
import kotlin.math.pow

object AlarmParameter {
    const val NUMBER_OF_ALARMS = 11
    val OFFSET = 10.0.pow(NUMBER_OF_ALARMS).toLong()
}

data class AlarmRaw(val alarm: Long, val backFlowReading: Float)

data class Alarm(
    var nonRealtimeBackFlowDetection: Boolean = false,
    var rebootDetection: Boolean = false,
    var leakageDetection: Boolean = false,
    var noFlowDetection: Boolean = false,
    var burstDetection: Boolean = false,
    var backFlowDetection: Boolean = false,
    var batteryLow: Boolean = false,
    var faultySensor: Boolean = false,
    var wireCutDetection: Boolean = false,
    var tiltDetection: Boolean = false,
    var magnetTamper: Boolean = false,
    var backFlowReading: Float = 0.0f
) {
    constructor(alarm: AlarmRaw) : this() {
        val rawAlarm = (alarm.alarm + AlarmParameter.OFFSET).toString().subSequence(1..NUMBER_OF_ALARMS)
            .map {
                it.digitToInt() == 1
            }
        magnetTamper = rawAlarm[10]
        tiltDetection = rawAlarm[9]
        wireCutDetection = rawAlarm[8]
        faultySensor = rawAlarm[7]
        batteryLow = rawAlarm[6]
        backFlowDetection = rawAlarm[5]
        burstDetection = rawAlarm[4]
        noFlowDetection = rawAlarm[3]
        leakageDetection = rawAlarm[2]
        rebootDetection = rawAlarm[1]
        nonRealtimeBackFlowDetection = rawAlarm[0]
        backFlowReading = alarm.backFlowReading
    }
}