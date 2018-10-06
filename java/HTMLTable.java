// See Gaddis, Starting out with C++, Early Objects, Ninth Edition, pp. 800-804

import java.io.*;
import java.util.*;

public class HTMLTable
{
    private Vector<String> headers;
    private Vector<Vector<String>> rows;
    
    HTMLTable()
    {
        headers = new Vector<String>();
        rows = new Vector<Vector<String>>();
    }
    
    void setHeaders(String[] headers)
    {
        this.headers.addAll(Arrays.asList(headers));
    }
    
    void addRow(String[] row)
    {
        rows.add(new Vector<String>(Arrays.asList(row)));
    }
    
    void writeRow(PrintStream out, String tag, Vector<String> row)
    {
        out.println("<tr>");
        for (int k = 0; k < headers.size(); k++) {
            out.print("<" + tag + "> " + row.get(k) + " </" + tag + "> ");
        }
        out.println("\n</tr>");
    }

    static void putTo(PrintStream out, HTMLTable htmlTable)
    {
        out.println("<table border = \"1\">");
        htmlTable.writeRow(out, "th", htmlTable.headers);
        for (int r = 0; r < htmlTable.rows.size(); r++) {
            htmlTable.writeRow(out, "td", htmlTable.rows.get(r));
        }
        out.println("</table>");
    }
    
    public static void main(String[] args)
    {

        String[] headers = { "Name", "Address", "Phone" };
        String[] person1 = { "Mike Sans", "1215 Mills St", "630-728-1293" };
        String[] person2 = { "Natasha Upenski", "513 Briarcliff Ln", "412-672-1004" };
        
        HTMLTable hTable = new HTMLTable();
        hTable.setHeaders(headers);
        hTable.addRow(person1);
        hTable.addRow(person2);

        putTo(System.out, hTable);
    }

}
