# Algorithme de Bellman-Ford

Ce projet implémente l'algorithme de Bellman-Ford en Java pour trouver les plus courts chemins dans un graphe pondéré.

## Structure du projet

- `Arc.java` : Définit la classe `Arc` représentant une arête du graphe.
- `Sommet.java` : Définit la classe `Sommet` représentant un sommet du graphe.
- `Graphe.java` : Définit la classe `Graphe` représentant le graphe et contient la méthode `main` pour exécuter l'algorithme.
- `BellmanFordAlgorithm.java` : Contient l'implémentation de l'algorithme de Bellman-Ford.

## Utilisation

Pour exécuter l'algorithme, compilez et exécutez la classe `Graphe` qui contient un exemple de graphe et appelle l'algorithme de Bellman-Ford.

```sh
javac *.java
java Graphe
```

## Exemple de sortie

L'exécution du programme affichera les distances les plus courtes du sommet de départ à tous les autres sommets du graphe.

## Auteurs

Ce projet a été réalisé par [votre nom].

## Licence

Ce projet est sous licence MIT. Voir le fichier [LICENSE](LICENSE) pour plus de détails.