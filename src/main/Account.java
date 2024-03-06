package main;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * main.Account class for CA$HTRACK
 * Manages purchases and payments as well as allowances and rollovers
 * @author Kieran Bentley
 * @version 1.0
 */

public class Account {

    private LocalDateTime startDate;
    private double balance;
    private double allowance;
    private LocalDateTime prevRollover;
    private LocalDateTime nextRollover;
    private boolean rolloverAllowed;
    private Analytics analytics;
    private Writer writer;

    public Account() throws IOException {

        writer = new Writer("src/main/cashtrack.txt");
        startDate = writer.readStartDate();
        balance = writer.readBalance();
        allowance = writer.readAllowance();
        prevRollover = writer.readPreviousRollover();
        nextRollover = writer.readNextRollover();
        rolloverAllowed = writer.readIsRolloverAllowed();
        analytics = writer.readAnalytics();

        update();

    }

    /**
     * Get the date and time the user began using the app
     * @return Date the user began tracking finances
     */
    public LocalDateTime getStartDate(){

        return startDate;

    }

    /**
     * Get the balance currently stored in the account
     * @return Current user balance
     */
    public double getBalance(){

        return balance;

    }

    /**
     * Get the allowance the user is currently receiving each week
     * @return Current user allowance
     */
    public double getAllowance(){

        return allowance;

    }

    /**
     * Get the next date the user's allowance will rollover
     * @return Next rollover date and time
     */
    public LocalDateTime getNext(){

        return nextRollover;

    }

    /**
     * Get the previous date the account rolled over
     * @return Previous rollover date and time
     */
    public LocalDateTime getPrev(){

        return prevRollover;

    }

    /**
     * Get an array containing a financial report and a set of recommendations for the user
     * @return A length 2 array containing (0. a report String) and (1. a recommendations String)
     */
    public String[] getAnalytics(){

        String[] analyticsArray = {analytics.getReport(), analytics.getRec()};
        return analyticsArray;

    }

    /**
     * Get a single, random recommendation for the user
     * @return A randomly selected recommendation from analytics
     */
    public String getRec(){

        return analytics.getRec();

    }

    /**
     * Get whether the user is allowed to have cash rollover
     * @return Is the user allowed to have cash rollover
     */
    public boolean isRolloverAllowed(){

        return rolloverAllowed;

    }

    /**
     * main.Log a purchase made by the user
     * @param amount the amount of the purchase in dollars
     * @return Did the purchase go through
     */
    public boolean purchase(double amount) {

        if (balance < amount) {
            return false;
        }

        balance -= amount;
        analytics.log(LogType.PURCHASE, LocalDateTime.now(), amount, allowance);
        return true;

    }

    /**
     * main.Log a payment made to the user
     * @param amount the amount of the payment in dollars
     */
    public void addPayment(double amount) {

        balance += amount;
        analytics.log(LogType.PAYMENT, LocalDateTime.now(), amount, allowance);

    }

    /**
     * Check prev and next against current datetime to determine how many, if any, rollovers have occurred
     */
    public void update(){

        if(LocalDateTime.now().isAfter(nextRollover)){
            double delta = LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(0)) - prevRollover.toEpochSecond(ZoneOffset.ofHours(0));
            int deltaWeeks = (int) delta / 604800;
            if(!rolloverAllowed){
                balance = allowance;
            }
            else {
                for (int ndx = 0; ndx < deltaWeeks; ndx++) {
                    balance += allowance;
                }
            }
            prevRollover = prevRollover.plusWeeks(deltaWeeks);
            nextRollover = nextRollover.plusWeeks(deltaWeeks);
        }

    }

    /**
     * Set the current account balance
     * @param amount the amount to set the balance to
     */
    public void setBalance(double amount){

        balance = amount;

    }

    /**
     * Set the allowance for the account
     * @param amount the amount to set the allowance to
     */
    public void setAllowance(double amount){

        allowance = amount;

    }

    /**
     * Toggle whether or not rollover is allowed
     */
    public void toggleRollover(){

        rolloverAllowed = !rolloverAllowed;

    }

    public void save() throws IOException{

        writer.write(
                balance,
                prevRollover,
                nextRollover,
                rolloverAllowed,
                allowance,
                analytics.getLogs(),
                analytics.getRecs()
        );

    }

}
