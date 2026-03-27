def zero(f, a, b, *, precision=10e-5):
    '''Retourner une abscisse où la fonction f s'annule entre a et b'''
    assert f(a) * f(b) <= 0

    if a > b:
        a, b = b, a
    while b - a > precision:
        milieu = (a + b) / 2
        if f(a) * f(milieu) > 0:
            a = milieu
        else:
            b = milieu
    return (a + b) / 2

# f est une fonction qui retourne un int/double/float
# on précise dans l'appel precision = 'la precision souhaitée"
# exemple
def f(x):
    return x**2 - 2 * x - 15

res = zero(f, 0, 15, precision=0.01)
print(res)