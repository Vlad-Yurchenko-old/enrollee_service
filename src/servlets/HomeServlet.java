package servlets;

import static util.Constants.*;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.mysql.Connector;
import domain.entityImpl.Subject;
import service.factory.ServiceFacroty;

//@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			Connector.init(DRIVER, URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Subject> list = ServiceFacroty.getSubjectService().readAll();
		for (Subject subject : list) {
			System.out.println(subject.getId() + " " + subject.getName());
		}
		
		//String param = request.getParameter("id");
		getServletContext().getRequestDispatcher("/pages/index.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String stringId = req.getParameter("id");
		
		getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doDelete()");
	}

}
