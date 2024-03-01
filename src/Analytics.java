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
     * Calculates a new report and set of recommendations
     */
    private void calculate() {

    }

    /**
     * Get the internal list of all purchase/payment logs
     * @return List of all stored logs
     */
    public ArrayList<Log> getLogs(){

        return null;

    }

    /**
     * Get the internal list of all purchase/payment logs in a parsed, print-ready String format
     * @return List of all stored logs as a human-readable String
     */
    public String getLogsToString(){

        return "";

    }

    /**
     * Get a processed report of financial activity
     * @return Print-ready String report of financial activity
     */
    public String getReport(){

        return "";

    }

    /**
     * Get a random financial recommendation from the internal list
     * @return A randomly-chosen financial recommendation, or an empty string if no recommendations exist
     */
    public String getRec(){

        return "";

    }

    /**
     * Get the full list of recommendations
     * @return List of all stored recommendations
     */
    public ArrayList<String> getRecs(){

        return null;

    }

}
