package cursor;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;

public class StaxXMLStreamWriter {
    public void writeXML(String filename, String rootElement,Map<String,String> elementsMap){
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

        try {
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileOutputStream(filename),
                    "UTF-8");

            //start writing xml file
            xmlStreamWriter.writeStartDocument("UTF-8","1.0");
            xmlStreamWriter.writeCharacters("\n");

            xmlStreamWriter.writeStartElement(rootElement);

            //write id as attribute
            xmlStreamWriter.writeAttribute("id", elementsMap.get("id"));

            //write other elements
            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeStartElement("name");
            xmlStreamWriter.writeCharacters("\n\t\t"+elementsMap.get("name"));
            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeStartElement("age");
            xmlStreamWriter.writeCharacters("\n\t\t"+elementsMap.get("age"));
            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeStartElement("gender");
            xmlStreamWriter.writeCharacters("\n\t\t"+elementsMap.get("gender"));
            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeStartElement("role");
            xmlStreamWriter.writeCharacters("\n\t\t"+elementsMap.get("role"));
            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeEndElement();
            //write end tag of Employee element
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeEndElement();

            // write end document
            xmlStreamWriter.writeEndDocument();

            // flush data to file and close writer
            xmlStreamWriter.flush();
            xmlStreamWriter.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
