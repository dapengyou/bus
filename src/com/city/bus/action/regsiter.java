package com.city.bus.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.bus.business.IBus;
import com.city.bus.business.IPower;
import com.city.bus.business.IUser;
import com.city.bus.factory.BusinessFactory;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

/**
 * Servlet implementation class regsiter
 */
@WebServlet("/bus/regsiter.do")
public class regsiter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config=null;
	private Connection cn = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regsiter() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
		
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SmartUpload upload=new SmartUpload();
		try
		{
					upload.initialize(config, request, response);
					upload.upload();
					//取得JspSmartupload提供的请求对象
					Request req=upload.getRequest();

					String username = req.getParameter("username");
					String password = req.getParameter("password");
					String power = req.getParameter("power");
					
					String a = req.getParameter("age");
					int age = Integer.parseInt(a);
					
					String sex = req.getParameter("sex");
					//String photo = req.getParameter("photo");
					
					IUser iUser = BusinessFactory.getUser();
					IPower iPower = BusinessFactory.getPower();
					iUser.add(username, password, power, age, sex);
					iPower.add(username, password, power);
						
					
		}
		catch(Exception e){
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
