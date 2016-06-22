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
import com.city.bus.dao.IStationDao;
import com.city.bus.factory.BusinessFactory;

/**
 * Servlet implementation class addstation
 */
@WebServlet("/bus/addstation.do")
public class addstation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addstation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stationId = request.getParameter("stationId");
		String station = request.getParameter("station");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		try {
			IStation ist = BusinessFactory.getStation();
			ist.add(stationId, station, startTime, endTime);
			RequestDispatcher dispatcher = request.getRequestDispatcher("findstation.do");
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
