package fk.sp.ListEasy.core;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.json.XML;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author sabarinath.s
 * Date: 05-Jun-2015	
 * Time: 12:13:04 am 
 */

public class HtmlCrawler {

	static Logger logger = Logger.getLogger(HtmlCrawler.class);

	public static Elements crawlPageandRetrievePDlinks(URL url) {

		Document parse = null;
		Elements links = null;
		try{
			parse = Jsoup.parse(url, 10000);
		}catch(Exception e){
			logger.error("unable to parse url - "+url.toString(), e);
		}
		if(parse !=null){
			links = parse.getElementsByAttributeValue("class","vip");
		}
		if(!(links.size()>0)){
			logger.warn("No product links found");
			throw new RuntimeException("No product links found");
		}
		return links;
	}

	public static void parseProductDetails(Elements links) {

		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(20);

		if(links != null & links.size()>0 ){
			for(Element e  : links){
				String attr = null;
				try {
					attr = e.getElementsByTag("a").get(0).attr("href");
					newFixedThreadPool.execute(new ProductPageScrapper(new URL(attr)));
				} catch (MalformedURLException e1) {
					logger.error("invalid link found ", e1);
					e1.printStackTrace();
				}
			}
		}else{
			logger.warn("No product links found");
			throw new RuntimeException("No product links found");
		}
	}

	public static void parseSDProductDetails(String vc, int categoryId, int count, String sellerId, String vertical) throws IOException {

		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(20);


		for(int i=0 ; i < count; i ++){
			ProductJsonScraper jsonscp = new ProductJsonScraper(new URL("http://www.snapdeal.com/json/sellerStoreFront/"+i+"/1?view=List&vc="+vc+"&categoryId="+categoryId+"&lang=en"),sellerId,vertical );
			newFixedThreadPool.execute(jsonscp);
		}
	}

	public static void main(String []a) throws IOException, JDOMException{
		
		String s ="<?xml version=\"1.0\" encoding=\"UTF-8\"?><note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>";
		SAXBuilder sx=new SAXBuilder();
		org.jdom.Document build = sx.build(new ByteArrayInputStream(s.getBytes("UTF-8")));
		
		//parseSDProductDetails("S774ce",2396,1);
	}
}
