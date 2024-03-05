package main;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Finance data analytics class for CA$HTRACK
 * Stores, manages and analyzes purchase logs and produces reports and recommendations
 * @author Kieran Bentley
 * @version 1.0
 */

public class Analytics {

    private ArrayList<Log> logs;
    private ArrayList<String> recs;

    public Analytics(ArrayList<Log> logs, ArrayList<String> recs){

        this.logs = logs;
        this.recs = recs;

    }

    /**
     * Enters a log into the analytics object from a log object
     * @param log the log to be entered
     */
    public void log(Log log){

        logs.add(log);

    }

    /**
     * Enters a log into the analytics object from raw log data
     * @param type the type of the log being entered
     * @param dateTime the date and time the log was made
     * @param amount the amount of the log being entered
     * @param allowanceAtTime the allowance at the time the log was entered
     */
    public void log(LogType type, LocalDateTime dateTime, double amount, double allowanceAtTime){

        logs.add(new Log(type, amount, allowanceAtTime, dateTime));

    }

    /**
     * Calculates a new report and set of recommendations
     */
    private void calculate() {

    }

    /**
     * Get the internal list of all purchase/payment logs
     * @return List of all stored logs
     */
    public ArrayList<Log> getLogs(){

        return logs;

    }

    /**
     * Get the internal list of all purchase/payment logs in a parsed, print-ready String format
     * @return List of all stored logs as a human-readable String
     */
    public String getLogsToString(){

        String logsString = "== ALL LOGS ==\n";
        int index = 1;
        for(Log l : logs){
            logsString = logsString.concat(
                    "" + index + ". " + l.getType() + " at "
                            + l.getDateTimeAtTime() + ": $"
                            + l.getAmount() + " / $" + l.getAllowanceAtTime() + "\n"
            );
            index++;
        }
        return logsString;

    }

    /**
     * Get a processed report of financial activity
     * @return Print-ready String report of financial activity
     */
    public String getReport(){
        if (logs.size() == 0){
            return "No transactions have been logged.";
        }
        return "PLACEHOLDER FOR REPORT";

    }

    /**
     * Get a random financial recommendation from the internal list
     * @return A randomly-chosen financial recommendation, or an empty string if no recommendations exist
     */
    public String getRec(){

        if (logs.size() == 0) {
            return "No transactions have been logged.";
        }
        return "PLACEHOLDER FOR REC";

    }

    /**
     * Get the full list of recommendations
     * @return List of all stored recommendations
     */
    public ArrayList<String> getRecs(){

        return recs;

    }

}
