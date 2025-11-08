% Fonction estim_param_Dyx_MV_2droites (exercice_2.m) 

function [a_Dyx_1,b_Dyx_1,a_Dyx_2,b_Dyx_2] = ... 
         estim_param_Dyx_MV_2droites(x_donnees_bruitees,y_donnees_bruitees,sigma, ...
                                     tirages_G_1,tirages_psi_1,tirages_G_2,tirages_psi_2)    
    x = x_donnees_bruitees;
    y = y_donnees_bruitees;
    n = length(tirages_G_1);
    expression = zeros(n,n);
    for i = 1:n
        for j= 1:n
            for k = 1:length(x)
                r_1 = (y(k)- tirages_G_1(i,2))- tan(tirages_psi_1(j))*(x(k)- tirages_G_1(i,1));
                r_2 = (y(k)- tirages_G_2(i,2))- tan(tirages_psi_2(j))*(x(k)- tirages_G_2(i,1));
                expression(i,j) = expression(i,j) + log(exp((-r_1^2)/2*sigma^2)+exp((-r_2^2)/2*sigma^2));
            end
        end
    end
    [A,I] = max(expression);
    [~,J] = max(A);
    G_1 = tirages_G_1(I(J),:);
    G_2 = tirages_G_2(I(J),:);
    psi_1 = tirages_psi_1(I(J));
    psi_2 = tirages_psi_2(I(J));
    a_Dyx_1 = tan(psi_1);
    b_Dyx_1 =  G_1(2) - a_Dyx_1 * G_1(1);
    a_Dyx_2 = tan(psi_2);
    b_Dyx_2 = G_2(2) - a_Dyx_2 * G_2(1);

end