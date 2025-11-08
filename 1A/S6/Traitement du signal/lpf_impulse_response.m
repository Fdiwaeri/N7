% Fonction pour générer la réponse impulsionnelle du filtre passe-bas
function h = lpf_impulse_response(N, fc, Fe)
    % N est l'ordre du filtre divisé par 2 (demi-ordre)
    % fc est la fréquence de coupure en Hz
    % Fe est la fréquence d'échantillonnage en Hz
    
    f_norm = fc/Fe;   % Fréquence de coupure normalisée
    n = -N:N;         % Indices pour la réponse impulsionnelle
    
    % Calcul de la réponse impulsionnelle idéale tronquée avec fenêtre rectangulaire
    h = 2 * f_norm * sinc(2 * f_norm * n);
end