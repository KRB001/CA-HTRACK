package test;

import main.Log;
import main.LogType;
import main.Analytics;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AnalyticsTest {

    ArrayList<Log> logs = new ArrayList<>();
    ArrayList<String> recs = new ArrayList<>();

    Analytics analytics = new Analytics(logs, recs);

    @Test
    void logTest(){

        assertEquals(0, analytics.getLogs().size());

        LocalDateTime now = LocalDateTime.now();
        analytics.log(LogType.PURCHASE, now, 50, 500);
        Log testLog = new Log(LogType.PAYMENT, 100, 500, now);
        analytics.log(testLog);

        assertEquals(2, analytics.getLogs().size());
        assertEquals(50, analytics.getLogs().get(0).getAmount());
        assertEquals(100, analytics.getLogs().get(0).getAmount());

        assertEquals("== ALL LOGS ==\n" +
                "1. PURCHASE at " + now + ": $50.00 / $ 500.000\n" +
                "2. PAYMENT at " + now + ": $100.00 / $ 500.000", analytics.getLogsToString());

    }

    @Test
    void reportTest(){

        assertEquals("No transactions have been logged.", analytics.getReport());
        assertEquals("No transactions have been logged.", analytics.getRec());
        assertEquals(0, analytics.getRecs().size());

        LocalDateTime now = LocalDateTime.now();
        Log testLog1 = new Log(LogType.PAYMENT, 100, 500, now);
        Log testLog2 = new Log(LogType.PAYMENT, 200, 500, now);
        Log testLog3 = new Log(LogType.PURCHASE, 50, 500, now);
        Log testLog4 = new Log(LogType.PURCHASE, 250, 500, now);
        analytics.log(testLog1);
        analytics.log(testLog2);
        analytics.log(testLog3);
        analytics.log(testLog4);

        assertEquals("PLACEHOLDER FOR REPORT", analytics.getReport());
        assertEquals("PLACEHOLDER FOR REC", analytics.getRec());

    }

}
