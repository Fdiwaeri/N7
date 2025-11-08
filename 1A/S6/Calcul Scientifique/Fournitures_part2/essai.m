%%  Application de la SVD : compression d'images

clear all
close all

% Lecture de l'image
I = imread('BD_Spirou_2.jpg');
I = rgb2gray(I);
I = double(I);

[q, p] = size(I)

% Décomposition par SVD
fprintf('Décomposition en valeurs singulières\n')
tic
[U, S, V] = svd(I);
toc

l = min(p,q);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% On choisit de ne considérer que 200 vecteurs
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% 200 vecteurs utilisés pour la reconstruction et on affiche l'image tous les 40 vecteurs (pas)
inter = 1:40:(200+40);
inter(end) = 200;

% vecteur pour stocker la différence entre l'image et l'image reconstruite

differenceSVD = zeros(size(inter,2), 1);

% images reconstruites en utilisant de 1 à 200 vecteurs
ti = 0;
td = 0;
for k = inter

    % Calcul de l'image de rang k
    Im_k = U(:, 1:k)*S(1:k, 1:k)*V(:, 1:k)';

    % Affichage de l'image reconstruite
    ti = ti+1;
    figure(ti)
    colormap('gray')
    imagesc(Im_k), axis equal
    
    % Calcul de la différence entre les 2 images (RMSE : Root Mean Square Error)
    td = td + 1;
    differenceSVD(td) = sqrt(sum(sum((I-Im_k).^2)));
    pause
end

% Figure des différences entre l'image réelle et les images reconstruites
ti = ti+1;
figure(ti)
hold on 
plot(inter, differenceSVD, 'rx')
ylabel('RMSE')
xlabel('rank k')
pause


% Plugger les différentes méthodes : eig, puissance itérée et les 4 versions de la "subspace iteration method" 

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% QUELQUES VALEURS PAR DÉFAUT DE PARAMÈTRES, 
% VALEURS QUE VOUS DEVEZ FAIRE ÉVOLUER
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% tolérance
eps = 1e-8;
% nombre d'itérations max pour atteindre la convergence
maxit = 10000;

% taille de l'espace de recherche (m)
search_space = 400;

% pourcentage que l'on se fixe
percentage = 0.99;

% p pour les versions 2 et 3 (attention p déjà utilisé comme taille)
puiss = 1;

%%%%%%%%%%%%%
% À COMPLÉTER
%%%%%%%%%%%%%
% Question 1 : What happens when q < p?
% On détermine la matrice à utiliser selon les dimensions de l'image
if q > p
    % Si l'image est plus haute que large, on utilise I'*I
    M = I' * I;
    portrait = true;
else
    % Si l'image est plus large que haute (ou carrée), on utilise I*I'
    M = I * I';
    portrait = false; % image paysage
end
% On affiche la taille de la matrice
fprintf('Taille de la matrice M : %d x %d\n', size(M))

% Question 2 : Using 6 different functions that compute the eigenpairs 
% of a matrix
%% Méthode 2: Power Method
fprintf('\nMéthode 2: Power Method avec deflation\n')
%%
% calcul des couples propres
%%
tic
% Calcul des k plus grandes valeurs propres et vecteurs propres
k_max = max(inter);

% Solution plus simple: Implémentation directe de la méthode de la puissance
lambda_power = zeros(k_max, 1);
V_power = zeros(size(M, 1), k_max);

M_deflated = M;
for i = 1:k_max
    % Initialisation avec un vecteur aléatoire
    v = randn(size(M_deflated, 1), 1);
    v = v / norm(v);
    
    % Méthode de la puissance itérée
    converged = false;
    iter = 0;
    
    while ~converged && iter < maxit
        % Multiplication par la matrice
        w = M_deflated * v;
        
        % Calcul de la valeur propre estimée (quotient de Rayleigh)
        lambda = v' * w;
        
        % Normalisation du nouveau vecteur
        w_norm = norm(w);
        if w_norm < eps
            % Si le vecteur devient nul, on en choisit un nouveau
            v = randn(size(M_deflated, 1), 1);
            v = v / norm(v);
        else
            % Nouveau vecteur normalisé
            new_v = w / w_norm;
            
            % Test de convergence: différence entre les vecteurs
            if norm(new_v - v) < eps || norm(new_v + v) < eps
                converged = true;
            end
            
            v = new_v;
        end
        
        iter = iter + 1;
    end
    
    % Stockage des résultats
    lambda_power(i) = lambda;
    V_power(:, i) = v;
    
    % Déflation
    M_deflated = M_deflated - lambda * (v * v');
    
    fprintf('Valeur propre %d: %f (convergence en %d itérations)\n', i, lambda, iter);
end
%%
% calcul des valeurs singulières
%%
sigma_power = sqrt(abs(lambda_power)); % Prendre la valeur absolue pour éviter des problèmes avec valeurs propres négatives
%%
% calcul de l'autre ensemble de vecteurs
%%
% Les vecteurs singuliers
if portrait
    % M = I'*I, donc V_power contient V
    % On calcule U à partir de V selon l'équation (1)
    U_power = zeros(q, length(sigma_power));
    for i = 1:length(sigma_power)
        if sigma_power(i) > eps
            U_power(:, i) = (I * V_power(:, i)) / sigma_power(i);
        end
    end
else
    % M = I*I', donc V_power contient U
    U_power = V_power;
    % On calcule V à partir de U selon l'équation (1)
    V_power = zeros(p, length(sigma_power));
    for i = 1:length(sigma_power)
        if sigma_power(i) > eps
            V_power(:, i) = (I' * U_power(:, i)) / sigma_power(i);
        end
    end
end
toc
%%
% calcul des meilleures approximations de rang faible
%%
diff_power = zeros(size(inter, 2), 1);
fprintf('Reconstruction avec power method\n')
td = 0;
for idx = 1:length(inter)
    k = inter(idx);
    % Calcul de l'image de rang k
    Im_k_power = zeros(q, p);
    for i = 1:k
        Im_k_power = Im_k_power + sigma_power(i) * U_power(:, i) * V_power(:, i)';
    end

    % Affichage de l'image reconstruite
    ti = ti+1;
    figure(ti)
    colormap('gray');
    imagesc(Im_k_power), axis equal
    
    % Calcul de la différence entre les 2 images (RMSE : Root Mean Square Error)
    td = td + 1;
    diff_power(td) = sqrt(sum(sum((I-Im_k_power).^2)));
    pause
end

% Figure des différences entre l'image réelle et les images reconstruites
ti = ti+1;
figure(ti)
hold on
plot(inter, diff_power, 'go-') %courbe en vert avec des o
title('RMSE - Power method') % affichage du titre pour indiquer la méthode utilisée
ylabel('RMSE')
xlabel('rank k')
pause