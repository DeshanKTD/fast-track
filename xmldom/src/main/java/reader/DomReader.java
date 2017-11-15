package reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DomReader {

    private File xmlFIle = null;
    private DocumentBuilder dBuilder;

    public DomReader(){}

    public void readXml(String filename){
        this.xmlFIle = new File(filename);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try {
            this.dBuilder = dbFactory.newDocumentBuilder();
            Document doc = this.dBuilder.parse(this.xmlFIle);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Employee");

            List<Employee> empList = new ArrayList<Employee>();
            for (int i=0;i<nodeList.getLength();i++){
                empList.add(getEmployee(nodeList.item(i)));
            }


            // print itemset
            for (Employee emp: empList){
                System.out.println(emp.toString());
            }



        }
        catch (SAXException e){
            e.printStackTrace();
        }
        catch (ParserConfigurationException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }


    } // end of read XML


    private static Employee getEmployee(Node node){
        Employee emp = new Employee();

        if(node.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) node;
            emp.setName(getTagValue("name",element));
            emp.setAge(Integer.parseInt(getTagValue("age",element)));
            emp.setGender(getTagValue("gender",element));
            emp.setRole(getTagValue("role",element));
        } //end of if

        return emp;
    } // end of getEmployee

    private static String getTagValue(String tag,Element element){
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }   // end of getTagValue
}