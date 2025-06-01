

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import viettd.example.AccountService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountServiceTest {

    AccountService accountService = new AccountService();

    @ParameterizedTest(name = "Test {index}: registerAccount({0}, {1}, {2}) = {3}")
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testRegisterAccount(String username, String password, String email, boolean expected) {
        boolean actual = accountService.registerAccount(username, password, email);
        assertEquals(expected, actual);
    }
}
