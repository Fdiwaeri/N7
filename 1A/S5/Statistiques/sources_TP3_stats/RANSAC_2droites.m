% Fonction RANSAC_2droites (exercice_2.m)

function [rho_F_estime,theta_F_estime] = RANSAC_2droites(rho,theta,parametres)

    % Parametres de l'algorithme RANSAC :
    S_ecart = parametres(1); % seuil pour l'ecart
    S_prop = parametres(2); % seuil pour la proportion
    k_max = parametres(3); % nombre d'iterations
    n_donnees = length(rho);
    ecart_moyen_min = Inf;
    n = length(rho);
    for J=1:k_max
        %1
        a = randi(n);
        b = randi(n);
        while a == b
            b = randi(n);
        end
        %2
        rho_new = [rho(a); rho(b)];
        theta_new = [theta(a); theta(b)];
        m=0;
        [rho_F_temp,theta_F_temp,ecart_moyen] = estim_param_F(rho_new,theta_new);
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
            [rho_F_temp,theta_F_temp,ecart_moyen] = estim_param_F(rho_m,theta_m);
            if ecart_moyen < ecart_moyen_min
                ecart_moyen_min = ecart_moyen;
                rho_F_estime = rho_F_temp;
                theta_F_estime = theta_F_temp;
            end
        end
    end
end