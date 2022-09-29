package translator

import Util.decodeHex
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.cbor.databind.CBORMapper
import model.Alarm
import model.AlarmParameter
import model.AlarmRaw

/* This is a translator for LWM2M object 10377 instance 0 Data object */
object AlarmTranslator {

    private fun translate(input: String): AlarmRaw {
        val mapper: ObjectMapper = CBORMapper()
        val byteArrayValueShort = input.decodeHex()
        val offset = 0
        val list = mapper.readValue(byteArrayValueShort, offset, byteArrayValueShort.size, List::class.java)
        val alarmRaw = list[0] as Int
        val alarmBinary = alarmRaw.toString(2).toLong()
        val backFlowReading = list[1] as Float
        return AlarmRaw(alarmBinary, backFlowReading)
    }

    fun toObject(input: String): Alarm {
        val rawAlarm = translate(input)
        return Alarm(rawAlarm)
    }

    fun toNodes(input: String): ArrayList<Number> {
        val alarms = ArrayList<Number>()
        val rawAlarm = translate(input)
        (rawAlarm.alarm + AlarmParameter.OFFSET).toString().subSequence(1..AlarmParameter.NUMBER_OF_ALARMS)
            .map {
                alarms.add(it.digitToInt())
            }
        alarms.add(rawAlarm.backFlowReading)
        return alarms
    }

}