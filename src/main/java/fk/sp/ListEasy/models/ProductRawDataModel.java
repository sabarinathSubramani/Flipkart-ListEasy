package fk.sp.ListEasy.models;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sabarinath.s
 * Date: 05-Jun-2015	
 * Time: 7:06:01 pm 
 */

@XmlRootElement
public class ProductRawDataModel {

	
	private HashMap<String, String> productAttributes = new HashMap<String, String>();
	private String image = null;

	public HashMap<String, String> getProductAttributes() {
		return productAttributes;
	}

	public void setProductAttributes(HashMap<String, String> productAttributes) {
		this.productAttributes = productAttributes;
	}
	
	public static void main(String[] a) throws JAXBException{
		
		ProductRawDataModel model = new ProductRawDataModel();
		model.getProductAttributes().put("testkey", "testvalue");
		model.getProductAttributes().put("testkey1", "testvalue1");
		StringWriter writer = new StringWriter();
		JAXBContext newInstance = JAXBContext.newInstance(ProductRawDataModel.class);
		Marshaller createMarshaller = newInstance.createMarshaller();
		createMarshaller.marshal(model, writer);
		System.out.println(writer.toString());

	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
