function [beta, norm_grad_f_beta, f_beta, norm_delta, nb_it, exitflag] ...
          = Algo_Gauss_Newton(residu, J_residu, beta0, option)
%*****************************************************************
% Fichier  ~gergaud/ENS/Optim1a/TP-optim-20-21/TP-ref/GN_ref.m   *
% Novembre 2020                                                  *
% Université de Toulouse, INP-ENSEEIHT                           *
%*****************************************************************
%
% GN resout par l'algorithme de Gauss-Newton les problemes aux moindres carres
% Min 0.5||r(beta)||^2
% beta \in \IR^p
%
% Paramètres en entrés
% --------------------
% residu : fonction qui code les résidus
%          r : \IR^p --> \IR^n
% J_residu : fonction qui code la matrice jacobienne
%            Jr : \IR^p --> real(n,p)
% beta0 : point de départ
%         real(p)
% option(1) : Tol_abs, tolérance absolue
%             real
% option(2) : Tol_rel, tolérance relative
%             real
% option(3) : n_itmax, nombre d'itérations maximum
%             integer
%
% Paramètres en sortie
% --------------------
% beta      : beta
%             real(p)
% norm_gradf_beta : ||gradient f(beta)||
%                   real
% f_beta : f(beta)
%          real
% r_beta : r(beta)
%          real(n)
% norm_delta : ||delta||
%              real
% nbit : nombre d'itérations
%        integer
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
    beta = beta0;
    r_beta = residu(beta);
    J_r = J_residu(beta);
    norm_grad_f_beta = norm( J_r' * r_beta);
    f_beta = (1/2)*(norm(r_beta))^2;
    norm_delta = 0;
    nb_it = 0;
    exitflag = 0;
    s= 0;
    norm_grad_f_beta_0 = norm ( J_r' * r_beta );
    while exitflag == 0
        nb_it = nb_it +1; 
        J_r = J_residu(beta);
        r_beta= residu(beta);
        s = ((J_r)'*J_r)\(J_r'*r_beta);
        beta = beta - s;
        f_beta_k = f_beta;
        f_beta = (1/2)*(norm(r_beta))^2;
        norm_grad_f_beta = norm(J_r);
        r_beta = residu(beta);
        delta = (J_r)'*r_beta;
        norm_delta = norm(delta);
        if norm_grad_f_beta < max(option(2) * norm_grad_f_beta_0,option(1))
            exitflag = 1
        elseif abs(f_beta- f_beta_k) < max(option(2) * abs(f_beta_k),option(1))
            exitflag = 2
        elseif norm_delta < max(option(2) * delta,option(1))
            exitflag = 3
        elseif nb_it > n_it_max 
            exitflag = 4
        end
    end


end
