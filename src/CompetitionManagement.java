import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CompetitionManagement {

    void addPlayers(String fileName) throws IOException {
        String userData;
        String[] userDataTable;
        List<Player> players = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj wynik  gracza Imie Nazwisko wynik (lub stop): ");
        userData = scan.nextLine();
        while (!(userData.equals("stop"))) {
            userDataTable = userData.split(" ");
            players.add(new Player(userDataTable[0], userDataTable[1], Integer.valueOf(userDataTable[2])));
            System.out.println("Podaj wynik kolejnego gracza Imie Nazwisko wynik (lub stop): ");
            userData = scan.nextLine();
        }
        scan.close();
        saveToFile(fileName, players);
        System.out.println("Dane posortowano i zapisano do pliku stats.csv.");
    }

    private void saveToFile(String fileName, List<Player> players) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bfw = new BufferedWriter(fileWriter);
        ResultComparator resultComparator = new ResultComparator();
        Collections.sort(players, resultComparator);
        for (int i = 0; i < players.size(); i++) {
            bfw.write(players.get(i).getPlayerData());
            bfw.newLine();
        }
        bfw.close();
        fileWriter.close();;
    }
}
