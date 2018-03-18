import java.util.ArrayList;

public class Biblioteca {

    String nombre;
    ArrayList<Libro> libros = new ArrayList<>();

    public Biblioteca(String nombre){
        this.nombre = nombre;
    }

    public void añadir (Libro lib){
        libros.add(lib);
    }

    // Método que te devuelva todos los libros a partir de una fecha.
    public ArrayList<Libro> obtenerLibrosPorFecha(Fecha fecha) {
        ArrayList<Libro> lanzamiento = new ArrayList<>();
        for (Libro l: libros){
            if (l.publicacion.before(fecha) || l.publicacion.equals(fecha)){
                lanzamiento.add(l);
            }
        }
        return lanzamiento;
    }

    /*
    Método que te devuelva otro libro del mismo autor
    y si no existe pues que devuelva null.
    */
    public Libro devolverLibroMismoAutor (Libro libro) {
        for (Libro lib : libros) {
            if (libro.autor.equals(lib.autor) && !libro.nombre.equals(lib.nombre)) {
                return lib;
            }
        }
        return null;
    }

    /*
    Método que te indique si la biblioteca tiene
    libros del mismo género que del libro devuelto.
    */
    public boolean hayMismoGenero (Libro lib){
        for (Libro libro : libros){
            if (libro.genero.equals(lib.genero) && !libro.nombre.equals(lib.nombre)){
                return true;
            }
        }
        return false;
    }

    /*
    Método que devuelva los libros con un
    titulo entre 8 y 15 caracteres.
    */
    public String devolverTituloEntre8Y15 (){
        String mensaje="";
        for (Libro libro : libros){
            if (libro.nombre.length() >8 && libro.nombre.length()< 15){
                mensaje+= libro + "\n";
            }
        }
        if (mensaje == ""){
            mensaje+= "No se han encontrado libros con esa característica";
        }
        return mensaje;
    }

    // Método que compara si dos libros son el mismo
    public boolean compararLibros (Libro lib){
        return this.equals(libros);
    }

    /*
    Método que indique si es una biblioteca con mucha diversidad:
    Se considera diversa si el hay 10 géneros de libros distinto.
     */
    public boolean comprobarDiversidad(){
        int contador = 0;
        ArrayList<Libro> generosBiblioteca = new ArrayList<>();
        for (int i=0;i< libros.size(); i++){
            for (int j=0;i< libros.size(); i++){
                if (!libros.get(i).genero.equals(libros.get(j).genero) && !generosBiblioteca.contains(libros.get(j))){
                    contador ++;
                    generosBiblioteca.add(libros.get(j));
                }
            }
        }
        if (contador > 9){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String mensaje = "Biblioteca: " + nombre + "\n";

        for (Libro libro : libros) {
            mensaje+= libro + "\n";
        }
        return mensaje;
    }



}
