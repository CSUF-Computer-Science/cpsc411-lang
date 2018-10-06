// See Gaddis, Starting out with C++, Early Objects, Ninth Edition, pp. 974-976

import java.io.*;

public class SimpleEncryption extends Encryption {

    SimpleEncryption(String inFileName, String outFileName) throws IOException
    {
        super(inFileName, outFileName);
    }
    
    @Override
    public int transform(int ch)
    {
        return ch + 1;
    }
    
}
