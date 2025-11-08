% Fonction estimation_C (exercice_2.m)

function C_estime = estimation_C(x_donnees_bruitees,y_donnees_bruitees,tirages_C,R_moyen)

    X_c= repmat(tirages_C(:,1)' , 1, lenght(x_donnees_bruitees));
    Y_c= repmat(tirages_C(:,2)', 1, lenght(y_donnees_bruitees));
    X_p= repmat( x_donnees_bruitees, lenght(tirages_C), 1);
    Y_p= repmat(y_donnees_bruitees,lenght(tirages_C), 1);
    distances = sqrt((X_p - X_c).^2)+((Y_p - Y_c).^2);
    Residus= (distances - R_moyen).^2;
    S= sum(Residus);
    [pos, ~]= min(S);
    C_estime= tirages_C(pos);


end