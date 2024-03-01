import java.time.LocalDateTime;

/**
 * Log data class for CA$HTRACK
 * @author Kieran Bentley
 * @version 1.0
 */

public class Log {

    private LogType type;
    private double amount;
    private double allowanceAtTime;
    private LocalDateTime dateTimeAtTime;

    public Log(LogType type, double amount, double allowanceAtTime, LocalDateTime dateTimeAtTime){

        this.type = type;
        this.amount = amount;
        this.allowanceAtTime = allowanceAtTime;
        this.dateTimeAtTime = dateTimeAtTime;

    }

    /**
     * Get the type of a given log
     * @return The type of log this is (Purchase or Payment)
     */
    public LogType getType(){

        return null;

    }

    /**
     * Get the amount this log was made for
     * @return The amount of the log
     */
    public double getAmount(){

        return 0.0;

    }

    /**
     * Get the set allowance at the time of the log
     * @return The allowance at the time the log was created
     */
    public double getAllowanceAtTime(){

        return 0.0;

    }

    /**
     * Get the time and date the log was created
     * @return The exact time and date the log was created
     */
    public LocalDateTime getDateTimeAtTime() {

        return null;

    }
}
