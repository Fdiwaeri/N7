% Fonction tirages_aleatoires (exercice_2.m)

function [tirages_C,tirages_R] = tirages_aleatoires_uniformes(n_tirages,G,R_moyen)
    
    tirages_C= R_moyen*((rand(2,n_tirages)*2)-1);
    G_2= [G,G];
    tirages_C = tirages_C + G_2;
    tirages_R = 0;

end