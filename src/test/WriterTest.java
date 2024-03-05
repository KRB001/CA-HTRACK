package test;

import main.Analytics;
import main.Writer;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;


public class WriterTest {

    Writer writer = new Writer("src/test/test.txt");

    public WriterTest() throws FileNotFoundException {
    }

    @Test
    void readTest(){

        try {
            assertEquals(500, writer.readBalance());
            LocalDateTime created = LocalDateTime.of(2024, 3, 3, 12, 0);
            LocalDateTime next = LocalDateTime.of(2024, 3, 10, 12, 0);
            assertEquals(created, writer.readStartDate());
            assertEquals(next, writer.readNextRollover());
            assertTrue(writer.readIsRolloverAllowed());
            assertEquals(200, writer.readAllowance());
        }
        catch (IOException e){

            System.out.println("Encountered an IO error while parsing.");

        }

    }

    @Test
    void readAnalyticsTest(){

        LocalDateTime logTime1 = LocalDateTime.of(2024,3,5,12,0);

        try {
            Analytics analytics = writer.readAnalytics();
            assertEquals(3, analytics.getLogs().size());
            assertEquals(logTime1, analytics.getLogs().get(0).getDateTimeAtTime());
            assertEquals(25, analytics.getLogs().get(1).getAmount());
            assertEquals(120, analytics.getLogs().get(2).getAllowanceAtTime());
        }
        catch (IOException e) {

            System.out.println("Encountered an IO error while parsing.");

        }

    }

}
