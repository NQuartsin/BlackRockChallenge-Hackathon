import java.time.LocalTime;

public class Bonus {
    public Bonus(){}

    public static void main(String[] args) {
        Bonus task = new Bonus();
        task.isTooOften();
    }

    public boolean isTooOften(){
        // if you trade more than 100 inspections in 5 minutes you're more likely to be a malicious bot
        LocalTime start = LocalTime.now();
        LocalTime newTime = start.plusMinutes(5);
        int val = LocalTime.now().compareTo(newTime);
        int nTrades=0;
        while (val <0 ){ // while it has not been more than 5 minutes from start time
            trade(); // the bot trades
            nTrades++;
            val = LocalTime.now().compareTo(newTime);
        }

        // After 5 minutes check if it tradesd more than 100 inspections 
        if(nTrades > 100)
            return true;

        return false;
    }

    public void trade(){
        // implements the trade of the bot
    }
}
