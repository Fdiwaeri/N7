with Ada.Text_IO;            use Ada.Text_IO;
with Ada.Unchecked_Deallocation;

package body ABR is

	procedure Free is
		new Ada.Unchecked_Deallocation (Object => T_Noeud, Name => T_ABR);


	procedure Initialiser(Arbre: out T_ABR) is
	begin
		Arbre := null;
	end Initialiser;


	procedure Detruire (Arbre : in out T_ABR) is
	begin
	    if Arbre = null then
		    Free(Arbre);
	    else
	        Detruire(Arbre.all.Gauche);
	        Detruire(Arbre.all.Droit);
	        Free(Arbre);
	    end if;
	end Detruire;



    function Est_Feuille(Arbre : in T_ABR) return Boolean is
    -- Determiner si un noeud est une feuille ou non
    begin
	    return Arbre.All.Gauche = Null and Arbre.All.Droit = Null;
    end;
    
    
    procedure Afficher_Debug (Arbre : in T_ABR; Niveau : in Unbounded_String ) is
	    Niveau_G, Niveau_D : Unbounded_String;
    begin
        if Arbre /= null then
            if Est_Feuille(Arbre) then
                Afficher_Frequence(Arbre.all.Frequence);
                Afficher_Symbole(Arbre.all.Symbole);
            else
                Afficher_Frequence(Arbre.all.Frequence);
                New_Line;

                for i in To_String(Niveau)'range loop
                    if To_String(Niveau)(i) = '0' then
                        Put("|    ");
                    else
	                    Put("    ");
                    end if;
                end loop;

                -- Affichage de l’arbre gauche
                Put("\--0--");
                Niveau_G := Niveau & To_Unbounded_String(Character'Image('0'));
                Afficher_Debug(Arbre.all.Gauche, Niveau_G);
                New_Line;

                for i in To_String(Niveau)'range loop
                    if To_String(Niveau)(i) = '0' then
                        Put("|    ");
                    else
	                    Put("    ");
                    end if;
                end loop;

                -- Affichage de l’arbre droit
                Put("\--1--");
                Niveau_D := Niveau & To_Unbounded_String(Character'Image('1'));
                Afficher_Debug(Arbre.all.Droit, Niveau_D);
                New_Line;
            end if;
        end if;
    end Afficher_Debug;



	function Est_Vide (Arbre : T_ABR) return Boolean is
	begin
		return (Arbre = null);
	end Est_Vide;


	function Taille (Arbre : in T_ABR) return Integer is
	begin
        if Arbre = Null then
            return 0;
        else 
            return 1 + Taille(Arbre.All.Gauche) + Taille(Arbre.All.Droit);
        end if;
	end Taille;
	
	
	



    function Symbole(Arbre : in T_ABR) return T_Symbole is 
    begin
        return Arbre.All.Symbole;
    end Symbole;
        
        
    function Frequence(Arbre : in T_ABR) return T_Frequence is
    begin
        return Arbre.All.Frequence;
    end Frequence;


    function Gauche(Arbre : in T_ABR) return T_ABR is 
    begin
        return Arbre.All.Gauche;
    end Gauche;
    
    
    function Droit(Arbre : in T_ABR) return T_ABR is
    begin
        return Arbre.All.Droit;
    end Droit;
    
    
    procedure Remplacer(Arbre1 : in T_ABR;Arbre2 : in out T_ABR) is 
    begin
        Arbre2 := Arbre1;
    end Remplacer;
    
    
    procedure Remplacer_Donnees(Arbre1 : in T_ABR; Arbre2 : in out T_ABR) is 
    begin
        if Arbre1 /= null and Arbre2 /= null then
            Arbre2.All.Symbole := Symbole(Arbre1);
            Arbre2.All.Frequence := Frequence(Arbre1);
            Arbre2.All.Gauche := Gauche(Arbre1);
            Arbre2.All.Droit := Droit(Arbre1);
        end if;
    end Remplacer_Donnees;
    
    
    procedure Creer_Nouveau_Noeud(Arbre: out T_ABR; Symbole : in T_Symbole; Frequence : in T_Frequence; Gauche : in T_ABR; Droit : in T_ABR) is
    begin
        Arbre := new T_Noeud'(Symbole =>Symbole, Frequence => Frequence, Gauche => Gauche, Droit => Droit);
    end Creer_Nouveau_Noeud;
    
    
    procedure Creer_Fils_Gauche(Arbre: in out T_ABR; Symbole : in T_Symbole; Frequence : in T_Frequence) is
    begin
        Arbre.all.Gauche := New T_Noeud'(Symbole => Symbole, Frequence => Frequence, Gauche => null, Droit => null);
    end Creer_Fils_Gauche;
    

    procedure Creer_Fils_Droit(Arbre: in out T_ABR; Symbole : in T_Symbole; Frequence : in T_Frequence) is
    begin
        Arbre.all.Droit := New T_Noeud'(Symbole => Symbole, Frequence => Frequence, Gauche => null, Droit => null);
    end Creer_Fils_Droit;
    
end ABR;
