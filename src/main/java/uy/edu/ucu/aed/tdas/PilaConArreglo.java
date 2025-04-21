package uy.edu.ucu.aed.tdas;
import java.util.Arrays;

public class PilaConArreglo<T> implements IPila<T> {
    
    private int tamanioOriginal;
    private T[] datos;
    private int tope;

    //Suprimo el warning porque java no puede verificar en tiempo de compilacion si esto es seguro, pero con los test notamos que esta bien
    @SuppressWarnings("unchecked")
    public PilaConArreglo(int tamanio){
        this.tamanioOriginal = tamanio;
        datos = (T[]) new Object[tamanio];
        tope = -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void Anula() {
        //De esta manera cuando utilizemos el metodo, hacemos que nuestra pila vuelva al tamanio original que una vez usamos, es la opcion
        //mas eficiente y menos costosa para poder empezar de nuevo y libero memoria que quizas no voy a utilizar si fue el caso de agrandar el Array
        datos = (T[]) new Object[tamanioOriginal];
        tope = -1;
    }

    @Override
    public T Tope() {
        //Queremos comunicar que el metodo solicitado no realizar la operacion debido al estado de la pila
        if (EsVacia()) throw new IllegalStateException("Pila vacía");
        return datos[tope];
    }

    @Override
    public void Saca() {
        //Queremos comunicar que el metodo solicitado no realizar la operacion debido al estado de la pila
        if (EsVacia()) throw new IllegalStateException("Pila vacía");
        tope--;
    }

    @Override
    public void Mete(T dato) {
        
        if (tope + 1 == datos.length) {
            datos = Arrays.copyOf(datos, datos.length * 2); // duplicamos tamaño si se nos llena la pila
        }
        datos[++tope] = dato;
    }

    @Override
    public boolean EsVacia() {
        return tope == -1;
    }
}
