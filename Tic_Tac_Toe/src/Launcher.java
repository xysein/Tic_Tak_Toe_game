import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Launcher {

    private static final Scanner scanner = new Scanner(System.in);
    static char[] gameField =   {'_','_','_',
                                '_','_','_',
                                '_','_','_'};

    static int xy = 0;              // Position of tern
    static char finish = 4;         // 4 - game start, x - x Won, 0 - 0 Won, 3 - Draw
    static boolean xTern = true;    // Player's tern
    static int count = 0;           // Count of terns
    static boolean bot = false;     // Bot
    static int VS = 0;              // 0 - Human VS Human, 1 - Computer VS Human, 2 - Computer VS Computer
    static int copyVS = Launcher.VS;
    final static Random random = new Random();

    public static void main(String[] args) {

        introduction();

        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println(player1.getUserName() + " VS " + player2.getUserName());

        // ---------------
        do {

            startValues();

            do {
                printGameField();
                enterPosition();
                clearScreen();
                finish = checkFinish();

            } while (finish == 4);


            // ---------------

            printGameField();

            if (finish == 'x') {
                player1.setWinCount();
                System.out.println(player1.getUserName() + " win! ");
            }
            else if (finish == '0'){
                player2.setWinCount();
                System.out.println(player2.getUserName() + " win! ");
            }
            else if (finish == 3) {
                System.out.println("The game ended in a draw =( " );
            }

            System.out.println("Score:\n" + player1.getUserName() + " " + player1.getWinCount()
                    + " - "
                    + player2.getWinCount() + " " + player2.getUserName());

            // ---------------

            System.out.print("Continue? (Y/N) \n");
           // scanner.nextLine();
            String nextRound = scanner.nextLine();
            if (nextRound.equals("Y") || nextRound.equals(""))
                finish = 4;


        } while (finish == 4);

        System.out.println("Bye-Bye! ");
}

    public static void printGameField(){
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0)
                System.out.println();
            System.out.print(gameField[i] + " ");
        }
        System.out.println();
    }

    public static void enterPosition() {
        boolean correctCoordinate = false;
        while (correctCoordinate == false) {

           if (bot) {
               xy = random.nextInt(20) / (random.nextInt(4) + 1);
           }
           else {
               System.out.println("Enter the position number: ");
              xy = scanner.nextInt();
           }

            if (xy >= 0 & xy <= 8 && gameField[xy] == '_')
                correctCoordinate = true;
            else {
                correctCoordinate = false;
                if (!bot)
                System.out.println("Enter the correct coordinates! ");
            }
        }

        // xTern? gameField[xy] = 'x' : gameField[xy] = '0';
        if (xTern)
            gameField[xy] = 'x';
        else
            gameField[xy] = '0';
        xTern = !xTern;

        if (copyVS == 1)
            bot = !bot;
    }

    public static char checkFinish() {
        count++;
        if      (gameField[0] == gameField[1] && gameField[1] == gameField[2] & gameField[0] != '_')
            return gameField[0];
        else if (gameField[3] == gameField[4] && gameField[4] == gameField[5] & gameField[3] != '_')
            return gameField[3];
        else if (gameField[6] == gameField[7] && gameField[7] == gameField[8] & gameField[6] != '_')
            return gameField[6];
        else if (gameField[0] == gameField[3] && gameField[3] == gameField[6] & gameField[0] != '_')
            return gameField[0];
        else if (gameField[1] == gameField[4] && gameField[4] == gameField[7] & gameField[1] != '_')
            return gameField[1];
        else if (gameField[2] == gameField[5] && gameField[5] == gameField[8] & gameField[2] != '_')
            return gameField[2];
        else if (gameField[0] == gameField[4] && gameField[4] == gameField[8] & gameField[4] != '_')
            return gameField[0];
        else if (gameField[2] == gameField[4] && gameField[4] == gameField[6] & gameField[2] != '_')
            return gameField[2];

        if (count == 9)
            return 3;

        return 4;
    }

    public static void clearScreen() {
        for (int i = 0; i < 4; i++) {
            System.out.println();
        }
    }

    public static void startValues() {
        xy = 0;
        xTern = true;
        count = 0;
        for (int i = 0; i < 9; i++) {
            gameField[i] = '_';
        }
        if (copyVS == 1 || copyVS == 2)
            bot = true;
    }

    public static void introduction(){
        System.out.println("\t Hello! \n Its my first JAVA game, so don't judge strictly =) " +
                "The rules are very simple: \n " +
                "\t 0 1 2 \n " +
                "\t 3 4 5 \n " +
                "\t 6 7 8 \n " +
        "Chose game mode: ");

        System.out.println("\t • Human VS Human (0) \n" +
                "\t • Computer VS Human (1) \n " +
                "\t • Computer VS Computer (2)");
        VS = scanner.nextInt();
        copyVS = VS;

        if (VS == 1 || VS == 2)
            bot = true;
    }

    public static void go(){
        //Test
        // test 2
        // test 3
    }
}