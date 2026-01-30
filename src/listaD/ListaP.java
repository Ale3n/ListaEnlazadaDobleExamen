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
        while (p !=null) {
            s+=p.elem;
            if (p.prox != null) {
                s+=",";
            }
            p = p.prox;
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
    public void eliminarPrim()
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
    public void eliminarUlt()
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
        while (p !=null) {
            if (p.elem == x) {
                p.elem = y;
            }
            p = p.prox;
        }
    }
    public int frecuencia(int x)
    {
        Nodo p = prim;
        int c = 0;
        while (p !=null) {
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
        while (p !=null) {
            if (frecuencia(p.elem)>1) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }
    public boolean poker()
    {
        Nodo p = prim;
        while (p !=null) {
            if (frecuencia(p.elem)==cantElem -1) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }
    
    public void insertarUlt(ListaP l)
    {
        Nodo p = l.prim;
        while (p !=null) {
           insertarUlt(p.elem);
            p = p.prox;
        }
    }
    public void intercalar(ListaP l1,ListaP l2)
    {
        Nodo p = l1.prim;
        Nodo q = l2.prim;
        while (p !=null || q !=null) {
            if (p !=null) {
                insertarUlt(p.elem);
                 p = p.prox;
            }
            if (q !=null) {
                insertarUlt(q.elem);
                 q = q.prox;
            }
        }
    }
    
    public void eliminarNodo(Nodo p)
    {
        if (p == prim) {
            eliminarPrim();
        } else if(p == ult) {
            eliminarUlt();      
        }else{
            p.ant.prox = p.prox;
            p.prox.ant = p.ant;
            cantElem--;
        {
    }
        }   
    } 
    public void eliminarPares()
    {
        Nodo p = prim;
        while (p !=null) {
            Nodo q = p.prox;
            if (p.elem % 2 == 0) {
                eliminarNodo(p);
            }
            p = q;
            
        }
    }
    public void eliminarMayores(int x)
    {
        Nodo p = prim;
        while (p !=null) {
            Nodo q = p.prox;
            if (p.elem > x) {
                eliminarNodo(p);
            }
            p = q;
            
        }
    }
    
    public void eliminarEstanEn(ListaP l)
    {
        Nodo p = prim;
        while (p !=null) {
            Nodo q = p.prox;
            if (l.buscar(p.elem)) {
                eliminarNodo(p);
            }
            p = q;
            
        }
    }
    public boolean buscar(int x)
    {
        Nodo p = prim;
        while (p !=null) {
            if ((p.elem) == x) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }
    
    
    public void eliminarPrim(int n)
    {
        while (n>0 && !vacia()) {
            eliminarPrim();
        }
    }
    public void eliminarUlt(int n)
    {
        while (n>0 && !vacia()) {
            eliminarUlt();
        }
    }
    public void eliminarExtremos(int n)
    {
        
            eliminarUlt(n);
            eliminarPrim(n);
    }
    
    public void eliminarTodos(int x)
    {
        Nodo p = prim;
        while (p !=null) {
            Nodo q = p.prox;
            if (p.elem  == x) {
                eliminarNodo(p);
            }
            p = q;
            
        }
    }
    
    
     
    
    
    

}
   