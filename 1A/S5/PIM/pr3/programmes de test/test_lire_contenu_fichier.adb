with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with Ada.Streams;
with Ada.Streams.Stream_IO; use Ada.Streams.Stream_IO;

procedure Test_Lire_Contenu_Fichier is

    -- Définir les types
    type T_Octet is mod 2 ** 8;	-- sur 8 bits
    for T_Octet'Size use 8;
    
    type T_Liste_Caracteres is array (0 .. 256) of Unbounded_String;

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
    
    -- Déclaration des variables et des constantes.
    Nom_Fichier : Constant String := "test.txt.hff";
    Tableau_Caracteres : T_Liste_Caracteres;
    Nombre_Caracteres : Integer := 1;
    Contenu : Unbounded_String := To_Unbounded_String("");
begin
    -- Lire le fichier compressé.
    Lire_Contenu_Fichier(Nom_Fichier, Tableau_Caracteres, Nombre_Caracteres, Contenu);
    Put_Line("Le nombre des caractères: " & Integer'Image(Nombre_Caracteres));
    Put_Line("La liste des caractères:");
    for I in 1 .. Nombre_Caracteres loop
        Put_Line(To_String(Tableau_Caracteres(I)));
    end loop;
    Put("Le reste du contenu du fichier compressé en binaire:");
    Put(To_String(Contenu));
end Test_Lire_Contenu_Fichier;
