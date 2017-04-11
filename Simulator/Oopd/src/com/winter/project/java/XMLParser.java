package com.winter.project.java;
import java.io.File;
import com.winter.project.java.Connections;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLParser {
	public static String fileName1=null;
	public void saxParser(String fileName){
		try {	
			 fileName1=fileName;
			 Connections.connect();
	         File inputFile = new File(fileName);
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         ParserHandler userHandler = new ParserHandler();
	         saxParser.parse(inputFile, userHandler);     
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
}
}
