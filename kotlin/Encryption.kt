// See Gaddis, Starting out with C++, Early Objects, Ninth Edition, pp. 974-976

import java.io.*
import java.util.*

class SimpleEncryption(inFileName: String, outFileName: String) : Encryption(inFileName, outFileName) {

    override fun transform(ch: Byte): Byte {
        return ch.inc()
    }

}

abstract class Encryption(val inFileName: String, val outFileName: String) {

    abstract fun transform(ch: Byte): Byte

    fun encrypt() {
        FileInputStream(inFileName).use { inFile ->
            FileOutputStream(outFileName).use { outFile ->
                val output = inFile.readBytes().map { byte -> transform(byte) }
                outFile.write(output.toByteArray())
            }
        }
    }
}

fun main(args: Array<String>) {
    print("Enter name of file to encrypt: ")
    val inFileName = readLine()

    print("Enter name of file to receive the encrypted text: ")
    val outFileName = readLine()

    val obfuscate = SimpleEncryption(inFileName!!, outFileName!!)
    obfuscate.encrypt()
}