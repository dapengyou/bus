package com.city.bus.business.Impl;

import java.awt.Transparency;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class EmployeeBusinessImpl {
	public void sendMail(String mail) throws Exception{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/bus");
		Connection cn = ds.getConnection();
		
		String username = "";
		String password = "";
		
	    String sql = "select username,password from usertable where sex = ?";
	    
		 PreparedStatement ps=cn.prepareStatement(sql);
		 ps.setString(1, mail);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next()){
			 username = rs.getString("username");
			 password = rs.getString("password");
			Properties p = new Properties();
			p.put("mail.transport.protocol","smtp");
			p.put("mail.smtp.host", "127.0.0.1");
			p.put("mail.smtp.port","25");
			System.out.println(username+password);
			Session session = Session.getInstance(p,null);
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress("1@city.com"));
			
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));
			message.setSubject("username password");
			message.setSentDate(new Date());
			
			message.setText("username："+username+" password："+password);
			Transport.send(message);
		 }
		 rs.close();
		 ps.close();
		 cn.close();
	}
}
