package model

data class DataPoint(
    var index: Int = -1,
    var timestamp: Long = -1,
    var meterReading: Double = -1.0,
    var temperature: Int = -1,
    var alarmStatus: Int = -1
) {
    constructor(index: Int) : this() // for jackson translation
    constructor(timestamp: Long) : this() // for jackson translation
    constructor(meterReading: Double) : this() // for jackson translation

}