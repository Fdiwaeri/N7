% Fonction estim_param_Dyx_MC (exercice_1.m)

function [a_Dyx,b_Dyx] = ...
                   estim_param_Dyx_MC(x_donnees_bruitees,y_donnees_bruitees)
    x = x_donnees_bruitees;
    y = y_donnees_bruitees;
    n = length(x);
    A = [x' ; ones(1,n)]';
    B = y;
    beta_Dyx = inv(A' * A) * A' * B;
    a_Dyx = beta_Dyx(1);
    b_Dyx = beta_Dyx(2);

    
end