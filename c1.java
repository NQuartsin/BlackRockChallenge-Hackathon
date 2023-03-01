package c2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class c1{

    public c1(){}

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        c1 task = new c1();
        int[] bots = task.getBots();
        int[] top5 = task.getTop5(bots);

	}

    public int[] act() throws FileNotFoundException{
        int[] bots = getBots();
        int[] top5 = getTop5(bots);
        return top5;

    }

    public int[] getBots() throws FileNotFoundException{

        File file = new File("challenge_1.txt");
		Scanner scan = new Scanner(file);

        ArrayList<Integer> bots = new ArrayList<>();
        // 
	
        int sum = 0;
		while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.length() > 0){
                int n = Integer.parseInt(line) ;
                sum+= n;
            }
            else{
                bots.add(sum);
                sum =0;
            }
		}
        bots.add(sum); // for last bot 
        scan.close();

        int[] botsArr = bots.stream().mapToInt(i -> i).toArray();
        return botsArr;
    }

    /**
     * @param bots
     * @return ArrayList of top5 bots using the cpu
     */
    public int[] getTop5( int[] bots){
        Arrays.sort(bots);
        int[] top5 = new int[5];
        for(int bot=0; bot<5; bot++){
            top5[bot] = bots[bots.length -1 -bot];
        }
        return top5;

    }
}


