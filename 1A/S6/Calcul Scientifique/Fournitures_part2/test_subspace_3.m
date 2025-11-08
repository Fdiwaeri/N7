%%  Application de la SVD : compression d'images

clear all
close all

% Lecture de l'image
I = imread('BD_Asterix_1.png');
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

%% Méthode 6: subspace_iter_v3
fprintf('\nMéthode 6: subspace_iter_v3\n')
%%
% calcul des couples propres
%%
tic
[V_v3, W_v3, ~,~,~,~] = subspace_iter_v3(M, search_space, percentage, puiss, eps, maxit);

%%
% calcul des valeurs singulières
%%
sigma_v3 = sqrt(diag(W_v3));

%%
% calcul de l'autre ensemble de vecteurs
%%
% Les vecteurs singuliers
if portrait
    % M = I'*I, donc V_v3 contient V
    % On calcule U à partir de V selon l'équation (1)
    U_v3 = zeros(q, length(sigma_v3));
    for i = 1:length(sigma_v3)
        if sigma_v3(i) > 1e-10
            U_v3(:, i) = (I * V_v3(:, i)) / sigma_v3(i);
        end
    end
else
    % M = I*I', donc V_v3 contient U
    U_v3 = V_v3;
    % On calcule V à partir de U selon l'équation (1)
    V_v3_new = zeros(p, length(sigma_v3));
    for i = 1:length(sigma_v3)
        if sigma_v3(i) > 1e-10
            V_v3_new(:, i) = (I' * U_v3(:, i)) / sigma_v3(i);
        end
    end
    V_v3 = V_v3_new;
end
toc
%%
% calcul des meilleures approximations de rang faible
%%
diff_v3 = zeros(size(inter, 2), 1);
fprintf('Reconstruction avec subspace_iter_v3\n')
td = 0;
for k = inter
    % Calcul de l'image de rang k
    Im_k_v3 = zeros(q, p);
    for i = 1:min(k, length(sigma_v3))
        Im_k_v3 = Im_k_v3 + sigma_v3(i) * U_v3(:, i) * V_v3(:, i)';
    end
    
    % Affichage de l'image reconstruite
    ti = ti+1;
    figure(ti)
    colormap('gray')
    imagesc(Im_k_v3), axis equal
    title(sprintf('Reconstruction avec subspace_iter_v3 (rang %d)', k));
    
    % Calcul de la différence entre les 2 images (RMSE : Root Mean Square Error)
    td = td + 1;
    diff_v3(td) = sqrt(sum(sum((I-Im_k_v3).^2)));
    pause
end

% Figure des différences entre l'image réelle et les images reconstruites
ti = ti+1;
figure(ti)
hold on
plot(inter, diff_v3, 'yx') % courbe des x en jaune (yellow)
title('RMSE - subspace_iter_v3') % affichage du titre pour indiquer la méthode utilisée
ylabel('RMSE')
xlabel('rank k')
pause