with Ada.Text_IO; use Ada.Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with LCA;

procedure Test_Symboles is 
    package LCA_UStr_UStr is new LCA(T_Cle => Unbounded_String,T_Valeur => Unbounded_String);
    use LCA_UStr_UStr;
    
    type T_Tab is array(0..256) of Integer;
    function Symboles (Table_Huffman : in LCA_UStr_UStr.T_LCA) return T_Tab is
	        Curseur : LCA_UStr_UStr.T_LCA;
	        Position : Integer := 0;
	        Dollar : Constant Unbounded_String := To_Unbounded_String("\$");
	        Table_Symboles : T_Tab;
	        I : Integer := 1;
    begin
            Remplacer(Table_Huffman, Curseur);
            while not (Est_Vide(Curseur)) and then La_Cle(Curseur) /= Dollar loop
	            Position := Position + 1;
	            Remplacer(Suivant(Curseur), Curseur);
            end loop;
            Table_Symboles(0) := Position;
            Remplacer(Table_Huffman, Curseur);
            while not (Est_Vide(Curseur)) loop
                
                if LCA_UStr_UStr.La_Cle(Curseur) /= Dollar then
                    Table_Symboles(I) := Character'Pos(To_String(La_Cle(Curseur))(1));
                    I := I + 1;
                end if;
                Remplacer(Suivant(Curseur), Curseur);
            end loop;
            Table_Symboles(I) := Table_Symboles(I-1);
            return Table_Symboles;
    end Symboles;
    
    procedure Afficher_Tableau(Tab : in T_Tab) is
    begin
        Put("Table_Symboles=[");
        for I in 0..4 loop
            Put(Integer'Image(Tab(I)));
            if I<4 then
                Put(",");
            end if;
        end loop;
        Put("]");
    end Afficher_Tableau;
    
    Table : LCA_UStr_UStr.T_LCA;
    Resultat : T_Tab;
    
begin
    Enregistrer(Table,To_Unbounded_String("\$"),To_Unbounded_String("1"));
    Enregistrer(Table,To_Unbounded_String("x"),To_Unbounded_String("2"));
    Enregistrer(Table,To_Unbounded_String("y"),To_Unbounded_String("3"));
    
    Resultat := Symboles(Table);
    Put_Line("Resultat obtenu:");
    Afficher_Tableau(Resultat);
    Detruire(Table);
end Test_Symboles;
    
