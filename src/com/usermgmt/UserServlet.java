package com.usermgmt;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class UserServlet
 */

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserServlet() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("Get");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 StringBuffer sb = new StringBuffer();
		 
		    try 
		    {
		      BufferedReader reader = request.getReader();
		      String line = null;
		      while ((line = reader.readLine()) != null)
		      {
		        sb.append(line);
		      }
		    } catch (Exception e) { e.printStackTrace(); }
		 
		    JSONParser parser = new JSONParser();
		    JSONObject joUser = null;
		    try
		    {
		      joUser = (JSONObject) parser.parse(sb.toString());
		    } catch (Exception e) { e.printStackTrace(); }
		 
		    String user = (String) joUser.get("name");
		 
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    out.write("A new user " + user + " has been created.");
		    out.flush();
		    out.close();
	}

}
