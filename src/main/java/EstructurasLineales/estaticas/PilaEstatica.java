/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasLineales.estaticas;

/**
 *
 * @author Sabina
 */
public class PilaEstatica {
    
    private Object arreglo[];
    private final int TAMANIO;
    private int tope;
    
    public PilaEstatica(int Tam){
        TAMANIO = Tam;
        arreglo = new Object[Tam];
        tope = -1;
    }
    
    public boolean apilar(Object nuevoElem){
        
        boolean exito;
        
        if(tope + 1  >= TAMANIO){
            //Error: Pila llena
            exito = false;
        } else {
            // pone el elemento en el tope de la pila e incrementa el tope
            tope++;
            arreglo[tope] = nuevoElem;
            exito = true;
        }
        
        return exito;
    }
    
    public boolean desapilar(){
        
        boolean exito;
        
        if(this.esVacia()){
            //Error: Pila vacía
            exito = false;
        } else {
            // saca el elemento del tope y decrementa tope
            arreglo[tope] = null;
            tope--;
            exito = true;
        }
        
        return exito;
    }
    
    public Object obtenerTope(){
        //Precondición: La pila no está vacía
        return arreglo[tope];
    }
    
    public boolean esVacia(){
        //Retorn si la pila está vacía
        return tope == -1;
    }
    
    public void vaciar(){
        //Mientras no esté vacia desapila el tope y decrementa tope, 
        // resultando en una pila vacía con tope = -1;
        while(!this.esVacia()){
            arreglo[tope] = null;
            tope--;
        }
    }
    
    public PilaEstatica clone(){
        
        // Se crea una pilaFinal que será la que se devuelva y una auxiliar, que
        // servirá en el proceso explicado a continuación
        PilaEstatica pilaFinal = new PilaEstatica(this.TAMANIO),
                     pilaAux = new PilaEstatica(this.TAMANIO);
        
        //Se desapilan los objetos y apilan en la pila auxiliar, quedando todos
        // en el orden totalmente opuesto
        while(!this.esVacia()){
            pilaAux.apilar(this.obtenerTope());
            this.desapilar();
        }
        
        // Al desapilarlo y apilarlo de nuevo vuelven a quedar en su orden original
        // Por lo que se lo pasa a la pila final y devuelve a la original.
        while(!pilaAux.esVacia()){
            pilaFinal.apilar(pilaAux.obtenerTope());
            this.apilar(pilaAux.obtenerTope());
            pilaAux.desapilar();
        }
        
        return pilaFinal;
    }
    
    public String toString(){
        
        String s;
        
        if(this.esVacia()){
            s = "La pila está vacía";
        } else {
            s = "Pila = [";
            // Auxiliar parar recorrer el arreglo sin mover tope
            int aux = tope;
            while(aux > -1){
                // Agrega el elemento al string y decrementa aux para ir al siguiente
                s += arreglo[aux].toString();
                aux--;
                // Mientras no sea el último agrega ", "
                if(aux != -1)s += ", ";
            }
            s += "]";
        }
        
        return s;
    }
}
