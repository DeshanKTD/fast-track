package cursor;

import reader.Employee;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLStreamConstants;

public class StaxXMLStreamReader {

    private static boolean bName;
    private static boolean bAge;
    private static boolean bGender;
    private static boolean bRole;

    public StaxXMLStreamReader(){}

    public static List<Employee> parseXML(String filename){
        List<Employee> empList = new ArrayList<Employee>();
        Employee emp = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();

        try {
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(filename));
            int event = xmlStreamReader.getEventType();

            while(true){
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (xmlStreamReader.getLocalName().equals("Employee")) {
                            emp = new Employee();
                            emp.setId(Integer.parseInt(xmlStreamReader.getAttributeValue(0)));
                        } else if (xmlStreamReader.getLocalName().equals("name")) {
                            bName = true;
                        } else if (xmlStreamReader.getLocalName().equals("age")) {
                            bAge = true;
                        } else if (xmlStreamReader.getLocalName().equals("role")) {
                            bRole = true;
                        } else if (xmlStreamReader.getLocalName().equals("gender")) {
                            bGender = true;
                        } //end if

                        break;

                    case XMLStreamConstants.CHARACTERS:
                        if (bName) {
                            emp.setName(xmlStreamReader.getText());
                            bName = false;
                        } else if (bAge) {
                            emp.setAge(Integer.parseInt((xmlStreamReader.getText())));
                            bAge = false;
                        } else if (bGender) {
                            emp.setGender(xmlStreamReader.getText());
                            bGender = false;
                        } else if (bRole) {
                            emp.setGender(xmlStreamReader.getText());
                            bRole = false;
                        } // end if
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        if (xmlStreamReader.getLocalName().equals("Employee")) {
                            empList.add(emp);
                        } // end if
                        break;
                } // end switch

                if(!xmlStreamReader.hasNext()){
                    break;
                }
                event = xmlStreamReader.next();
            } //end loop
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return empList;
    }

}
