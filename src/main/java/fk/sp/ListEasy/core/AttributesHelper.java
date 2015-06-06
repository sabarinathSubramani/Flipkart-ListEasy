package fk.sp.ListEasy.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sabarinath.s
 * Date: 06-Jun-2015	
 * Time: 2:56:10 am 
 */

public class AttributesHelper {

	public static List<String> getAttributesForBooks(){
		
		List<String> attributes = new ArrayList<String>();
		attributes.add("author");
		attributes.add("publisher");
		attributes.add("binding");
		attributes.add("title");
		attributes.add("language");
		return 	attributes;

	}
}
