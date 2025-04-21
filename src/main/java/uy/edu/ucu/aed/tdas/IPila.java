package uy.edu.ucu.aed.tdas;

public interface IPila<T> {

    //Elimina todos los objetos de la pila
    public void Anula();

    //Nos devuelve el Tope de la pila, osea el objeto que va ser eliminado si usamos el metodo Saca
    public T Tope();

    //Elimina el ultimo en entrar
    public void Saca();

    //Agrega un elemento a la pila
    public void Mete(T dato);

    //Nos desvuelve si la lsita esta vacia o no
    public boolean EsVacia();

}
