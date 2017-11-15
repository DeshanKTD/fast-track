import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {
    public static boolean validateXMLSchema(String xsdPath, String xmlPath){
        boolean status = false;
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (SAXException e) {
            e.printStackTrace();
            return status;

        } catch (IOException e){
            e.printStackTrace();
            return status;
        }
        status = true;
        return status;

    }

    public static void main(String [] args){
        // give arg 1 as xsd -
        // give arg 2 as xml to validete

        System.out.println("Validate xml");
        boolean isReal = validateXMLSchema(args[0],args[1]);
        if(isReal){
            System.out.println("File is validated");
        }
        else {
            System.out.println("File is not validated");
        }
    }


}
