package face;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public final class CalculateFaceTest {
    @Mock
    List mockList;

    @Test
    public void testTest() {
        mockList.add("one");
    }
}