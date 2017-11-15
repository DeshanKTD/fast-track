package iterator;

import reader.Employee;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StaxXMLIteratorReader {

    public List<Employee> parseXML(String filename){
        List<Employee> employeeList = new ArrayList<Employee>();
        Employee emp = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(filename));

            while (xmlEventReader.hasNext()){
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();

                    if (startElement.getName().getLocalPart().equals("Employee")){
                        emp = new Employee();

                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if(idAttr != null){
                            emp.setId(Integer.parseInt(idAttr.getValue()));
                        } // end if idAttr

                    }
                    else if (startElement.getName().getLocalPart().equals("age")){
                        xmlEvent = xmlEventReader.nextEvent();
                        emp.setAge(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }
                    else if (startElement.getName().getLocalPart().equals("name")){
                        xmlEvent = xmlEventReader.nextEvent();
                        emp.setName(xmlEvent.asCharacters().getData());
                    }
                    else if (startElement.getName().getLocalPart().equals("gender")){
                        xmlEvent = xmlEventReader.nextEvent();
                        emp.setGender(xmlEvent.asCharacters().getData());
                    }
                    else if (startElement.getName().getLocalPart().equals("role")){
                        xmlEvent = xmlEventReader.nextEvent();
                        emp.setRole(xmlEvent.asCharacters().getData());
                    } // end if
                }
                if (xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();

                    if (endElement.getName().getLocalPart().equals("Employee")){
                        employeeList.add(emp);
                    }
                }
            }

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
