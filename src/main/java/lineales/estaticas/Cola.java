package lineales.estaticas;

public class Cola {
    
    // Atributos de la Cola
    private static final int TAMANIO = 20;
    private final Object[] array;
    private int frente, fin;
    
    // Crea y devuelve una cola vacía
    public Cola(){
        array = new Object[TAMANIO];
        frente = 0;
        fin = 0;
    }
    
    // Pone el elemento al final de la cola. Devuelve verdadero si el elemento se pudo agregar en la estructura
    //      y falso en caso contrario.
    public boolean poner(Object nuevoElem){
        
        // Variable para devolver el exito
        boolean exito;
        
        if(fin + 1 == frente){
            //  Si la cola esta llena
            exito = false;
        } else {
            //  Si la cola no esta llena, suma uno a fin (Cuidando que si se pasa vuelve a 0)
            fin = (fin + 1) % TAMANIO;
            //  Y lo agrega al nuevo fin
            array[fin] = nuevoElem;
            exito = true;
        }
        
        return exito;
    }

    
    // Saca el elemento que está en el frente de la cola. Devuelve verdadero si el elemento se pudo sacar 
    //      (la estructura no estaba vacía) y falso en caso contrario.
    public boolean sacar (){
        
        //  Variable para devolver el exito
        boolean exito;
        
        if(this.esVacia()){
            //  Si esta vacía
            exito = false;
        } else {
            //  Borra el elemento del frente
            array[frente] = null;
            //  Reduce el frente
            frente--;
            //  En caso de haber pasado el limite, da la vuelta al otro lado
            if(fin == -1)fin = TAMANIO;
            exito = true;
        }
        
        return exito;
    }

    // Devuelve el elemento que está en el frente. Precondición: la cola no está vacía.
    public Object obtenerFrente(){
        return array[frente];
    }
    
    // Devuelve verdadero si la cola no tiene elementos y falso en caso contrario
    public boolean esVacia(){
        return frente==fin;
    }
    
    // Saca todos los elementos de la estructura.
    public void vaciar (){
        
        //  Mientras no este vacia, va sacando los elementos
        while(!this.esVacia()){
            this.sacar();
        }
    }

    // Devuelve una copia exacta de los datos en la estructura original, y respetando el orden de los mismos,
    //      en otra estructura del mismo tipo
    public Cola clone(){
        
        //  Nueva Cola que se devolvera de resultado
        Cola resultado = new Cola();
        
        //  Auxiliar para recorrer el arreglo
        int aux = frente;
        
        //  Mientras no haya llegado al ultimo, va poniendo los elementos en el clon
        while(aux != fin){
            resultado.poner(array[aux]);
        }
        
        return resultado;
    }
    
    // Crea y devuelve una cadena de caracteres formada por todos los elementos de la cola 
    //      para poder mostrarla por pantalla. Es recomendable utilizar este método únicamente 
    //      en la etapa de prueba y luego comentar el código.
    public String toString(){
        
        //  String para el resultado
        String resultado;
        
        if(this.esVacia()){
            //  Si esta vacia
            resultado = "Cola Vacía";
        } else {
            //  Si no esta vacia, abre el corchete
            resultado = "[";
            //  Auxiliar para recorrer el arreglo
            int aux = frente;
            
            //  Mientras no haya llegado
            while(aux != fin){
                //  Agrega el elemento al array
                resultado += array[aux].toString();
                
                //  Aumenta en uno el aux, checkeando que de la vuelta correctamente.
                aux = (aux + 1) % TAMANIO;
                
                //  Si no es el ultimo, agrega ", "
                if(aux != fin){
                    resultado += ", ";
                }
            }
            
            //  Cierra el corchete
            resultado = "]";
        }
        
        return resultado;
    }
}
