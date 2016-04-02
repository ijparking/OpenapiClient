import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser {
	public static String getContent(Element element, String tagName) {
		NodeList list = element.getElementsByTagName(tagName);
		Element cElement = (Element)list.item(0);
		
		if(cElement.getFirstChild()!=null) {
			return cElement.getFirstChild().getNodeValue();
		} else {
			return "";
		}
	}
	
	public void parse(String uri) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(uri);
			Element root = doc.getDocumentElement();
			NodeList list = root.getElementsByTagName("krdomain");
			
			System.out.println(list.getLength());
			
			for(int i=0; i<list.getLength(); i++) {
				Element element = (Element)list.item(i);
				
				System.out.println("** Whois Open API Connect **");
				System.out.println("name : "+getContent(element, "name"));
				System.out.println("regName : "+getContent(element, "regName"));
				System.out.println("adminName : "+getContent(element, "adminName"));
				System.out.println("adminEmail : "+getContent(element, "adminEmail"));
				System.out.println("lastUpdatedDate : "+getContent(element, "lastUpdatedDate"));
				System.out.println("regDate : "+getContent(element, "regDate"));
				System.out.println("endDate : "+getContent(element, "endDate"));
				System.out.println("infoYN : "+getContent(element, "infoYN"));
				System.out.println("agency : "+getContent(element, "agency"));
				System.out.println("agency_url : "+getContent(element, "agency_url"));
				System.out.println("e_regName : "+getContent(element, "e_regName"));
				System.out.println("e_adminName : "+getContent(element, "e_adminName"));
				System.out.println("e_agency : "+getContent(element, "e_agency"));
				System.out.println("dnssec : "+getContent(element, "dnssec"));
				System.out.println("ns1 : "+getContent(element, "ns1"));
				System.out.println("ip1 : "+getContent(element, "ip1"));				
				System.out.println("ns2 : "+getContent(element, "ns2"));
				System.out.println("ip2 : "+getContent(element, "ip2"));
				System.out.println("ns3 : "+getContent(element, "ns3"));
				System.out.println("ip3 : "+getContent(element, "ip3"));
				System.out.println("ns4 : "+getContent(element, "ns4"));
				System.out.println("ip4 : "+getContent(element, "ip4"));
			}
			
		} catch(ParserConfigurationException e) {
			e.printStackTrace();
		} catch(SAXException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
