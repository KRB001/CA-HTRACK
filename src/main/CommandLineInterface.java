package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * CLI for CA$HTRACK
 * @author Kieran Bentley
 * @version 1.0
 */
public class CommandLineInterface {

    public CommandLineInterface(){

    }

    public static void launch() throws IOException {

        for(int ndx = 0; ndx < 20; ndx++){
            System.out.println("\n");
        }

        Account account = new Account();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("  /$$$$$$   /$$$$$$     /$$    /$$   /$$ /$$$$$$$$ /$$$$$$$   /$$$$$$   /$$$$$$  /$$   /$$\n" +
                " /$$__  $$ /$$__  $$  /$$$$$$ | $$  | $$|__  $$__/| $$__  $$ /$$__  $$ /$$__  $$| $$  /$$/\n" +
                "| $$  \\__/| $$  \\ $$ /$$__  $$| $$  | $$   | $$   | $$  \\ $$| $$  \\ $$| $$  \\__/| $$ /$$/ \n" +
                "| $$      | $$$$$$$$| $$  \\__/| $$$$$$$$   | $$   | $$$$$$$/| $$$$$$$$| $$      | $$$$$/  \n" +
                "| $$      | $$__  $$|  $$$$$$ | $$__  $$   | $$   | $$__  $$| $$__  $$| $$      | $$  $$  \n" +
                "| $$    $$| $$  | $$ \\____  $$| $$  | $$   | $$   | $$  \\ $$| $$  | $$| $$    $$| $$\\  $$ \n" +
                "|  $$$$$$/| $$  | $$ /$$  \\ $$| $$  | $$   | $$   | $$  | $$| $$  | $$|  $$$$$$/| $$ \\  $$\n" +
                " \\______/ |__/  |__/|  $$$$$$/|__/  |__/   |__/   |__/  |__/|__/  |__/ \\______/ |__/  \\__/\n" +
                "                     \\_  $$_/                                                             \n" +
                "                       \\__/                                                               \n" +
                "                                                                                          ");

        System.out.println("\n\nWELCOME TO CA$HTRACK - SELECT AN OPTION TO CONTINUE");
        String interfaceChoice = "";

        while(!interfaceChoice.equals("esc")){
            System.out.println("\n\t[trk]\ttrack finances with budget and allowances");
            System.out.println("\t[log]\tlog finances without budgetary restrictions");
            System.out.println("\t[any]\tget a financial analytics report");
            System.out.println("\t[adv]\tget some advice based on your financial activity");
            System.out.println("\t[acc]\tupdate your account information");
            System.out.println("\t[esc]\texit the program");

            interfaceChoice = reader.readLine();

            if(interfaceChoice.equals("trk")){
                track(reader, account);
            }
            else if(interfaceChoice.equals("log")){
                trackSandbox(reader, account);
            }
            else if(interfaceChoice.equals("any")){
                getAnalytics(reader, account);
            }
            else if(interfaceChoice.equals("adv")){
                getAdvice(account);
            }
            else if(interfaceChoice.equals("acc")){
                updateAccount(reader, account);
            }
            else if(interfaceChoice.equals("esc")){
                account.save();
                System.out.println("\nThanks for using CA$HTRACK!");
            }
            else{
                System.out.println("'" + interfaceChoice + "' is not a valid command");
            }

        }

    }

    /**
     * Enter dialogue for budgeted purchase tracking
     */
    private static void track(BufferedReader reader, Account account) {



    }

    /**
     * Enter dialogue for sandbox purchase tracking
     */
    private static void trackSandbox(BufferedReader reader, Account account) {

        System.out.println("SYSTEM IS UNDER CONSTRUCTION");

    }

    /**
     * Enter dialogue for updating account info and settings
     */
    private static void updateAccount(BufferedReader reader, Account account) {

        System.out.println("SYSTEM IS UNDER CONSTRUCTION");

    }

    /**
     * Enter dialogue for getting analytics information
     */
    private static void getAnalytics(BufferedReader reader, Account account) {

        System.out.println("SYSTEM IS UNDER CONSTRUCTION");

    }

    /**
     * Get an advice printout
     */
    private static void getAdvice(Account account) {

        System.out.println("SYSTEM IS UNDER CONSTRUCTION");

    }

    /**
     * Internal class for validating amounts
     * @param amount the amount to be validated
     * @return is the amount valid
     */
    private static boolean isAmountValid(double amount) {

        return false;

    }

}