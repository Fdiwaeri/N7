with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with LCA;
with Ada.Characters.Latin_1;

procedure Test_Decoder_Texte is

    -- Instancier les packages.
    package LCA_UStr_UStr is new LCA(T_Cle => Unbounded_String, T_Valeur => Unbounded_String);
	use LCA_UStr_UStr;
	
	procedure Afficher_Cle(Cle : in Unbounded_String) is 
    begin
        Put("'");
        Put(To_String(Cle));
        Put("'");
    end Afficher_Cle;
    procedure Afficher_Valeur(Valeur : in Unbounded_String) is 
    begin
        Put(To_String(Valeur));
    end Afficher_Valeur;
    procedure Afficher_Table is new LCA_UStr_UStr.Afficher_Debug(Afficher_Cle => Afficher_Cle, Afficher_Valeur => Afficher_Valeur);

    function Decoder_Texte(Table_Huffman: in T_LCA; Texte_Compresse: in Unbounded_String) return Unbounded_String is
        Texte_Decompresse : Unbounded_String := To_Unbounded_String("");
        Code: Unbounded_String := To_Unbounded_String("");
    begin
        for I in 1 .. Length(Texte_Compresse) loop
            Code := Code & To_Unbounded_String(To_String(Texte_Compresse)(I .. I));
            if Valeur_Presente(Table_Huffman, Code) then
                if La_Cle_De_Valeur(Table_Huffman, Code) = To_Unbounded_String("\n") then
                    Texte_Decompresse := Texte_Decompresse & To_Unbounded_String("" & Ada.Characters.Latin_1.LF);
                elsif La_Cle_De_Valeur(Table_Huffman, Code) = To_Unbounded_String("\$") then
                    null;
                else
                    Texte_Decompresse := Texte_Decompresse & La_Cle_De_Valeur(Table_Huffman, Code);
                end if;
                Code := To_Unbounded_String("");
            end if;
        end loop;
        return Texte_Decompresse;
    end Decoder_Texte; 
    
    Table_Huffman : T_LCA;
    Texte_Compresse : Unbounded_String;
    Texte_Decompresse : Unbounded_String;
begin
    Initialiser(Table_Huffman);
    Enregistrer(Table_Huffman, To_Unbounded_String("\$"), To_Unbounded_String("000"));
    Enregistrer(Table_Huffman, To_Unbounded_String("\n"), To_Unbounded_String("001"));
    Enregistrer(Table_Huffman, To_Unbounded_String("a"), To_Unbounded_String("01"));
    Enregistrer(Table_Huffman, To_Unbounded_String("d"), To_Unbounded_String("100"));
    Enregistrer(Table_Huffman, To_Unbounded_String("e"), To_Unbounded_String("101"));
    Enregistrer(Table_Huffman, To_Unbounded_String("f"), To_Unbounded_String("110"));
    Enregistrer(Table_Huffman, To_Unbounded_String("w"), To_Unbounded_String("111"));
    Afficher_Table(Table_Huffman);
    Texte_Compresse := To_Unbounded_String("1100110011101001101000");
    Texte_Decompresse := Decoder_Texte(Table_Huffman, Texte_Compresse);
    Put_Line("Le texte décompressé:");
    Put(To_String(Texte_Decompresse));
    Detruire(Table_Huffman);
end Test_Decoder_Texte;
