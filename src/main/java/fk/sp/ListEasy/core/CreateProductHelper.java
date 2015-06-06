package fk.sp.ListEasy.core;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import fk.sp.ListEasy.core.JerseyClient.Method;
import fk.sp.ListEasy.models.CreateProductRequest;
import fk.sp.ListEasy.models.CreateProductRequest.Property;
import fk.sp.ListEasy.models.ImageData;
import fk.sp.ListEasy.models.ProductRawDataModel;

/**
 * @author sabarinath.s
 * Date: 06-Jun-2015	
 * Time: 12:51:18 am 
 */

public class CreateProductHelper {

	static	Logger logger = Logger.getLogger(CreateProductHelper.class);

	public static void createProduct(String vertical, ProductRawDataModel prdm, String sellerId){

		CreateProductRequest request = new CreateProductRequest();
		request.setSellerId(sellerId);
		request.setRowId("1");
		request.setDraft("false");
		request.setSkuId(randomizeGroupId());
		request.setVertical(vertical);
		request.setVerticalGroup("Books");
		request.setGroupId(randomizeGroupId());
		Map<String, List<Property>> row = new HashMap<String, List<Property>>();
		HashMap<String,String> productAttributes = prdm.getProductAttributes();
		ImageData imgdata = new ImageData();
		imgdata.setOrderNo(1);
		imgdata.setPath(prdm.getImage());
		List<ImageData> emptyList =new ArrayList<ImageData>();
		emptyList.add(imgdata);
		request.setImages(emptyList);


		for(Entry<String, String> e : productAttributes.entrySet()){
			for(String attribute : AttributesHelper.getAttributesForBooks()){
				if(e.getKey().toLowerCase().contains(attribute)){	
					ArrayList<CreateProductRequest.Property> propertyList = new ArrayList<CreateProductRequest.Property>();
					CreateProductRequest.Property property = new CreateProductRequest.Property();
					property.setValue(e.getValue());
					property.setQualifier("");
					propertyList.add(property);
					row.put(attribute, propertyList);
				}

			}
		}
		request.setRowData(row);

		JSONObject j = new JSONObject(request);
		System.out.println("request -"+j.toString());

		JerseyClient client = JerseyClient.getInstance();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type","application/json");
		try {
			ClientRequest request1 = client.populateRequest("http://sp-cms-backend1.stage.ch.flipkart.com:26600/sp-cms-backend/rest/product/create", request, headers , Method.POST);
			ClientResponse execute = client.execute(request1);
			System.out.println(execute.getStatus());
			System.out.println(execute.getEntity(String.class));
		} catch (URISyntaxException e1) {
			logger.error("Create Product call failed", e1);
			e1.printStackTrace();

		}


	}

	public static void randomizeSku(){

	}

	private static String randomizeGroupId(){
		return RandomStringUtils.randomAlphanumeric(13);
		//return UUID.randomUUID().toString();
	}
}
