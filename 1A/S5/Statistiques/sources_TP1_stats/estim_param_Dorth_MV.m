% Fonction estim_param_Dorth_MV (exercice_3.m)

function [theta_Dorth,rho_Dorth] = ...
         estim_param_Dorth_MV(x_donnees_bruitees,y_donnees_bruitees,tirages_theta)
    x = x_donnees_bruitees;
    y = y_donnees_bruitees;
    [x_G, y_G, x_c, y_c] = centrage_des_donnees(x,y);
    n = length(tirages_theta);
    expression_theta = zeros(size(tirages_theta));
    for i = 1:n
        expression_theta(i) = norm(x_c*cos(tirages_theta(i)) + y_c*sin(tirages_theta(i)))^2;
    end
    [~,I] = min(expression_theta);
    theta_Dorth = tirages_theta(I);
    rho_Dorth = x_G*cos(theta_Dorth) + y_G*sin(theta_Dorth);


end