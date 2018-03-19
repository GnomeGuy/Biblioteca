import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class obtenerLibrosPorFechaTest extends Contador {

    static Biblioteca biblioteca;

    static Autor a1;
    static Autor a2;
    static Autor a3;

    static Fecha f1;
    static Fecha f2;

    static Libro l1;
    static Libro l2;
    static Libro l3;
    static Libro l4;
    static Libro l5;
    static Libro l6;
    static ArrayList<Libro>libros = new ArrayList<>();

    static Biblioteca b1;

    @BeforeAll
    static void creaObjetos() {

        a1 = new Autor("Adolf Hitler");
        a2 = new Autor("El perchas");
        a3 = new Autor("Roberto Pamplinas");

        f1 = new Fecha();
        f2 = new Fecha(16, 4, 2018);

        l1 = new Libro("Mein Kampf", "Educativo",f1, a1);
        l2 = new Libro("Caca culo pedo pis", "Superación y psicología",f1, a2);
        l3 = new Libro("El método del calcetín", "Adultos",f1, a3);
        l4 = new Libro("Semana de exámenes", "Drama",f2, a3);
        l5 = new Libro("Programación avanzada en java", "Terror psicológico",f1, a2);
        l6 = new Libro("Sevoio y el café de vainilla", "Romántico",f1, a3);

        libros.add(l1);
        libros.add(l2);
        libros.add(l3);
        libros.add(l5);
        libros.add(l6);
        b1 = new Biblioteca("Meloinvento");

        b1.añadir(l1);
        b1.añadir(l2);
        b1.añadir(l3);
        b1.añadir(l4);
        b1.añadir(l5);
        b1.añadir(l6);


    }
    static int contador = 0;
    @AfterEach
    void contador (){
        System.out.println( "Pruebas realizadas: " + ++contador + "\n");
    }
        @DisplayName("Método que te devuelva todos los libros a partir de una fecha.")
        @Test
        void juegosLanzamiento1 () {
            assertNotEquals(libros, b1.obtenerLibrosPorFecha(f1));
        }
       @Test
        void juegosLanzamiento2 () {
            ArrayList<Libro> libs = b1.obtenerLibrosPorFecha(f1);
            for (int i = 0; i < libs.size(); i++) {
                assertEquals(libs, libros);
            }
        }
       @Test
      void juegosLanzamiento3 () {
           assertNotNull(b1.obtenerLibrosPorFecha(f1));
       }
    }