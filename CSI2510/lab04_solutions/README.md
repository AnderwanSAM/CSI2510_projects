# Solutions

## Exercice 1

### A quel élément d'un arbre correspond la classe Entry ?

La classe correspond aux noeuds d'un arbre.

Dans le cas d'arbre binaire, les éléments seront triés selon leur clé et les valeurs seront la valeur retournées par chaque noeud.

### Quelle structure de donnée représente l'interface PriorityQueue ?

Cette interface représente les files de priorité.

On peut identifier les élements de base pour ce genre de structure de donnée à savoir l'ajout d'un nouvel élément, le retrait d'un élément, la vérification si la file est vide et une fonction qui retourne la taille de la file.

### Quels sont les éléments manquants pour que PriorityQueue puisse être géré par un arbre ?

On considère ici que l'arbre est stocké dans un tableau.

Il manque plusieurs éléments :

- un attribut permettant de stocker l'arbre (le tableau)

- un attribut pour l'index de fin de l'arbre

- une méthode pour retourner le parent d'un noeud

- une méthode pour échanger 2 noeud

- une méthode pour remonter l'arbre lorsqu'un élément est inséré (on l'insère en fin de tableau)

- une méthode pour replacer les éléments dans l'ordre après suppression de la racine

## Exercice 2

Les étapes sont ordonnées de la manière suivante :

- 1 à 4 sont les éléments de l'interface indépendant de la structure d'arbre
- 6 à 8 sont les éléments spécifiques de la structure d'arbre
- 9 à 11 sont les derniers éléments de l'interface, dont l'implémentation dépend de la structure en arbre
