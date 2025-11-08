%%  Application de la SVD : compression d'images

clear all
close all

% Lecture de l'image
I = imread('BD_Thorgal_1.jpg');
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
%% Méthode 1: eig (fonction MATLAB)
fprintf('\nMéthode 1: eig \n')
%%
% calcul des couples propres
%%
tic
[V_eig, D_eig] = eig(M);
%%
% calcul des valeurs singulières
%%
% Tri des valeurs propres et vecteurs propres par ordre décroissant
[lambda_eig, indices] = sort(diag(D_eig), 'descend');
V_eig = V_eig(:, indices);
sigma_eig = sqrt(lambda_eig);
%%
% calcul de l'autre ensemble de vecteurs
%%
if portrait
    % M = I'*I, donc V_eig contient V
    % On calcule U à partir de V selon l'équation (1)
    U_eig = zeros(q, length(sigma_eig));
    for i = 1:length(sigma_eig)
        if sigma_eig(i) > eps
            U_eig(:, i) = (I * V_eig(:, i)) / sigma_eig(i);
        end
    end
else
    % M = I*I', donc V_eig contient U
    U_eig = V_eig;
    % On calcule V à partir de U selon l'équation (1)
    V_eig = zeros(p, length(sigma_eig));
    for i = 1:length(sigma_eig)
        if sigma_eig(i) > eps
            V_eig(:, i) = (I' * U_eig(:, i)) / sigma_eig(i);
        end
    end
end
toc
%%
% calcul des meilleures approximations de rang faible
%%
diff_eig = zeros(size(inter, 2), 1);
fprintf('Reconstruction avec eig\n')
td = 0;
for k = inter
    % Calcul de l'image de rang k
    Im_k_eig = zeros(q, p);
    for i = 1:k
        Im_k_eig = Im_k_eig + sigma_eig(i) * U_eig(:, i) * V_eig(:, i)';
    end

    % Affichage de l'image reconstruite
    ti = ti+1;
    figure(ti)
    colormap('gray')
    imagesc(Im_k_eig), axis equal
    
    % Calcul de la différence entre les 2 images (RMSE : Root Mean Square Error)
    td = td + 1;
    diff_eig(td) = sqrt(sum(sum((I-Im_k_eig).^2)));
    pause
end
% Figure des différences entre l'image réelle et les images reconstruites
ti = ti+1;
figure(ti)
hold on 
plot(inter, diff_eig, 'bx') % courbe en bleu avec des x
title('RMSE - eig') % affichage du titre pour indiquer la méthode utilisée
ylabel('RMSE')
xlabel('rank k')
pause

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
plot(inter, diff_power, 'gx') %courbe des x en vert
title('RMSE - Power method') % affichage du titre pour indiquer la méthode utilisée
ylabel('RMSE')
xlabel('rank k')
pause

%% Méthode 3: subspace_iter_v0
fprintf('\nMéthode 3: subspace_iter_v0\n')
%%
% calcul des couples propres
%%
%k_max = max(inter);
tic
[V_v0, W_v0,~, ~] = subspace_iter_v0(M, search_space, eps, maxit);
%%
% calcul des valeurs singulières
%%
sigma_v0 = sqrt(diag(W_v0));
%%
% calcul de l'autre ensemble de vecteurs
%%
% Les vecteurs singuliers
if portrait
    % M = I'*I, donc V_v0 contient V
    % On calcule U à partir de V selon l'équation (1)
    U_v0 = zeros(q, length(sigma_v0));
    for i = 1:length(sigma_v0)
        if sigma_v0(i) > 1e-10
            U_v0(:, i) = (I * V_v0(:, i)) / sigma_v0(i);
        end
    end
else
    % M = I*I', donc V_v0 contient U
    U_v0 = V_v0;
    % On calcule V à partir de U selon l'équation (1)
    V_v0_new = zeros(p, length(sigma_v0));
    for i = 1:length(sigma_v0)
        if sigma_v0(i) > 1e-10
            V_v0_new(:, i) = (I' * U_v0(:, i)) / sigma_v0(i);
        end
    end
    V_v0 = V_v0_new;
end
toc
%%
% calcul des meilleures approximations de rang faible
%%
diff_v0 = zeros(size(inter, 2), 1);
fprintf('Reconstruction avec subspace_iter_v0\n')
td = 0;
for k = inter
    % Calcul de l'image de rang k
    Im_k_v0 = zeros(q, p);
    for i = 1:k
        Im_k_v0 = Im_k_v0 + sigma_v0(i) * U_v0(:, i) * V_v0(:, i)';
    end

    % Affichage de l'image reconstruite
    ti = ti+1;
    figure(ti)
    colormap('gray')
    imagesc(Im_k_v0), axis equal
    
    % Calcul de la différence entre les 2 images (RMSE : Root Mean Square Error)
    td = td + 1;
    diff_v0(td) = sqrt(sum(sum((I-Im_k_v0).^2)));
    pause
end

% Figure des différences entre l'image réelle et les images reconstruites
ti = ti+1;
figure(ti)
hold on
plot(inter, diff_v0, 'mx') %courbe des x en rose (magenta)
title('RMSE - subspace_iter_v0') % affichage du titre pour indiquer la méthode utilisée
ylabel('RMSE')
xlabel('rank k')
pause
%% Méthode 4: subspace_iter_v1
fprintf('\nMéthode 4: subspace_iter_v1\n')
%%
% calcul des couples propres
%%
tic
[V_v1, W_v1, n_ev,~,~, ~] = subspace_iter_v1(M, search_space, percentage, eps, maxit);

%%
% calcul des valeurs singulières
%%
sigma_v1 = sqrt(diag(W_v1));
%%
% calcul de l'autre ensemble de vecteurs
%%
% Les vecteurs singuliers
if portrait
    % M = I'*I, donc V_v1 contient V
    % On calcule U à partir de V selon l'équation (1)
    U_v1 = zeros(q, length(sigma_v1));
    for i = 1:length(sigma_v1)
        if sigma_v1(i) > 1e-10
            U_v1(:, i) = (I * V_v1(:, i)) / sigma_v1(i);
        end
    end
else
    % M = I*I', donc V_v1 contient U
    U_v1 = V_v1;
    % On calcule V à partir de U selon l'équation (1)
    V_v1_new = zeros(p, length(sigma_v1));
    for i = 1:length(sigma_v1)
        if sigma_v1(i) > 1e-10
            V_v1_new(:, i) = (I' * U_v1(:, i)) / sigma_v1(i);
        end
    end
    V_v1 = V_v1_new;
end
toc
%%
% calcul des meilleures approximations de rang faible
%%
diff_v1 = zeros(size(inter, 2), 1);
fprintf('Reconstruction avec subspace_iter_v1\n')
td = 0;
for k = inter
    % Calcul de l'image de rang k
    Im_k_v1 = zeros(q, p);
    for i = 1:min(k, length(sigma_v1))
        Im_k_v1 = Im_k_v1 + sigma_v1(i) * U_v1(:, i) * V_v1(:, i)';
    end
    
    % Affichage de l'image reconstruite
    ti = ti+1;
    figure(ti)
    colormap('gray')
    imagesc(Im_k_v1), axis equal
    
    % Calcul de la différence entre les 2 images (RMSE : Root Mean Square Error)
    td = td + 1;
    diff_v1(td) = sqrt(sum(sum((I-Im_k_v1).^2)));
    pause
end

% Figure des différences entre l'image réelle et les images reconstruites
ti = ti+1;
figure(ti)
hold on
plot(inter, diff_v1, 'cx') %courbe des x en bleu clair (cyan)
title('RMSE - subspace_iter_v1') % affichage du titre pour indiquer la méthode utilisée
ylabel('RMSE')
xlabel('rank k')
pause

%% Méthode 5: subspace_iter_v2
fprintf('\nMéthode 5: subspace_iter_v2\n')
%%
% calcul des couples propres
%%
tic
[V_v2, W_v2, ~,~,~,~] = subspace_iter_v2(M, search_space, percentage, puiss, eps, maxit);
%%
% calcul des valeurs singulières
%%
sigma_v2 = sqrt(diag(W_v2));
%%
% calcul de l'autre ensemble de vecteurs
%%
% Les vecteurs singuliers
if portrait
    % M = I'*I, donc V_v2 contient V
    % On calcule U à partir de V selon l'équation (1)
    U_v2 = zeros(q, length(sigma_v2));
    for i = 1:length(sigma_v2)
        if sigma_v2(i) > 1e-10
            U_v2(:, i) = (I * V_v2(:, i)) / sigma_v2(i);
        end
    end
else
    % M = I*I', donc V_v2 contient U
    U_v2 = V_v2;
    % On calcule V à partir de U selon l'équation (1)
    V_v2_new = zeros(p, length(sigma_v2));
    for i = 1:length(sigma_v2)
        if sigma_v2(i) > 1e-10
            V_v2_new(:, i) = (I' * U_v2(:, i)) / sigma_v2(i);
        end
    end
    V_v2 = V_v2_new;
end
toc
%%
% calcul des meilleures approximations de rang faible
%%
diff_v2 = zeros(size(inter, 2), 1);
fprintf('Reconstruction avec subspace_iter_v2\n')
td = 0;
for k = inter
    % Calcul de l'image de rang k
    Im_k_v2 = zeros(q, p);
    for i = 1:min(k, length(sigma_v2))
        Im_k_v2 = Im_k_v2 + sigma_v2(i) * U_v2(:, i) * V_v2(:, i)';
    end
    
    % Affichage de l'image reconstruite
    ti = ti+1;
    figure(ti)
    colormap('gray')
    imagesc(Im_k_v2), axis equal
    
    % Calcul de la différence entre les 2 images (RMSE : Root Mean Square Error)
    td = td + 1;
    diff_v2(td) = sqrt(sum(sum((I-Im_k_v2).^2)));
    pause
end

% Figure des différences entre l'image réelle et les images reconstruites
ti = ti+1;
figure(ti)
hold on
plot(inter, diff_v2, 'kx') %courbe des x en noir
title('RMSE - subspace_iter_v2') % affichage du titre pour indiquer la méthode utilisée
ylabel('RMSE')
xlabel('rank k')
pause

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

%% Comparaison de toutes les méthodes
ti = ti+1;
figure(ti)
hold on
plot(inter, differenceSVD, 'rx', 'LineWidth', 1.5)
plot(inter, diff_eig, 'bx', 'LineWidth', 1.5)
plot(inter, diff_power, 'gx', 'LineWidth', 1.5)
plot(inter, diff_v0, 'mx', 'LineWidth', 1.5)
plot(inter, diff_v1, 'cx', 'LineWidth', 1.5)
plot(inter, diff_v2, 'kx', 'LineWidth', 1.5)
plot(inter, diff_v3, 'yx', 'LineWidth', 1.5)
title('Comparaison RMSE de toutes les méthodes')
legend('SVD', 'eig', 'Power method', 'subspace\_iter\_v0', 'subspace\_iter\_v1', 'subspace\_iter\_v2', 'subspace\_iter\_v3')
ylabel('RMSE')
xlabel('rank k')
grid on