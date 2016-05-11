
package ldlcircular;

public class NoD {
    int valor;
    NoD proximo;
    NoD anterior;
    
    public NoD(int v){
        this.valor = v;
        this.proximo = null;
        this.anterior = null;
    }
}
