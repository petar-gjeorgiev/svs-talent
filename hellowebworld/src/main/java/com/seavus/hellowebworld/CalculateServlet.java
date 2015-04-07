package com.seavus.hellowebworld;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String type = req.getParameter("operation");
		Integer operand1 = Integer.parseInt(req.getParameter("operandOne"));
		Integer operand2 = Integer.parseInt(req.getParameter("operandTwo"));
		int res = 0;
		HttpSession session = req.getSession();
		if(session.getAttribute("operation") == null) {
			List<Operation> operations = new ArrayList<Operation>();
			session.setAttribute("operation", operations);
		}
		
		if (type.equals("ADD")) {
			res = operand1 + operand2;
			List<Operation> operations = (List<Operation>) session.getAttribute("operation");
			operations.add(new Operation(operand1, operand2, OperationType.ADD,res));
			session.setAttribute("operation",operations);
		}
		if (type.equalsIgnoreCase("SUBSTRACT")) {
			res = operand1 - operand2;
			List<Operation> operations = (List<Operation>) session.getAttribute("operation");
			operations.add(new Operation(operand1, operand2, OperationType.SUBSTRACT,res));
			session.setAttribute("operation", operations);
		}
		System.out.println("DO GET\n");

		printMessage(req, resp, res, operand1, operand2);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String type = req.getParameter("operation");
		Integer operand1 = Integer.parseInt(req.getParameter("operandOne"));
		Integer operand2 = Integer.parseInt(req.getParameter("operandTwo"));
		int res = 0;

		HttpSession session = req.getSession();
		if(session.getAttribute("operation") == null) {
			List<Operation> operations = new ArrayList<Operation>();
			session.setAttribute("operation", operations);
		}
		
		if (type.equals("ADD")) {
			res = operand1 + operand2;
			@SuppressWarnings("unchecked")
			List<Operation> operations = (List<Operation>) session.getAttribute("operation");
			operations.add(new Operation(operand1, operand2, OperationType.ADD,res));
			session.setAttribute("operation",operations);
		}
		if (type.equalsIgnoreCase("SUBSTRACT")) {
			res = operand1 - operand2;
			List<Operation> operations = (List<Operation>) session.getAttribute("operation");
			operations.add(new Operation(operand1, operand2, OperationType.SUBSTRACT,res));
			session.setAttribute("operation", operations);
		}
		System.out.println("DO POST\n");

		printMessage(req, resp, res, operand1, operand2);
	}

	private void printMessage(HttpServletRequest req, HttpServletResponse resp,
			int res, Integer op1, Integer op2) throws IOException {

		resp.setContentType("text/html");
		resp.getWriter().println("Operand1: " + op1 + " Operand2: " + op2 + " Result: " + res);
		
	}

}
