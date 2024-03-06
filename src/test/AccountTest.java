package test;

import main.Account;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void accountIntegrationTest() throws IOException {

        Account account = new Account();

        assertTrue(account.isRolloverAllowed());
        account.toggleRollover();
        assertFalse(account.isRolloverAllowed());
        account.toggleRollover();

        assertEquals(500, account.getBalance());
        account.purchase(150);
        assertEquals(350, account.getBalance());
        account.addPayment(150);
        assertEquals(500, account.getBalance());

        assertEquals(200, account.getAllowance());
        account.setAllowance(220);
        assertEquals(220, account.getAllowance());
        account.setAllowance(200);

    }

}
