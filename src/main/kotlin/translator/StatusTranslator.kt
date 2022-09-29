package translator

import Util.decodeHex
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.cbor.databind.CBORMapper
import model.Status

/* This is a translator for LWM2M object 10376 instance 1 Record object */
object StatusTranslator {

    fun toObject(input: String): Status {
        val mapper: ObjectMapper = CBORMapper()
        val byteArrayValueShort = input.decodeHex()

        val offset = 0
        val myDataArray = mapper.readValue(byteArrayValueShort, offset, byteArrayValueShort.size, Array<Any>::class.java)
        val dp = Status()
        myDataArray.forEachIndexed { index, data ->
            when (index) {
                0 -> dp.index = data as Int
                1 -> dp.timestamp = data as Int
                2 -> dp.noOfTransmission = data as Int
                3 -> dp.noOfFailedTransmission = data as Int
                4 -> dp.noOfAttachment = data as Int
                5 -> dp.noOfDisattachment = data as Int
                6 -> dp.noOfSimError = data as Int
                7 -> dp.latency_ms = data as Int
                8 -> dp.avgLatency_ms = data as Int
                9 -> dp.minLatency_ms = data as Int
                10 -> dp.maxLatency_ms = data as Int
                11 -> dp.pingLatency_ms = data as Int
                12 -> dp.avgPingLatency_ms = data as Int
                13 -> dp.minPingLatency_ms = data as Int
                14 -> dp.maxPingLatency_ms = data as Int
                15 -> dp.rsrp = data as Int
                16 -> dp.avgRsrp = data as Int
                17 -> dp.minRsrp = data as Int
                18 -> dp.maxRsrp = data as Int
                19 -> dp.rssi = data as Int
                20 -> dp.avgRssi = data as Int
                21 -> dp.minRssi = data as Int
                22 -> dp.maxRssi = data as Int
                23 -> dp.sinr = data as Int
                24 -> dp.avgSinr = data as Int
                25 -> dp.minSinr = data as Int
                26 -> dp.maxSinr = data as Int
                27 -> dp.rsrq = data as Int
                28 -> dp.avgRsrq = data as Int
                29 -> dp.minRsrq = data as Int
                30 -> dp.maxRsrq = data as Int
                31 -> dp.txPower = data as Int
                32 -> dp.avgTxPower = data as Int
                33 -> dp.minTxPower = data as Int
                34 -> dp.maxTxPower = data as Int
                35 -> dp.ceMode = data as Int
                36 -> dp.ecl = data as Int
                37 -> dp.batteryVoltage_mV = data as Int
            }
        }
        return dp
    }

    fun toNodes(input: String): JsonNode {
        val mapper: ObjectMapper = CBORMapper()
        val byteArrayValueShort = input.decodeHex()

        val offset = 0
        val myDataArray = mapper.readValue(byteArrayValueShort, offset, byteArrayValueShort.size, Array<Any>::class.java)
        return mapper.valueToTree(myDataArray)
    }

}