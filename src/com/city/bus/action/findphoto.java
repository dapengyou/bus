package com.city.bus.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.bus.factory.ConnectionFactory;

/**
 * Servlet implementation class findphoto
 */
@WebServlet("/bus/findphoto.do")
public class findphoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findphoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		int len = 0;
		byte[] data = new byte[1000];
		String sql = "select photo from usertable where username=?";
		System.out.println(username);
		try {
			Connection cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				System.out.println("lssdk");
				response.setContentType("image/jpeg");
				OutputStream out = response.getOutputStream();
				InputStream in = rs.getBinaryStream("photo");
				while((len=in.read(data))!=-1){
					out.write(data, 0, len);
				}
				
				out.flush();
				in.close();
				out.close();
			}
			rs.close();
			ps.close();
			cn.close();
			
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
