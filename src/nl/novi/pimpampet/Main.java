package nl.novi.pimpampet;

import novi.basics.AES;

import javax.swing.*;
import java.util.Random;

public class Main {
    static Player[] players = new Player[1];
    static Player currentPlayer;
    static int difficultyOption;
    static int rounds;
//  static int numberOfPlayers;

    public static void main(String[] args) {

        // Methoden + volgorde                                      Functie

        intro();                                                    // groet en korte uitleg spelregels

        //numberOfPlayers = getNumberOfPlayers();                   // selectie aantal spelers en terugkoppeling

        players = namePlayers();                                    // invoer naam en terugkoppeling

        rounds = selectRounds(/*numberOfPlayers*/);                 // selectie aantal ronden en terugkoppeling

        String[] categories = selectDifficulty(difficultyOption);   // selectie moeilijkheidsgraad en terugkoppeling

        switchPlayer(players, currentPlayer/* numberOfPlayers*/);   // spelerswissel via de huidige speler met terugkoppeling

        gameMode(rounds, players, categories, currentPlayer);       // spelmodus waarin de spelers de ronde spelen met letter en categorie spelen

        showScore(/*numberOfPlayers,*/ players);                    // laat de score en winnaar zien

        readerWriter();                                             // schrijft en leest de score, past encriptie en decriptie toe

        endGame(categories);                                        // stoppen of terug naar het keuzemenu

        startGame();                                                // geeft de speler in endGame de keuze om het spel opnieuw in te stellen en te starten
    }

    public static void intro() {

        JOptionPane.showMessageDialog(null, "Welkom bij Pim Pam Pet!  (druk op ok)", "Intro", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Dit spel gaat als volgt:", "Intro", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Je krijgt een willekeurige letter van A t/m Z en een categorie in beeld, zoals bv een 'land'", "Intro", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Vervolgens moet je uit deze categorie een voorbeeld noemen die begint met deze willekeurige letter", "Intro", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Bijvoorbeeld, krijg je een P dan kun je bij 'land' Polen noemen of bij 'dier' Parkiet", "Intro", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Om je antwoord te controleren is het handig om internet bij de hand te hebben", "intro", JOptionPane.INFORMATION_MESSAGE);
    }

//    public static int getNumberOfPlayers() {
//        boolean inputAccepted = false;
//        while (!inputAccepted) {
//            try {
//                numberOfPlayers = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecteer 1 of 2 spelers ", "keuzemenu", JOptionPane.INFORMATION_MESSAGE));
//                // do some other validation checks
//                if (numberOfPlayers < 1 || numberOfPlayers > 2) {
//                    JOptionPane.showMessageDialog(null, "Voer 1 of 2 in  ", "Attentie!", JOptionPane.ERROR_MESSAGE);
//                } else {
//                    //JOptionPane.showMessageDialog(null, numberOfPlayers + " speler(s) geselecteerd ", "keuzemenu", JOptionPane.INFORMATION_MESSAGE);
//                    inputAccepted = true;
//                }
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null, "Voer 1 of 2 in  ", "Attentie!", JOptionPane.ERROR_MESSAGE);
//
//            }
//        }
//        return numberOfPlayers;
//    }

    public static Player[] namePlayers() {
//        if (numberOfPlayers == 1) {
//            String name1 = JOptionPane.showInputDialog(null, "Speler 1 typ je naam","naam?", JOptionPane.INFORMATION_MESSAGE);
//            Player player1 = new Player(name1, 0);
//
//            JOptionPane.showMessageDialog(null,"Welkom " + player1.getName() + "!", "keuzemenu", JOptionPane.INFORMATION_MESSAGE);
//            players = new Player[]{player1};
//            return players;
//
//        }
        //if (numberOfPlayers == 2) {
        String name1 = JOptionPane.showInputDialog(null,"Speler 1, typ je naam", "naam?",JOptionPane.INFORMATION_MESSAGE);
        Player player1 = new Player(name1, 0);
        currentPlayer = player1;


        String name2 = JOptionPane.showInputDialog(null,"Speler 2, typ je naam","naam?",JOptionPane.INFORMATION_MESSAGE);
        Player player2 = new Player(name2, 0);

        JOptionPane.showMessageDialog(null, "Welkom " + player1.getName() + " en " + player2.getName(),"Hallo", JOptionPane.INFORMATION_MESSAGE);
        players = new Player[]{player1, player2};
        return players;


//        if (numberOfPlayers == 3) {
//            String name1 = JOptionPane.showInputDialog("Speler 1, typ je naam");
//            Player player1 = new Player(name1, 0);
//            currentPlayer = player1;
//
//            String name2 = JOptionPane.showInputDialog("Speler 2, typ je naam");
//            Player player2 = new Player(name2, 0);
//
//            String name3 = JOptionPane.showInputDialog("Speler 3, typ je naam");
//            Player player3 = new Player(name3, 0);
//
//            JOptionPane.showMessageDialog(null, "Welkom " + player1.getName() + " , " + player2.getName() + " en " + player3.getName());
//
//            players = new Player[]{player1, player2, player3};
//            return players;
//        }
//
//        if (numberOfPlayers == 4) {
//            String name1 = JOptionPane.showInputDialog("Speler 1, typ je naam");
//            Player player1 = new Player(name1, 0);
//            currentPlayer = player1;
//
//            String name2 = JOptionPane.showInputDialog("Speler 2, typ je naam");
//            Player player2 = new Player(name2, 0);
//
//            String name3 = JOptionPane.showInputDialog("Speler 3, typ je naam");
//            Player player3 = new Player(name3, 0);
//
//            String name4 = JOptionPane.showInputDialog("Speler 4, typ je naam");
//            Player player4 = new Player(name4, 0);
//
//            JOptionPane.showMessageDialog(null, "Welkom " + player1.getName() + ", " + player2.getName() + ", " + player3.getName() + " en " + player4.getName());
//            players = new Player[]{player1, player2, player3, player4};
//            return players;
//        }
//
    }

    public static int selectRounds() {
        boolean inputAccepted = false;
        while (!inputAccepted) {
            try {
                rounds = Integer.parseInt(JOptionPane.showInputDialog(null, "selecteer nu het aantal ronden dat jullie willen spelen van 1 t/m 10 ", "keuzemenu", JOptionPane.INFORMATION_MESSAGE));

                if (rounds < 1 || rounds > 10) {
                    JOptionPane.showMessageDialog(null, "Voer een getal van 1 t/m 10 in  ", "Attentie!", JOptionPane.ERROR_MESSAGE);
                } else {
                    //JOptionPane.showMessageDialog(null, rounds + " ronde(s) geselecteerd ", "keuzemenu", JOptionPane.INFORMATION_MESSAGE);
                    inputAccepted = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Voer een getal van 1 t/m 10 in  ", "Attentie!", JOptionPane.ERROR_MESSAGE);
            }
        }
        return rounds * 2;
    }

    public static String[] selectDifficulty(int difficultyOption) {
        //https://stackoverflow.com/questions/3544521/user-input-validation-for-joptionpane-showinputdialog
        boolean inputAccepted = false;
        while (!inputAccepted) {
            try {
                difficultyOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecteer de moeilijkheidsgraad van 1 t/m 3 (makkelijk, gemiddeld of moeilijk)", "keuzemenu", JOptionPane.INFORMATION_MESSAGE));
                // do some other validation checks
                if (difficultyOption < 1 || difficultyOption > 3) {
                    JOptionPane.showMessageDialog(null, "Voer 1,2 of 3 in  ", "Attentie!", JOptionPane.ERROR_MESSAGE);


                } else {
                    //JOptionPane.showMessageDialog(null, "Moeilijkheidsgraad " + difficultyOption + " geselecteerd ", "keuzemenu", JOptionPane.INFORMATION_MESSAGE);
                    inputAccepted = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Voer 1,2 of 3 in  ", "Attentie!", JOptionPane.ERROR_MESSAGE);
            }
        }
        return SelectDifficulty.getCategories(difficultyOption);
    }

    public static Player switchPlayer(Player[] players, Player currentPlayer /*int numberOfPlayers*/) {
//        if (numberOfPlayers == 1) {
//            //currentPlayer =new Player(players[0].getName(),players[0].getScore());
//            currentPlayer = players[0];
//        }
        if (currentPlayer.getName().equals(players[0].getName())) {
            currentPlayer = players[1];
        } else {
            currentPlayer = players[0];
//
            /*
        else if (currentPlayer.getName().equals(players[1].getName())){
            currentPlayer = players[2];
        }
        else if (currentPlayer.getName().equals(players[2].getName())){
            currentPlayer = players[3];
        }
        else if (currentPlayer.getName().equals(players[3].getName())){
            currentPlayer = players[0];
        }*/
        }
        return currentPlayer;
    }

    public static void gameMode(int rounds, Player[] players, String[] categories, Player currentPlayer) {
        for (int i = 0; i < rounds; i++) {

            JOptionPane.showMessageDialog(null, currentPlayer.getName() + " druk op OK om je letter te ontvangen en de ronde te starten","quiz",JOptionPane.INFORMATION_MESSAGE);

            // https://stackoverflow.com/questions/2626835/is-there-functionality-to-generate-a-random-character-in-java

            Random rnd = new Random();
            char c = (char) ('A' + rnd.nextInt(26)); // (char) ('A' + rnd.nextInt(26)) - deze kopieren in regel 235

            Random r = new Random();
            int randomNumber = r.nextInt(categories.length);
            JOptionPane.showInputDialog(null, c + "   " + categories[randomNumber], "quiz",JOptionPane.INFORMATION_MESSAGE);

            int points = JOptionPane.showConfirmDialog(null, currentPlayer.getName() + " is je antwoord correct?", "quiz", JOptionPane.YES_NO_CANCEL_OPTION);
            if (points == 0) {
                currentPlayer.addScore();
                JOptionPane.showMessageDialog(null, currentPlayer.getName() + " je hebt 1 punt verdiend", "quiz",JOptionPane.INFORMATION_MESSAGE);

            } else if (points == 1) {
                JOptionPane.showMessageDialog(null, "Helaas, je hebt geen punt erbij", "quiz",JOptionPane.INFORMATION_MESSAGE);
            }
            currentPlayer = switchPlayer(players, currentPlayer/* numberOfPlayers*/);
        }
    }

    public static void showScore(/*int numberOfPlayers*/ Player[] players) {
//        if (numberOfPlayers == 1) {
//            JOptionPane.showMessageDialog(null, "Je eindscore is " + players[0].getScore() + " punt(en) ");
//        }

        // 1ste mededeling - de score opsomming per speler
//        if (numberOfPlayers == 2) {
        JOptionPane.showMessageDialog(null, "De eindscore is " + players[0].getName() + " met " + players[0].getScore() + " punt(en) en " + players[1].getName() + " met " + players[1].getScore() + " punt(en)", "score",JOptionPane.INFORMATION_MESSAGE);
//        }

        // 2de mededeling - de slotconclusie betreffend de winnaar of gelijkspel
        // Is de players[0] score groter (>) dan die van players[1] of andersom (else), of gelijk(==) ? Dan wordt dit in JOptionpane.showMessageDialog weergegeven

        if (players[0].getScore() > (players[1].getScore())) {
            JOptionPane.showMessageDialog(null, players[0].getName() + " heeft gewonnen!", "uitslag",JOptionPane.INFORMATION_MESSAGE);
        } else if (players[0].getScore() == players[1].getScore()) {
            JOptionPane.showMessageDialog(null, " Dus een gelijkspel","uitslag",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, players[1].getName() + " heeft gewonnen!");
        }
//        Hier dezelfde opzet alleen voor 3 spelers, waarmee het aantal mogelijkheden zijn vergroot. De else functie is hier niet meer handig.
//        if (numberOfPlayers == 3) {
//            JOptionPane.showMessageDialog(null, "De eindscore is " + players[0].getName() + " met " + players[0].getScore() + " punten en " + players[1].getName() + " met " + players[1].getScore() + " punten en " + players[2].getName() + " met " + players[2].getScore() + " punten");
//        }
//        if (players[0].getScore() > players[1].getScore() && players[0].getScore() > players[2].getScore()) {
//            JOptionPane.showMessageDialog(null, players[0].getName() + " heeft gewonnen!");
//            if (players[1].getScore() > players[2].getScore() && players[1].getScore() > players[0].getScore()) {
//                JOptionPane.showMessageDialog(null, players[1].getName() + " heeft gewonnen!");
//            }
//            if (players[2].getScore() > players[0].getScore() && players[2].getScore() > players[1].getScore()) {
//                JOptionPane.showMessageDialog(null, players[2].getName() + " heeft gewonnen!");
//            }
//            if (players[0].getScore() == players[1].getScore() && players[0].getScore() > players[2].getScore()) {
//                JOptionPane.showMessageDialog(null, "Er zijn 2 winnaars: " + players[0].getName() + " en " + players[1].getName() + " !");
//            }
//            if (players[1].getScore() == players[2].getScore() && players[1].getScore() > players[0].getScore()) {
//                JOptionPane.showMessageDialog(null, "Er zijn 2 winnaars: " + players[1].getName() + " en " + players[2].getName() + " !");
//            }
//            if (players[0].getScore() == players[1].getScore() && players[0].getScore() == players[2].getScore() && players[1].getScore() == players[2].getScore()) {
//                JOptionPane.showMessageDialog(null, "Er zijn 3 winnaars: " + players[0].getName() + " en " + players[1].getName() + " en " + players[2].getName() + " !");
//            }
//        }
    }

    public static void readerWriter() {

        new AES();
        final String secretKey = "QWhj83'd<.jjhdu#";

        String tekst = (players[0].getName() + "=" + players[0].getScore() + "\n" + players[1].getName() + "=" + players[1].getScore());
        String encryptedString = AES.encrypt(tekst, secretKey);
        String decryptedString = AES.decrypt(encryptedString, secretKey);

        System.out.println(tekst);
        System.out.println(encryptedString);

        // readerwriter

        ReaderWriter scoreFile = new ReaderWriter();

        scoreFile.write("data", encryptedString);
        scoreFile.read("data", encryptedString);
        AES.decrypt(decryptedString,secretKey);
        System.out.println(decryptedString);

    }

    public static void endGame(String[] categories) {
        int userOption = JOptionPane.showConfirmDialog(
                null,
                "Wil je verder spelen of stoppen?\n" + "Yes (verder), No (stoppen)",
                "Nog een keer?",
                JOptionPane.YES_NO_OPTION);

        if (userOption == JOptionPane.YES_OPTION) startGame();
        else {
            JOptionPane.showMessageDialog(null, "Tot ziens!", "exit",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public static void startGame() {
        //numberOfPlayers = getNumberOfPlayers();
        players = namePlayers();
        rounds = selectRounds(/*numberOfPlayers*/);
        String[] categories = selectDifficulty(difficultyOption);
        switchPlayer(players, currentPlayer/* numberOfPlayers*/);
        gameMode(rounds, players, categories, currentPlayer);
        showScore(/*numberOfPlayers,*/ players);
        endGame(categories);
        startGame();
    }
}





