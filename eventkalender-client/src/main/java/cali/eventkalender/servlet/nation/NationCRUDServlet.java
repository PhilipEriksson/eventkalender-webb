package cali.eventkalender.servlet.nation;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cali.eventkalender.facade.FacadeLocal;
import cali.eventkalender.model.Nation;

/**
 * Servlet implementation class NationServlet
 */
@WebServlet("/nations/crud")
public class NationCRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private FacadeLocal facade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NationCRUDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Nation> nations = facade.findAllNations();
		request.setAttribute("nations", nations);
		request.getRequestDispatcher("/pages/NationCRUD.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
