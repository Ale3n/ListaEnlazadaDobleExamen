/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaD;

/**
 *
 * @author Tower
 */
public class ListaP {
    public Nodo prim;
    public Nodo ult;
    public int cantElem;

    public ListaP() {
        cantElem = 0;
        prim = ult = null;    
    }
    
    public String toString()
    {
        Nodo p = prim;
        String s = "[";
        while (p!=null) {
            s+=p.elem;
            if (p.prox != null) {
                 s+=",";
            }
        }
        return s+="]";
    }
    public boolean vacia()
    {
     return cantElem == 0;  
    }
    
    public void insertarPrim(int x)
    {
        if (vacia()) {
            prim = ult = new Nodo(null,x,null);
        } else {
            prim = prim.ant = new Nodo(null,x,prim);
        }
        cantElem++;
    }
    
     public void insertarUlt(int x)
    {
        if (vacia()) {
            prim = ult = new Nodo(null,x,null);
        } else {
            ult = ult.prox = new Nodo(ult,x,null);
        }
        cantElem++;
    }
     
     public void elimianrPrim()
    {
        if (vacia()) {
            return;
        }
        if (prim == ult) {
            prim = ult = null;
        } else {
            prim.prox.ant = null;
            prim = prim.prox;
        }
        cantElem--;
    }
     public void elimianrUlt()
    {
        if (vacia()) {
            return;
        }
        if (prim == ult) {
            prim = ult = null;
        } else {
            ult.ant.prox = null;
            ult = ult.ant;
        }
        cantElem--;
    }
     public void reemplazar(int x, int y)
    {
        Nodo p = prim;
        while (p!=null) {
            if (p.elem == x) {
                p.elem = y;
            }
            p = p.prox;
        }
    }
     public int fecuencia(int x)
    {
        Nodo p = prim;
        int c = 0;
        while (p!=null) {
            if (p.elem == x) {
                c++;
            }
            p = p.prox;
        }
        return c;
    }
     
     public boolean diferentes()
    {
        Nodo p = prim;
        while (p!=null) {
            if (fecuencia(p.elem)>1) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }
     public boolean poker()
    {
        Nodo p = prim;
        while (p!=null) {
            if (fecuencia(p.elem)==cantElem-1) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }
     public void insertarUlt(ListaD l)
    {
        Nodo p = l.prim;
        while (p!=null) {
            insertarUlt(p.elem);
            p = p.prox;
        }
    }
     
    public void intercalar(ListaD l1, ListaD l2)
    {
        Nodo p = prim;
        Nodo q = prim;
        while (p!=null || q!=null) {
            if (p!=null) {
               insertarUlt(p.elem);
               p = p.prox;
            }
            if (q!=null) {
               insertarUlt(q.elem);
               q = q.prox;
            }
        }
    }
    
    public void eliminarNodo(Nodo p)
    {
        if(p == prim) {
            elimianrPrim();
        } else if(p == ult){
            elimianrUlt();
        }else{
            p.ant.prox = p.prox;
            p.prox.ant = p.ant;
            cantElem--;
        }
    }
     public void elimianarPares()
    {
        Nodo p = prim;
        while (p!=null) {
            if (p.elem % 2 == 0) {
                Nodo q = p.prox;
                eliminarNodo(p);
                p = q;
            }else{
            p = p.prox;
            }
        }
    }
    
     public void elimianarMayores(int x)
    {
        Nodo p = prim;
        while (p!=null) {
            if (p.elem > x) {
                Nodo q = p.prox;
                eliminarNodo(p);
                p = q;
            }else{
            p = p.prox;
            }
        }
    }
     
    public void eliminarSiEstaEn(ListaP l)
    {
        Nodo p = prim;
        while (p!=null) {
            if (l.buscar(p.elem)) {
                Nodo q = p.prox;
                eliminarNodo(p);
                p = q;
            }else{
            p = p.prox;
            }
        }
    }
    
     public boolean buscar(int x)
    {
        Nodo p = prim;
        while (p!=null) {
            if (p.elem == x) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }
     
    public void elimianrPrim(int n)
    {
        Nodo p = prim;
        while (n>0 && !vacia()) {
           elimianrPrim();
           n--;
        }
    }
    public void elimianrUlt(int n)
    {
        Nodo p = prim;
        while (n>0 && !vacia()) {
           elimianrUlt();
           n--;
        }
    }
     
    public void extremos(int n)
    {
        elimianrPrim(n);
        elimianrUlt(n);
    }
     public void eliminarTodos(int x)
    {
        Nodo p = prim;
        while (p!=null) {
            if (p.elem == x) {
                Nodo q = p.prox;
                eliminarNodo(p);
                p = q;
            }else{
            p = p.prox;
            }
        }
    }
    
     
    
    
    
}
