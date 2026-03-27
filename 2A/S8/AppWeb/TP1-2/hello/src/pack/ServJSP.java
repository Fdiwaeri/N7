package pack;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServJSP")
public class ServJSP extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("calc.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s1 = request.getParameter("nb1");
        String s2 = request.getParameter("nb2");
        if (s1!=null && s2!=null) {
            try {
                int res = (int) (Integer.parseInt(s1)+ Integer.parseInt(s2));
                request.setAttribute("res", res);
                RequestDispatcher rd = request.getRequestDispatcher("calc.jsp");
                rd.forward(request, response);
            } catch(NumberFormatException e) {
                response.getWriter().println("<html><body>Erreur: Donnez des parametres entiers</body></html>");
            }
        }
    }
}