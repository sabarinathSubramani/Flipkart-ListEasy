package fk.sp.ListEasy.core;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * @author sabarinath.s
 * Date: 05-Jun-2015	
 * Time: 4:50:09 pm 
 */

public class VelocityTemplateEngine {

	private VelocityEngine velocityEngine = null;

	private VelocityTemplateEngine(){
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		this.velocityEngine =ve;
	}

	private static VelocityTemplateEngine vte = new VelocityTemplateEngine();

	public static VelocityTemplateEngine getInstance(){
		return vte;
	}

	public String getMergedTemplate(VelocityContext ctx, String templateName){
		
		Template template = velocityEngine.getTemplate(templateName);
		Writer writer = new StringWriter();
		template.merge(ctx, writer);
		return writer.toString();
	}

}
