package behavioural.template;

abstract class DataParser {
    // Template method
    public final void parseDataAndGenerateOutput() {
        readData();
        processData();
        writeData();
    }

    // Steps to be implemented by subclasses
    abstract void readData();
    abstract void processData();

    // Common method
    void writeData() {
        System.out.println("Output generated and written to a file.");
    }
};

class CSVDataParser extends DataParser {
    @Override
    void readData() {
        System.out.println("Reading data from CSV file.");
    }

    @Override
    void processData() {
        System.out.println("Processing CSV data.");
    }
}

class XMLDataParser extends DataParser {

    int a, b;

    @Override
    void readData() {
        System.out.println("Reading data from XML file.");
    }

    @Override
    void processData() {
        System.out.println("Processing XML data.");
        System.out.println(a+" "+b);
    }


};

public class TemplateDesignExample {
    public static void main(String[] args) {
        DataParser csvParser = new CSVDataParser();
        csvParser.parseDataAndGenerateOutput();
        DataParser xmlParser = new XMLDataParser();
        xmlParser.parseDataAndGenerateOutput();
        System.err.println("Huehue");
    }
}
