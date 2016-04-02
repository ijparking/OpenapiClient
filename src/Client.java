public class Client {
	public static void main(String[] args) {
		String searchQuery = "jcicorp.kr";
		
		String uri = "http://whois.kisa.or.kr/openapi/whois.jsp?query="+searchQuery+"&key=2016040221243860265678&answer=xml";
		
		XmlParser parser = new XmlParser();
		parser.parse(uri);
	}
}