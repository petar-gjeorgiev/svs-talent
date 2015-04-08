package com.seavus.calculate;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		printMessage(req, resp);
		System.out.println("HISTORY DO GET\n");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	private void printMessage(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		HttpSession session = req.getSession();
		resp.setContentType("text/html");

		resp.setContentType("text/html");
		resp.getWriter().println("Operations:<br/>");
		if (session.getAttribute("operation") != null) {
			@SuppressWarnings("unchecked")
			List<Operation> operations = (List<Operation>) session
					.getAttribute("operation");
			for (Operation o : operations) {
				resp.getWriter().println(o + "<br/>");
			}

		}

	}

}
