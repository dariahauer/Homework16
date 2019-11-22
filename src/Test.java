import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

        try {
            CompetitionManagement sportControl = new CompetitionManagement();
            sportControl.addPlayers("stats.csv");
        } catch (IOException | ArrayIndexOutOfBoundsException| NumberFormatException ex) {
            System.err.println("Niepoprawne dane");
        }

    }
}

