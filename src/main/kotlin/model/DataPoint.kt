package model

data class DataPoint(
    var index: Int = -1,
    var timestamp: Int = -1,
    var meterReading: Float = 0f,
    var meterConsumptions: Float = 0f,
    var temperature: Int = -1,
    var batteryLevel: Int = -1
) {
    constructor(intDataType: Int) : this() // for jackson translation
    constructor(floatDataType: Float) : this() // for jackson translation

}