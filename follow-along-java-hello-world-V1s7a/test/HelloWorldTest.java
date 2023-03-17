import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    @Test
    void main() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        HelloWorld h = new HelloWorld();
        h.main();

        assertEquals("Hello World", bos.toString());
        System.setOut(originalOut);
    }
}
