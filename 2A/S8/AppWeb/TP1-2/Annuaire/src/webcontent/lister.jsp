<%@ page language="Java" import="pack.*, java.util.*" %>
<html>
    <body>
        <form method="get" action="Serv">
            <% Collection<Personne> lp = (Collection<Personne>)request.getAttribute("lp");
                for (Personne p : lp) {
                    String label = p.getNom() + " " + p.getPrenom();
                    Collection<Adresse> la = (Collection<Adresse>)p.getAdresses();
            %>
            <%= label %><br><ul>
            <% for (Adresse a : la) {
                String labela = a.getRue() + " " + a.getVille(); %>
                <li><%= labela %><br></li>
            <% } %></ul>
            <% } %>
        </form>
    </body>
</html>