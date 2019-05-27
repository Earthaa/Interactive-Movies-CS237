package net.balusc.webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XmlTransformServlet
 */
@WebServlet("/XmlTransformServlet")
public class XmlTransformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XmlTransformServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String xml = request.getParameter("xmlData");
		String xslt = request.getParameter("xsltData");

		try {
			String transform = XmlUtil.transform(xslt, xml);
			response.getWriter().write("<html>");
			response.getWriter().write(transform);
			response.getWriter().write("</html>");
		} catch (Exception e) {
			response.getWriter().write("<html>hello world</html>");
		}
		
		response.setContentType("text/html");
	}

}
