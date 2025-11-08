% Fonction estim_param_Dyx_MC2 (exercice_2bis.m)

function [a_Dyx,b_Dyx,coeff_r2] = ...
                   estim_param_Dyx_MC2(x_donnees_bruitees,y_donnees_bruitees)
    x = x_donnees_bruitees;
    y = y_donnees_bruitees;
    r = cov(x, y)/sqrt(var(x)*var(y));
    a_Dyx = r*sqrt(var(y)/var(x));
    b_Dyx = mean(y) - a_Dyx * mean(x);
    coeff_r2 = r^2;

end