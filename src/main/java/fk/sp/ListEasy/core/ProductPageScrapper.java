package fk.sp.ListEasy.core;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.jdom.input.DOMBuilder;
import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.xml.sax.SAXException;

/**
 * @author sabarinath.s
 * Date: 05-Jun-2015	
 * Time: 2:48:44 pm 
 */

public class ProductPageScrapper implements Runnable {


	Logger logger = Logger.getLogger(ProductPageScrapper.class);
	public URL url = null;

	public ProductPageScrapper(URL url){
		super();
		this.url = url;
	}

	@Override
	public void run(){


		try {
			org.w3c.dom.Document parse2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url.toString());
		/*	Document parse = Jsoup.connect(url.toString()).get();
			W3CDom w3cdom = new W3CDom();
			org.w3c.dom.Document fromJsoup = w3cdom.fromJsoup(parse);*/
			DOMBuilder builder = new DOMBuilder();
			TemplateHelper.getProductPojo(builder.build(parse2));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (MalformedURLException e1) {
			logger.error("unable to parse the url", e1);
			e1.printStackTrace();
		} catch (IOException e1) {
			logger.error("Error occured while parsing the url", e1);
			e1.printStackTrace();
		}
	}
}
