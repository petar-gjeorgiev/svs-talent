package com.seavus.calculate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String type = req.getParameter("operation");
		Integer operand1 = Integer.parseInt(req.getParameter("operandOne"));
		Integer operand2 = Integer.parseInt(req.getParameter("operandTwo"));
		int res;
		Operation operation = new Operation();
		operation.setOperand1(operand1);
		operation.setOperand2(operand2);

		HttpSession session = req.getSession();
		if (session.getAttribute("operation") == null) {
			List<Operation> operations = new ArrayList<Operation>();
			session.setAttribute("operation", operations);
		}

		if (type.equals("ADD")) {
			res = operand1 + operand2;
			operation.setResult(res);
			operation.setType(OperationType.ADD);
			@SuppressWarnings("unchecked")
			List<Operation> operations = (List<Operation>) session
					.getAttribute("operation");
			operations.add(operation);
			session.setAttribute("operation", operations);
		}
		if (type.equalsIgnoreCase("SUBSTRACT")) {
			res = operand1 - operand2;
			operation.setResult(res);
			operation.setType(OperationType.SUBSTRACT);
			@SuppressWarnings("unchecked")
			List<Operation> operations = (List<Operation>) session
					.getAttribute("operation");
			operations.add(operation);
			session.setAttribute("operation", operations);
		}
		System.out.println("DO GET\n");

		printMessage(req, resp, operation);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String type = req.getParameter("operation");
		Integer operand1 = Integer.parseInt(req.getParameter("operandOne"));
		Integer operand2 = Integer.parseInt(req.getParameter("operandTwo"));
		int res = 0;
		Operation operation = new Operation();
		operation.setOperand1(operand1);
		operation.setOperand2(operand2);

		HttpSession session = req.getSession();
		if (session.getAttribute("operation") == null) {
			List<Operation> operations = new ArrayList<Operation>();
			session.setAttribute("operation", operations);
		}

		if (type.equals("ADD")) {
			res = operand1 + operand2;
			operation.setResult(res);
			operation.setType(OperationType.ADD);
			@SuppressWarnings("unchecked")
			List<Operation> operations = (List<Operation>) session
					.getAttribute("operation");
			operations.add(operation);
			session.setAttribute("operation", operations);
		}
		if (type.equalsIgnoreCase("SUBSTRACT")) {
			res = operand1 - operand2;
			operation.setResult(res);
			operation.setType(OperationType.SUBSTRACT);
			@SuppressWarnings("unchecked")
			List<Operation> operations = (List<Operation>) session
					.getAttribute("operation");
			operations.add(operation);
			session.setAttribute("operation", operations);
		}
		System.out.println("DO POST\n");

		printMessage(req, resp, operation);
	}

	private void printMessage(HttpServletRequest req, HttpServletResponse resp,
			Operation o) throws IOException {

		resp.setContentType("text/html");
		resp.getWriter().println("Operation:<br/>");
		resp.getWriter().println(o + "<br/>");

	}
}
