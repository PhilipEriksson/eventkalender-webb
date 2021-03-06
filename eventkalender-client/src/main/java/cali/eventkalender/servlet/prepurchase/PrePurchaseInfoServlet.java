package cali.eventkalender.servlet.prepurchase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prepurchase/info")
public class PrePurchaseInfoServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

    public PrePurchaseInfoServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/pages/PrePurchaseInfo.jsp").forward(request, response);
	}
   
}
