import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Controller should")

class ControllerTest {

    AppVariables appVariables;
    Resources resources;

    //Creates clean instances
    @BeforeEach
    void init(){
        appVariables = new AppVariables();
        resources = new Resources();
    }

    //Test to see that the instances has been created
    @DisplayName("Creates instances of classes:")
    @Test
    void createHelperClasses(){
        assertAll(
                () -> assertNotNull(appVariables),
                () -> assertNotNull(resources)
        );
    }
}