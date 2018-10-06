// See Gaddis, Starting out with C++, Early Objects, Ninth Edition, pp. 974-976

import java.io.*;
import java.util.*; 

public abstract class Encryption
{
    protected InputStream inFile;
    protected OutputStream outFile;

    Encryption(String inFileName, String outFileName) throws IOException
    {
        inFile = new FileInputStream(inFileName);
        outFile = new FileOutputStream(outFileName);
    }
    
    void close() throws IOException
    {
        inFile.close();
        outFile.close();
    }
    
    abstract int transform(int ch);
    
    final void encrypt()
    {
        int ch;
        int transCh;
        try {
            ch = inFile.read();
            while (ch >= 0) {
                transCh = transform(ch);
                outFile.write(transCh);
                ch = inFile.read();
            }
        } catch (IOException e) { }
    }
    
    public static void main(String[] args) throws IOException
    {
        String inFileName, outFileName;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter name of file to encrypt: ");
        inFileName = scanner.next();
        
        System.out.print("Enter name of file to receive the encrypted text: ");
        outFileName = scanner.next();

        SimpleEncryption obfuscate = new SimpleEncryption(inFileName, outFileName);
        obfuscate.encrypt();
        obfuscate.close();
    }
    
};

