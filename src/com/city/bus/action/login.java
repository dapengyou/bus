package com.city.bus.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.city.bus.business.IUser;
import com.city.bus.factory.BusinessFactory;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.NestedParticle;

/**
 * Servlet implementation class login
 */
@WebServlet("/bus/login.do")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
		
					IUser user = BusinessFactory.getUser();
					if(user.check(username, password)){
					HttpSession session = request.getSession();
					session.setAttribute("user",username);
					RequestDispatcher dispatcher = request.getRequestDispatcher("finduser.do");
					dispatcher.forward(request, response);
					}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
