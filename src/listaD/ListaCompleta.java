/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaD;

/**
 *
 * @author Tower
 */
public class ListaCompleta {
    public int cantElem;
    public Nodo prim;
    public Nodo ult;

    public ListaCompleta() {
        prim = ult = null;
        cantElem = 0;
    }
    
    private boolean vacia() {
        return (cantElem == 0);
    }
    public String toString() {
        String S1 = "[";
        Nodo p = prim;
        while (p != null) {
            S1 = S1 + p.elem;
            if (p.prox != null) {
                S1 = S1 + ", ";
            }
            p = p.prox;
        }
        return S1 + "]";
    }
    
    public void insertarPrim(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        } else {
            prim = prim.ant = new Nodo(null, x, prim);
        }
        cantElem++;
    }
    //2 
    public void insertarUlt(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        } else {
            ult = ult.prox = new Nodo(ult, x, null);
        }
        cantElem++;
    }
    public void eliminarPrim(){
        if(vacia()){
            return;
        }
        if(prim ==ult){
            prim=ult=null;
        }else{
            prim.prox.ant=null;
            prim=prim.prox;
        }
        cantElem--;
    }
    public void eliminarUlt(){
           if(vacia()){
               return;
           }
        if(prim ==ult){
            prim=ult=null;
        }else{
            ult.ant.prox=null;
            ult=ult.ant;
        }
        cantElem--;  
    }
    //////////////////////
    public boolean iguales(){ //6   L1.iguales() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son iguales.
        if (vacia()){
            return true;
        }
        int x = prim.elem;
        Nodo p = prim.prox;
        while (p != null) {
            if (p.elem != x) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }
    
    public int mayorElem() {//7
        int mayor = prim.elem;
        Nodo p = prim.prox;
        while (p != null) {
            if (p.elem > mayor){
                mayor = p.elem;
            }
            p = p.prox;
        }
        return mayor;
    }
    
    public int menorElem() {//8
        int menor = prim.elem;
        Nodo p = prim.prox;
        while (p != null) {
            if (p.elem < menor){
                menor = p.elem;
            }
            p = p.prox;
        }
        return menor;
    }
    
    public boolean ordenado() {//9
        if (cantElem <= 1) {
            return true;
        }
        boolean asc = true, desc = true;
        Nodo p = prim;

        while (p.prox != null) {
            if (p.elem > p.prox.elem){
                asc = false;
            }
            if (p.elem < p.prox.elem){
                desc = false;
            }
            p = p.prox;
        }
        return asc || desc;
    }
    
    public boolean pares() {//10
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 != 0){
                return false;
            }
            p = p.prox;
        }
        return true;
    }
    
    public boolean parImpar() {//11
        boolean par = false, impar = false;
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 == 0) {
                par = true;
            }
            else{
                impar = true;
            }
            p = p.prox;
        }
        return par && impar;
    }
    
    
    public void reemplazar(int x, int y) {//12
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x){
                p.elem = y;
            }
            p = p.prox;
        }
    }
    
    public boolean seEncuentra(int x){//13
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x){
                return true;
            }
            p = p.prox;
        }
        return false;
    }
    
    // 14
    public boolean mismosElem(ListaCompleta L2) {
        if (cantElem != L2.cantElem){
            return false;
        }
        Nodo p = prim;
        while (p != null) {
            if (frecuencia(p.elem) != L2.frecuencia(p.elem)){
                return false;
            }
            p = p.prox;
        }
        return true;
    }
    
    // 15
    public int frecuencia(int x) {
        int c = 0;
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x){
                c++;
            }
            p = p.prox;
        }
        return c;
    }
    
    
    // 16
    public boolean existeFrec(int k) {
        Nodo p = prim;
        while (p != null) {
            if (frecuencia(p.elem) == k){
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    // 17
    public boolean mismasFrec() {
        if (vacia()){
            return true;
        }
        int f = frecuencia(prim.elem);
        Nodo p = prim.prox;
        while (p != null) {
            if (frecuencia(p.elem) != f){
                return false;
            }
            p = p.prox;
        }
        return true;
    }
    
    // 18
    public boolean diferentes() {
        Nodo p = prim;
        while (p != null) {
            if (frecuencia(p.elem) > 1){
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    // 19
    public boolean poker() {
        Nodo p = prim;
        while (p != null) {
            if (frecuencia(p.elem) == cantElem - 1){
                return true;
            }
            p = p.prox;
        }
        return false;
    }
    // 20
    public boolean existePar() {
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 == 0) return true;
            p = p.prox;
        }
        return false;
    }

    // 21
    public boolean existeImpar() {
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 != 0) return true;
            p = p.prox;
        }
        return false;
    }

    // 22
    public boolean todoPares() {
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 != 0){
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    // 23
    public boolean todoImpares() {
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 == 0){
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    // 24
    public boolean existeParImpar() {
        return existePar() && existeImpar();
    }

    // 25
    public boolean alternos() {
        if (cantElem <= 1) {
            return true;
        }
        Nodo p = prim;
        boolean par = (p.elem % 2 == 0);
        p = p.prox;
        while (p != null) {
            if ((p.elem % 2 == 0) == par) return false;
            par = !par;
            p = p.prox;
        }
        return true;
    }

    // 26
    public void insertarPrim(ListaCompleta L2) {
        Nodo p = L2.ult;
        while (p != null) {
            insertarPrim(p.elem);
            p = p.ant;
        }
    }
    
    // 27
    public void insertarUlt(ListaCompleta L2) {
        Nodo p = L2.prim;
        while (p != null) {
            insertarUlt(p.elem);
            p = p.prox;
        }
    }

    // 28
    public void intercalar(ListaCompleta L2, ListaCompleta L3) {
        Nodo p = L2.prim;
        Nodo q = L3.prim;
        while (p != null || q != null) {
            if (p != null) {
                insertarUlt(p.elem);
                p = p.prox;
            }
            if (q != null) {
                insertarUlt(q.elem);
                q = q.prox;
            }
        }
    }

    // 29
    public void eliminarPrim(int n) {
        while (n > 0 && !vacia()) {
            eliminarPrim();
            n--;
        }
    }

    // 30
    public void eliminarUlt(int n) {
        while (n > 0 && !vacia()) {
            eliminarUlt();
            n--;
        }
    }

    // 31
    public void eliminarExtremos(int n) {
        eliminarPrim(n);
        eliminarUlt(n);
    }

    // 32
    public void rotarIzqDer(int n) {
        while (n > 0 && cantElem > 1) {
            int x = prim.elem;
            eliminarPrim();
            insertarUlt(x);
            n--;
        }
    }
    // 33
    public void rotarDerIzq(int n) {
        while (n > 0 && cantElem > 1) {
            int x = ult.elem;
            eliminarUlt();
            insertarPrim(x);
            n--;
        }
    }

    // 34
    public int indexOf(int x) {
        int i = 0;
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) return i;
            i++;
            p = p.prox;
        }
        return -1;
    }

    // 35
    public int lastIndexOf(int x) {
        int i = cantElem - 1;
        Nodo p = ult;
        while (p != null) {
            if (p.elem == x) return i;
            i--;
            p = p.ant;
        }
        return -1;
    }

    // 36
    public boolean palindrome() {
        Nodo i = prim;
        Nodo d = ult;
        while (i != d && i.ant != d) {
            if (i.elem != d.elem) return false;
            i = i.prox;
            d = d.ant;
        }
        return true;
    }
    
    // 37.1
    public void union(ListaCompleta L2) {
        Nodo p = L2.prim;
        while (p != null) {
            if (!seEncuentra(p.elem)) {
                insertarUlt(p.elem);
            }
            p = p.prox;
        }
    }

    // 37.2
    public void interseccion(ListaCompleta L2) {
        Nodo p = prim;
        while (p != null) {
            Nodo sig = p.prox;
            if (!L2.seEncuentra(p.elem)) {
                eliminarElemento(p);
            }
            p = sig;
        }
    }

    // 37.3 
    public void eliminarComunes(ListaCompleta L2, ListaCompleta L3) {
        Nodo p = L2.prim;
        while (p != null) {
            if (L3.seEncuentra(p.elem)) {
                eliminarTodo(p.elem);
            }
            p = p.prox;
        }
    }

    // 37.4 
    public int contarMayores(int x) {
        int c = 0;
        Nodo p = prim;
        while (p != null) {
            if (p.elem > x) c++;
            p = p.prox;
        }
        return c;
    }

    // 37.5 
    public boolean esSubLista(ListaCompleta L2) {
        Nodo p = L2.prim;
        while (p != null) {
            if (!seEncuentra(p.elem)) return false;
            p = p.prox;
        }
        return true;
    }

    // MÉTODOS AUXILIARES
    private void eliminarElemento(Nodo p) {
        if (p == prim && p == ult) {
            prim = ult = null;
        } else if (p == prim) {
            prim = prim.prox;
            prim.ant = null;
        } else if (p == ult) {
            ult = ult.ant;
            ult.prox = null;
        } else {
            p.ant.prox = p.prox;
            p.prox.ant = p.ant;
        }
        cantElem--;
    }

    public void eliminarTodo(int x) {
        Nodo p = prim;
        while (p != null) {
            Nodo sig = p.prox;
            if (p.elem == x) {
                eliminarElemento(p);
            }
            p = sig;
        }
    }
}
