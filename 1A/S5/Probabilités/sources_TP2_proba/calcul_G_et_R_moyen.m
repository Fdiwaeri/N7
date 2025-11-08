% Fonction calcul_G_et_R_moyen (exercice_1.m)

function [G, R_moyen, distances] = calcul_G_et_R_moyen(x_donnees_bruitees,y_donnees_bruitees)

    xG= mean(x_donnees_bruitees);
    yG= mean(y_donnees_bruitees);
    G = [xG; yG];
    distances = [sqrt(((x_donnees_bruitees - xG).^2) + ((y_donnees_bruitees - yG).^2))];
    R_moyen = mean(distances);

end