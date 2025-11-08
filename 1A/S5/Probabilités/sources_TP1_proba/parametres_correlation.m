% Fonction parametres_correlation (exercice_1.m)

function [r,a,b] = parametres_correlation(Vd,Vg)

    Ex = mean(Vd);
    Ey = mean(Vg);
    Vx = mean(Vd.*Vd)-mean(Vd)^2;
    Vy = mean(Vg.*Vg)-mean(Vg)^2;
    r = (mean(Vg.*Vd)-Ex*Ey) / (sqrt(Vx*Vy));
    a = (mean(Vg.*Vd)-Ex*Ey)/Vx;
    b = Ey - a * Ex;

end