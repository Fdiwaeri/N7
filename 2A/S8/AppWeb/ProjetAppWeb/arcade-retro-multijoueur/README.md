# Site d'Arcade Rétro Multijoueur 🕹️
(English version below)

Ce projet a pour objectif de développer une plateforme web d'arcade rétro permettant à plusieurs joueurs de s'affronter en temps réel dans une sélection de mini-jeux. Le système est optimisé pour des joueurs connectés depuis des machines différentes sur le même réseau local.

L'interface s'inspire de l'esthétique des bornes d'arcade des années 70-80 avec du pixel art, une palette de couleurs contrastée et des typographies rétro. 

## Fonctionnalités Principales

* **Gestion des comptes** : Inscription, connexion sécurisée par token (JWT), profils et historique des scores. 
* **Catalogue de jeux** : Présentation des mini-jeux avec vignettes et descriptions.
* **Système d'invitation** : Les joueurs peuvent s'inviter en temps réel par pseudo.
* **Multijoueur en temps réel** : Synchronisation bidirectionnelle de l'état du jeu via WebSockets.
* **Leaderboard** : Classement compétitif mis à jour après chaque partie.

## Les Mini-Jeux Intégrés

* **Tic-Tac-Toe** : Le morpion classique en 3x3.
* **Connect 4** : Puissance 4 sur une grille de 6x7.
* **Battleship** : Bataille navale au tour par tour.
* **Brawlbots** : Combat de robots où les actions sont résolues simultanément.
* **Match Masters** : Mini-jeu d'affrontement sur plusieurs manches au score cumulatif.
* **Asteroid Duel** : Jeu d'action spatial. Il est inclus dans le code source mais n'est pas jouable en multijoueur, car notre architecture basée sur les WebSockets introduit une latence incompatible avec la synchronisation à très haute fréquence requise pour ce type de jeu en temps réel.

## Pile Technologique (Architecture 3 Tiers)

L'application repose sur une architecture client-serveur classique couplée à un canal WebSocket.

**Frontend** :
* React 18 & React Router
* Axios (avec intercepteur pour injecter le JWT)
* STOMP.js & Sock.JS-client

**Backend** :
* Java 17 & Spring Boot 3
* Spring Data JPA & Hibernate
* Spring WebSocket (Message Broker)
* Sécurité : JWT (jjwt)

**Base de Données** :
* MySQL 8

## Installation et Lancement (Développement Local)

### Prérequis
* Node.js et npm
* Java 17 et Maven
* Serveur MySQL 8 en cours d'exécution

### 1. Configuration de la Base de Données
* Créez une base de données MySQL nommée `arcade_db` (ou selon votre configuration).
* Modifiez le fichier `backend/src/main/resources/application.properties` pour y insérer vos identifiants de base de données locaux (ne commitez pas vos mots de passe de production).

### 2. Lancement du Backend (Spring Boot)
Dans un terminal dans `/backend` :
```bash
./mvnw spring-boot:run
```

### 3. Lancement du Frontend (React)
Dans un terminal dans `/frontend` :
```bash
npm install
npm start
```

L'application sera accessible sur http://localhost:3000.

Ce projet a été réalisé en équipe durant mon année universitaire 2025-2026.


# Retro Multiplayer Arcade Platform 🕹️

This project is a web-based retro arcade platform allowing multiple players to compete in real-time across a selection of mini-games. The system is designed and optimized for players connected from different devices on the same local network.

The user interface draws inspiration from the aesthetics of 70s and 80s arcade cabinets, featuring pixel art, high-contrast color palettes, and retro typography.

## Core Features

* **Account Management**: Secure registration and login using JSON Web Tokens (JWT), user profiles, and score history.
* **Game Catalog**: Browsable selection of available mini-games with thumbnails and descriptions.
* **Dynamic Invitation System**: Players can invite each other in real-time using their usernames.
* **Real-Time Multiplayer**: Bidirectional game state synchronization powered by WebSockets.
* **Leaderboard**: Competitive ranking system updated automatically after each match.

## Available Mini-Games

* **Tic-Tac-Toe**: Features the classic 3x3 grid.
* **Connect 4**: Standard 6x7 grid with red and yellow tokens.
* **Battleship**: Turn-based tactical naval combat.
* **Brawlbots**: Turn-based robot combat where chosen actions (attack, shield, heal) are resolved simultaneously.
* **Match Masters**: A multi-round cumulative score challenge.
* **Asteroid Duel**: A real-time space action game. It is included in the source code but is not fully functional in multiplayer, as our WebSocket-based architecture introduces a latency that conflicts with the high-frequency synchronization required for this specific type of game.

## Technology Stack

The application is built on a classic 3-tier architecture enhanced with a WebSocket channel.

**Frontend** :
* React 18 & React Router
* Axios
* STOMP.js & Sock.JS-client

**Backend** :
* Java 17 & Spring Boot 3
* Spring Data JPA & Hibernate
* Spring WebSocket

**Security** :
* JWT (jjwt)

**Database** :
* MySQL 8 (via JDBC / Hibernate)

## Setup and Installation

### Prerequisites

* Node.js and npm
* Java 17 and Maven
* MySQL 8 Server running locally

### 1. Database Configuration

* Create a local MySQL database (named `arcade_db` for example).
* Update the `backend/src/main/resources/application.properties` file with your local database credentials.

### 2. Running the Backend (Spring Boot)

In a terminal in `/backend` :
```
./mvnw spring-boot:run
```

### 3. Running the Frontend (React)

In a terminal in `/frontend` :
```
npm install
npm start
```

The application will be accessible at http://localhost:3000.

This team project was developed during my 2025-2026 academic year.
