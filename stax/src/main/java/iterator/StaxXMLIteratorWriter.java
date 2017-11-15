package iterator;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;

public class StaxXMLIteratorWriter {

    public void writeXML(String fileName, String rootElement, Map<String,String> elementsMap){
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

        try {
            XMLEventWriter xmlEventWriter = xmlOutputFactory.createXMLEventWriter(new FileOutputStream(fileName),
                    "UTF-8");

            XMLEventFactory eventFactory = XMLEventFactory.newInstance();
            XMLEvent end = eventFactory.createDTD("\n");
            StartDocument startDocument = eventFactory.createStartDocument();
            xmlEventWriter.add(startDocument);
            xmlEventWriter.add(end);
            StartElement configStartElement = eventFactory.createStartElement("","",rootElement);
            xmlEventWriter.add(configStartElement);

            //write the element nodes
            Set<String> elementNodes = elementsMap.keySet();
            for(String key : elementNodes){
                createNode(xmlEventWriter,key,elementsMap.get(key));
            }

            xmlEventWriter.add(eventFactory.createEndElement("","",rootElement));
            xmlEventWriter.add(end);
            xmlEventWriter.add(eventFactory.createEndDocument());
            xmlEventWriter.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    } // end method

    private static void createNode(XMLEventWriter eventWriter,String element, String value) throws XMLStreamException {
        XMLEventFactory xmlEventFactory = XMLEventFactory.newInstance();
        XMLEvent end = xmlEventFactory.createDTD("\n");
        XMLEvent tab = xmlEventFactory.createDTD("\t");

        //create start node
        StartElement sElement = xmlEventFactory.createStartElement("","",element);
        eventWriter.add(tab);
        eventWriter.add(sElement);

        //create content
        Characters characters = xmlEventFactory.createCharacters(value);
        eventWriter.add(characters);

        // crate end node
        EndElement eElement = xmlEventFactory.createEndElement("","",element);
        eventWriter.add(eElement);
        eventWriter.add(end);
    }

}
