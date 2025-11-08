% Fonction probabilites_classe (exercice_3.m)

function [probas_classe_1,probas_classe_2] = probabilites_classe(x_donnees_bruitees,y_donnees_bruitees,sigma,...
                                                                 a_1,b_1,proportion_1,a_2,b_2,proportion_2)
    x = x_donnees_bruitees;
    y = y_donnees_bruitees;
    n = length(x);
    r_1 = y - a_1*x - b_1*ones(n,1);
    r_2 = y - a_2*x - b_2*ones(n,1);
    sum = proportion_1*exp(-(r_1.^2)/(2*sigma^2)) + proportion_2*exp(-(r_2.^2)/(2*sigma^2));
    probas_classe_1 = (proportion_1*exp(-(r_1.^2)/(2*sigma^2)))/sum;
    probas_classe_2 = (proportion_2*exp(-(r_2.^2)/(2*sigma^2)))/sum;


end