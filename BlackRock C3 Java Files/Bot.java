import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is a Bot
 * Blackrock is awesome!
 * @author Emily, Kamilia, Naomi, Reema
 * @version 2.03.23
 */
public class Bot
{
    private int ruleNum;
    private ArrayList<Long> securities;
    private Bot ifBot;
    private Bot elseBot;
    private int inspectCount;
    private String name;
    
    /**
     * Constructor for objects of class Bot
     * @param ruleNum The number the security should be divisible by
     * @param name The name of the Bot
     */
    public Bot(int ruleNum, String name)
    {
        // initialise instance variables
        inspectCount = 0;
        this.name = name;
        this.ruleNum = ruleNum;
        securities = new ArrayList<>();
    }

    /**
     * Multiply the security by itself
     *
     * @param  security  The security of the given bot.
     * @return security The altered security of the given bot.
     */
    public long alterSecurity(long security)
    {
        if (security <1000)
            security = security*security ;
        return security;
    }
    
    /**
     * Check trading rule
     * 
     * @param alteredSecurity The altered security that's being checked.
     * @return True If the altered security is divisible by the rule number.
     */
    public Boolean checkTrade(long alteredSecurity)
    {
        return (alteredSecurity % ruleNum == 0);
    }
    
    /**
     * Add security to the securities Array List.
     */
    public void addSecurity(long y)
    {
        securities.add(y);
    }
    
    /**
     * The trade function.
     * Checks through the bot's trade rule to determine which bot to trade with.
     * 
     * @param x The security
     */
    private void trade(long x)
    {
        long value = alterSecurity(x);
        if (checkTrade(value)) {
            ifBot.addSecurity(value);
        }
        else {
            elseBot.addSecurity(value);
        }
    }
    
    /**
     * Go through each security in the Array List.
     * And trades them to the right bot.
     * Increases the number of inspections each time.
     * 
     */
    public void tradeThroughSecurities()
    {
        
        for (int i = 0; i< securities.size(); i++) {
            trade(securities.get(i));
            inspectCount++;
        }
        securities.clear();
    }
    
    /**
     * Return the number of inspections a bot has made.
     * 
     * @return inspectCount The number of inspections a bot has made.
     */
    public int getInspections()
    {
        return inspectCount;
    }
    
    /**
     * Return the name of the given bot.
     * 
     * @return name The name of the given bot.
     */
    public String returnName()
    {
        return "Bot " + name;
    }
    
    /**
     * Return string of the name and inpsection count of the given bot.
     * 
     * @return The name and inpsection count of the given bot.
     * 
     */
    public String resultForBot()
    {
        return returnName() + ": " + getInspections();
    }
    
    /**
     * Set the trading options for the bot.
     * ifBot is the bot traded with if the trade rule is met.
     * elseBot is the bot traded with if the trade rule isn't met.
     * 
     * @param botA The bot assigned to the ifBot.
     * @param botB The bot assigned to the elseBot.
     */
    public void setIfAndElseBots(Bot botA, Bot botB)
    {
        ifBot = botA;
        elseBot = botB;
    }
}
