package writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import java.io.OutputStream;

public class DomWriter {
    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    private Document doc;

    public DomWriter(){}

    public void writeXml(String filename){
        this.dbFactory = DocumentBuilderFactory.newInstance();

        try {
            this.dBuilder = dbFactory.newDocumentBuilder();
            this.doc = dBuilder.newDocument();
            Element rootElement = doc.createElementNS("https://www.example.com/employees","Employees");
            doc.appendChild(rootElement);
            rootElement.appendChild(getEmployee(doc,"1","pankaj","30","java developer","Male"));
            rootElement.appendChild(getEmployee(doc,"2","Lisa","23","Manager","Female"));

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            DOMSource source = new DOMSource(doc);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File(filename));

            //write data
            transformer.transform(source,console);
            transformer.transform(source,file);

            System.out.print("DONE");


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e){
            e.printStackTrace();
        } catch (TransformerException e){
            e.printStackTrace();
        }




    }

    private static Node getEmployee(Document doc,String id,String name,String age,
                                    String role, String gender){
        Element employee = doc.createElement("Employee");

        employee.setAttribute("id",id);
        employee.appendChild(getEmployeeElements(doc,employee,"name",name));
        employee.appendChild(getEmployeeElements(doc,employee,"age",age));
        employee.appendChild(getEmployeeElements(doc,employee,"role",role));
        employee.appendChild(getEmployeeElements(doc,employee,"gender",gender));
        return employee;

    }   // end of getEmployee

    private static Node getEmployeeElements(Document doc, Element element,
                                            String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }   // end of getEmployeeElements
}
