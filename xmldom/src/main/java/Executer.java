
import reader.DomReader;
import writer.DomWriter;

public class Executer {

    public Executer(){}


    public static void main(String[] args){

        // read xml
        DomReader domReader = new DomReader();
        // pass location of xml file
        domReader.readXml(args[0]);

        //write xml
        DomWriter domWriter = new DomWriter();
        //test dom writer
        domWriter.writeXml(args[1]);
    }
}
