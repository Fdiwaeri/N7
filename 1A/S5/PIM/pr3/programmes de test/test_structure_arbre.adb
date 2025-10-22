with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with SDA_Exceptions;        use SDA_Exceptions;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with ABR;
with LCA;
with Ada.Command_Line;

procedure test_structure_arbre is

    package ABR_UStr_Int is new ABR (T_Symbole => Unbounded_String, T_Frequence => Integer);
	use ABR_UStr_Int;

    procedure Structure_Arbre(Arbre : in ABR_UStr_Int.T_ABR; Structure : out Unbounded_String) is
    begin
	    if not Est_Vide(Arbre) then
	        if Est_Feuille(Arbre) then
		        Structure := Structure & "1";
	        else
	            Structure := Structure & "0";
	            Structure_Arbre(Arbre.all.Gauche, Structure);
	            Structure_Arbre(Arbre.all.Droit, Structure);
            end if;
        end if;
    end Structure_Arbre;
    
    Feuille1 : T_ABR := new T_Noeud'(To_Unbounded_String("C"), 1, null, null);
    Feuille2 : T_ABR := new T_Noeud'(To_Unbounded_String("D"), 1, null, null);
    Feuille3 : T_ABR := new T_Noeud'(To_Unbounded_String("1"), 2, null, null);
    Feuille4 : T_ABR := new T_Noeud'(To_Unbounded_String("4"), 3, null, null);
    Arbre1 : T_ABR := new T_Noeud'(To_Unbounded_String(""), 2, Feuille1, Feuille2);
    Arbre2 : T_ABR := new T_Noeud'(To_Unbounded_String(""), 5, Feuille3, Feuille4);
    Arbre : T_ABR := new T_Noeud'(To_Unbounded_String(""), 7, Arbre1, Arbre2);
    
    Struture : Unbounded_String := To_Unbounded_String("");
begin
    Structure_Arbre(Arbre, Structure);
    Put(To_String(Structure));
end test_structure_arbre;
    
