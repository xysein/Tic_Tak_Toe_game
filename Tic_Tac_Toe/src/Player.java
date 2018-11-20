import java.util.Scanner;

public class Player {

    private static final Scanner scanner = new Scanner(System.in);
    private String userName;
    private int winCount;
    static boolean first = true;

    public Player(){
        if (Launcher.VS == 0) {
            if (first)
                System.out.println("Enter the first player's name: ");
            else
                System.out.println("Enter the second player's name: ");


            String name = scanner.nextLine();
            this.userName = name;
            this.winCount = 0;
        }
        else {
            this.userName = "Computer";
            this.winCount = 0;
            Launcher.VS--;
        }
        first = false;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setWinCount(){
        this.winCount++;
    }

    public int getWinCount() {
        return this.winCount;
    }
}
