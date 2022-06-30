import Util.decodeHex
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.cbor.databind.CBORMapper
import model.DataPoint

object Translator {

    fun toDataPoints(input: String): List<DataPoint> {
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
                    1 -> dp.timestamp = data as Int
                    2 -> dp.meterReading = (data as Number).toFloat()
                    3 -> dp.meterConsumptions = (data as Number).toFloat()
                    4 -> dp.temperature = data as Int
                    5 -> dp.batteryLevel = data as Int
                }
            }
            dataPoints.add(dp)

            offset += mapper.writeValueAsBytes(tree).size
        }
        return dataPoints.toList()
    }

    fun toNodes(input: String): List<JsonNode> {
        val nodeList = arrayListOf<JsonNode>()
        val mapper: ObjectMapper = CBORMapper()
        val byteArrayValueShort = input.decodeHex()

        var offset = 0
        while (offset < byteArrayValueShort.size) {
            val myDataArray =
                mapper.readValue(byteArrayValueShort, offset, byteArrayValueShort.size, Array<Any>::class.java)
            val tree = mapper.valueToTree<JsonNode>(myDataArray)
            nodeList.add(tree)
            offset += mapper.writeValueAsBytes(tree).size
        }
        return nodeList.toList()
    }

}