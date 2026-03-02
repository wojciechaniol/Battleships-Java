# Battleships Game
## About the project
Battleships Game is a digital implementation of the classic board game *Battleships*.
Two players place ships on their boards and take turns attempting
to sink the opponent’s fleet. The player who sinks all enemy ships 
first wins the game.


This project reimagines the traditional paper-based experience and aims to extend
it with additional mechanics and modern online capabilities.

---

## My motivation to create this game
The primary goal of this project is to **learn and practice** technologies required to 
design, implement, and deploy a multiplayer game application.

Beyond the educational aspect, I wanted to **enhance** the traditional Battleships formula.  
After playing many paper-based versions, I noticed the game can become predictable and repetitive.  
This project aims to introduce new mechanics and twists to make the gameplay **more engaging**.

---

## Project Vision (Goal State)
The long-term goal is to build:
- Online Multiplayer mode
- Web-based frontend
- Single-player mode with AI opponents
- Persistent user accounts and statistics stored in a database
- Robust authentication system

---

## Current Status
**Work in Progress**

At the moment, the core game logic is implemented and available as console-based
two-player offline game.
This logic serves as the foundation for future expansion into online
and AI-powered gameplay.

---

## Current Features
- Simple authentication system using a `.txt` file to store registered users.
- Console-based menu implemented using Command Design Pattern
- User registration and login functionality
- Ability to create a new game session
- Base Player class implementation
- Core Battleships game logic

---

## Planned Features
- AI agents for single-player games
- Online multiplayer system using Spring Boot
- Full backend communication architecture
- Database integration for:
  - User accounts
  - Game statistics
- Improved Authentication System
- Web frontend (HTML, CSS, JavaScript)
- Gameplay extensions and additional mechanics

---

## How to run
There is no need to install Gradle, you can use wrapper which is included in this project.

On macOS / Linux in terminal in the directory of the project run:
`./gradlew build`
and then:
`./gradlew run`

On Windows:
`./gradlew.bat build`
and then:
`./gradlew.bat run`

## Tech Stack
List of the technologies used (or planned to future use) in the project:
- Java
- Gradle
- Docker (planned deployment)
- Spring Boot (planned integration)
- HTML / CSS / JavaScript (planned frontend)

## License
This project is licensed under the MIT License - see the LICENSE file for more details.



