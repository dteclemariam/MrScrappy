import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MrScrapperMainTest {

    @Test
    void main() {
        assertTrue((new AppVariables().maximumMilliseconds != 0)||(new AppVariables().minimumMilliseconds != 0));
    }
}