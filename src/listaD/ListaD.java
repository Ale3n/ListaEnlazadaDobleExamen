/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaD;

/**
 *
 * @author Tower
 */
public class ListaD {
    public Nodo prim;
    public int cantElem;
    public Nodo ult;

    public ListaD() {
        prim = ult = null;
        cantElem = 0;
    }

    private boolean vacia() {
        return cantElem == 0;
    }

 public String toString() {
        String s = "[";
        Nodo p = prim;
        while (p != null) {
            s += p.elem;
            if (p.prox != null) s += ", ";
            p = p.prox;
        }
        return s + "]";
    }

    public void insertarPrim(int x) {
        if (vacia())
            prim = ult = new Nodo(null, x, null);
        else {
            prim = prim.ant = new Nodo(null,x,prim);
        }
        cantElem++;
    }

    public void insertarUlt(int x) {
        if (vacia())
            prim = ult = new Nodo(null, x, null);
        else {
            ult = ult.prox = new Nodo(ult,x,null);
        }
        cantElem++;
    }

    public void eliminarPrim() {
        if (vacia()) return;
        if (prim == ult){
            prim = ult = null;
        }
        else {
            prim.prox.ant = null;
            prim = prim.prox;
        }
        cantElem--;
    }

    public void eliminarUlt() {
        if (vacia()) return;
        if (prim == ult){
            prim = ult = null;
        }
        else {
            ult.ant.prox = null;
            ult = ult.ant;
        }
        cantElem--;
    }

    // ===== 5 INSERTAR / CONSULTA (CORTOS Y REALES) =====

    public void reemplazar(int x, int y) {//12
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x){
                p.elem = y;
            }
            p = p.prox;
        }
    }

    // 18
    
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
    public boolean diferentes() {// L1.diferentes() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son diferentes.
        Nodo p = prim;
        while (p != null) {
            if (frecuencia(p.elem) > 1){
                return false;
            }
            p = p.prox;
        }
        return true;
    }

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


    public void insertarUlt(ListaD L2) {//Método que inserta los elementos de la Lista L2, al final de la Lista L1.
        Nodo p = L2.prim;
        while (p != null) {
            insertarUlt(p.elem);
            p = p.prox;
        }
    }

    public void intercalar(ListaD L2, ListaD L3) {
        Nodo p = L2.prim, q = L3.prim;
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

    // ===== MÉTODO AUXILIAR =====

    private void eliminarNodo(Nodo p) {
        if (p == prim) {
            eliminarPrim();
        } else if (p == ult) {
            eliminarUlt();
        } else {
            p.ant.prox = p.prox;
            p.prox.ant = p.ant;
            cantElem--;
        }
    }

    // ===== 5 ELIMINAR (CORTOS Y REALES) =====///////////////////////////////////

    public void eliminarPares() {
        Nodo p = prim;
        while (p != null) {
            Nodo sig = p.prox; // guardamos el siguiente siempre
            if (p.elem % 2 == 0) {
                eliminarNodo(p);
            }
            p = sig; // avanzamos siempre
        }
    }

    public void eliminarMayores(int x) {
        Nodo p = prim;
        while (p != null) {
            Nodo sig = p.prox; // guardamos el siguiente siempre
            if (p.elem > x) {
                eliminarNodo(p);
            }
            p = sig; // avanzamos siempre
        }
    }

   public void eliminarSiEstaEn(ListaD L2) {
        Nodo p = prim;
        while (p != null) {
            Nodo sig = p.prox; // guardamos el siguiente siempre
            if (L2.buscar(p.elem)) {
                eliminarNodo(p);
            }
            p = sig; // avanzamos siempre
        }
    }



   public boolean buscar(int x) {
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                return true;
            }
            p = p.prox;
        }
        return false;
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
////////////////////////////////////////////////////////////////////


    public void eliminarTodos(int x) {
        Nodo p = prim;
        while (p != null) {
            Nodo sig = p.prox;
            if (p.elem == x) {
                eliminarNodo(p);
            }
            p = sig;
        }
    }

}
