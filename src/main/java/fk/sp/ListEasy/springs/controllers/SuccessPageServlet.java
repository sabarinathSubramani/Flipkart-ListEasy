package fk.sp.ListEasy.springs.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fk.sp.ListEasy.core.HtmlCrawler;

/**
 * @author sabarinath.s
 * Date: 06-Jun-2015	
 * Time: 4:26:55 am 
 */

public class SuccessPageServlet extends HttpServlet{

	protected void doPost( HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		response.setContentType("text/html");
		
		Map<String, String[]> parameterMap = request.getParameterMap();
		forwardRequest(parameterMap.get("store_id")[0],parameterMap.get("seller_id")[0],parameterMap.get("URL")[0],parameterMap.get("vertical")[0]);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

	}
	
	public void forwardRequest(String vendorCode, String sellerId, String categoryId, String vertical){
		try{
		HtmlCrawler.parseSDProductDetails(vendorCode,Integer.valueOf(categoryId), 10, sellerId, vertical);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
