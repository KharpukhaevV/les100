import exceptions.AccountlsLockedException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

public class TerminalTest {
    @Mock
    private User user1;
    @Mock
    private User user2;
    @Mock
    private PinValidator pinValidator;

    @InjectMocks
    private TerminalImpl terminal;

    @Before
    public void setUp() throws Exception {
        openMocks(this);
        this.user1 = new User("Ivanov", "Ivan", "Ivanovich", "123_456_678", 123L, 111);
        this.user2 = new User("Ivanov", "Ivan", "Ivanovich", "123_285_678", 100L, 112);
        when(pinValidator.validate(user1)).thenReturn(true);
        doReturn(true).when(pinValidator).validate(user1);
    }

    @Test
    public void transfer() throws InterruptedException {
        terminal.transfer(user1, user2, 100L);
    }
}