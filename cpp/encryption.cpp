// Gaddis, Starting out with C++, Early Objects, Ninth Edition, pp. 974-976

#include <iostream>
#include <fstream>
#include <string>
#include <cstdlib>

using namespace std;

class Encryption
{
    protected:
        ifstream inFile;
        ofstream outFile;

    public:
        Encryption(const string& inFileName, const string& outFileName);
        virtual ~Encryption();
        virtual char transform(char ch) const = 0;
        virtual void encrypt() final;
};

Encryption::Encryption(const string& inFileName, const string& outFileName)
{
    inFile.open(inFileName);
    outFile.open(outFileName);

    if (!inFile) {
        cout << "The file " << inFileName << " cannot be opened.";
        exit(1);
    }

    if (!outFile) {
        cout << "The file " << outFileName << " cannot be opened.";
        exit(1);
    }
}

Encryption::~Encryption()
{
    inFile.close();
    outFile.close();
}

void Encryption::encrypt()
{
    char ch;
    char transCh;
    inFile.get(ch);
    while (!inFile.fail()) {
        transCh = transform(ch);
        outFile.put(transCh);
        inFile.get(ch);
    }
}

class SimpleEncryption : public Encryption
{
    public:
        char transform(char ch) const override
        {
            return ch + 1;
        }

        SimpleEncryption(const string& inFileName, const string& outFileName)
            : Encryption(inFileName, outFileName) { }
};

int main()
{
    string inFileName, outFileName;

    cout << "Enter name of file to encrypt: ";
    cin >> inFileName;

    cout << "Enter name of file to receive the encrypted text: ";
    cin >> outFileName;

    SimpleEncryption obfuscate(inFileName, outFileName);
    obfuscate.encrypt();

    return 0;
}
