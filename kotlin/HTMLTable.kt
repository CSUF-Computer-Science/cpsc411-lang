// See Gaddis, Starting out with C++, Early Objects, Ninth Edition, pp. 800-804

import java.io.*
import java.util.*

class HTMLTable internal constructor() {
    private val headers: Vector<String>
    private val rows: Vector<Vector<String>>

    init {
        headers = Vector()
        rows = Vector()
    }

    internal fun setHeaders(headers: Array<String>) {
        this.headers.addAll(Arrays.asList(*headers))
    }

    internal fun addRow(row: Array<String>) {
        rows.add(Vector(Arrays.asList(*row)))
    }

    internal fun writeRow(out: PrintStream, tag: String, row: Vector<String>) {
        out.println("<tr>")
        for (k in headers.indices) {
            out.print("<$tag>${row[k]}</$tag>")
        }
        out.println("\n</tr>")
    }

    companion object {

        internal fun putTo(out: PrintStream, htmlTable: HTMLTable) {
            out.println("<table border = \"1\">")
            htmlTable.writeRow(out, "th", htmlTable.headers)
            for (r in htmlTable.rows.indices) {
                htmlTable.writeRow(out, "td", htmlTable.rows[r])
            }
            out.println("</table>")
        }

        @JvmStatic
        fun main(args: Array<String>) {

            val headers = arrayOf("Name", "Address", "Phone")
            val person1 = arrayOf("Mike Sans", "1215 Mills St", "630-728-1293")
            val person2 = arrayOf("Natasha Upenski", "513 Briarcliff Ln", "412-672-1004")

            val hTable = HTMLTable()
            hTable.setHeaders(headers)
            hTable.addRow(person1)
            hTable.addRow(person2)

            putTo(System.out, hTable)
        }
    }

}