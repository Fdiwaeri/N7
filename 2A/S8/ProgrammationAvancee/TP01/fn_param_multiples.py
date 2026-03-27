def f(a=4, *p, x, **kw):
    print('a =', a)
    print('p =', p)
    print('kw =', kw)
    print(*p, sep='... ', end=' !\n')

f(1, 2, 3, x=5, y=6, z=7)

# dans la signature de f, p est une liste et kw est un dictionnaire
# dans le print, *p correspond aux éléments de la liste p qu'on veut afficher
# l'appel f(1,2,3) n'est pas possible, car il manque le paramètre x