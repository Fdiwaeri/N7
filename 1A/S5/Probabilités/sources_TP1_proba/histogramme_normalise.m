% Fonction histogramme_normalise (exercice_2.m)

function [vecteur_Imin_a_Imax,vecteur_frequences] = histogramme_normalise(I)

    Imin= min(I);
    Imax= max(I);
    vecteur_Imin_a_Imax
    T= histcounts(I,Imin,Imax+1);
    vecteur_frequences= T / sum(T);
    

end