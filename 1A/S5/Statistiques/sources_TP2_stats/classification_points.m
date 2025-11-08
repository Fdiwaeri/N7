% Fonction classification_points (exercice_3.m)

function [x_classe_1,y_classe_1,x_classe_2,y_classe_2] = classification_points ...
              (x_donnees_bruitees,y_donnees_bruitees,probas_classe_1,probas_classe_2)
    x = x_donnees_bruitees;
    y = y_donnees_bruitees;
    n = length(x);
    for i =1:n
        if probas_classe_1(i)>probas_classe_2(i)
            x_classe_1 = [x_classe_1 ; x(i)];
            y_classe_1 = [y_classe_1 ; y(i)];
        else
            x_classe_2 = [x_classe_2 ; x(i)];
            y_classe_2 = [y_classe_2 ; y(i)];
        end
    end


end