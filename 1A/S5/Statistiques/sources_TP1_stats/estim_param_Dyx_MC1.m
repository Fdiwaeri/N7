% Fonction estim_param_Dyx_MC1 (exercice_2.m)

function [a_Dyx,b_Dyx,coeff_R2] = ...
                   estim_param_Dyx_MC1(x_donnees_bruitees,y_donnees_bruitees)
    x = x_donnees_bruitees;
    y = y_donnees_bruitees;
    n = length(x);
    A = [x' ; ones(1,n)]';
    B = y;
    beta_Dyx = inv(A' * A) * A' * B;
    a_Dyx = beta_Dyx(1);
    b_Dyx = beta_Dyx(2);
    y_G = ones(size(y))* mean(y);
    coeff_R2 = 1 - ( (norm(y - a_Dyx*x - b_Dyx)^2)/(norm(y - y_G)^2) );
    
end