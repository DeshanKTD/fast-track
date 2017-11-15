import cursor.StaxXMLStreamReader;
import cursor.StaxXMLStreamWriter;
import iterator.StaxXMLIteratorReader;
import iterator.StaxXMLIteratorWriter;
import reader.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Executer {
    /*
     * give args 0  - read xml
     * give args 1 - write file 1 cursor api
     * give args 2 - write file 2 iterator api
     */
    public static void main(String[] args){

        //read data from cursor base api
        System.out.println("Testing cursor api reader");
        StaxXMLStreamReader staxXMLStreamReader = new StaxXMLStreamReader();
        List<Employee> employeeList =  staxXMLStreamReader.parseXML(args[0]);
        for(Employee emp: employeeList){
            System.out.println(emp);
        }


        // write data from cursor based api
        String rootElement = "Employee";
        StaxXMLStreamWriter staxXMLStreamWriter = new StaxXMLStreamWriter();
        Map<String,String> elementsMap = new HashMap<String,String>();

        elementsMap.put("id","1");
        elementsMap.put("name","Lisa");
        elementsMap.put("age","24");
        elementsMap.put("role","Java developer");
        elementsMap.put("gender", "Male");
        staxXMLStreamWriter.writeXML(args[1], rootElement, elementsMap);

        System.out.println("DONE with cusror");

        // read data from iterator api
        System.out.println("Read xml form iterator api");
        employeeList = null;
        StaxXMLIteratorReader staxXMLIteratorReader = new StaxXMLIteratorReader();
        employeeList = staxXMLIteratorReader.parseXML(args[0]);
        for(Employee emp : employeeList){
            System.out.println(emp);
        }

        // write data from iterator api
        StaxXMLIteratorWriter staxXMLIteratorWriter = new StaxXMLIteratorWriter();
        staxXMLIteratorWriter.writeXML(args[2],rootElement,elementsMap);
        System.out.println("Iterator write finished");

    }
}
