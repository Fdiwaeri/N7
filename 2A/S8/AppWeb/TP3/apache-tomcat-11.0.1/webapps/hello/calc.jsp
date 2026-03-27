<%@ page language="Java" %>
<html>
    <head>
        <title>Calculatrice avec JSP</title>
    </head>
    <body>
        <form method="POST" action="ServJSP">
            nb1 : <input type="text" name="nb1"><br>
            nb2 : <input type="text" name="nb2"><br>
            <input type="submit" value="compute">
        </form>

        <hr>
        <%
        if (request.getAttribute("res") != null) { %>
            <h3>Resultat : ${res}</h3>
        <% } %>
    </body>
</html>