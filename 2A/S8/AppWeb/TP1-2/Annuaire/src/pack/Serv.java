package pack;

import java.io.IOException;

import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Serv")
public class Serv extends HttpServlet {
    final String path ="http://localhost:8080/facade";
    private Facade f;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResteasyClient client = new ResteasyClientBuilder().build () ;
        ResteasyWebTarget target = client.target(UriBuilder.fromPath(path)) ;
        f = target.proxy(Facade.class) ;
    
        String op = request.getParameter("op");
        switch (op){
            case "ajouterP":
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                f.addPersonne(nom, prenom);
                request.getRequestDispatcher("index.html").forward(request, response);
                return;

            case "ajouterA":
                String rue = request.getParameter("rue");
                String ville = request.getParameter("ville");
                f.addAdresse(rue, ville);
                request.getRequestDispatcher("index.html").forward(request, response);
                return;

            case "choix":
                request.setAttribute("lp", f.consulterPersonnes());
                request.setAttribute("la", f.consulterAdresses());
                request.getRequestDispatcher("choix.jsp").forward(request, response);
                return;

            case "associer":
                int idp = Integer.parseInt(request.getParameter("idp"));
                int ida = Integer.parseInt(request.getParameter("ida"));
                f.associer(idp, ida);
                request.getRequestDispatcher("index.html").forward(request, response);
                return;

            case "lister":
                request.setAttribute("lp", f.consulterPersonnes());
                request.getRequestDispatcher("lister.jsp").forward(request, response);
                return;
        }
    }
}