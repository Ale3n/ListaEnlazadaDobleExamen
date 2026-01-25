/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listae;

/**
 *
 * @author Tower
 */
public class Lista {
    public int cantElem;
    public Nodo prim;
    public Nodo ult;
    
     public Lista() {
        cantElem = 0;
        prim = ult = null;
    }
     
    public String toString() {
        String s = "[";
        Nodo p = prim;
        while (p != null) {
            s += p.elem;
            if (p.prox != null) {
                s += ", ";
            }
            p = p.prox;
        }
        return s + "]";
    }
      public boolean vacia() {
        return cantElem == 0;
    }

    public void insertarPrim(int x) {//2 Método que inserta el elemento x, al inicio de la lista L1.
        if (vacia())
        {
            prim = ult = new Nodo(x, null);
        }
        else {
            prim = new Nodo(x, prim);
        }
        cantElem++;
    }
     public void insertarUlt(int x) {//3Método que inserta el elemento x, al inicio de la lista L1.
        if (vacia())
        {
            prim = ult = new Nodo(x, null);
        }
        else {
            ult = ult.prox = new Nodo(x, null);
        }
        cantElem++;
    }
     
     
    public void eliminarPrim() {//4 Método que elimina el primer elemento de la lista L1.
        if (vacia())
        {
            return;
        }
        if (prim == ult)
        {
            prim = ult = null;
        }
        else {
            prim = prim.prox;
        }
        cantElem--;
    }
    
    public void eliminarUlt() { //5
    if (vacia()) {
        return;
    }
    
    if (prim == ult) {
        prim = ult = null;
    } else {
        Nodo p = prim;
        
        // Se agregaron las llaves aquí
        while (p.prox != ult) {
            p = p.prox;
        }
        
        p.prox = null;
        ult = p;
    }
    cantElem--;
    }
    public boolean iguales() { // 6 Método Lógico que devuelve True, si todos los elementos de la lista L1 son iguales.
        if (vacia()) {
            return true;
        }
        Nodo p = prim.prox;
        while (p != null) {
            if (p.elem != prim.elem) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }
    public int mayorElem() {//7 Método que devuelve el mayor elemento de la lista L1.   
        int mayor = prim.elem;
        Nodo p = prim.prox;
        while (p != null) {
            if (p.elem > mayor) {
                mayor = p.elem;
            }
            p = p.prox;
        }
        return mayor;
    }
     public int menorElem() {//8 Método que devuelve el menor elemento de la lista L1.
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
     
      public boolean ordenado() {//9 : Método Lógico que devuelve True, si todos los elementos de la lista L1 están ordenados en forma ascendente o descendente.
        if (cantElem < 2) {
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
    
     public boolean pares() {//10 Método lógico que devuelve True, si todos los elementos de la lista L1 son pares.
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 != 0) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }
     
      public boolean parImpar() {//11 Método lógico que devuelve True, si la lista L1 contiene al menos un elemento par e impar.
        return existePar() && existeImpar();
    }

    public void reemplazar(int x, int y) {//12 Método que reemplaza todas las ocurrencias del elemento x por el elemento y en la lista L1.
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                p.elem = y;
            }
            p = p.prox;
        }
    }
    
    public boolean seEncuentra(int x) {//13 Método Lógico que devuelve True, si el elemento x, se encuentra en la lista L1.
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }
    
     public boolean mismosElem(Lista L2) {//14 Método Lógico que devuelve True, las Listas L1 y L2, tienen los mismos elementos.
        Nodo p = prim;
        while (p != null) {
            if (!L2.seEncuentra(p.elem)){
                return false;
            }
            p = p.prox;
        }
        p = L2.prim;
        while (p != null) {
            if (!seEncuentra(p.elem)) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }
     
     public int frecuencia(int x) {//15 Método que devuelve la cantidad de veces que aparece el elemento x en la lista L1.
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
     
      public boolean existeFrec(int k) {//16 Método Lógico que devuelve True, si existe algún elemento que se repite exactamente k-veces en la lista L1.    
        Nodo p = prim;
        while (p != null) {
            if (frecuencia(p.elem) == k) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }
      
      public boolean mismasFrec() {//17 Método Lógico que devuelve True, si todos los elementos de la lista L1 tienen la misma frecuencia.
        if (vacia()) return true;
        int f = frecuencia(prim.elem);
        Nodo p = prim;
        while (p != null) {
            if (frecuencia(p.elem) != f){
                return false;
            }
            p = p.prox;
        }
        return true;
    }
    public boolean diferentes() {//18 Método Lógico que devuelve True, si todos los elementos de la lista L1 son diferentes.
        Nodo p = prim;
        while (p != null) {
            if (frecuencia(p.elem) > 1) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    public boolean poker() {//19  Método Lógico que devuelve True, si los elementos de la lista L1 forman poker. (Todos los elementos son iguales excepto uno)
        Nodo p = prim;
        while (p != null) {
            int f = frecuencia(p.elem);
            if (!(f == 1 || f == cantElem - 1)){
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    public boolean existePar() {//20 Método lógico que devuelve True, si la lista L1 contiene al menos un elemento par.
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 == 0){
                return true;
            }
            p = p.prox;
        }
        return false;
    }
    
     public boolean existeImpar() {//21 Método lógico que devuelve True, si la lista L1 contiene al menos un elemento impar.
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 != 0) return true;
            p = p.prox;
        }
        return false;
    }

    public boolean todoPares() {//22 Método lógico que devuelve True, si todos los elementos de la lista L1 son pares.
        return pares();
    }

    public boolean todoImpares() {//23 Método lógico que devuelve True, si todos los elementos de la lista L1 son impares.
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 == 0) return false;
            p = p.prox;
        }
        return true;
    }

    public boolean existeParImpar() {//24 Método lógico que devuelve True, si en la lista L1 al menos existe un elemento par y un elemento impar.
        return existePar() && existeImpar();
    }

    public boolean alternos() {//25 Método lógico que devuelve true, si la lista L1 contiene elementos en la siguiente secuencia: par, impar, par, impar, . . . or  impar, par, impar, par, . . . .
        if (cantElem < 2) return true;
        Nodo p = prim;
        boolean par = p.elem % 2 == 0;
        p = p.prox;
        while (p != null) {
            if ((p.elem % 2 == 0) == par) return false;
            par = !par;
            p = p.prox;
        }
        return true;
    }

    public void insertarPrim(Lista L2) {//26 Método que inserta los elementos de la Lista L2, al inicio de la Lista L1.
        Nodo p = L2.prim;
        while (p != null) {
            insertarPrim(p.elem);
            p = p.prox;
        }
    }

    public void insertarUlt(Lista L2) {//27 Método que inserta los elementos de la Lista L2, al final de la Lista L1.
        Nodo p = L2.prim;
        while (p != null) {
            insertarUlt(p.elem);
            p = p.prox;
        }
    }
    
     public void intercalar(Lista L2, Lista L3) {//28 
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
     // 29. Eliminar los primeros n elementos
    public void eliminarPrim(int n) {
        while (!vacia() && n > 0) {
            eliminarPrim();
            n--;
        }
    }

    // 30. Eliminar los últimos n elementos
    public void eliminarUlt(int n) {
        while (!vacia() && n > 0) {
            eliminarUlt();
            n--;
        }
    }

    // 31. Eliminar n elementos de ambos extremos
    public void eliminarExtremos(int n) {
        eliminarPrim(n);
        eliminarUlt(n);
    }

    // 32. Rotar n veces de izquierda a derecha
    public void rotarIzqDer(int n) {
        while (!vacia() && n > 0) {
            int x = prim.elem;
            eliminarPrim();
            insertarUlt(x);
            n--;
        }
    }

    // 33. Rotar n veces de derecha a izquierda
    public void rotarDerIzq(int n) {
        while (!vacia() && n > 0) {
            int x = ult.elem;
            eliminarUlt();
            insertarPrim(x);
            n--;
        }
    }

    /* ============================
       34. MÉTODOS ADICIONALES (5)
       ============================ */

    // A. Suma de todos los elementos
    public int sumaElem() {
        int s = 0;
        Nodo p = prim;
        while (p != null) {
            s += p.elem;
            p = p.prox;
        }
        return s;
    }

    // B. Promedio de los elementos
    public double promedio() {
        if (vacia()) return 0;
        return (double) sumaElem() / cantElem;
    }

    // C. Contar elementos pares
    public int contarPares() {
        int c = 0;
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 == 0) c++;
            p = p.prox;
        }
        return c;
    }

    // D. Verificar si la lista es palíndroma
    public boolean esPalindromo() {
        Nodo i = prim;
        while (i != null) {
            Nodo j = ult;
            Nodo p = prim;
            while (p.prox != null && p != i) p = p.prox;
            if (i.elem != j.elem) return false;
            i = i.prox;
            ult = p;
        }
        return true;
    }

    // E. Clonar la lista
    public Lista clonar() {
        Lista L = new Lista();
        Nodo p = prim;
        while (p != null) {
            L.insertarUlt(p.elem);
            p = p.prox;
        }
        return L;
    }


}
