<%@ page language="Java" import="pack.*, java.util.*" %>
<html>
    <body>
        <form method="get" action="Serv">
            <h3>Choisissez la personne:</h3>
            <% Collection<Personne> lp = (Collection<Personne>)request.getAttribute("lp");
                for (Personne p : lp) {
                    int id = p.getId();
                    String label = p.getNom() + " " + p.getPrenom();
            %>
            <input type="radio" name="idp" value="<%= id %>">
            <%= label %><br>
            <% } %>

            <h3>Coisissez l'adresse:</h3>
            <% Collection<Adresse> la = (Collection<Adresse>) request.getAttribute("la");
                for (Adresse a : la) {
                    int id = a.getId();
                    String label = a.getRue() + " " + a.getVille();
            %>
            <input type="radio" name="ida" value="<%= id %>">
            <%= label %><br>
            <%  } %>

            <input type="submit" value="OK">
            <input type="hidden" name="op" value="associer">
        </form>
    </body>
</html>