%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%               TP1 de Traitement Num�rique du Signal
%                   SCIENCES DU NUMERIQUE 1A
%                       Fevrier 2025 
%                       Fadwa Ellaik
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


clear all
close all

%% %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%PARAMETRES GENERAUX
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
A=1;                %amplitude du cosinus
f0=1100;            %fréquence du cosinus en Hz
T0=1/f0;            %période du cosinus en secondes
N=90;               %nombre d'échantillons souhaités pour le cosinus
Fe=10000;           %fréquence d'échantillonnage en Hz
Te=1/Fe;            %période d'échantillonnage en secondes
SNR=0;              %SNR souhaité en dB pour le cosinus bruité


%% %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%GENERATION DU COSINUS NUMERIQUE
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%D�finition de l'�chelle temporelle
temps= (0:N-1)*Te;
%G�n�ration de N �chantillons de cosinus � la fr�quence f0
x= A*cos(2*pi*f0*temps);

%% %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%TRACE DU COSINUS NUMERIQUE
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Sans se pr�occuper de l'�chelle temporelle
figure
plot(x)

%Trac� avec une �chelle temporelle en secondes
%des labels sur les axes et un titre (utilisation de xlabel, ylabel et
%title)
figure
plot(temps, x);
grid
xlabel('Temps (s)')
ylabel('signal')
title(['Tracé d un cosinus numérique de fréquence ' num2str(f0) 'Hz']);

%% %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%CALCUL DE LA TRANSFORMEE DE FOURIER NUMERIQUE (TFD) DU COSINUS NUMERIQUE
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Sans zero padding 
X=fft(x);
%Avec zero padding (ZP : param�tre de zero padding � d�finir) 
ZP = 2^nextpow2(N);
X_ZP=fft(x, ZP);

%% %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%TRACE DU MODULE DE LA TFD DU COSINUS NUMERIQUE EN ECHELLE LOG
%SANS PUIS AVEC ZERO PADDING
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%Avec une �chelle fr�quentielle en Hz
%des labels sur les axes et des titres
%Trac�s en utilisant plusieurs zones de la figure (utilisation de subplot) 
figure('name',['Tracé du module de la TFD d''un cosinus numérique de fréquence ' num2str(f0) 'Hz'])

subplot(2,1,1)
echelle_frequentielle=(0:N-1)*Fe/N;
semilogy(echelle_frequentielle, abs(X));
grid
title('Sans zero padding')
xlabel('Fréquence (Hz)')
ylabel('|TFD|')

subplot(2,1,2)
echelle_frequentielle=(0:ZP-1)*Fe/ZP;
semilogy(echelle_frequentielle, abs(X_ZP));
grid
title('Avec zero padding')
xlabel('Fréquence (Hz)')
ylabel('|TFD|')

%Avec une �chelle fr�quentielle en Hz
%des labels sur les axes et des titres
%Trac�s superpos�s sur une m�me figure 
% (utilisation de hold, de couleurs diff�rentes et de legend)
% !! UTILISER ICI fftshit POUR LE TRACE !!
figure
echelle_frequentielle=(-N/2:N/2-1)*Fe/N;
semilogy(echelle_frequentielle, fftshift(abs(X)),'b');    %Tracé en bleu : 'b'
hold on
echelle_frequentielle=(-ZP/2:ZP/2-1)*Fe/ZP;
semilogy(echelle_frequentielle, fftshift(abs(X_ZP)),'r'); %Tracé en rouge : 'r'
grid
legend('Sans zero padding','Avec zero padding')
xlabel('Fréquence (Hz)')
ylabel('|TFD|')
title(['Tracé du module de la TFD d''un cosinus numérique de fréquence ' num2str(f0) 'Hz'])

%% %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%CALCUL DE LA TFD DU COSINUS NUMERIQUE AVEC FENETRAGE
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Application de la fen�tre de pond�ration de Hamming
x_fenetre_hamming=x.*hamming(length(x)).';
%Calcul de la TFD pond�r�e, avec zeros padding
X_ZP_hamming=fft(x_fenetre_hamming, ZP);
%Application de la fen�tre de pond�ration de Blackman
x_fenetre_blackman=x.*blackman(length(x)).';
%Calcul de la TFD pond�r�e, avec zeros padding
X_ZP_blackman=fft(x_fenetre_blackman, ZP);

%% %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%TRACE DU MODULE DE LA TFD DU COSINUS NUMERIQUE AVEC FENETRAGE EN ECHELLE LOG
%POUR DIFFERENTES FENETRES
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Tracés superposés sur la même figure de la TFD non fenêtrée, 
% de la TFD avec fenêtrage de Hamming, de la TFD avec fenêtrage de Blackman
% Le tout avec une échelle fréquentielle en Hz, un titre, des labels sur les axes, 
% une légende et en utilisant fftshift

figure
echelle_frequentielle = (-ZP/2:ZP/2-1)*Fe/ZP;
semilogy(echelle_frequentielle, fftshift(abs(X_ZP)), 'b');
hold on
semilogy(echelle_frequentielle, fftshift(abs(X_ZP_hamming)), 'r');
semilogy(echelle_frequentielle, fftshift(abs(X_ZP_blackman)), 'g');
grid
legend('Sans fenêtrage', 'Fenêtrage de Hamming', 'Fenêtrage de Blackman')
xlabel('Fréquence (Hz)')
ylabel('|TFD|')
title('Module de la TFD avec différents fenêtrages')

%% %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%CALCUL DE LA DENSITE SPECTRALE DE PUISSANCE (DSP) DU COSINUS NUMERIQUE
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%Estimation par p�riodogramme
Sx_periodogramme=(1/(N*Fe))*abs(fft(x)).^2;

%Estimation par p�riodogramme de Welch
Sx_Welch=pwelch(x, [],[],[],Fe,'twosided');

%% %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%TRACE DE LA DENSITE SPECTRALE DE PUISSANCE (DSP) DU COSINUS NUMERIQUE
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%Trac�s superpos�s sur une m�me figure en utilisant fftshift
%Avec une �chelle fr�quentielle en Hz
%des labels sur les axes, un titre, une l�gende
figure
echelle_frequentielle=(-N/2:N/2-1)*Fe/N;
semilogy(echelle_frequentielle, fftshift(Sx_periodogramme),'b')
hold on
echelle_frequentielle=(-length(Sx_Welch)/2:length(Sx_Welch)/2-1)*Fe/length(Sx_Welch);
semilogy(echelle_frequentielle, fftshift(Sx_Welch),'r')
legend('Periodogramme','Periodogramme de Welch')
xlabel('Fréquences (Hz)')
ylabel('DSP')
title('Tracés de la DSP d''un cosinus numérique de fréquence 1100 Hz');

%% %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%CALCUL ET TRACE DE LA FONCTION D'AUTOCORRELATION DU COSINUS BRUITE AVEC LE
%BON SNR
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%       

%Calcul de la puissance du signal
P_signal=mean(abs(x).^2);
%Calcul de la puissance du bruit pour obtenir le SNR souhait�
P_bruit=P_signal/(10^(SNR/10));

%G�n�ration du bruit gaussien � la puissance Pb
bruit=sqrt(P_bruit)*randn(1,length(x));
%Ajout du bruit sur le signal
x_bruite=x+bruit;

%Calcul de la fonction d'autocorr�lation du signal bruite
%attention pas le 1/N quand on utilise xcorr => � rajouter
Rx=(1/length(x_bruite))*xcorr(x_bruite); 

%Trac� du signal bruit� avec une �chelle temporelle en secondes
figure
plot(temps, x_bruite)
grid
xlabel('Temps (s)')
ylabel('Signal')
title('Tracé du cosinus bruité');

%Trac� de la fonction d'autocorr�lation du signal bruite avec une �chelle 
%temporelle en secondes
figure
echelle_tau=(-length(x_bruite)+1:length(x_bruite)-1)*Te;
plot(echelle_tau, Rx)
grid
xlabel('\tau (s)')
ylabel('R_x(\tau)')
title('Tracé de la fonction d''autocorrélation du cosinus bruité');