package fk.sp.ListEasy.core;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.anakia.XPathTool;
import org.apache.velocity.tools.generic.EscapeTool;
import org.apache.velocity.tools.generic.MathTool;
import org.jdom.Document;
import org.json.JSONObject;

/**
 * @author sabarinath.s
 * Date: 05-Jun-2015	
 * Time: 5:35:40 pm 
 */

public class TemplateHelper {

	public static String getProductPojo(Document document){
		
		VelocityContext ctx = new VelocityContext();
		ctx.put("doc", document);
		ctx.put("xpath", new XPathTool());
		return VelocityTemplateEngine.getInstance().getMergedTemplate(ctx, "ebayin.vm");
		
	}
	
	public static String getProductPojo(JSONObject obj){
		
		VelocityContext ctx = new VelocityContext();
		ctx.put("jsonObject", obj);
		ctx.put("mathTool", new MathTool());
		ctx.put("esc", new EscapeTool());

		return VelocityTemplateEngine.getInstance().getMergedTemplate(ctx, "sd.vm");
	}
}
