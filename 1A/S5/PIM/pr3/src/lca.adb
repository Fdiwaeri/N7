with Ada.Text_IO;            use Ada.Text_IO;
with SDA_Exceptions;         use SDA_Exceptions;
with Ada.Unchecked_Deallocation;

package body LCA is

	procedure Free is
		new Ada.Unchecked_Deallocation (Object => T_Cellule, Name => T_LCA);


	procedure Initialiser(Sda: out T_LCA) is
	begin
		Sda := null;
	end Initialiser;


	procedure Detruire (Sda : in out T_LCA) is
	begin
	    if sda = null then
		    Free(Sda);
	    else
	        Detruire(sda.all.Suivant);
	        Free(Sda);
	    end if;
	end Detruire;


	procedure Afficher_Debug (Sda : in T_LCA) is	
		Liste: T_LCA;
	begin
		Liste := Sda;
		while not (Liste = null) loop
		    Afficher_Cle(Liste.All.Cle);
		    Put(" --> ");
		    Afficher_Valeur(Liste.All.Valeur);
		    New_Line;
		    Liste := Liste.all.Suivant;
	        end loop;
	end Afficher_Debug;


	function Est_Vide (Sda : T_LCA) return Boolean is
	begin
		return (Sda = null);
	end Est_Vide;


	function Taille (Sda : in T_LCA) return Integer is
	    taille : Integer := 0;
	    Liste : T_LCA;
	begin
		Liste := Sda;
		while not (Liste = null) loop 
		    taille := taille + 1;
		    Liste := Liste.Suivant;
	    end loop;
	    return taille;
	end Taille;


	procedure Enregistrer (Sda : in out T_LCA ; Cle : in T_Cle ; Valeur : in T_Valeur) is
	    Pointeur : T_LCA;
	    d : T_LCA;
	    function dernier(Sda: in T_LCA) return T_LCA is 
	        p : T_LCA;
	    begin 
	        p := Sda;
	        while p.All.Suivant /= Null loop
	            p := p.All.Suivant;
	        end loop;
	        return p;
	    end dernier;
	begin
	    if not Cle_Presente(Sda,Cle) then 
	        Pointeur := new T_Cellule;
	        Pointeur.All.Cle := Cle;
	        Pointeur.All.Valeur := Valeur;
	        Pointeur.All.Suivant := Null;
	        if Sda = Null then 
	            Sda := Pointeur;
	        else 
	            d := dernier(Sda);
	            d.All.Suivant := Pointeur;
	        end if;
	        
	    else 
		    Pointeur := Sda;
		    while Pointeur /= Null loop
		        if Pointeur.All.Cle = Cle then
		            Pointeur.All.Valeur := Valeur;
		            exit;
		        else  
		            Pointeur := Pointeur.All.Suivant;
		        end if;
		    end loop; 
		end if;
	end Enregistrer;


	function Cle_Presente (Sda : in T_LCA ; Cle : in T_Cle) return Boolean is
	    Liste : T_LCA;
	begin
		Liste := Sda;
		while not (Liste = null) loop
		    if Liste.all.Cle = Cle then
		        return True;
		    else null;
		    end if;
		    Liste := Liste.all.Suivant;
	    end loop;
	    return False;	   
	end;


	function La_Valeur (Sda : in T_LCA ; Cle : in T_Cle) return T_Valeur is
	begin
	    if Sda = null then
	        raise Cle_Absente_Exception;
		elsif Sda.All.Cle = Cle then
		    return Sda.All.Valeur;
		else
		    return La_Valeur(Sda.All.Suivant, Cle);
		end if;
	end La_Valeur;


	procedure Supprimer (Sda : in out T_LCA ; Cle : in T_Cle) is
	    Liste : T_LCA;
	begin
		if Sda = null then
		    raise Cle_Absente_Exception;
	    elsif Sda.All.Cle = Cle then
	        Liste := Sda;
	        Sda := Sda.All.Suivant;
	        Free(Liste);
        else
            Supprimer(Sda.All.Suivant, Cle);
        end if;
	end Supprimer;


	procedure Pour_Chaque (Sda : in T_LCA) is
	    Liste : T_LCA;
	begin
		Liste := Sda;
		while not (Liste = null) loop
		    begin
		        Traiter(Liste.All.Cle, Liste.All.Valeur);
	        exception
                when others => Skip_Line;
            end;
            Liste := Liste.All.Suivant;
        end loop;
	end Pour_Chaque;


    function Suivant(Sda: in T_LCA) return T_LCA is
    begin
        return Sda.all.Suivant;
    end;
    
    
    procedure Remplacer(Sda1 : in T_LCA; Sda2 : in out T_LCA) is
    begin
        Sda2 := Sda1;
    end;


    function La_Cle (Sda : in T_LCA) return T_Cle is
    begin
        return Sda.all.Cle;
    end La_Cle;
    
    
    function Cle_Indice(Sda : in T_LCA; Indice : in Integer) return T_Cle is
        Compteur : Integer := 1;
        Liste : T_LCA := Sda;
    begin
        while Compteur /= Indice loop
            Liste := Liste.all.Suivant;
            Compteur := Compteur + 1;
        end loop;
        return Liste.all.Cle;
    end Cle_Indice;


    function Valeur_Indice(Sda : in T_LCA; Indice : in Integer) return T_Valeur is
        Compteur : Integer := 1;
        Liste : T_LCA := Sda;
    begin
        while Compteur /= Indice loop
            Liste := Liste.all.Suivant;
            Compteur := Compteur + 1;
        end loop;
        return Liste.all.Valeur;
    end Valeur_Indice;


    procedure Inserer(Sda : in out T_LCA; Cle : in T_Cle; Valeur : in T_Valeur; Indice : in Integer) is
    begin
        if Indice = 1 then
            Enregistrer(Sda, Cle, Valeur);
        elsif Indice > 1 then
            Inserer(Sda.all.Suivant, Cle, Valeur, Indice-1);
        end if;
    end Inserer;


    procedure Inverser(Sda: in out T_LCA) is
        Liste: T_LCA;
        n : Constant Integer := Taille(Sda);
    begin
        if not Est_Vide(Sda) then
            Initialiser(Liste);
            for I in 1..n loop
                Enregistrer(Liste, Cle_Indice(Sda, I), Valeur_Indice(Sda, I));
            end loop;
            Sda := Liste;
        end if;
    end;
    
    
    procedure Supprimer_premier(Sda: in out T_LCA) is
    begin
        Sda := Sda.all.Suivant;
    end;
    
    
    function La_Cle_De_Valeur (Sda : in T_LCA; Valeur : in T_Valeur) return T_Cle is
    begin
	    if Sda.All.Valeur = Valeur then
		    return Sda.All.Cle;
		else
		    return La_Cle_De_Valeur(Sda.All.Suivant, Valeur);
		end if;
	end La_Cle_De_Valeur;
        
    
    function Valeur_Presente (Sda : in T_LCA ; Valeur : in T_Valeur) return Boolean is
        Liste : T_LCA;
	begin
		Liste := Sda;
		while not (Liste = null) loop
		    if Liste.all.Valeur = Valeur then
		        return True;
		    else null;
		    end if;
		    Liste := Liste.all.Suivant;
	    end loop;
	    return False;	   
	end Valeur_Presente;

end LCA;
