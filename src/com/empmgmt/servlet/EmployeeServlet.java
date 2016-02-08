package com.empmgmt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.empmgmt.dao.EmployeeDAO;
import com.empmgmt.model.Employee;
import com.mongodb.MongoClient;

/**
 * 
 * @author seema3006 Servlet implementation class EmployeeServlet
 */

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		EmployeeDAO empDAO = new EmployeeDAO(mongo);
		JSONArray employees = empDAO.readAllEmployees();

		response.getWriter().write(employees.toString());
	}

	protected void createEmployee(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String deptIdStr = request.getParameter("deptId");
		String salaryStr = request.getParameter("salary");

		int deptId = 0;
		int salary = 0;
		if (deptIdStr != null) {
			deptId = Integer.parseInt(deptIdStr);
		}

		if (salaryStr != null) {
			salary = Integer.parseInt(salaryStr);
		}

		if ((firstName == null || firstName.equals(""))
				|| (lastName == null || lastName.equals(""))) {
			request.setAttribute("error", "Mandatory Parameters Missing");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/employees.jsp");
			rd.forward(request, response);
		} else {
			Employee emp = new Employee();
			emp.setFirstName(firstName);
			emp.setLastName(lastName);
			emp.setDeptId(deptId);
			emp.setSalary(salary);

			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			EmployeeDAO empDAO = new EmployeeDAO(mongo);
			request.setAttribute("success", "Person Added Successfully");
			List<Employee> employees = empDAO.readAllEmployees();
			request.setAttribute("employees", employees);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/employees.jsp");
			rd.forward(request, response);

		}

	}
}
