with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with ABR;      
with LCA;
with Ada.Command_Line;use Ada.Command_Line;
with Ada.Streams.Stream_IO;use Ada.Streams.Stream_IO;
with Ada.Streams;
with Ada.Characters.Latin_1;

procedure Compresser is
-- Compresser le fichier texte .txt.

    type T_Octet is mod 2 ** 8;	-- sur 8 bits
    for T_Octet'Size use 8;

    -- Instancier les modules.
    package LCA_UStr_Int is new LCA(T_Cle => Unbounded_String, T_Valeur => Integer);
    use LCA_UStr_Int;

    package ABR_UStr_Int is new ABR (T_Symbole => Unbounded_String, T_Frequence => Integer);
    use ABR_UStr_Int;

    package LCA_UStr_UStr is new LCA(T_Cle => Unbounded_String, T_Valeur => Unbounded_String);
    use LCA_UStr_UStr;
   
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    procedure Construire_Table_De_Frequences(Nom_Fichier: in Unbounded_String;Table_Frequences : out LCA_UStr_Int.T_LCA) is
        Fichier : Ada.Text_IO.File_Type;
        C : Character;
        UStr : Unbounded_String;
        
    begin
        Ada.Text_IO.Open(File => Fichier , Mode => Ada.Text_IO.In_File , Name => To_String(Nom_Fichier));
        LCA_UStr_Int.Initialiser(Table_Frequences);
        while not Ada.Text_IO.End_Of_File(Fichier) loop
            Ada.Text_IO.Get(Fichier,C);
            if End_Of_Line(Fichier) then
                UStr := To_Unbounded_String(Character'Image(C));
                if LCA_UStr_Int.Cle_Presente(Table_Frequences, UStr) then 
                    LCA_UStr_Int.Enregistrer(Table_Frequences, UStr, La_Valeur(Table_Frequences, UStr) + 1);
                else 
                    LCA_UStr_Int.Enregistrer(Table_Frequences, UStr, 1);
                end if;
                
                UStr := To_Unbounded_String("\n");
                if LCA_UStr_Int.Cle_Presente(Table_Frequences, UStr) then 
                    LCA_UStr_Int.Enregistrer(Table_Frequences, UStr, La_Valeur(Table_Frequences,UStr)+1);
                else 
                    LCA_UStr_Int.Enregistrer(Table_Frequences, UStr, 1);
                end if;
                Skip_Line(Fichier);             -- Pour passer à la ligne suivante
            else
                UStr := To_Unbounded_String(Character'Image(C));
                if LCA_UStr_Int.Cle_Presente(Table_Frequences, UStr) then 
                    LCA_UStr_Int.Enregistrer(Table_Frequences, UStr, La_Valeur(Table_Frequences, UStr) + 1);
                else 
                    LCA_UStr_Int.Enregistrer(Table_Frequences, UStr, 1);
                end if;
            end if;
         end loop;
         Ada.Text_IO.Close(Fichier);
         LCA_UStr_Int.Enregistrer(Table_Frequences,To_Unbounded_String("\$"),0);
         
         
    end Construire_Table_De_Frequences;
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    function Fusion(Arbre_1 : in ABR_UStr_Int.T_ABR; Arbre_2 : in ABR_UStr_Int.T_ABR) return ABR_UStr_Int.T_ABR is
            Arbre: ABR_UStr_Int.T_ABR;
    begin
        Creer_Nouveau_Noeud(Arbre, To_Unbounded_String(""),Frequence(Arbre_1) + Frequence(Arbre_2), Arbre_1,Arbre_2);
        return Arbre;
    end Fusion;

    procedure Creer_Arbre_De_Huffman(Arbre_Huffman: out ABR_UStr_Int.T_ABR; Table_Frequences :in LCA_UStr_Int.T_LCA) is
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
            Arbre_Nul: ABR_UStr_Int.T_ABR;
            begin
                Initialiser(Arbre_Nul);
                for C in Character range Character'First..Character'Last loop
                    if C = Ada.Characters.Latin_1.LF then
                        if Cle_Presente(Table_Frequences, To_Unbounded_String("\n")) then
                            Nombre_Noeuds := Nombre_Noeuds + 1;
                            Creer_Nouveau_Noeud(Liste_Noeuds(Nombre_Noeuds), To_Unbounded_String("\n"), La_Valeur(Table_Frequences, To_Unbounded_String("\n")), Arbre_Nul, Arbre_Nul);     
                        end if;
                    else
                        if Cle_Presente(Table_Frequences, To_Unbounded_String(Character'Image(C))) then
                            Nombre_Noeuds := Nombre_Noeuds + 1;
                            Creer_Nouveau_Noeud(Liste_Noeuds(Nombre_Noeuds), To_Unbounded_String(Character'Image(C)), La_Valeur(Table_Frequences, To_Unbounded_String(Character'Image(C))), Arbre_Nul, Arbre_Nul);     
                        end if;
                    end if;
                end loop;
            end Construire_Feuilles;
            
            Arbre_Temporaire : ABR_UStr_Int.T_ABR;
            Arbre_Null: ABR_UStr_Int.T_ABR;
    begin
        Initialiser(Arbre_Null);
        Construire_Feuilles(Table_Frequences, Liste_Noeuds, Nombre_Noeuds);
        Nombre_Noeuds := Nombre_Noeuds + 1;
        Creer_Nouveau_Noeud(Liste_Noeuds(Nombre_Noeuds), To_Unbounded_String("\$"), 0, Arbre_Null, Arbre_Null);
        while Nombre_Noeuds > 1 loop
            Trier_Noeuds(Liste_Noeuds, Nombre_Noeuds);
            Remplacer(Fusion(Liste_Noeuds(1),Liste_Noeuds(2)), Arbre_Temporaire);
            for I in 3..Nombre_Noeuds loop
                Liste_Noeuds(I-2) := Liste_Noeuds(I);
            end loop;
            Nombre_Noeuds := Nombre_Noeuds -1;
            Remplacer(Arbre_Temporaire,Liste_Noeuds(Nombre_Noeuds));
        end loop;
        Remplacer(Liste_Noeuds(1), Arbre_Huffman);
    end Creer_Arbre_De_Huffman;
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                
    procedure Table_De_Huffman(Arbre_Huffman : in ABR_UStr_Int.T_ABR; Table_Huffman : in out LCA_UStr_UStr.T_LCA) is
        procedure Generer_Codes(Arbre : in ABR_UStr_Int.T_ABR; Code: in Unbounded_String; Table: in out LCA_UStr_UStr.T_LCA) is
            Code_G, Code_D : Unbounded_String;
        begin
            if not (Est_Vide(Arbre)) then
                if Est_Feuille(Arbre) then
                    Enregistrer(Table, Symbole(Arbre), Code);
                else
                    Code_G := Code & To_Unbounded_String("0");
                    Generer_Codes(Gauche(Arbre), Code_G, Table);
                    Code_D := Code & To_Unbounded_String("1");
                    Generer_Codes(Droit(Arbre), Code_D, Table);
                end if;
            end if;
        end Generer_Codes;

    begin
        Initialiser(Table_Huffman);
        Generer_Codes(Arbre_Huffman, Null_Unbounded_String, Table_Huffman);
    end Table_De_Huffman;
    
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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
------------------------------------------------------------------------------------------------------------------------------------------------------
    procedure Ecrire_Structure_Arbre(Arbre : in T_ABR; Structure : out Unbounded_String) is
        
    begin
        if not Est_Vide(Arbre) then
            if Est_Feuille(Arbre) then
                Structure := Structure & "1";
            else
                Structure := Structure & "0";
                Ecrire_Structure_Arbre(Gauche(Arbre),Structure);
                Ecrire_Structure_Arbre(Droit(Arbre),Structure);
            end if;
        end if;
    end Ecrire_Structure_Arbre;
-----------------------------------------------------------------------------------------------------------------------------------------------------
    procedure Encoder_Texte(Nom_Fichier : in String; Table_Huffman : in LCA_UStr_UStr.T_LCA; Arbre_Huffman : in ABR_UStr_Int.T_ABR) is
        Fichier_Entree : Ada.Text_IO.File_Type; 
        S : Stream_Access;
        Bit_Courant : T_Octet := 0;
        Indice_Bit : Natural := 0;
        Caractere_Courant : Character;
        Liste_Symboles : T_Tab;
        Code : Unbounded_String;
        Fichier_Compresse : Ada.Streams.Stream_IO.File_Type;
        Structure : Unbounded_String;
      

        function Le_Code(Caractere : Character) return Unbounded_String is
            Car_UStr : Unbounded_String;
        begin
            Car_UStr := To_Unbounded_String(Character'Image(Caractere));
            if Cle_Presente(Table_Huffman, Car_UStr) then
                return La_Valeur(Table_Huffman, Car_UStr);
            else
                return Null_Unbounded_String;
            end if;
        end Le_Code;
          
    begin
        -- Ouvrir les fichiers.
        Ada.Text_IO.Open(Fichier_Entree, Ada.Text_IO.In_File, Nom_Fichier);
        Ada.Streams.Stream_IO.Create(Fichier_Compresse, Ada.Streams.Stream_IO.Out_File, Nom_Fichier & ".hff");
        S := Stream(Fichier_Compresse);
        Liste_Symboles := Symboles(Table_Huffman);
        
        --Ecriture des codes ASCII dans le fichier compressé
        for I in 0..Taille(Table_Huffman)+1 loop
            T_Octet'Write(S,T_Octet(Liste_Symboles(I)));
        end loop;

        --Ecriture de la structure de l'arbre dans le fichier compressé
        Ecrire_Structure_Arbre(Arbre_Huffman, Structure);
        for I in 1..Length(Structure) loop
            if Element(Structure,I) = '1' then
                Bit_Courant := (Bit_Courant * 2) or 1;
            else
                Bit_Courant := (Bit_Courant * 2);
            end if;
            Indice_Bit := Indice_Bit + 1;

            if Indice_Bit = 8 then
            T_Octet'Write(S,Bit_Courant);
            Bit_Courant := 0;
            Indice_Bit := 0;
            end if;
        end loop;
        
        --Ecrire le code de chaque caractère du texte d'origine dans le fichier compressé
        while not Ada.Text_IO.End_Of_File(Fichier_Entree) loop
            Ada.Text_IO.Get(Fichier_Entree, Caractere_Courant);

            if Caractere_Courant = ASCII.LF then
                if Cle_Presente(Table_Huffman, To_Unbounded_String("\n")) then
                   Code := La_Valeur(Table_Huffman, To_Unbounded_String("\n"));
                end if;
            else
                Code := Le_Code(Caractere_Courant);
            end if;

            for I in 1..Length(Code) loop
                if Element(Code, I) = '1' then
                    Bit_Courant := (Bit_Courant * 2) or 1;
                else
                    Bit_Courant := (Bit_Courant * 2);
                end if;
                Indice_Bit := Indice_Bit + 1;
                if Indice_Bit = 8 then
                    T_Octet'Write(S, Bit_Courant);
                    Bit_Courant := 0;
                    Indice_Bit := 0;
                end if;
            end loop;
        end loop;

     
        if Cle_Presente(Table_Huffman, To_Unbounded_String("\$")) then
            Code := La_Valeur(Table_Huffman, To_Unbounded_String("\$"));
      
            for I in 1..Length(Code) loop
                if Element(Code, I) = '1' then
                    Bit_Courant := (Bit_Courant * 2) or 1;
                else
                    Bit_Courant := (Bit_Courant * 2);
                end if;
                Indice_Bit := Indice_Bit + 1;

                if Indice_Bit = 8 then
                    T_Octet'Write(S, Bit_Courant);
                    Bit_Courant := 0;
                    Indice_Bit := 0;
                end if;
            end loop;
        end if;


        if Indice_Bit > 0 then
            while Indice_Bit < 8 loop
                Bit_Courant := Bit_Courant * 2;
                Indice_Bit := Indice_Bit + 1;
            end loop;
            T_Octet'Write(S,Bit_Courant);
        end if;

      -- Fermer les fichiers.
        Ada.Text_IO.Close(Fichier_Entree);
        Ada.Streams.Stream_IO.Close(Fichier_Compresse);
    end Encoder_Texte;
        
        
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    procedure Afficher_Cle(Cle : in Unbounded_String) is 
    begin
        if Cle = To_Unbounded_String("\$") or Cle = To_Unbounded_String("\n") then
            Put("'");
            Put(To_String(Cle));
            Put("'");
        else
            Put(To_String(Cle));
        end if;
    end Afficher_Cle;
    procedure Afficher_Valeur(Valeur : in Unbounded_String) is 
    begin
        Put(To_String(Valeur));
    end Afficher_Valeur;
    procedure Afficher_Table is new LCA_UStr_UStr.Afficher_Debug(Afficher_Cle => Afficher_Cle, Afficher_Valeur => Afficher_Valeur);

    
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------    
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

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    -- Déclaration des variables.
    Nombre_Argument : Integer := Ada.Command_Line.Argument_Count;
    Option : String (1 .. 2) := "-b";
    Nom_Fichier : Unbounded_String;
    Table_Frequences : LCA_UStr_Int.T_LCA;
    Arbre_Huffman : T_ABR;
    Table_Huffman : LCA_UStr_UStr.T_LCA;
    Structure : Unbounded_String; 
    FALSE_ARGUMENT : exception;
    UNKNOWN_ARGUMENT : exception;
    
   
begin

   Nombre_Argument := Argument_Count;
   if Nombre_Argument = 0 or Nombre_Argument > 2 then
      raise  FALSE_ARGUMENT;
   elsif Nombre_Argument = 1 then
        Nom_Fichier := To_Unbounded_String(Argument(1));
   else
         if Argument(1) = "-b" then
            Option := "-b";
            New_Line;
            Nom_Fichier := To_Unbounded_String(Argument(2));
         elsif Argument(1) = "-s" then
            Option := "-s";
            Nom_Fichier := To_Unbounded_String(Argument(2));
          else
            raise UNKNOWN_ARGUMENT;
         end if;
    end if;
   
   
    -- Construire le tableau de fréquences des symboles du texte.
    Construire_Table_De_Frequences(Nom_Fichier, Table_Frequences);
      
    
    

    -- Construire l’arbre de Huffman.
    Creer_Arbre_De_Huffman(Arbre_Huffman, Table_Frequences);

    -- Construire la table de Huffman.
    Table_De_Huffman(Arbre_Huffman, Table_Huffman);
    
    --Construire le fichier compressé
    Encoder_Texte(To_String(Nom_Fichier),Table_Huffman,Arbre_Huffman);
    
    --Obtenir la structure de l'arbre de Huffman
    Ecrire_Structure_Arbre(Arbre_Huffman, Structure);


    -- Afficher la trace des principales opérations du codage de Huffman.
    if Option = "-b" then
        Put_Line("Affichage de l'arbre de Huffman:");
        Afficher_Arbre(Arbre_Huffman, 0);
        New_Line;
        Put_Line("Affichage de la table de Huffman");
        Afficher_Table(Table_Huffman);
    end if;
    Detruire(Table_Frequences);
    Detruire(Arbre_Huffman);
    Detruire(Table_Huffman);
  
exception
   when Ada.Text_IO.Name_Error =>
      Put_Line("Erreur : fichier non trouvé");
   when COMPRESSER.FALSE_ARGUMENT =>
      Put_Line("Il faut entrer" & Command_Name & " [-b|-s] <fichier>"); 
   when UNKNOWN_ARGUMENT =>
      Put_Line("Option invalide.");
   when others => 
      Put_Line("Erreur de compression");
   


end Compresser;

