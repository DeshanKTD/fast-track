import org.xml.sax.SAXException;
import reader.Employee;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaxReader {

    private SAXParserFactory saxPaserFactory;
    private SAXParser saxParser;

    public SaxReader(){
        this.saxPaserFactory = SAXParserFactory.newInstance();
    }

    public void readXML(String filename){
        try {
           this.saxParser = saxPaserFactory.newSAXParser();
           MyHandler handler = new MyHandler();

           saxParser.parse(new File(filename),handler);

           //get employee list
            List<Employee> empList = handler.getEmpList();
            //print
            for(Employee emp: empList){
                System.out.println(emp);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
