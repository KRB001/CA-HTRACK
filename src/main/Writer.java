package main;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Utility file reader/writer class for CA$HTRACK
 * @author Kieran Bentley
 * @version 1.0
 */

public class Writer {

    private String destination;
    FileReader fileReader = null;
    LineNumberReader lineNumberReader = null;


    public Writer(String destination) throws FileNotFoundException{

        this.destination = destination;

        try {
            File file = new File(destination);
            file.createNewFile();
        }
        catch (IOException e) {

        }

        try {
            fileReader = new FileReader(destination);
            lineNumberReader = new LineNumberReader(fileReader);
            lineNumberReader.mark(5000);
        }
        catch (IOException f) {

            throw new FileNotFoundException("There is no file at " + destination);

        }

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

    ) throws IOException {

        FileWriter writer = new FileWriter(destination);

        String startDate = String.valueOf(readStartDate());
        int rolloverAllowedInt = 0;
        if(rolloverAllowed) { rolloverAllowedInt = 1; }
        String outputString = "" + startDate + "\n" +
                balance + "\n" +
                prev + "\n" +
                next + "\n" +
                rolloverAllowedInt + "\n" +
                allowance + "\n" +
                "-logs\n";
        for(Log l : logs){
            String tempLog = "" + l.getType() + "/" + l.getAmount() + "/" +
                    l.getAllowanceAtTime() + "/" + l.getDateTimeAtTime();
            outputString = outputString.concat("" + tempLog + "\n");
        }
        outputString = outputString.concat("-recs\n");
        for(String r : recs){
            outputString = outputString.concat("" + r + "\n");
        }

        writer.write(outputString);
        writer.close();

    }

    /**
     * Read the user's balance at the last logout date
     * @return Last recorded user balance
     */
    public double readBalance() throws IOException{

        lineNumberReader.reset();
        while(lineNumberReader.getLineNumber() < 1){
            lineNumberReader.readLine();
        }

        return Double.parseDouble(lineNumberReader.readLine());

    }

    /**
     * Read the date the user began tracking
     * @return Date and time user began tracking finances
     */
    public LocalDateTime readStartDate() throws IOException{

        lineNumberReader.reset();
        return LocalDateTime.parse(lineNumberReader.readLine(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

    }

    /**
     * Read the allowance the user most recently set for themselves
     * @return Current user allowance
     */
    public double readAllowance() throws IOException{

        lineNumberReader.reset();
        while(lineNumberReader.getLineNumber() < 5){
            lineNumberReader.readLine();
        }

        return Double.parseDouble(lineNumberReader.readLine());

    }

    /**
     * Read the date and time of the most recent rollover at the time of last logout
     * @return Most recent rollover date and time recorded
     */
    public LocalDateTime readPreviousRollover() throws IOException{

        lineNumberReader.reset();
        while(lineNumberReader.getLineNumber() < 2){
            lineNumberReader.readLine();
        }
        return LocalDateTime.parse(lineNumberReader.readLine(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

    }

    /**
     * Read the date and time of the next rollover at the time of last logout
     * @return Most recent upcoming rollover date and time recorded
     */
    public LocalDateTime readNextRollover() throws IOException{

        lineNumberReader.reset();
        while(lineNumberReader.getLineNumber() < 3){
            lineNumberReader.readLine();
        }
        return LocalDateTime.parse(lineNumberReader.readLine(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

    }

    /**
     * Read whether user has set cash rollover to be allowed
     * @return Has the user allowed cash rollover
     */
    public boolean readIsRolloverAllowed() throws IOException{

        lineNumberReader.reset();
        while(lineNumberReader.getLineNumber() < 4){
            lineNumberReader.readLine();
        }
        int isAllowedInt = Integer.parseInt(lineNumberReader.readLine());
        return isAllowedInt == 1;

    }

    /**
     * Read the data from the most recently stored analytics object
     * @return A reinstantiated Analytics object built from most recent data
     */
    public Analytics readAnalytics() throws IOException{

        lineNumberReader.reset();
        while(lineNumberReader.getLineNumber() < 7){
            lineNumberReader.readLine();
        }

        ArrayList<Log> logs = new ArrayList<>();
        ArrayList<String> recs = new ArrayList<>();
        String current = "";

        while(!current.equals("-recs")){

            current = lineNumberReader.readLine();
            if(!current.equals("-recs")){

                LogType type = null;
                double amount = 0;
                double allowance = 0;
                LocalDateTime dateTime = null;

                String[] currentSplit = current.split("/");
                if(currentSplit[0].equals("PURCHASE")){
                    type = LogType.PURCHASE;
                }
                else { type = LogType.PAYMENT; }

                amount = Double.parseDouble(currentSplit[1]);
                allowance = Double.parseDouble(currentSplit[2]);
                dateTime = LocalDateTime.parse(currentSplit[3], DateTimeFormatter.ISO_LOCAL_DATE_TIME);

                logs.add(new Log(type, amount, allowance, dateTime));

            }

        }

        while(current != null){

            current = lineNumberReader.readLine();

            if (current != null){

                recs.add(current);

            }

        }

        return new Analytics(logs, recs);

    }
}
