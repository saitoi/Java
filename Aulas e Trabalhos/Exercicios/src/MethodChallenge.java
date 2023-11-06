public class MethodChallenge {

    public static void main(String[] args) {
        String PlayerName[] = {"Tim", "Bob", "Percy", "Gilbert", "James"};
        int PlayerPosition[] = {1500, 1000, 500, 100, 25};

        for (int i = 0; i < 5; ++i)
            PlayerPosition[i] = calculateHighScorePosition(PlayerPosition[i]);
        for (int i = 0; i < 5; ++i)
            displayHighScore(PlayerName[i], PlayerPosition[i]);

    }

    public static void displayHighScore(String PlayerName, int PlayerPosition) {
        System.out.println(PlayerName + " managed to get into position " + PlayerPosition + " on the high score list.");
    }
    public static int calculateHighScorePosition(int PlayerPosition) {
        if (PlayerPosition >= 1_000)
            return 1;
        else if(PlayerPosition >= 500 && PlayerPosition < 1_000)
            return 2;
        else if(PlayerPosition >= 100 && PlayerPosition < 500)
            return 3;
        else
            return 4;
    }
}
