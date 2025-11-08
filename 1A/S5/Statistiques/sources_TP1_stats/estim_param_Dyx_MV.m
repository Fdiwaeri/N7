% Fonction estim_param_Dyx_MV (exercice_1.m)

function [a_Dyx,b_Dyx,residus_Dyx] = ...
           estim_param_Dyx_MV(x_donnees_bruitees,y_donnees_bruitees,tirages_psi)
    [x_G,y_G, x, y] = centrage_des_donnees(x_donnees_bruitees,y_donnees_bruitees);
    for i = 1:length(tirages_psi)
        expression(i) = norm(y - tan(tirages_psi(i))*x)^2;
    end
    [~,I] = min(expression);
    psi_min = tirages_psi(I);
    a_Dyx = tan(psi_min);
    b_Dyx = y_G - a_Dyx * x_G;
    residus_Dyx = y - a_Dyx * x;

    
end