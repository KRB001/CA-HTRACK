package test;

import main.Analytics;
import main.Writer;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;


public class WriterTest {

    Writer writer = new Writer("src/main/test.txt");

    @Test
    void readTest(){

        LocalDateTime created = LocalDateTime.of(2024,3,3,12,0);
        LocalDateTime next = LocalDateTime.of(2024,3,10,12,0);
        assertEquals(created, writer.readStartDate());
        assertEquals(created, writer.readPreviousRollover());
        assertEquals(next, writer.readNextRollover());
        assertEquals(500, writer.readBalance());
        assertTrue(writer.readIsRolloverAllowed());
        assertEquals(200,writer.readAllowance());

    }

    @Test
    void readAnalyticsTest(){

        LocalDateTime logTime1 = LocalDateTime.of(2024,3,5,12,0);

        Analytics analytics =  writer.readAnalytics();

        assertEquals(3, analytics.getLogs().size());
        assertEquals(logTime1, analytics.getLogs().get(0).getDateTimeAtTime());
        assertEquals(25, analytics.getLogs().get(1).getAmount());
        assertEquals(120, analytics.getLogs().get(2).getAllowanceAtTime());

    }

}
