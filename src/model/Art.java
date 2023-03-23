package model;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Art {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation dom = builder.getDOMImplementation();

            Document document = dom.createDocument(null, "ObraArte", null);
            document.setXmlVersion("1.0");

            Element art = document.createElement("Obra");

            Element art1 = document.createElement("Obra1");

            Element titleArt1 = document.createElement("NombreObra");
            Text titleTextArt1 = document.createTextNode("La mona lisa");
            titleArt1.appendChild(titleTextArt1);

            Element type1 = document.createElement("TipoObra");
            Text typeText1 = document.createTextNode("Pintura");
            type1.appendChild(typeText1);

            Element value1 = document.createElement("Precio");
            Text valueText1 = document.createTextNode("50000 USD");
            value1.appendChild(valueText1);

            Element authorArt1 = document.createElement("Autor");

            Element authorName1 = document.createElement("Nombre");
            Text authorNameText1 = document.createTextNode("Leonardo");
            authorName1.appendChild(authorNameText1);

            Element authorLastName1 = document.createElement("Apellido");
            Text authorLastNameText1 = document.createTextNode("Da Vinci");
            authorLastName1.appendChild(authorLastNameText1);

            authorArt1.appendChild(authorName1);
            authorArt1.appendChild(authorLastName1);

            Element art2 = document.createElement("Obra2");

            Element titleArt2 = document.createElement("NombreObra");
            Text titleTextArt2 = document.createTextNode("Torso de mujer");
            titleArt2.appendChild(titleTextArt2);

            Element type2 = document.createElement("TipoObra");
            Text typeText2 = document.createTextNode("Escultura");
            type2.appendChild(typeText2);

            Element value2 = document.createElement("Precio");
            Text valueText2 = document.createTextNode("30000 USD");
            value2.appendChild(valueText2);

            Element authorArt2 = document.createElement("Autor");

            Element authorName2 = document.createElement("Nombre");
            Text authorNameText2 = document.createTextNode("Fernando");
            authorName2.appendChild(authorNameText2);

            Element authorLastName2 = document.createElement("Apellido");
            Text authorLastNameText2 = document.createTextNode("Botero");
            authorLastName2.appendChild(authorLastNameText2);

            authorArt2.appendChild(authorName2);
            authorArt2.appendChild(authorLastName2);

            art1.appendChild(titleArt1);
            art1.appendChild(type1);
            art1.appendChild(value1);
            art1.appendChild(authorArt1);

            art2.appendChild(titleArt2);
            art2.appendChild(type2);
            art2.appendChild(value2);
            art2.appendChild(authorArt2);

            art.appendChild(art1);
            art.appendChild(art2);

            document.getDocumentElement().appendChild(art);

            Source source = new DOMSource(document);
            Result result = new StreamResult(new File("WorkShopXML/src/resources/ObraArte.xml"));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

            System.out.println("Archivo XML creado");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
