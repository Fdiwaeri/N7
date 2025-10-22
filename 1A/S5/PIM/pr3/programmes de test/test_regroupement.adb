with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
procedure test_regroupement is 

    function Regroupement(Texte_Code : in Unbounded_String) return Unbounded_String is 
        Texte_Compresse : Unbounded_String := To_Unbounded_String("");
        Compteur : Integer := 0;
        Texte_Code_Fixe :Constant String := To_String(Texte_Code);
    begin
        for i in Texte_Code_Fixe'range loop
            if not (Texte_Code_Fixe(i) = '.') then
                Texte_Compresse := Texte_Compresse & To_Unbounded_String(Character'Image(Texte_Code_Fixe(i)));
                Compteur := Compteur +1;
                if Compteur = 8 then 
                    Texte_Compresse := Texte_Compresse & To_Unbounded_String(".");
                    Compteur := 0;
                end if;
             end if;
         end loop;
         return Texte_Compresse;
         
    end Regroupement;
    Texte_Code : Unbounded_String;
    Texte_Compresse : Unbounded_String;
begin
    Texte_Code := To_Unbounded_String("100.01.0011.111.101.0000.010.");
    Texte_Compresse := Regroupement(Texte_Code);
    Put(To_String(Texte_Compresse));
         
end test_regroupement;            
