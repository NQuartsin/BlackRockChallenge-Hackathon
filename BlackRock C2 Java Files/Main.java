import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is the main class.
 * Challenge #3
 * @author Emily, Kamilia, Naomi, Reema
 * @version 1.03.23
 */
public class Main
{
    // instance variables - replace the example below with your own
    private Bot ada;
    private Bot lovelace;
    private Bot alan;
    private Bot turing;
    private Bot anna;
    private Bot[] botList = new Bot[5];
    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        //initialise the bots
        botList[0]=ada = new Bot(4, "Ada");
        botList[1]=lovelace = new Bot(5, "Lovelace");
        botList[2]=alan = new Bot(3, "Alan");
        botList[3]=turing = new Bot(6, "Turing");
        botList[4]= anna = new Bot(2, "Anna");

        //add the bots securities
        addSecurities();

        //set the trading options for each bot
        ada.setIfAndElseBots(turing, alan);
        lovelace.setIfAndElseBots(ada, turing);
        alan.setIfAndElseBots(anna, lovelace);
        turing.setIfAndElseBots(lovelace, anna);
        anna.setIfAndElseBots(alan, ada);
    }

    /**
     * The main method of the class
     */
    public static void main(String[] args)
    {
        Main main = new Main();
        main.setUp();
    }

    /**
     * Add the initial securities for each bot.
     */
    private void addSecurities()
    {
        ada.addSecurity(3);
        ada.addSecurity(4);
        ada.addSecurity(6);

        lovelace.addSecurity(8);
        lovelace.addSecurity(2);

        alan.addSecurity(5);

        turing.addSecurity(5);
        turing.addSecurity(7);
        turing.addSecurity(9);

        anna.addSecurity(7);
        anna.addSecurity(8);
        anna.addSecurity(9);
    }

    /**
     * Set up the simulation.
     */
    private void setUp()
    {
        doTrades();
        getResults();
    }

    /**
     * Carry out the trades for an 'n' period of time.
     * In this case it is run 2 times.
     */
    private void doTrades()
    {
        for (int i = 0; i<2; i++) {
            ada.tradeThroughSecurities();
            lovelace.tradeThroughSecurities();
            alan.tradeThroughSecurities();
            turing.tradeThroughSecurities();
            anna.tradeThroughSecurities();
        }
    }

    /**
     * Prints the results to the terminal.
     */
    private void getResults()
    {
        Bot[] botArr = sortBots(botList);
        for(int i=0; i< botArr.length; i++){
            System.out.println(botArr[i].resultForBot());        
        }
    }

    /**
     * Sort the bots in descending order of the number of inspections it has made.
     * @return sortedList The list of the bots in descending order of 
     * the number of inspections it has made.
     */ 
    public Bot[] sortBots(Bot[] botList){
        ArrayList<Bot> botArrList = new ArrayList<>(Arrays.asList(botList));
        Bot[] sortedList = new Bot[5];

        for(int i=0; i< botList.length; i++){
            int max = botArrList.get(0).getInspections();
            Bot maxBot =botArrList.get(0);
            int maxInd = 0;
            for(int j=0 ; j <botArrList.size(); j++){
                Bot bot = botArrList.get(j);
                if (max < bot.getInspections()){
                    max = bot.getInspections();
                    maxBot = bot;
                    maxInd = j;
                }
            }
            sortedList[i] = maxBot;
            botArrList.remove(maxInd);            
        }
        return sortedList;
    }
}
