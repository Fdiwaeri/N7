import functools
p = 0
def trace(f):
    @functools.wraps(f)
    def f_interne(n):
        global p
        marge = '   ' * p
        print(marge, '-->', f.__qualname__, f'({n})')
        p+=1
        res = f(n)
        p-=1
        print(marge, '<--', res)
        return res
    return f_interne
