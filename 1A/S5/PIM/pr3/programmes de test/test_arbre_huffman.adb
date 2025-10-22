with Ada.Text_IO; use Ada.Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with ABR;      
with LCA;

with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;






procedure test_Arbre_Huffman is 

    package ABR_UStr_Int is new ABR (T_Symbole => Unbounded_String, T_Frequence => Integer);
    use ABR_UStr_Int;
    package LCA_UStr_Int is new LCA (T_Cle => Unbounded_String, T_Valeur => Integer);
    use LCA_UStr_Int;

    procedure Afficher_Arbre(Arbre: in T_ABR; espace : in Integer) is
        espace_gauche: integer;
        espace_droit: integer;
    begin
        Put("(");
        Put(Frequence(Arbre));
        Put(")");
        if Est_Feuille(Arbre)  then
            Put("'" & To_String(Symbole(Arbre)) & "'");
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

    function Fusion(Arbre_1 : in ABR_UStr_Int.T_ABR; Arbre_2 : in ABR_UStr_Int.T_ABR) return ABR_UStr_Int.T_ABR is
            Arbre: ABR_UStr_Int.T_ABR;
    begin
        Creer_Nouveau_Noeud(Arbre, To_Unbounded_String(""), Frequence(Arbre_1) + Frequence(Arbre_2), Arbre_1, Arbre_2);
        return Arbre;
    end Fusion;

    function Arbre_Huffman(Table_Frequences :in LCA_UStr_Int.T_LCA) return ABR_UStr_Int.T_ABR is
            type T_Liste_Noeuds is array (1..257) of ABR_UStr_Int.T_ABR;
            Liste_Noeuds : T_Liste_Noeuds;
            Nombre_Noeuds : Integer := 0;
            
            procedure Trier_Noeuds(Liste : in out T_Liste_Noeuds; Nombre_Noeuds : in Integer) is
                Noeud_temporaire : ABR_UStr_Int.T_ABR;
            begin
                for i in 1..Nombre_Noeuds-1 loop
                    for j in 1..Nombre_Noeuds-i loop
                        if Frequence(Liste(j)) > Frequence(Liste(j+1)) then
                            Remplacer(Liste(j) , Noeud_temporaire); 
                            Remplacer(Liste(j+1) , Liste(j));
                            Remplacer(Noeud_temporaire , Liste(j+1));
                        end if;
                    end loop;
                end loop;
            end Trier_Noeuds;
            
            procedure Construire_Feuilles(Table_Frequences : in LCA_UStr_Int.T_LCA; Liste_Noeuds : out T_Liste_Noeuds; Nombre_Noeuds: in out Integer) is
            Arbre_Nulle: ABR_UStr_Int.T_ABR;
            begin
                Initialiser(Arbre_Nulle);
                for C in Character range Character'First..Character'Last loop
                    if not Cle_Presente(Table_Frequences,To_Unbounded_String(Character'Image(C))) then
                        Nombre_Noeuds := Nombre_Noeuds + 1;    
                        Creer_Nouveau_Noeud(Liste_Noeuds(Nombre_Noeuds), To_Unbounded_String(Character'Image(C)), La_Valeur(Table_Frequences, To_Unbounded_String(Character'Image(C))), Arbre_Nulle, Arbre_Nulle);           
                    end if;
                end loop;
            end Construire_Feuilles;
            
            Arbre_Temporaire : ABR_UStr_Int.T_ABR;
            Arbre_Nulle: ABR_UStr_Int.T_ABR;
    begin
        Initialiser(Arbre_Nulle);
        Construire_Feuilles(Table_Frequences, Liste_Noeuds, Nombre_Noeuds);
        Nombre_Noeuds := Nombre_Noeuds + 1;
        Creer_Nouveau_Noeud(Liste_Noeuds(Nombre_Noeuds), To_Unbounded_String("\$"), 0, Arbre_Nulle, Arbre_Nulle );
        while Nombre_Noeuds > 1 loop
            Trier_Noeuds(Liste_Noeuds, Nombre_Noeuds);
            Remplacer(Fusion(Liste_Noeuds(1),Liste_Noeuds(2)), Arbre_Temporaire);
            for I in 3..Nombre_Noeuds loop
                Liste_Noeuds(I-2) := Liste_Noeuds(I);
            end loop;
            Nombre_Noeuds := Nombre_Noeuds -1;
            Remplacer(Arbre_Temporaire,Liste_Noeuds(Nombre_Noeuds));
        end loop;
        return Liste_Noeuds(1);
    end Arbre_Huffman;
    
    Arbre_Huff : ABR_UStr_Int.T_ABR;
    Table_Frequences : LCA_UStr_Int.T_LCA;
begin

    Initialiser(Table_Frequences);
    Initialiser(Arbre_Huff);
    Enregistrer(Table_Frequences,To_Unbounded_String("\n"),2);
    Enregistrer(Table_Frequences,To_Unbounded_String(" "),5);
    Enregistrer(Table_Frequences,To_Unbounded_String(":"),1);
    Enregistrer(Table_Frequences,To_Unbounded_String("d"),1);
    Enregistrer(Table_Frequences,To_Unbounded_String("e"),15);
    Enregistrer(Table_Frequences,To_Unbounded_String("l"),2);
    Enregistrer(Table_Frequences,To_Unbounded_String("m"),4);
    Enregistrer(Table_Frequences,To_Unbounded_String("p"),3);
    Enregistrer(Table_Frequences,To_Unbounded_String("t"),5);
    Enregistrer(Table_Frequences,To_Unbounded_String("x"),4);
    Remplacer(Arbre_Huffman(Table_Frequences), Arbre_Huff);
    Afficher_Arbre(Arbre_Huff,0);
    
end test_Arbre_Huffman;
