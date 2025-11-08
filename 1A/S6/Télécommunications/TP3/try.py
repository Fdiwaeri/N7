import matplotlib.pyplot as plt
import numpy as np

# Niveaux de la constellation
levels = [-3, -1, 1, 3]
I, Q = np.meshgrid(levels, levels)
symbols = I.flatten() + 1j * Q.flatten()

# Tracé de la constellation
plt.figure(figsize=(6, 6))
plt.scatter(np.real(symbols), np.imag(symbols), color='blue', s=100)
plt.axhline(0, color='black', linewidth=0.5)
plt.axvline(0, color='black', linewidth=0.5)

# Seuils de décision optimaux
seuils = [-2, 0, 2]
for s in seuils:
    plt.axhline(s, color='red', linestyle='--', linewidth=1)
    plt.axvline(s, color='red', linestyle='--', linewidth=1)

# Étiquettes des points
for symb in symbols:
    plt.text(np.real(symb) + 0.1, np.imag(symb) + 0.1,
             f'({int(np.real(symb))}, {int(np.imag(symb))})',
             fontsize=8)

plt.title('Constellation 16-QAM avec seuils optimaux')
plt.xlabel('I (In-Phase)')
plt.ylabel('Q (Quadrature)')
plt.grid(True)
plt.axis('equal')
plt.xlim(-4, 4)
plt.ylim(-4, 4)
plt.show()

