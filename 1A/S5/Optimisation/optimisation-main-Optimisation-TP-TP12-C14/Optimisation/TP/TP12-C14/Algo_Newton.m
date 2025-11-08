function [beta, norm_grad_f_beta, f_beta, norm_delta, nb_it, exitflag] ...
          = Algo_Newton(Hess_f_C14, beta0, option)
%************************************************************
% Fichier  ~gergaud/ENS/Optim1a/TP-optim-20-21/Newton_ref.m *
% Novembre 2020                                             *
% Université de Toulouse, INP-ENSEEIHT                      *
%************************************************************
%
% Newton r�sout par l'algorithme de Newton les problemes aux moindres carres
% Min 0.5||r(beta)||^2
% beta \in R^p
%
% Parametres en entrees
% --------------------
% Hess_f_C14 : fonction qui code la hessiennne de f
%              Hess_f_C14 : R^p --> matrice (p,p)
%              (la fonction retourne aussi le residu et la jacobienne)
% beta0  : point de départ
%          real(p)
% option(1) : Tol_abs, tolérance absolue
%             real
% option(2) : Tol_rel, tolérance relative
%             real
% option(3) : nitimax, nombre d'itérations maximum
%             integer
%
% Parametres en sortie
% --------------------
% beta      : beta
%             real(p)
% norm_gradf_beta : ||gradient f(beta)||
%                   real
% f_beta    : f(beta)
%             real
% res       : r(beta)
%             real(n)
% norm_delta : ||delta||
%              real
% nbit       : nombre d'itérations
%              integer
% exitflag   : indicateur de sortie
%              integer entre 1 et 4
% exitflag = 1 : ||gradient f(beta)|| < max(Tol_rel||gradient f(beta0)||,Tol_abs)
% exitflag = 2 : |f(beta^{k+1})-f(beta^k)| < max(Tol_rel|f(beta^k)|,Tol_abs)
% exitflag = 3 : ||delta)|| < max(Tol_rel delta^k),Tol_abs)
% exitflag = 4 : nombre maximum d'itérations atteint
%      
% ---------------------------------------------------------------------------------

% TO DO %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    n_it_max = option(3);
    Tol_rel = option(2);
    beta = beta0;
    [H,r,J] = Hess_f_C14(beta);
    norm_grad_f_beta = norm( J' * r);
    f_beta = (1/2)*(norm(r))^2;
    norm_delta = 0;
    nb_it = 0;
    exitflag = 0;
    s= 0;
    norm_grad_f_beta_0 = norm ( J' * r );
    while exitflag == 0
        nb_it = nb_it +1; 
        
        s = H\(J'*r);
        beta = beta - s;
        [H,r,J] = Hess_f_C14(beta);
        f_beta_k = f_beta;
        f_beta = (1/2)*(norm(r))^2;
        norm_grad_f_beta = norm(J);
        delta = (J)'*r;
        norm_delta = norm(delta);
        if norm_grad_f_beta < max( Tol_rel * norm_grad_f_beta_0,option(1))
            exitflag = 1
        elseif abs(f_beta- f_beta_k) < max( Tol_rel * abs(f_beta_k),option(1))
            exitflag = 2
        elseif norm_delta < max( Tol_rel * delta,option(1))
            exitflag = 3
        elseif nb_it > n_it_max 
            exitflag = 4
        end
    end

end
