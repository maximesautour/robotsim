# Robotsim - Simulateur d'usine robotisée

Projet INF112 - Programmation Orientée Objet en Java
Télécom Paris, 1A 2025-2026

## État du projet

| TP | Description | Statut |
|----|-------------|--------|
| TP1 | Setup environnement (Eclipse, Git) | OK |
| TP2 | Classe Robot | OK |
| TP3 | Factory avec ArrayList | OK |
| TP4 | Héritage Component / CompositeComponent | OK |
| TP5 | Interfaces Canvas / Figure | OK |
| TP6 | MVC avec Observer/Observable | OK |
| TP7 | Persistance et Logging | OK |
| TP8 | Contournement d'obstacles | Implémenté en version simplifiée ... |

## Architecture

- `fr.tp.robotsim` - Point d'entrée (SimulatorApplication)
- `fr.tp.robotsim.controller` - Contrôleur MVC (SimulatorController)
- `fr.tp.robotsim.model` - Modèle (Component, Factory, Robot, Room, etc.)
- `fr.tp.robotsim.model.shape` - Formes géométriques (BasicRectangleShape, BasicOvalShape)
- `fr.tp.robotsim.model.impl` - Implémentation persistance (FileSystemCanvasPersistenceManager)

## Configuration

- `config/SimulatorApplication.launch` : configuration de lancement Eclipse partagée
- `config/logging.properties` : configuration du logging (handlers console + fichier XML)

## Note sur le TP8

Le TP8 a été implémenté dans une version simplifiée par rapport à la spécification :
au lieu d'utiliser une bibliothèque externe (JGraphT ou Graph fait-maison) et l'algorithme
de Dijkstra, j'ai opté pour une approche d'évitement local naïf, codée directement dans
la méthode `move()` de la classe Robot. La méthode `overlays()` ajoutée à `Component`
(et redéfinie dans `Room`) permet de détecter les obstacles. Le robot tente plusieurs
directions avant chaque déplacement, ce qui suffit à contourner les obstacles dans des
configurations simples mais ne garantit pas le chemin optimal...

Limites connues : l'évitement local ne garantit pas le chemin optimal et peut 
laisser un robot bloqué si aucune direction immédiate n'est libre. Une 
implémentation Dijkstra complète aurait été préférable pour gérer ces cas, 
mais elle dépassait le périmètre de ce que j'ai pu réaliser dans le temps imparti.

## AI-Assisted Tool Usage

| Team Member | Declaration |
| ----------- | ----------- |
| [Ton Prénom Nom] | Used Claude AI for guidance on architecture decisions, code review, and debugging help during the TPs |