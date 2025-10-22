with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
-- Définition de structures de données associatives sous forme d'un arbre 
-- binaire.
generic
	type T_Symbole is private;
	type T_Frequence is private;

package ABR is

	type T_ABR is private;

	-- Initialiser un arbre.  L'arbre est vide.
	procedure Initialiser(Arbre : out T_ABR) with
		Post => Est_Vide (Arbre);


	-- Détruire un arbre. Il ne devra plus être utilisé.
	procedure Detruire (Arbre : in out T_ABR);


	-- Est-ce qu'un arbre est vide ?
	function Est_Vide (Arbre : in T_ABR) return Boolean;

    -- Est-ce qu'une Arbre est une feuille?
    function Est_Feuille(Arbre : in T_ABR) return Boolean;
    
    
	-- Obtenir le nombre d'éléments d'une Arbre. 
	function Taille (Arbre : in T_ABR) return Integer with
		Post => Taille'Result >= 0
			and (Taille'Result = 0) = Est_Vide (Arbre);




	-- Afficher la Arbre en révélant sa structure interne.
	-- Voici un exemple d'affichage.
	
	-- (42)
    -- \--0--(17)
    -- |    \--0--(8)
    -- |    |       \--0--(4) 'm'
    -- |    |       \--1--(4) 'x'
    -- |    \--1--(9)
    -- |        \--0--(4)
    -- |        |      \--0--(2) '\n'
    -- |        |      \--1--(2) 'l'
    -- |        \- -1--(5) ' '
    -- \--1--(25)
    --      \--0--(10)
    --      |       \--0--(5) 't'
    --      |       \--1--(5)
    --      |               \--0--(2)
    --      |               |       \--0--(1) 'd'
    --      |               |       \--1--(1)
    --      |               |               \--0--(0) '\$'
    --      |               |               \--1--(1) ':'
    --      |               \--1--(3) 'p'
    --      \--1--(15) 'e'
	generic
		with procedure Afficher_Symbole (Symbole : in T_Symbole);
		with procedure Afficher_Frequence (Frequence : in T_Frequence);
	procedure Afficher_Debug (Arbre : in T_ABR; Niveau: in Unbounded_String);



    function Symbole(Arbre : in T_ABR) return T_Symbole;
        
        
    function Frequence(Arbre : in T_ABR) return T_Frequence;


    function Gauche(Arbre : in T_ABR) return T_ABR;
    
    
    function Droit(Arbre : in T_ABR) return T_ABR;
    
    
    procedure Remplacer(Arbre1 : in T_ABR;Arbre2 : in out T_ABR);
    
    
    procedure Remplacer_Donnees(Arbre1 : in T_ABR; Arbre2 : in out T_ABR);
    
    
    procedure Creer_Nouveau_Noeud(Arbre: out T_ABR; Symbole : in T_Symbole; Frequence : in T_Frequence; Gauche : in T_ABR; Droit : in T_ABR);
    
    
    procedure Creer_Fils_Gauche(Arbre: in out T_ABR; Symbole : in T_Symbole; Frequence : in T_Frequence);
    

    procedure Creer_Fils_Droit(Arbre: in out T_ABR; Symbole : in T_Symbole; Frequence : in T_Frequence);
private

    type T_Noeud;
    type T_ABR is access T_Noeud;
	type T_Noeud is
	    record
	        Symbole : T_Symbole ;
	        Frequence: T_Frequence ;
	        Gauche : T_ABR ;
	        Droit : T_ABR;
	    end record;
	    

end ABR;
