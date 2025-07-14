# ♟️ sCacchiMiei - Java Chess Game 

**sCacchiMiei** è un gioco di scacchi sviluppato in Java, con supporto per grafica 2D tramite `Swing` e gestione del progetto tramite `Maven`. È progettato come uno starter kit per chi vuole studiare, migliorare o espandere un motore di scacchi con grafica integrata.

---

## 📁 Struttura del Progetto

src/
└── main/ # Contiene il codice sorgente del progetto
├── java/ # Contiene le classi Java del progetto
│ └── com/
│ └── scacchimiei/
│ ├── GamePanel.java # Game loop e rendering
│ ├── Board.java # Disegno della scacchiera
│ ├── Mouse.java # Gestione input mouse
│ ├── Type.java # Enum per tipo di pezzo
│ └── piece/
│ ├── Piece.java # Classe astratta base
│ ├── Rook.java
│ ├── Bishop.java
│ ├── Knight.java
│ ├── Queen.java
│ ├── King.java
│ └── Pawn.java
└── resources/
└── piece/ # Immagini PNG dei pezzi originali
    ├── w-rook
    ├── w-queen
    ├── w-bishop
    ├── w-king
    ├── w-pawn
    ├── w-knight
    ├── b-rook
    ├── b-queen
    ├── b-bishop
    ├── b-king
    ├── b-knight 
    └── b-pawn

## 🧰 Tecnologie Utilizzate

- **Java 24** 
- **Maven** per la gestione del progetto
- **Swing** per l’interfaccia grafica
- **JUnit 4** per eventuali test

---

## ▶️ Come Eseguire il Progetto

### ✅ Requisiti

- Java JDK **24**
- Maven
- IDE consigliata: IntelliJ IDEA, Eclipse o VS Code
