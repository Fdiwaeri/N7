% Fonction RANSAC_3points (exercice_3)

function [C_estime,R_estime] = RANSAC_3points(x_donnees_bruitees,y_donnees_bruitees,parametres)

    % Parametres de l'algorithme RANSAC :
    S_ecart = parametres(1); % seuil pour l'ecart
    S_prop = parametres(2); % seuil pour la proportion
    k_max = parametres(3); % nombre d'iterations
    n_tirages = parametres(4); 
    n_donnees = size(x_donnees_bruitees,1);
    ecart_moyen_min = Inf;
    for J=1:k_max
        %1
        a = randi(n);
        b = randi(n);
        while a == b
            b = randi(n);
        end
        c = randi(n);
        while c == a | c == b
            c = randi(n);
        end
        %2
        x_new = [x_donnees_bruitees(a); x_donnees_bruitees(b); x_donnees_bruitees(c)];
        y_new = [y_donnees_bruitees(a); y_donnees_bruitees(b); y_donnees_bruitees(c)];
        m=0;
        [C_3p,R_3p] = estim_param_cercle_3points(x_new,y_new);
        %3
   
        for i=1:n_donnees
            if abs(rho(i) - rho_F_temp*cos(theta(i)-theta_F_temp)) < S_ecart
                m = m+1;
                donnees_conformes(m,:)= [rho(i), theta(i)];
            end
        end
        rho_m = donnees_conformes(:,1);
        theta_m = donnees_conformes(:,2);
        %4
        if m/n > S_prop
            [C_estime_temp,R_estime_temp,ecart_moyen] = ...
         estimation_C_et_R(x_donnees_bruitees,y_donnees_bruitees,tirages_C,tirages_R)
            [rho_F_temp,theta_F_temp,ecart_moyen] = estim_param_F(rho_m,theta_m);
            if ecart_moyen < ecart_moyen_min
                ecart_moyen_min = ecart_moyen;
                rho_F_estime = rho_F_temp;
                theta_F_estime = theta_F_temp;
            end
        end
    end
end
end