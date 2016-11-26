package com.Validation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validation_Form
 */
@WebServlet("/Form")
public class Validation_Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validation_Form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String fname=request.getParameter("f_name");
		String lname=request.getParameter("l_name");
		String age=request.getParameter("age");
		String dob=request.getParameter("d_o_b");
		String gender=request.getParameter("gender");
		String phone=request.getParameter("phone");
		String message=request.getParameter("message");
		try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/patient_info","root","google");
				
				/*Statement stmt=con.createStatement();
				stmt.executeUpdate("Create table patient (f_name varchar(20),l_name varchar(20),age varchar(3),D_O_B date,Gender varchar(10),phone_no varchar(10),message varchar(150))");
			*/
				PreparedStatement pstmt=con.prepareStatement("insert into patient values(?,?,?,?,?,?,?)");
				pstmt.setString(1,fname);
				pstmt.setString(2,lname);
				pstmt.setString(3,age);
				pstmt.setString(4,dob);
				pstmt.setString(5,gender);
				pstmt.setString(6,phone);
				pstmt.setString(7,message);
				pstmt.executeUpdate();
				
				out.println("<h> <b>successfully inserted into database...!!");
			
		} 
		catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
