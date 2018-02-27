package com.prayasb.springconfigconverter.converter;

import com.prayasb.springconfigconverter.model.BeanMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLConfigConverter {
    private static final Logger LOG = LoggerFactory.getLogger(XMLConfigConverter.class);

    private Document doc;

    private List<String> importClasses = new ArrayList<>();

    private Map<String, BeanMethod> beansMap = new HashMap<>();

    public XMLConfigConverter(InputStream xmlInputStream) {
        doc = readAsDocument(xmlInputStream);
    }

    private Document readAsDocument(InputStream xmlInputStream) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlInputStream);
            doc.getDocumentElement().normalize();

            return doc;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            LOG.error("Error reading input stream as document", e);

            throw new RuntimeException(e);
        }
    }

    public void convert() {
        NodeList nodeList = doc.getElementsByTagName("bean");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;



            }
        }
    }

    private BeanMethod toBeanMethod(Element element) {
        String id = element.getAttribute("id");
        String name = id == null ? element.getAttribute("name") : id;
        String className = element.getAttribute("class");
        String scope = element.getAttribute("scope");

        String[] classPath = className.split("\\.");
        String simpleClassName = classPath[classPath.length - 1];

        importClasses.add(className);

        NodeList constructorArgs = element.getElementsByTagName("constructor-arg");


        BeanMethod method = new BeanMethod(scope, name, methodBody, simpleClassName);
    }
}
