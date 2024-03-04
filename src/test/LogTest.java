package test;

import main.Log;
import main.LogType;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class LogTest {

    @Test
    void getterTest(){

        LocalDateTime now = LocalDateTime.now();
        Log purchase = new Log(LogType.PURCHASE, 50, 500, now);
        Log payment = new Log(LogType.PAYMENT, 50, 500, now);

        assertEquals(50, purchase.getAmount());
        assertEquals(50, payment.getAmount());

        assertEquals(500, purchase.getAllowanceAtTime());
        assertEquals(500, payment.getAllowanceAtTime());

        assertEquals(now, purchase.getDateTimeAtTime());
        assertEquals(now, payment.getDateTimeAtTime());

    }

}
