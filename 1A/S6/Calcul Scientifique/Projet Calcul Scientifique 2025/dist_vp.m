%%test_Q14
%Affichage du spectre des 4 types de matrices générées par matgen_csad


% Affiche pour chaque type de matrice la distribution des valeurs propres
% pour plusieurs tailles (n = 50, 100, 150, 200)

clear;
close all;

n_values = [50, 100, 150, 200];  % différentes tailles à tester
nb_types = 4;
colors = lines(length(n_values));  % couleurs pour les tailles

for imat = 1:nb_types
    figure;
    hold on;

    for i = 1:length(n_values)
        n = n_values(i);
        [A, ~, ~] = matgen_csad(imat, n);
        eigvals = sort(eig(A), 'descend');  % tri des valeurs propres

        plot(1:n, eigvals, '-o', 'LineWidth', 1.5, ...
            'DisplayName', ['n = ', num2str(n)], ...
            'Color', colors(i,:));
    end

    title(['Distribution des valeurs propres - Matrice type ', num2str(imat)]);
    xlabel('Indice de la valeur propre');
    ylabel('Valeur propre');
    legend show;
    grid on;
    hold off;
end