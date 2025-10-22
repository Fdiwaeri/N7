with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with ABR;
with LCA;
with Ada.Command_Line;
with Ada.Streams;
with Ada.Streams.Stream_IO; use Ada.Streams.Stream_IO;
with Ada.Characters.Latin_1;

procedure Decompresser is
-- Decompresser le fichier texte .hff.


    -- Définir les types.
    type T_Octet is mod 2 ** 8;	-- sur 8 bits
    for T_Octet'Size use 8;
    
    type T_Liste_Caracteres is array (0 .. 256) of Unbounded_String;
    
    
    -- Instancier les packages.
    package LCA_UStr_UStr is new LCA(T_Cle => Unbounded_String, T_Valeur => Unbounded_String);
	use LCA_UStr_UStr;
	
    package ABR_UStr_Int is new ABR (T_Symbole => Unbounded_String, T_Frequence => Integer);
	use ABR_UStr_Int;
    
    
    -- Définir les sous-programmes.
    procedure Lire_Contenu_Fichier(Nom_Fichier : in String; Tableau_Caracteres : out T_Liste_Caracteres; Nombre_Caracteres : in out Integer; Contenu : in out Unbounded_String) is
       Fichier  : Ada.Streams.Stream_IO.File_Type;
       Stream  : Stream_Access;
       Tableau : T_Liste_Caracteres := (others => To_Unbounded_String(""));
       Octet : T_Octet;
       Octet_Precedent : T_Octet;
       Indice_Dollar : Integer;
       Caractere : Character;
       Indice : Integer := 0; -- L'indexation qu'on a définie commence par 0
       Bit : Integer;
       Continue : Boolean := True;
    begin
       -- Ouvrir le fichier en lecture
        Open(File => Fichier, Mode => Ada.Streams.Stream_IO.In_File, Name => Nom_Fichier);
        Stream := Ada.Streams.Stream_IO.Stream(Fichier);
        T_Octet'Read(Stream, Octet);
        Indice_Dollar := Natural(Octet);
        Tableau(Indice_Dollar) := To_Unbounded_String("\$");
        Octet := T_Octet'Input(Stream);
        Caractere := Character'Val(Integer(Octet)); -- Convertir l'octet en caractère
        if Tableau(Indice) = To_Unbounded_String("\$") then
            Indice := Indice + 1;
        end if;
        Tableau(Indice) := To_Unbounded_String(Character'Image(Caractere));
        Indice := Indice + 1;
        Nombre_Caracteres := Nombre_Caracteres + 1;
        Octet_Precedent := Octet;
        
        while not End_Of_File(Fichier) and Continue loop
            Octet := T_Octet'Input(Stream);
            Caractere := Character'Val(Integer(Octet)); -- Convertir chaque octet en caractère
            if Octet_Precedent /= Octet then
                if Tableau(Indice) = To_Unbounded_String("\$") then
                    Indice := Indice + 1;
                end if;
                Tableau(Indice) := To_Unbounded_String(Character'Image(Caractere));
                Indice := Indice + 1;
                Nombre_Caracteres := Nombre_Caracteres + 1;
                Octet_Precedent := Octet;
            else
                Continue := false;
            end if;
        end loop;
        
        Tableau_Caracteres := Tableau;

       -- Lire caractère par caractère le reste du contenu du fichier compressé
        while not Ada.Streams.Stream_IO.End_Of_File(Fichier) loop
            T_Octet'Read(Stream, Octet);
            -- Convertir l'octet en une chaîne binaire
            for I in 1 .. 8 loop
               Bit := Integer(Octet) / 128;
               Octet := (Octet * 2) mod 255;
               if Bit = 1 then
                  Contenu := Contenu & To_Unbounded_String("1");
               else
                  Contenu := Contenu & To_Unbounded_String("0");
               end if;
            end loop;
        end loop;

       -- Fermer le fichier
       Close(Fichier);
    end Lire_Contenu_Fichier;
    
    
    
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
    
    
    
    procedure Reconstruire_Table_Huffman(Table_Huffman : in out LCA_UStr_UStr.T_LCA; Arbre_Huffman : in ABR_UStr_Int.T_ABR) is
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
    end Reconstruire_Table_Huffman;
    
    
    
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
        
        
                
    -- Déclaration des variables et des constantes.
    Argument_Count : Constant Integer := Ada.Command_Line.Argument_Count;
    Nom_Fichier : Constant String := Ada.Command_Line.Argument (1);
    Extension : String(1 .. 4);
    Tableau_Caracteres : T_Liste_Caracteres;
    Nombre_Caracteres : Integer := 1;
    Contenu : Unbounded_String := To_Unbounded_String("");
    Liste_Caracteres : T_LCA;
    Structure_Arbre_Huffman : Unbounded_String := To_Unbounded_String("");
    Texte_Compresse : Unbounded_String := To_Unbounded_String("");
    Arbre_Huffman : T_ABR;
    Indice_Caractere : Integer := 1;
    Table_Huffman : T_LCA;
    Texte_Decompresse : Unbounded_String;
    Arbre_Nulle: T_ABR;
BEGIN
    -- Vérifier si le nombre d'arguments est valide.
    if Argument_Count /= 1 then
        Put_Line("Usage: ./decompresser <fichier>");
        return;
   	end if;
    
    Extension := Nom_Fichier(Nom_Fichier'Length - 3 .. Nom_Fichier'Last);
    -- Vérifier si le fichier a l'extension ".hff".
    if Extension /= ".hff" then
        Put_Line("Le fichier a decompresser doit avoir une extenion .hff");
        return;
   	end if;
    
    -- Lire le fichier compressé.
    Lire_Contenu_Fichier(Nom_Fichier, Tableau_Caracteres, Nombre_Caracteres, Contenu);
      
    -- Séparer le contenu du fichier .hff.
    Initialiser(Liste_Caracteres);
    Separer_Contenu(Tableau_Caracteres, Nombre_Caracteres, Contenu, Liste_Caracteres, Structure_Arbre_Huffman, Texte_Compresse);
    
    -- Reconstruire l’arbre de Huffman.
    Initialiser(Arbre_Huffman);
    Initialiser(Arbre_Nulle);
    Creer_Nouveau_Noeud(Arbre_Huffman, To_Unbounded_String(""), 0, Arbre_Nulle, Arbre_Nulle);
    Reconstruire_Arbre_Huffman(Structure_Arbre_Huffman, Liste_Caracteres, Indice_Caractere, Arbre_Huffman);

    -- Restituer le texte original à partir du texte compressé.
    -- Reconstruire la table de Huffman.
    Initialiser(Table_Huffman);
    Reconstruire_Table_Huffman(Table_Huffman, Arbre_Huffman);
    
    -- Décoder le texte compressé.
    Texte_Decompresse := Decoder_Texte(Table_Huffman, Texte_Compresse);


    -- Créer le fichier décompressé.
	-- Ouvrir un nouveau fichier .d.
    declare
        Fichier : Ada.Text_IO.File_Type;
        Fichier_Decompresse : Constant String := Nom_Fichier & ".d";
    begin
        Ada.Text_IO.Create(File => Fichier, Mode => Ada.Text_IO.Out_File, Name => Fichier_Decompresse); -- on crée ce nouveau fichier en mode écriture.
        -- Ajouter le texte décompressé.
        Ada.Text_IO.Put(Fichier, To_String(Texte_Decompresse));

        -- Fermer le fichier .d.
        Ada.Text_IO.Close(Fichier);
    end;
    
    -- Libérer les espaces mémoire.
    Detruire(Liste_Caracteres);
    Detruire(Arbre_Huffman);
    Detruire(Table_Huffman);
    Detruire(Arbre_Nulle);
end;
