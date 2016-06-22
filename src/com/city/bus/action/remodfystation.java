package com.city.bus.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.bus.business.IBus;
import com.city.bus.business.IStation;
import com.city.bus.factory.BusinessFactory;
import com.city.bus.value.busValue;
import com.city.bus.value.stationValue;

/**
 * Servlet implementation class remodfystation
 */
@WebServlet("/bus/remodfystation.do")
public class remodfystation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public remodfystation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stationId = request.getParameter("stationId");
		
		try {
			IStation iStation = BusinessFactory.getStation();
			stationValue bv = iStation.getstationValue(stationId);
			
			request.setAttribute("pi", bv);
			RequestDispatcher dispatcher = request.getRequestDispatcher("remodfystation.jsp");
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
