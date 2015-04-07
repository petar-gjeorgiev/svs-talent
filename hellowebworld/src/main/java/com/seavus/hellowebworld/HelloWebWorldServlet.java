package com.seavus.hellowebworld;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloWebWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out
				.println("com.seavus.hellowebworld.HelloWebWorldServlet.doGet");
		printMessage(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out
				.println("com.seavus.hellowebworld.HelloWebWorldServlet.doPost");
		printMessage(req, resp);
	}

	private void printMessage(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		final String name = req.getParameter("name");

		resp.setContentType("text/html");
		resp.getWriter().println("Hello " + name);
	}
}
