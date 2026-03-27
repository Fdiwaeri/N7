package pack;

import java.util.Collection;
import javax.ws.rs.*;

@Path("/")
public interface Facade {
    @POST
    @Path("/addp")
    @Consumes("application/json" )
    void addPersonne(String nom, String prenom) ;

    @POST
    @Path("/adda")
    @Consumes("application/json" )
    void addAdresse(String rue, String ville) ;


    @GET
    @Path("/consulterps")
    @Produces("application/json")
    Collection<Personne> consulterPersonnes();

    @GET
    @Path("/consulteras")
    @Produces("application/json")
    Collection<Adresse> consulterAdresses();


    @GET
    @Path("/consulterp" )
    @Produces("application/json")
    Personne consulterPersonne(@QueryParam("num") int num) ;

    @GET
    @Path("/consultera" )
    @Produces("application/json")
    Personne consulterAdresse(@QueryParam("num") int num) ;


    @POST
    @Path("/associer" )
    @Produces("application/json")
    void associer(@QueryParam("idp") int idp, @QueryParam("ida") int ida) ;
}