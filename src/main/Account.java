package main;

import java.time.LocalDateTime;

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

    public Account(){

    }

    /**
     * Get the date and time the user began using the app
     * @return Date the user began tracking finances
     */
    public LocalDateTime getStartDate(){

        return null;

    }

    /**
     * Get the balance currently stored in the account
     * @return Current user balance
     */
    public double getBalance(){

        return 0.0;

    }

    /**
     * Get the allowance the user is currently receiving each week
     * @return Current user allowance
     */
    public double getAllowance(){

        return 0.0;

    }

    /**
     * Get the next date the user's allowance will rollover
     * @return Next rollover date and time
     */
    public LocalDateTime getNext(){

        return null;

    }

    /**
     * Get the previous date the account rolled over
     * @return Previous rollover date and time
     */
    public LocalDateTime getPrev(){

        return null;

    }

    /**
     * Get an array containing a financial report and a set of recommendations for the user
     * @return A length 2 array containing (0. a report String) and (1. a recommendations String)
     */
    public String[] getAnalytics(){

        return null;

    }

    /**
     * Get a single, random recommendation for the user
     * @return A randomly selected recommendation from analytics
     */
    public String getRec(){

        return "";

    }

    /**
     * Get whether the user is allowed to have cash rollover
     * @return Is the user allowed to have cash rollover
     */
    public boolean isRolloverAllowed(){

        return false;

    }

    /**
     * main.Log a purchase made by the user
     * @param amount the amount of the purchase in dollars
     * @return Did the purchase go through
     */
    public boolean purchase(double amount) {

        return false;

    }

    /**
     * main.Log a payment made to the user
     * @param amount the amount of the payment in dollars
     */
    public void addPayment(double amount) {



    }

    /**
     * Check prev and next against current datetime to determine how many, if any, rollovers have occurred
     */
    public void update(){



    }

    /**
     * Set the current account balance
     * @param amount the amount to set the balance to
     */
    public void setBalance(double amount){



    }

    /**
     * Set the allowance for the account
     * @param amount the amount to set the allowance to
     */
    public void setAllowance(double amount){



    }

    /**
     * Toggle whether or not rollover is allowed
     */
    public void toggleRollover(){



    }

}
