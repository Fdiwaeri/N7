with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with LCA;
    
procedure Test_Separer_Contenu is

    -- Définir les types
    type T_Liste_Caracteres is array (0 .. 256) of Unbounded_String;

    -- Instancier les packages.
    package LCA_UStr_UStr is new LCA(T_Cle => Unbounded_String, T_Valeur => Unbounded_String);
	use LCA_UStr_UStr;
    
    -- Instancier les packages.
    procedure Separer_Contenu(Tableau_Caracteres : in T_Liste_Caracteres; Nombre_Caracteres : in Integer; Contenu : in Unbounded_String; Liste_Caracteres : out LCA_UStr_UStr.T_LCA; Structure_Arbre_Huffman : in out Unbounded_String; Texte_Compresse : out Unbounded_String) is
        Nombre_Des_Uns : Integer := 0;
        Indice : Integer := 1;
    begin
        for I in 1 .. Nombre_Caracteres loop
            Enregistrer(Liste_Caracteres, Tableau_Caracteres(I), To_Unbounded_String(""));
        end loop;
        
        while Nombre_Des_Uns /= Nombre_Caracteres loop
            if To_String(Contenu)(Indice) = '1' then
                Nombre_Des_Uns := Nombre_Des_Uns + 1;
            end if;
            Structure_Arbre_Huffman := Structure_Arbre_Huffman &
To_Unbounded_String(Character'Image(To_String(Contenu)(Indice)));
            Indice := Indice + 1;
        end loop;
        
        Texte_Compresse := To_Unbounded_String(To_String(Contenu)(Indice .. Length(Contenu)));

    end Separer_Contenu;
    
    
    Tableau_Caracteres : T_Liste_Caracteres;
    Nombre_Caracteres : Integer;
    Contenu : Unbounded_String;
    Liste_Caracteres : LCA_UStr_UStr.T_LCA;
    Structure_Arbre_Huffman : Unbounded_String := To_Unbounded_String("");
    Texte_Compresse : Unbounded_String := To_Unbounded_String("");
begin
    Tableau_Caracteres(0) := To_Unbounded_String("\$");
    Tableau_Caracteres(1) := To_Unbounded_String("\n");
    Tableau_Caracteres(2) := To_Unbounded_String(Character'Image('a'));
    Tableau_Caracteres(3) := To_Unbounded_String(Character'Image('d'));
    Tableau_Caracteres(4) := To_Unbounded_String(Character'Image('e'));
    Tableau_Caracteres(5) := To_Unbounded_String(Character'Image('f'));
    Tableau_Caracteres(6) := To_Unbounded_String(Character'Image('w'));
    Nombre_Caracteres := 7;
    -- La structure de l'arbre obtenue pour le texte "fadwae" est "0001110011011"
    -- et les codes des caractères seront :
    -- '\$' --> 000
    -- '\n' --> 001
    -- 'a'  --> 01
    -- 'd'  --> 100
    -- 'e'  --> 101
    -- 'f'  --> 110
    -- 'w'  --> 111
    -- Ce qui donne le texte compressé : 1100110011101001000
    Contenu := To_Unbounded_String("00011100110111100110011101001000");
    Initialiser(Liste_Caracteres);
    Separer_Contenu(Tableau_Caracteres, Nombre_Caracteres, Contenu, Liste_Caracteres, Structure_Arbre_Huffman, Texte_Compresse);
    Put("La structure de l'arbre: ");
    Put(To_String(Structure_Arbre_Huffman));
    New_Line;
    Put("Le texte compressé: ");
    Put(To_String(Texte_Compresse));
    Detruire(Liste_Caracteres);

end Test_Separer_Contenu;
