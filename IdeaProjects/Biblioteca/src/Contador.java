import org.junit.jupiter.api.AfterEach;

public class Contador {

    static int contador = 0;

    @AfterEach
    void afterEach() {
        System.out.println("Pruebas totales realizadas: " + ++contador);
    }
}