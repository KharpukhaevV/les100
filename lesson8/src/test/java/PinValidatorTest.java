import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class PinValidatorTest {
    @Mock
    private User user;

    @Mock
    private BufferedReader reader;

    @InjectMocks
    private PinValidator pinValidator;

    @Before
    public void setUp() throws Exception {
        this.user = new User("Ivanov", "Ivan", "Ivanovich", "123_456_678", 123L, 111);
    }

    @Test
    public void validate() throws InterruptedException, IOException {

        when(reader).getMock();
        pinValidator.validate(user);
    }
}