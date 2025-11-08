% Fonction estim_param_Dorth_MC (exercice_4.m)

function [theta_Dorth,rho_Dorth] = ...
                 estim_param_Dorth_MC(x_donnees_bruitees,y_donnees_bruitees)

    x = x_donnees_bruitees;
    y = y_donnees_bruitees;
    [x_G, y_G, x_c, y_c] = centrage_des_donnees(x,y);
    C = [x_c' ; y_c']';
    [V,D] = eig(C' * C);
    lambda = diag(D);
    [~,I] = min(lambda);
    Y = V(:,I);
    tan_theta = Y(2)/Y(1);
    theta_Dorth = atan(tan_theta);
    rho_Dorth = x_G*cos(theta_Dorth) + y_G*sin(theta_Dorth);
    

end