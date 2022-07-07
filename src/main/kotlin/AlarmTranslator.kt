import Util.decodeHex
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.cbor.databind.CBORMapper
import model.Alarm

/* This is a translator for LWM2M object 10377 instance 0 Data object */
object AlarmTranslator {

    private fun translate(input: String): Int {
        val mapper: ObjectMapper = CBORMapper()
        val byteArrayValueShort = input.decodeHex()
        val offset = 0
        return mapper.readValue(byteArrayValueShort, offset, byteArrayValueShort.size, Int::class.java)
    }

    fun toObject(input: String): Alarm {
        val rawAlarm = translate(input)
        return Alarm(rawAlarm)
    }

    fun toNodes(input: String): ArrayList<Int> {
        val alarms = ArrayList<Int>()
        val rawAlarm = translate(input)
        (rawAlarm + 1000000000).toString().subSequence(1..9).toString()
            //.reversed()
            .map {
                alarms.add(it.digitToInt())
            }
        return alarms
    }

}