package com.dts.etender.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.etender.dao.DepartmentDAO;
import com.dts.etender.dao.SecurityDAO;
import com.dts.etender.model.Department;

public class AddDeptAction extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target="AddDept.jsp?status=Department Addition Failed";
		try
		{

  			Department dept=new Department(); 
        dept.setDepartmentName(request.getParameter("DeptName")); 
        dept.setDepartmentAbbr(request.getParameter("DeptAbbr")); 
        dept.setDepartmentInChgID(Integer.parseInt(request.getParameter("EmpID"))); 
         
        boolean flag=new DepartmentDAO().insertDept(dept); 
         
        if(flag) 
            target="AdminHome.jsp?status=Deparment Added Successfully"; 
        else 
            target="AddDept.jsp?status=Department Addition Failed"; 
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);
	}catch(Exception e){RequestDispatcher rd = request.getRequestDispatcher(target);
    rd.forward(request,response);
}
	}

}
