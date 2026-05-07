# Robotsim - Simulateur d'usine robotisée

Maxime Sautour

## Architecture

*   `fr.tp.robotsim` - Point d'entrée (SimulatorApplication)
*   `fr.tp.robotsim.controller` - Contrôleur MVC (SimulatorController)
*   `fr.tp.robotsim.model` - Modèle (Component, Factory, Robot, etc.)
*   `fr.tp.robotsim.model.shape` - Formes géométriques
*   `fr.tp.robotsim.model.impl` - Implémentation persistance

## Configuration

Le launch Eclipse est sauvegardé dans `config/SimulatorApplication.launch`.
Le fichier `config/logging.properties` configure le logging (console + fichier XML).

## AI-Assisted Tool Usage

| Team Member | Declaration |
| :--- | :--- |
| [Sautour Maxime] | Used Claude AI for guidance on architecture decisions, code review, and debugging help during the TPs |