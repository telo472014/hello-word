package ldlcircular;

public class LDLcircular {
    
    static NoD inicio;
    
    public static void main(String[] args) {
        
        Inserir(inicio, 1);
        Inserir(inicio, 2);
        Inserir(inicio, 3);
        Inserir(inicio, 4);
        Inserir(inicio, 5);
        System.out.println("Lista Crescente");
        Exibir(inicio);
        System.out.println("Lista Decrescente");        
        ExibirInverso(inicio);
        Remover(inicio, 5);
        System.out.println("Lista depois de remover");
        Exibir(inicio);
        Remover(inicio, 4);
        Remover(inicio, 3);
        System.out.println("Lista depois de remover");
        Exibir(inicio);
        Remover(inicio, 2);
        Remover(inicio, 1);
        System.out.println("Lista depois de remover");
        Exibir(inicio);

    }

    
    
    static void Inserir(NoD e, int x){
        NoD novo = new NoD(x);
        if(inicio == null){
            e = novo;
            e.proximo = e;
            e.anterior = e;
            inicio = e;
        }
        else{
            
            while(e.proximo != inicio)
                e = e.proximo;
            novo.proximo = inicio;
            novo.anterior = inicio.anterior;
            inicio.anterior = novo;
            novo.anterior.proximo = novo;
        }
    
    }
    
    static void Remover (NoD e, int x){
        NoD temp  = e;
        if(!EstaVazia(e)){
            if(temp.valor == x && temp.anterior != inicio && temp.proximo != inicio){
                temp.anterior.proximo = temp.proximo;
                temp.proximo.anterior = temp.anterior;
            }
            else{
                if(temp.anterior == inicio && temp.valor == x){
                    if(temp.proximo != inicio){
                        temp.proximo.anterior = null;
                        temp = temp.proximo;
                        inicio = temp;
                    }
                    else{
                        temp = inicio;
                        inicio = null;
                    }
                }
                else{
                    if(temp.proximo == inicio && temp.valor == x){
                        temp.anterior.proximo = inicio;
                        temp = temp.anterior;
                    }
                    else{
                        Remover(e.proximo, x);
                    }
                }
            }
        }
    }
    
    public static void Exibir(NoD e){
        if(e == null){
            System.out.println("Lista vazia!!!");
        }
        else{
            System.out.println(e.valor);
            if(e.proximo != inicio)
            Exibir(e.proximo);
        } 
    }
    
    public static void ExibirInverso(NoD e){
        NoD temp = e;
        NoD temp2;
        if(!EstaVazia(e)){
            while(temp.proximo != inicio){
                temp = temp.proximo;
            }
            temp2 = temp;
            if(temp2.anterior == inicio){
                System.out.println(temp2.valor);
            }
            else{
                while(temp2 != inicio){
                System.out.println(temp2.valor);
                temp2 = temp2.anterior;
                }
            }
        }
    }    
    
    static boolean EstaVazia(NoD e){
        boolean vazia = false;
        if(e == null){
            vazia = true;
            System.out.println("Lista vazia !!!");
        }
        return vazia;
    }
    
     
}

