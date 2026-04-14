# ManaGame 🎮
Personal video game collection manager built in Java.

## About
ManaGame is a full-stack Java application that lets you manage your personal video game collection. Built as a first real Java project.

## Features
- Add, edit and delete games from your collection
- Filter by platform, genre and status
- Personal score (0-10) and notes for each game
- Statistics dashboard (total games, average score, best rated)
- Genre chart
- Data persistence in JSON
- Web dashboard accessible from the browser

## Tech Stack
- **Java 21**
- **Javalin 6** — lightweight web framework
- **Gson** — JSON serialization/deserialization
- **Jackson** — JSON mapping for Javalin
- **JUnit 5** — unit testing
- **Git + GitHub** — version control

## How to run
1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Run `Main.java`
4. Open your browser at `http://localhost:7000`

## Project structure
src/

├── Videojuego.java       # Game model

├── Coleccion.java        # Collection logic

├── GestorArchivo.java    # JSON persistence

├── Menu.java             # Console menu

├── Servidor.java         # Javalin web server

└── Main.java             # Entry point

web/

├── index.html            # Web dashboard

└── style.css             # Styles

test/

└── ColeccionTest.java    # JUnit tests

## Author
Ignacio — [@ignaciofloriano-github](https://github.com/ignaciofloriano)

From Spain with love :)