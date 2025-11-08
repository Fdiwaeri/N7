% Fonction tirages_aleatoires_uniformes (exercice_1.m)

function [tirages_angles,tirages_G] = tirages_aleatoires_uniformes(n_tirages,taille)
    
    % Tirages aleatoires d'angles : moyenne = 0 / demi-repartition = pi/2
    tirages_angles= (-pi/2) + pi*rand(n_tirages,1);
    % Tirages aleatoires de points pour se trouver sur la droite (sur [-20,20])
    tirages_G = (-20) + 40*rand(n_tirages,2);

end