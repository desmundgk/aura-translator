package model

data class Reading(
    var index: Int = 0,
    var timestamp: Int = 0,
    var meterReading: Float = 0f,
    var meterConsumptions: Float = 0f,
    var temperature: Int = 0,
    var batteryLevel: Int = 0
) {
    constructor(intDataType: Int) : this() // for jackson translation
    constructor(floatDataType: Float) : this() // for jackson translation

}