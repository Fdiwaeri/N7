with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with ABR;
with LCA;

procedure Test_Reconstruire_Arbre_Huffman is

    -- Instancier les packages.
    package LCA_UStr_UStr is new LCA(T_Cle => Unbounded_String, T_Valeur => Unbounded_String);
	use LCA_UStr_UStr;
	
    package ABR_UStr_Int is new ABR (T_Symbole => Unbounded_String, T_Frequence => Integer);
	use ABR_UStr_Int;
    
    
    -- Définir les sous-programmes
    procedure Afficher_Arbre(Arbre: in T_ABR; espace : in Integer) is
        espace_gauche: integer;
        espace_droit: integer;
    begin
        Put("(");
        Put(Frequence(Arbre),1);
        Put(")");
        if Est_Feuille(Arbre) then
            if Symbole(Arbre) = To_Unbounded_String("\$") or Symbole(Arbre) = To_Unbounded_String("\n") then
                Put("'");
                Put(To_String(Symbole(Arbre)));
                Put("'");
            else
                Put(To_String(Symbole(Arbre)));
            end if;
        else
            New_line;
            for I in 1..espace loop
                Put(" |     ");
            end loop;
            Put(" \--0--");
            espace_gauche := espace +1;
            Afficher_Arbre(Gauche(Arbre), espace_gauche);
            New_line;
            for I in 1..espace loop
                Put(" |     ");
            end loop;
            Put(" \--1--");
            espace_droit := espace +1;
            Afficher_Arbre(Droit(Arbre), espace_droit);
        end if;
    end Afficher_Arbre;
    
    
    procedure Reconstruire_Arbre_Huffman(Structure_Arbre_Huffman : in out Unbounded_String; Liste_Caracteres : in T_LCA; Indice_Caractere : in out Integer; Arbre_Huffman : out T_ABR) is
        Arbre: T_ABR;
        Noeud: T_ABR;
        Arbre_null: T_ABR;
        UStr_null : Constant Unbounded_String := To_Unbounded_String("");
    begin
        Initialiser(Arbre_null);
        Initialiser(Noeud);
        Initialiser(Arbre);
        if Structure_Arbre_Huffman /= UStr_null then
            Remplacer(Arbre_Huffman, Arbre);
            if To_String(Structure_Arbre_Huffman)(1) = '0' then
                Creer_Fils_Gauche(Arbre_Huffman, To_Unbounded_String(""), 0);
                Creer_Fils_Droit(Arbre_Huffman, To_Unbounded_String(""), 0);
                Structure_Arbre_Huffman := To_Unbounded_String(To_String(Structure_Arbre_Huffman)(2 .. Length(Structure_Arbre_Huffman)));
                Remplacer(Gauche(Arbre_Huffman), Arbre);
                Reconstruire_Arbre_Huffman(Structure_Arbre_Huffman, Liste_Caracteres, Indice_Caractere, Arbre);
                Remplacer(Droit(Arbre_Huffman), Arbre);
                Reconstruire_Arbre_Huffman(Structure_Arbre_Huffman, Liste_Caracteres, Indice_Caractere, Arbre);
            end if;
            if Structure_Arbre_Huffman /= UStr_null then
                if To_String(Structure_Arbre_Huffman)(1) = '1' then
                    Creer_Nouveau_Noeud(Noeud, Cle_Indice(Liste_Caracteres, Indice_Caractere), 0, Arbre_null, Arbre_null);
                    Remplacer_Donnees(Noeud, Arbre);
                    Structure_Arbre_Huffman := To_Unbounded_String(To_String(Structure_Arbre_Huffman)(2 .. Length(Structure_Arbre_Huffman)));
                    Indice_Caractere := Indice_Caractere + 1;
                end if;
            end if;
        end if;
        Detruire(Arbre);
        Detruire(Noeud);
        Detruire(Arbre_null);
    end Reconstruire_Arbre_Huffman;
    
    
    Liste_Caracteres : T_LCA;
    Structure_Arbre_Huffman : Unbounded_String;
    Arbre_Huffman : T_ABR;
    Arbre_Nulle: T_ABR;
    Indice_Caractere : Integer := 1;
begin
    Initialiser(Liste_Caracteres);
    Enregistrer(Liste_Caracteres, To_Unbounded_String("a"), To_Unbounded_String(""));
    Enregistrer(Liste_Caracteres, To_Unbounded_String("b"), To_Unbounded_String(""));
    Enregistrer(Liste_Caracteres, To_Unbounded_String("c"), To_Unbounded_String(""));
    Enregistrer(Liste_Caracteres, To_Unbounded_String("d"), To_Unbounded_String(""));
    Structure_Arbre_Huffman := To_Unbounded_String("0011011");
    Put_Line("La structure de l'arbre de Huffman donnée: " & To_String(Structure_Arbre_Huffman));
    Initialiser(Arbre_Huffman);
    Initialiser(Arbre_Nulle);
    Creer_Nouveau_Noeud(Arbre_Huffman, To_Unbounded_String(""), 0, Arbre_Nulle, Arbre_Nulle);
    Reconstruire_Arbre_Huffman(Structure_Arbre_Huffman, Liste_Caracteres, Indice_Caractere, Arbre_Huffman);
    Put_Line("L'arbre obtenu:");
    Afficher_Arbre(Arbre_Huffman, 0);
    Detruire(Liste_Caracteres);
    Detruire(Arbre_Huffman);
    Detruire(Arbre_Nulle);
end Test_Reconstruire_Arbre_Huffman;
