import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;


class CustomHelloTest {

    @Test
    void main() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        String[] args = new String[2];
        args[0] = "John";
        args[1] = "Doe";

        CustomHello.main(args);
        assertEquals("hello John Doe ", bos.toString());
        System.setOut(originalOut);
    }
}
