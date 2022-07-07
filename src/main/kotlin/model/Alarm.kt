package model

data class Alarm(
    var leakageDetection: Boolean = false,
    var noFlowDetection: Boolean = false,
    var burstDetection: Boolean = false,
    var backFlowDetection: Boolean = false,
    var batteryLow: Boolean = false,
    var faultySensor: Boolean = false,
    var wireCutDetection: Boolean = false,
    var tiltDetection: Boolean = false,
    var magnetTamper: Boolean = false
) {
    constructor(alarm: Int) : this() {
        val rawAlarm = (alarm + 1000000000).toString().subSequence(1..9)
            //.reversed()
            .map {
            it.digitToInt() == 1
        }
        magnetTamper = rawAlarm[8]
        tiltDetection = rawAlarm[7]
        wireCutDetection = rawAlarm[6]
        faultySensor = rawAlarm[5]
        batteryLow = rawAlarm[4]
        backFlowDetection = rawAlarm[3]
        burstDetection = rawAlarm[2]
        noFlowDetection = rawAlarm[1]
        leakageDetection = rawAlarm[0]
    }
}