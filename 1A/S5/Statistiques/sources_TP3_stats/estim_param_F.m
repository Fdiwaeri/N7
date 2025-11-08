% Fonction estim_param_F (exercice_1.m)

function [rho_F,theta_F,ecart_moyen] = estim_param_F(rho,theta)

    A = [cos(theta), sin(theta)];
    B = rho;
    beta = inv(A'*A) * A'* B;
    x_F = beta(1);
    y_F = beta(2);
    rho_F = sqrt(x_F^2 + y_F^2);
    theta_F = atan2(y_F,x_F);
    n = length(rho);
    ecart_moyen = 0;
    for I=1:n
        ecart_moyen = ecart_moyen + (1/n) * abs(rho(I) - rho_F*cos(theta(I)-theta_F));
    end
  
end