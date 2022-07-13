package nl.novi.pimpampet;
public class SelectDifficulty {

    private static final String[] categoryA = {"Land", "Dier", "Bloem of Plant", "Acteur", "Actrice", "Film", "Serie", "Fictief persoon in boek", "Fictief persoon in film", "Automerk", "Zanger", "Zangeres", "Boek", "Jongensnaam", "Meisjesnaam", "Eten en drinken", "Menselijk Lichaam"};
    private static final String[] categoryB = {"Land", "Dier", "Bloem of Plant", "Acteur", "Actrice", "Film", "Serie", "Fictief persoon in boek", "Fictief persoon in film", "Automerk", "Zanger", "Zangeres", "Boek", "Jongensnaam", "Meisjesnaam", "Eten en drinken", "Menselijk Lichaam", "(m.b.t.)Schilderkunst", "Ziekte", "Historische gebeurtenis", "Gezegde (Y of Z = A of B)", "Historisch figuur (sterfdatum vóór 1900)", "Wetenschap", "Ambacht"};
    private static final String[] categoryC = {"(m.b.t.)Schilderkunst", "Ziekte", "Historische gebeurtenis", "Gezegde (Y of Z = A of B)", "Historisch figuur (sterfdatum vóór 1900)", "Wetenschap", "Ambacht", "Klassieke Muziek", "Oudheid", "Planeet of ster", "Astronomie", "Koning(in) of heerser uit de geschiedenis", "Wapen(tuig)", "Computers", "Insect (uitgezonderd Q of X, kies dan A of B)"};

    public static String[] getCategories(int difficultyOption) {
        if (difficultyOption == 1) {
            return categoryA;
        } else if (difficultyOption == 2) {
            return categoryB;
        } else if (difficultyOption == 3) {
            return categoryC;
        }
        return null;
    }
}
