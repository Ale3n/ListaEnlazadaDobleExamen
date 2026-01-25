/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listae;

/**
 *
 * @author Tower
 */
public class ListaP {
   public int cantElem;
   public Nodo prim;
   public Nodo ult;

    public ListaP() {
        cantElem = 0;
        prim = ult = null;
    }
    
    public String toString()
    {
        String s = "[";
        Nodo p = prim;
        while (p!=null) {
            s +=p.elem;
            if (p.prox != null) {
                s+=",";
            }
            p = p.prox;
        }
        return s+="]";
    }
     public boolean vacia() {
        return cantElem==0;
    }
    
    
    public void insertarPrim(int x) {
        if(vacia()) {
            prim = ult = new Nodo(x,null);
        } else {
            prim = new Nodo(x,prim);
        }
        cantElem++;
    }
    public void insertarUlt(int x) {
        if(vacia()) {
            prim = ult = new Nodo(x,null);
        } else {
            ult = ult.prox = new Nodo(x,null);
        }
        cantElem++;
    }
    
    public void eliminarPrim() {
        if(vacia()) {
            return;
        }
        if (prim == ult) {
            prim = ult = null;
        } else {
            prim = prim.prox;
        }
        cantElem--;
    }
    
    /*
    public void () {
        
    }
    */
   
    
}
