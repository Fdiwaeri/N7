class ProtectionProxy:
    def __init__(self, objet, *interdites):
        self.__recepteur = objet
        self.__interdites = set(interdites)
        print("les methodes interdites self.__interdites = ", self.__interdites)
        print(dir(self.__class__))
        '''
        Ceci est nécessaire pour que ces opérations fonctionnent sur le
        ProtectionProxy
        '''
        for f in ('__str__', '__repr__', '__getitem__', '__len__'):
        # for f in dir(objet):
            print('f =', f)
            if f not in ('__class__', '__getattribute__', '__getattr__'):
                if f not in self.__interdites:
                    setattr(self.__class__, f, getattr(objet, f))
    
    
    def __getattr__(self, name):
        print("ProtectionProxy.__getattr__ ", name)
        if name in self.__interdites:
            raise AttributeError("Appel interdit ", name)
        else:
            return getattr(self.__recepteur, name)

      
liste = [2, 3, 5, 7]
print("liste = ", liste)
liste.remove(5)
print("liste = ", liste)
pp = ProtectionProxy(liste, "append", "pop", "insert", "remove")
print("pp = ", pp)
try:
    pp.append(6)
except Exception as e:
    print(e)
    print("Impossible d'utiliser append pour pp")

try:
    pp.remove(7)
except Exception as e:
    print(e)
    print("Impossible d'utiliser remove pour pp")
print("pp = ", pp)
print("dir(liste) = ", dir(liste))
print("dir(pp) = ", dir(pp))
print("dir(liste)==dir(pp) is ", dir(liste)==dir(pp))
