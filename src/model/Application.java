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

public class Application {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation dom = builder.getDOMImplementation();
			
			Document document = dom.createDocument(null, "library", null);
			document.setXmlVersion("1.0");
			
			Element books = document.createElement("books");
			
			Element book1 = document.createElement("book");
			book1.setAttribute("id", "1");
			
			Element title = document.createElement("title");
			Text titleText = document.createTextNode("Cien años de soledad");
			title.appendChild(titleText);
			
			Element author = document.createElement("autor");
			
			Element authorName = document.createElement("name");
			Text authorNameText = document.createTextNode("Gabriel");
			authorName.appendChild(authorNameText);
			
			
			Element authorLastName = document.createElement("lastname");
			Text authorLastNameText = document.createTextNode("Garcia Marquez");
			authorLastName.appendChild(authorLastNameText);
			
			author.appendChild(authorName);
			author.appendChild(authorLastName);
			
			book1.appendChild(title);
			book1.appendChild(author);
			
			books.appendChild(book1);
			
			document.getDocumentElement().appendChild(books);
			
			Source source = new DOMSource(document);
			Result result = new StreamResult(new File("src/resources/library.xml"));
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			
			System.out.println("Archivo XML creado exitosamente");
			
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	}
}
