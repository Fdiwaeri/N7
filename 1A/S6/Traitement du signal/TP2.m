%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%               TP1 de Traitement Num�rique du Signal
%                   SCIENCES DU NUMERIQUE 1A
%                       Fevrier 2025 
%                       Fadwa Ellaik
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

clear all
close all

%% GENERATION DU SIGNAL A FILTRER

% Paramètres du signal
Fe = 10000;           % Fréquence d'échantillonnage (Hz)
f1 = 1000;            % Fréquence du premier cosinus (Hz)
f2 = 3000;            % Fréquence du second cosinus (Hz)
N = 100;              % Nombre d'échantillons
t = (0:N-1)/Fe;       % Vecteur temps en secondes

% Génération du signal (somme de deux cosinus)
x = cos(2*pi*f1*t) + cos(2*pi*f2*t);

% Tracé du signal temporel
figure(1);
plot(t, x);
xlabel('Temps (s)');
ylabel('Amplitude (V)');
title('Signal temporel (somme de deux cosinus)');
grid on;

% Calcul et tracé de la représentation fréquentielle
N_fft = 1024;         % Nombre de points pour la FFT
X = fft(x, N_fft);    % Calcul de la TFD
f = (0:N_fft-1)*Fe/N_fft; % Vecteur fréquence en Hz

% On ne représente que la première moitié du spectre (jusqu'à Fe/2)
figure(2);
plot(f(1:N_fft/2), abs(X(1:N_fft/2))*2/N_fft);
xlabel('Fréquence (Hz)');
ylabel('Amplitude');
title('Représentation fréquentielle du signal');
xlim([0 Fe/2]);
grid on;


%% SYNTHESE DU FILTRE PASSE-BAS

% Paramètres du filtre
fc = 2000;            % Fréquence de coupure (Hz) - entre f1 et f2
f_norm = fc/Fe;       % Fréquence de coupure normalisée

% Génération de la réponse impulsionnelle pour ordre = 11 (23 coefficients)
N1 = 11;
h1 = lpf_impulse_response((N1-1)/2, fc, Fe);

% Génération de la réponse impulsionnelle pour ordre = 61 (123 coefficients)
N2 = 61;
h2 = lpf_impulse_response((N2-1)/2, fc, Fe);

% Tracé des réponses impulsionnelles
figure(3);
subplot(2,1,1);
stem(-((N1-1)/2):((N1-1)/2), h1);
xlabel('n');
ylabel('h[n]');
title(['Réponse impulsionnelle du filtre passe-bas (ordre = ', num2str(N1), ')']);
grid on;

subplot(2,1,2);
stem(-((N2-1)/2):((N2-1)/2), h2);
xlabel('n');
ylabel('h[n]');
title(['Réponse impulsionnelle du filtre passe-bas (ordre = ', num2str(N2), ')']);
grid on;

% Calcul et tracé des réponses en fréquence
N_fft = 1024;
H1 = fft(h1, N_fft);
H2 = fft(h2, N_fft);
f = (0:N_fft-1)*Fe/N_fft;

figure(4);
subplot(2,1,1);
plot(f(1:N_fft/2), abs(H1(1:N_fft/2)));
xlabel('Fréquence (Hz)');
ylabel('|H(f)|');
title(['Réponse en fréquence du filtre passe-bas (ordre = ', num2str(N1), ')']);
xlim([0 Fe/2]);
grid on;

subplot(2,1,2);
plot(f(1:N_fft/2), abs(H2(1:N_fft/2)));
xlabel('Fréquence (Hz)');
ylabel('|H(f)|');
title(['Réponse en fréquence du filtre passe-bas (ordre = ', num2str(N2), ')']);
xlim([0 Fe/2]);
grid on;


%% REALISATION DU FILTRAGE

% Paramètres
f1 = 1000;            % Fréquence du premier cosinus (Hz)
f2 = 3000;            % Fréquence du second cosinus (Hz)
N = 100;              % Nombre d'échantillons
t = (0:N-1)/Fe;       % Vecteur temps en secondes
fc = 2000;            % Fréquence de coupure (Hz)

% Génération du signal (somme de deux cosinus)
x = cos(2*pi*f1*t) + cos(2*pi*f2*t);

% Ordre des filtres
N1 = 11;              % Premier filtre
N2 = 61;              % Second filtre

% Génération des réponses impulsionnelles
h1 = lpf_impulse_response((N1-1)/2, fc, Fe);
h2 = lpf_impulse_response((N2-1)/2, fc, Fe);

% Calcul des réponses en fréquence pour visualisation
N_fft = 1024;
X = fft(x, N_fft);
H1 = fft(h1, N_fft);
H2 = fft(h2, N_fft);
f = (0:N_fft-1)*Fe/N_fft;

% Superposition des représentations fréquentielles
figure(5);
plot(f(1:N_fft/2), abs(X(1:N_fft/2))*2/N_fft, 'b', 'LineWidth', 1.5);
hold on;
plot(f(1:N_fft/2), abs(H1(1:N_fft/2)), 'r--', 'LineWidth', 1.5);
plot(f(1:N_fft/2), abs(H2(1:N_fft/2)), 'g-.', 'LineWidth', 1.5);
hold off;
xlabel('Fréquence (Hz)');
ylabel('Amplitude');
title('Superposition des représentations fréquentielles');
legend('Signal original', ['Filtre ordre = ', num2str(N1)], ['Filtre ordre = ', num2str(N2)]);
xlim([0 Fe/2]);
grid on;

% Filtrage du signal avec les deux filtres
y1 = filter(h1, 1, x);   % Filtrage avec le filtre d'ordre 11
y2 = filter(h2, 1, x);   % Filtrage avec le filtre d'ordre 61

% Visualisation des signaux temporels
figure(6);
subplot(3,1,1);
plot(t, x);
xlabel('Temps (s)');
ylabel('Amplitude');
title('Signal original');
grid on;

subplot(3,1,2);
plot(t, y1);
xlabel('Temps (s)');
ylabel('Amplitude');
title(['Signal filtré (ordre = ', num2str(N1), ')']);
grid on;

subplot(3,1,3);
plot(t, y2);
xlabel('Temps (s)');
ylabel('Amplitude');
title(['Signal filtré (ordre = ', num2str(N2), ')']);
grid on;

% Calcul du retard introduit par les filtres
delay1 = (N1-1)/2;    % Retard en nombre d'échantillons pour filtre d'ordre 11
delay2 = (N2-1)/2;    % Retard en nombre d'échantillons pour filtre d'ordre 61

delay1_sec = delay1/Fe;  % Retard en secondes pour filtre d'ordre 11
delay2_sec = delay2/Fe;  % Retard en secondes pour filtre d'ordre 61

fprintf('Retard introduit par le filtre d''ordre %d : %d échantillons (%.4f secondes)\n', N1, delay1, delay1_sec);
fprintf('Retard introduit par le filtre d''ordre %d : %d échantillons (%.4f secondes)\n', N2, delay2, delay2_sec);