import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Utility file reader/writer class for CA$HTRACK
 * @author Kieran Bentley
 * @version 1.0
 */

public class Writer {

    private String destination;

    public Writer(String destination){

        this.destination = destination;

    }

    /**
     * Write current in-memory data to file for future access
     * @param balance the user's current balance
     * @param prev the previous rollover date
     * @param next the next rollover date
     * @param rolloverAllowed is cash rollover allowed
     * @param allowance weekly user allowance
     * @param logs list of logs obtained from analytics
     * @param recs list of recs obtained from analytics
     */
    public void write(
            double balance,
            LocalDateTime prev,
            LocalDateTime next,
            boolean rolloverAllowed,
            double allowance,
            ArrayList<Log> logs,
            ArrayList<String> recs
    ) {



    }

    /**
     * Read the user's balance at the last logout date
     * @return Last recorded user balance
     */
    public double readBalance(){

        return 0.0;

    }

    /**
     * Read the date the user began tracking
     * @return Date and time user began tracking finances
     */
    public LocalDateTime readStartDate(){

        return null;

    }

    /**
     * Read the allowance the user most recently set for themselves
     * @return Current user allowance
     */
    public double readAllowance(){

        return 0.0;

    }

    /**
     * Read the date and time of the most recent rollover at the time of last logout
     * @return Most recent rollover date and time recorded
     */
    public LocalDateTime readPreviousRollover(){

        return null;

    }

    /**
     * Read the date and time of the next rollover at the time of last logout
     * @return Most recent upcoming rollover date and time recorded
     */
    public LocalDateTime readNextRollover(){

        return null;

    }

    /**
     * Read whether user has set cash rollover to be allowed
     * @return Has the user allowed cash rollover
     */
    public boolean readIsRolloverAllowed(){

        return false;

    }

    /**
     * Read the data from the most recently stored analytics object
     * @return A reinstantiated Analytics object built from most recent data
     */
    public Analytics readAnalytics(){

        return null;

    }
}
