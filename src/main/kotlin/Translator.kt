import Util.decodeHex
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.cbor.databind.CBORMapper
import model.DataPoint

object Translator {

    fun translate(input: String): List<DataPoint> {
        val dataPoints = arrayListOf<DataPoint>()
        val mapper: ObjectMapper = CBORMapper()
        val byteArrayValueShort = input.decodeHex()

        var offset = 0
        var dp: DataPoint
        while (offset < byteArrayValueShort.size) {
            val myDataArray =
                mapper.readValue(byteArrayValueShort, offset, byteArrayValueShort.size, Array<Any>::class.java)
            val tree = mapper.valueToTree<JsonNode>(myDataArray)
            dp = DataPoint()
            myDataArray.forEachIndexed { index, data ->
                when (index) {
                    0 -> dp.index = data as Int
                    1 -> dp.timestamp = (data as Number).toLong()
                    2 -> dp.meterReading = (data as Number).toDouble()
                    3 -> dp.temperature = data as Int
                    4 -> dp.alarmStatus = data as Int
                }
            }
            dataPoints.add(dp)

            offset += mapper.writeValueAsBytes(tree).size
        }
        return dataPoints.toList()
    }

}