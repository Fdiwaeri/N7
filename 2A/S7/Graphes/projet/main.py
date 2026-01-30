import pandas as pd
import numpy as np
import networkx as nx
import matplotlib.pyplot as plt
from scipy.spatial.distance import pdist, squareform
from collections import Counter
import os

# Config fichiers
FILES = {
    'Faible': 'topology_low.csv',
    'Moyenne': 'topology_avg.csv',
    'Forte': 'topology_high.csv'
}
RANGES_KM = [20, 40, 60]
OUTPUT_DIR = "Resultats_Projet"

# si le dossier n'existe pas
if not os.path.exists(OUTPUT_DIR):
    os.makedirs(OUTPUT_DIR)


def load_data(filename):
    # recupere juste les coords x,y,z depuis le csv
    try:
        df = pd.read_csv(filename)
        return df[['x', 'y', 'z']].values
    except FileNotFoundError:
        print(f"Pas de fichier : {filename}")
        return None
    except Exception as e:
        print(f"Erreur lors de la lecture de {filename}: {e}")
        return None

def plot_graph_2d(G, title, filename):
    # Partie 1
    plt.figure(figsize=(10, 8))
    # on utilise layout spring pour une visualisation claire de la topologie
    pos = nx.spring_layout(G, seed=42)
    nx.draw_networkx_nodes(G, pos, node_size=40, node_color='#3498db', alpha=0.9)
    nx.draw_networkx_edges(G, pos, edge_color='gray', alpha=0.3)
    plt.title(title)
    plt.axis('off')
    plt.tight_layout()
    plt.savefig(os.path.join(OUTPUT_DIR, filename), dpi=300)
    plt.close()

def plot_histogram(data, title, xlabel, filename, color='skyblue', bins=None):
    # Génère et sauvegarde un histogramme
    if not data: return
    
    plt.figure(figsize=(8, 6))
    
    # Gestion des bins auto
    if bins is None:
        if all(isinstance(x, int) for x in data):
            bins = range(int(min(data)), int(max(data)) + 2)
            align = 'left' 
        else:
            bins = 30
            align = 'mid'
    else:
        align = 'mid'

    plt.hist(data, bins=bins, color=color, edgecolor='black', alpha=0.7, align=align)
    plt.title(title)
    plt.xlabel(xlabel)
    plt.ylabel("Fréquence (Nombre de couples/noeuds)")
    plt.grid(axis='y', alpha=0.3)
    plt.tight_layout()
    plt.savefig(os.path.join(OUTPUT_DIR, filename), dpi=300)
    plt.close()

def analyze_graph_metrics(G, weighted=False):
    # Calcule toutes les métriques (stats) demandées
    # retourne un dict de stats (pour le CSV)
    # et des listes brutes (pour les plots)
    stats = {}
    
    # Degrés
    degrees = [d for n, d in G.degree()]
    stats['Degré Moyen'] = np.mean(degrees) if degrees else 0
    dist_degree = degrees

    # Clustering
    clustering_coeffs = list(nx.clustering(G).values())
    stats['Clustering Moyen'] = np.mean(clustering_coeffs) if clustering_coeffs else 0
    dist_clustering = clustering_coeffs

    # Composantes connexes
    components = list(nx.connected_components(G))
    stats['Nb Composantes'] = len(components)
    comp_orders = sorted([len(c) for c in components], reverse=True)
    # les 5 plus grandes tailles
    stats['Top5 Tailles Composantes'] = str(comp_orders[:5])
    
    # Cliques
    cliques = list(nx.find_cliques(G))
    stats['Nb Cliques'] = len(cliques)
    
    # distribution des tailles de cliques
    clique_sizes = [len(c) for c in cliques]
    clique_counts = Counter(clique_sizes)
    # format str pour le csv
    dist_cliques_str = " | ".join([f"{k}:{v}" for k, v in sorted(clique_counts.items())])
    stats['Distr. Tailles Cliques'] = dist_cliques_str
    dist_cliques = clique_sizes # Pour l'histogramme

    # Chemins (shortest paths)
    path_vals = []
    weight_attr = 'weight' if weighted else None
    
    if G.number_of_edges() > 0:
        for component in components:
            subg = G.subgraph(component)
            if len(subg) > 1:
                all_pairs = dict(nx.shortest_path_length(subg, weight=weight_attr))
                for src, targets in all_pairs.items():
                    for dest, val in targets.items():
                        if src < dest: 
                            path_vals.append(val)

    stats['Nb Chemins Calculés'] = len(path_vals)
    stats['Moyenne Longueur Chemins'] = np.mean(path_vals) if path_vals else 0
    stats['Diamètre (Max Chemin)'] = np.max(path_vals) if path_vals else 0
    
    dist_paths = path_vals

    return stats, dist_degree, dist_clustering, dist_paths, dist_cliques

# Main
if __name__ == "__main__":
    print(f"Analyse Graphes Nanosatellites :")
    final_results = []

    for density_name, csv_file in FILES.items():
        print(f"  Analyse densité : {density_name}")
        pos = load_data(csv_file)
        if pos is None: continue

        # Matrice de distances en mètres
        dist_matrix = squareform(pdist(pos, metric='euclidean'))

        # Parte 2 : analyse non valuée
        for r_km in RANGES_KM:
            threshold_m = r_km * 1000
            print(f"    Traitement Portée {r_km} km...")
            
            # construction graphe
            adj_matrix = (dist_matrix <= threshold_m)
            np.fill_diagonal(adj_matrix, False)
            G = nx.from_numpy_array(adj_matrix)
            
            # l'analyse
            metrics, d_deg, d_clus, d_path, d_clique = analyze_graph_metrics(G, weighted=False)
            
            metrics['Densité'] = density_name
            metrics['Portée (km)'] = r_km
            metrics['Type Graphe'] = 'Non Valué (Sauts)'
            final_results.append(metrics)

            # plots
            suffix = f"{density_name}_{r_km}"
            plot_graph_2d(G, f"Topologie {density_name} - {r_km}km", f"graphe_{suffix}.png")
            plot_histogram(d_deg, f"Distr. Degrés ({density_name}, {r_km}km)", "Degré", f"hist_degre_{suffix}.png", color='skyblue')
            plot_histogram(d_clus, f"Distr. Clustering ({density_name}, {r_km}km)", "Coeff. Clustering", f"hist_clustering_{suffix}.png", color='lightgreen')
            plot_histogram(d_path, f"Distr. Chemins (Sauts) ({density_name}, {r_km}km)", "Nombre de sauts", f"hist_chemins_{suffix}.png", color='salmon')
            plot_histogram(d_clique, f"Distr. Tailles Cliques ({density_name}, {r_km}km)", "Taille de la Clique", f"hist_cliques_{suffix}.png", color='gold')

        # Partie 3 : analyse valuée (60km seulement)
        print(f"    Calcul cas valué (60km, Coût = dist²)...")
        threshold_m_60 = 60 * 1000
        G_weighted = nx.Graph()
        G_weighted.add_nodes_from(range(len(pos)))
        
        rows, cols = np.where(np.triu(dist_matrix <= threshold_m_60, k=1))
        for u, v in zip(rows, cols):
            w = (dist_matrix[u, v])**2
            G_weighted.add_edge(u, v, weight=w)
            
        metrics_w, _, _, d_path_w, _ = analyze_graph_metrics(G_weighted, weighted=True)
        
        metrics_w['Densité'] = density_name
        metrics_w['Portée (km)'] = 60
        metrics_w['Type Graphe'] = 'Valué (Coût Énergétique)'
        final_results.append(metrics_w)

        plot_histogram(d_path_w, f"Distr. Coûts Chemins ({density_name}, 60km Valué)", "Coût Total (m²)", f"hist_couts_{density_name}_60_value.png", color='purple')

    # Export CSV
    df_res = pd.DataFrame(final_results)

    # clean format listes pour excel
    def clean_list_format(val):
        if isinstance(val, str) and val.startswith('[') and val.endswith(']'):
            return val.replace(',', '') 
        return val

    # on applique la correction sur tout le DataFrame
    try:
        df_clean = df_res.map(clean_list_format)
    except AttributeError:
        df_clean = df_res.applymap(clean_list_format)

    cols_order = [
        'Densité', 'Portée (km)', 'Type Graphe',
        'Degré Moyen', 'Clustering Moyen',
        'Nb Composantes', 'Top5 Tailles Composantes',
        'Nb Cliques', 'Distr. Tailles Cliques',
        'Moyenne Longueur Chemins', 'Diamètre (Max Chemin)', 'Nb Chemins Calculés'
    ]
    # garde ceux qui existent
    final_cols = [c for c in cols_order if c in df_clean.columns]
    
    output_csv = os.path.join(OUTPUT_DIR, "rapport_resultats.csv")
    df_clean[final_cols].to_csv(output_csv, index=False, sep=';', encoding='utf-8-sig')

    print(f"\n \nAnalyse terminée!")
    print(f"  Les données sont dans le fichier : {output_csv} ")
    print(f"  Les histogrammes et graphes sont dans le dossier : {OUTPUT_DIR}/")
    print(f"  Nb de fichiers générés : {len(os.listdir(OUTPUT_DIR))}")