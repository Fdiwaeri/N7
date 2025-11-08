% Fonction vectorisation_par_colonne (exercice_1.m)

function [Vd,Vg] = vectorisation_par_colonne(I)

    Ig= I(:,1: end-1);
    Id= I(:,2:end);
    Vg= Ig(:);
    Vd= Id(:);

end