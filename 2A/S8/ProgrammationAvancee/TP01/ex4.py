a = { 1, 2, 3, 4, 3, 2, 1} # a est un ensemble de int
b = { 'fr': 'France', 'de': 'Allemagne' } # b est un dictionnaire (string, string)

len(a) # 4, pas de doublons dans un ensemble
len(b) # 2
b[5] = 'fr' # on ajoute la clé 5 asspciée à la valeur 'fr'
x = b['fr'] # x = 'France'
y = b.get('it', -1) # -1 car aucune valeur 'it' dans b
del b[5] # on supprime (5, 'fr') de b
b.items() # [('fr', 'France'), ('de', 'Allemagne')]
b.values() # ['France', 'Allemagne']
b.keys() # ['fr', 'de']
p = b.pop('fr') # on supprime la clé 'fr' et sa valeur associée, la valeur est mise dans p