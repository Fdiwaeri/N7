
with Ada.Streams.Stream_IO; use Ada.Streams.Stream_IO;
with Ada.Text_IO; use Ada.Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;


with LCA;





procedure test_encoder is
    type T_Octet is mod 2 ** 8;	-- sur 8 bits
    for T_Octet'Size use 8;
    

        package LCA_UStr_UStr is new LCA(T_Cle => Unbounded_String, T_Valeur => Unbounded_String);
        use LCA_UStr_UStr;
            
    procedure Encoder_Texte(Nom_Fichier : in String ; Table_Huffman : in LCA_UStr_UStr.T_LCA) is 
            function Le_Code(Table : in LCA_UStr_UStr.T_LCA;Symbole : in Unbounded_String) return Unbounded_String is
            begin
                if Cle_Presente(Table,Symbole) then 
                    return La_Valeur(Table,Symbole);
                else 
                    return Null_Unbounded_String;
                end if;
            end Le_Code;
            
            Fichier_Entree : Ada.Text_IO.File_Type;
            Fichier_Compresse : Ada.Streams.Stream_IO.File_Type;
            
            --Une mémoire pour convertir une chaine binaire en T_Octet
            Memoire_Bit : String(1..8) := (others => '0');
            Indice_Bit : Integer := 0;
            
            Code : Unbounded_String;
            Caractere_Courant : Character;
            St : Stream_Access;
            
            function Binaire_En_Octet(Binaire : String) return T_Octet is
                Bit_Courant : T_Octet := 0;
            begin 
                for I in Binaire'Range loop
                    if Binaire(I) = '1' then
                        Bit_Courant := (Bit_Courant * 2) or 1;
                    else 
                        Bit_Courant := (Bit_Courant * 2);
                    end if;
                end loop;
                return Bit_Courant;
            end Binaire_En_Octet;
        begin
            St := Stream(Fichier_Compresse);
            --Ouvrir le fichier d'entrée
            Ada.Text_IO.Open(File => Fichier_Entree, Mode => Ada.Text_IO.In_File, Name => Nom_Fichier);
            --Créer le fichier compressé en binaire
            Ada.Streams.Stream_IO.Create(File => Fichier_Compresse, Mode => Ada.Streams.Stream_IO.Out_File, Name => Nom_Fichier & ".hff"); 
            while not Ada.Text_IO.End_Of_File(Fichier_Entree) loop
                Ada.Text_IO.Get(Fichier_Entree, Caractere_Courant);
                if Caractere_Courant = ASCII.LF then
                    if Cle_Presente(Table_Huffman, To_Unbounded_String("\n")) then
                        Code := La_Valeur(Table_Huffman, To_Unbounded_String("\n"));
                    end if;
                else
                    Code := Le_Code(Table_Huffman,To_Unbounded_String(Character'Image(Caractere_Courant)));
                end if;
                
                for J in To_String(Code)'Range loop
                    Indice_Bit := Indice_Bit+1;
                    Memoire_Bit(Indice_Bit) := To_String(Code)(J);
                    --Si la mémoire est pleine , écrire un octet
                    if Indice_Bit = 8 then
                        T_Octet'Write(St, Binaire_En_Octet(Memoire_Bit));
                        Memoire_Bit := (others => '0'); --Réinitialiser la mémoire
                        Indice_Bit := 0;
                    end if;
                end loop;
            end loop;
            
            Code := La_Valeur(Table_Huffman, To_Unbounded_String("\$"));
            
            for I in To_String(Code)'Range loop
                Memoire_Bit(Indice_Bit+1) := To_String(Code)(I);
                Indice_Bit := Indice_Bit + 1;
                if Indice_Bit = 8 then
                    T_Octet'Write(St, Binaire_En_Octet(Memoire_Bit));
                    Memoire_Bit := (others => '0');
                    Indice_Bit := 0;
                end if;
            end loop;
           
            if Indice_Bit > 0 then
                T_Octet'Write(St, Binaire_En_Octet(Memoire_Bit));
                
            end if;
            
            Ada.Text_IO.Close(Fichier_Entree);
            Ada.Streams.Stream_IO.Close(Fichier_Compresse);
        end Encoder_Texte;    
        
        Table : LCA_UStr_UStr.T_LCA;
        Fichier :  Ada.Text_IO.File_Type;
begin
        
        Enregistrer(Table,To_Unbounded_String("a"),To_Unbounded_String("011"));
        Enregistrer(Table,To_Unbounded_String("b"),To_UNbounded_String("10011"));
        Encoder_Texte("texte.txt" , Table);
end test_encoder;
