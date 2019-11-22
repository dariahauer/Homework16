import java.util.Comparator;

public class ResultComparator implements Comparator<Player>{
        public int compare(Player p1, Player p2) {
            if(p1.getResult()>p2.getResult())
                return 1;
            else if(p1.getResult()<p2.getResult())
                return -1;
            return 0;
        }
    }

