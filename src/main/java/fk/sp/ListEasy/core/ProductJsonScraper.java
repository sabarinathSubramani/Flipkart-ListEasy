package fk.sp.ListEasy.core;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.apache.velocity.anakia.XPathTool;
import org.apache.velocity.tools.generic.XmlTool;
import org.dom4j.io.SAXReader;
import org.jdom.JDOMException;
import org.jdom.input.DOMBuilder;
import org.jdom.input.SAXBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import fk.sp.ListEasy.models.ProductRawDataModel;

/**
 * @author sabarinath.s
 * Date: 05-Jun-2015	
 * Time: 7:38:34 pm 
 */

public class ProductJsonScraper implements Runnable{



	Logger logger = Logger.getLogger(ProductPageScrapper.class);
	public URL url = null;
	public String sellerId;
	public String vertical;

	public ProductJsonScraper(URL url, String sellerId, String vertical ){
		super();
		this.url = url;
		this.sellerId =sellerId;
		this.vertical = vertical;
	}

	@Override
	public void run(){
		try {
			
			//WebApplicationContext wc = ContextLoader.getCurrentWebApplicationContext();
		//	Object attribute = wc.getServletContext().getAttribute("sellerId");

			String body = Jsoup.connect(url.toString()).execute().body();
			JSONArray array = new JSONArray(body);
			JSONObject jsonObject = array.getJSONObject(0);
			jsonObject.remove("initAttributesFull");
			jsonObject.remove("offers");
			String productPojo = TemplateHelper.getProductPojo(jsonObject);
			System.out.println(productPojo);
			ProductRawDataModel convertToJavaPojo = convertToJavaPojo(productPojo);
			StringBuffer sb = new StringBuffer();
			sb.append("http://n4.sdlcdn.com/");
			sb.append(convertToJavaPojo.getImage());
			convertToJavaPojo.setImage(sb.toString());
			CreateProductHelper.createProduct(vertical, convertToJavaPojo, sellerId);
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	public ProductRawDataModel convertToJavaPojo(String xml) throws JAXBException{
		JAXBContext ctx = JAXBContext.newInstance(ProductRawDataModel.class);
		Unmarshaller createUnmarshaller = ctx.createUnmarshaller();
		return (ProductRawDataModel)createUnmarshaller.unmarshal(new StringBufferInputStream(xml));
	}
}
