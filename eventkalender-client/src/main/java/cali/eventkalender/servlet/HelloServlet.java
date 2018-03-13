package cali.eventkalender.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cali.eventkalender.facade.FacadeLocal;
import cali.eventkalender.model.Event;
import cali.eventkalender.model.Nation;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

	@EJB
	private FacadeLocal facade;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        out.write("<html>");
        out.write("<head>");
        out.write("<title>HelloServlet</title>");
        out.write("</head>");
        out.write("<body>");
        
        out.write("<h1>Hello!</h1>");
        
        Nation n = facade.findNationById(1);
        
        out.write(String.format("<p>%s</p>", n.getName()));
        
        out.write("<br />");
        
        out.write(String.format("<p>%s har följande evenemang:</p>", n.getName()));
        for (Event e : n.getEvents()) {
        	out.write("<p>-----------------</p>");
        	out.write(String.format("<p>Id: %d</p>", e.getId()));
        	out.write(String.format("<p>Name: %s</p>", e.getName()));
        	out.write(String.format("<p>Summary: %s</p>", e.getSummary()));
        	out.write(String.format("<p>StartTime: %s</p>", e.getStartTime()));
        	out.write(String.format("<p>EndTime: %s</p>", e.getEndTime()));
        }
        
        out.write("</body>");
        out.write("</html>");
    }

}
