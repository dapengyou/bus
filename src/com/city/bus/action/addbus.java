package com.city.bus.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.bus.business.IBus;
import com.city.bus.business.IPower;
import com.city.bus.factory.BusinessFactory;

/**
 * Servlet implementation class addbus
 */
@WebServlet("/bus/addbus.do")
public class addbus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addbus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stationId = request.getParameter("stationId");
		String stationA = request.getParameter("stationA");
		String stationB = request.getParameter("stationB");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		try {
			IBus iBus = BusinessFactory.getBus();
			iBus.add(stationId, stationA, stationB, startTime, endTime);
			RequestDispatcher dispatcher = request.getRequestDispatcher("findbus.do");
			dispatcher.forward(request, response);
			
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
