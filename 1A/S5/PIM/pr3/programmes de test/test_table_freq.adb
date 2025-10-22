with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with SDA_Exceptions; 
with LCA;


procedure Calculer is
    package LCA_UStr_Int is new LCA (T_Cle => Unbounded_String, T_Valeur => Integer);
        use LCA_UStr_Int;
        
    procedure Afficher_Cl(Cle : in Unbounded_String) is 
    begin
        Put(To_String(Cle));
    end Afficher_Cl;
    procedure Afficher_Val(Valeur : in Integer) is 
    begin
        Put(Valeur);
    end Afficher_Val;
    procedure Afficher is new Afficher_Debug(Afficher_Cle => Afficher_Cl , Afficher_Valeur => Afficher_Val);

    procedure Construire_Table_De_Frequences(Texte: in Unbounded_String;Table_Frequences : out LCA_UStr_Int.T_LCA) is
       
        Texte_fixe : Constant String := To_String(Texte);
    begin
        Initialiser(Table_Frequences);
        for i in Texte_fixe'range loop
            if not Cle_Presente(Table_Frequences, To_Unbounded_String(Character'Image(Texte_fixe(i)))) then 
                Enregistrer(Table_Frequences,To_Unbounded_String(Character'Image(Texte_fixe(i))),1);
            else 
                Enregistrer(Table_Frequences,To_Unbounded_String(Character'Image(Texte_fixe(i))),La_Valeur(Table_Frequences,To_Unbounded_String(Character'Image(Texte_fixe(i))))+1);
            end if;
         end loop;
         
         Enregistrer(Table_Frequences,To_Unbounded_String("\$"),0);
         
    end Construire_Table_De_Frequences;
    Texte : Unbounded_String;
    
    Table_Frequences : LCA_UStr_Int.T_LCA;
begin
    Texte := To_Unbounded_String("Je m'appelle Aya");
    Construire_Table_De_Frequences(Texte,Table_Frequences);
    Afficher(Table_Frequences);
end Calculer;
