with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;

procedure Lire is

    procedure Lire_Contenu_Fichier (Nom_Fichier : in String; Texte : out Unbounded_String) is
            Fichier   : Ada.Text_IO.File_Type;
            Caractere : Character;
            
        begin
            Texte := To_Unbounded_String("");  -- Initialisation
            Ada.Text_IO.Open (File => Fichier, Mode => Ada.Text_IO.In_File, Name => Nom_Fichier);

            while not Ada.Text_IO.End_Of_File(Fichier) loop
                Ada.Text_IO.Get(File => Fichier, Item => Caractere);
                Texte := Texte & To_Unbounded_String(Character'Image(Caractere));
            end loop;

            Ada.Text_IO.Close(Fichier);
        end Lire_Contenu_Fichier;
   Texte : Unbounded_String;
begin    
    Lire_Contenu_Fichier("texte.txt",Texte);
   Put(To_String(Texte));
end Lire;
