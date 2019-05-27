package net.balusc.webapp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListFilesServlet
 */
@WebServlet("/ListFilesServlet")
public class ListFilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListFilesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String path = getServletContext().getInitParameter("basePath"); // getInitParameter("basePath");
//		File[] files = new File(path).listFiles();
		PrintWriter writer = response.getWriter();

		response.setContentType("text/html; charset='UTF-8'");
		System.out.println(request.getContextPath());
		writer.append("<!DOCTYPE html>");
		writer.append("<head>");
		writer.append("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />");
		writer.append("<meta charset='UTF-8'>");
		writer.append("</head>");



		writer.append("<video width=\"320\" height=\"240\" controls>");
		writer.append("<source src=\"video/trailer.mp4\" type=\"video/mp4\">");
		writer.append("<source src=\"video/trailer.ogg\" type=\"video/ogg\">");
		writer.append(" Your browser does not support HTML5 video.\n");
		writer.append("</video>");
//		Set<Entry<String, File>> entrySet = Mp3Table.getInstance().entrySet();
//		for (Entry<String, File> e : entrySet) {
//
//			writer.append("<a href='/MediaPlayer/files/").append(e.getKey()).append("' target='playboard'>").append(e.getValue().getName())
//					.append("</a>").append("</br>");
//		}

		//		for (File file : files) {
		//			if (file.getName().endsWith(".mp3") || file.getName().endsWith(".mp4")) {
		//				writer.append("<a href='/MediaPlayer/files/").append(file.getName()).append("' target='playboard'>").append(file.getName())
		//						.append("</a>").append("</br>");
		//			}
		//
		//		}

		writer.append("</html>");
		writer.flush();
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
