package com.dts.etender.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.etender.dao.DepartmentDAO;
import com.dts.etender.dao.QuatationDAO;
import com.dts.etender.model.Department;
import com.dts.etender.model.Quatation;

public class TenderAwardAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target="SearchTender.jsp?status=Awarding Completion Failed";
		try
		{

  			Quatation quatation=new Quatation(); 
        quatation.setQuatatonID(Integer.parseInt(request.getParameter("quatationID"))); 
       
         
        boolean flag=new QuatationDAO().awardingTender(quatation); 
         
        if(flag) 
            target="SearchTender.jsp?status=Awarding Completed Successfully"; 
        else 
            target="SearchTender.jsp?status=Awarding Completion Failed"; 
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);
	}catch(Exception e){RequestDispatcher rd = request.getRequestDispatcher(target);
    rd.forward(request,response);
}
}

}
