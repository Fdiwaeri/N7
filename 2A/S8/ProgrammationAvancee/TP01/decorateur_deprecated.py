import functools

def deprecated(f):
    @functools.wraps(f)
    def f_interne(*p, **k):
        print('la fonction', f.__qualname__, 'ne devrait plus être utilisée...')
        f(*p, **k)
    return f_interne

@deprecated
def exemple(x, y='ok'):
    print('exemple:', y, x)

@deprecated
def exemple2(x):
    x = x+1
    return x

print('Appel à exemple')
exemple('?')
exemple(2, "okk")

print('\nAppel à exemple2')
y = exemple2(3)
z = exemple2(5)

print('\nAppel aux deux exemples')
exemple2(-1)
exemple('ok')
exemple2(1)

