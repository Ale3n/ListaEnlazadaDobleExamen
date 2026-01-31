/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbolpack;

/**
 *
 * @author Tower
 */
public class ArbolE {
    private  Nodo raiz;

    public ArbolE() {
        raiz = null;
    }
    
    public void insertar(int x)
    {
        raiz = insertar(raiz, x);
    }
    private Nodo insertar(Nodo p ,int x)
    {
        if (p == null) {
            return new Nodo(x);
        }
        if (x<p.elem) {
            p.izq = insertar(p.izq,x);
        } else {
             p.der = insertar(p.der,x);
        }
        return p;
    }
    
    public void eliminar(int x)
    {
        raiz = eliminar(raiz, x);
    }
    private Nodo eliminar(Nodo p ,int x)
    {
        if (p == null) {
            return null;
        }
        if (x == p.elem) {
            p = eliminarNodo(p);
        } else {
            if (x<p.elem) {
                p.izq = eliminar(p.izq,x);
            } else {
                 p.der = eliminar(p.der,x);
            }          
        }  
        return p;
    }
    private Nodo eliminarNodo(Nodo p )
    {
        if(p.izq == null && p.der == null) return null;
        if(p.izq == null && p.der != null) return p.der;
        if(p.izq != null && p.der == null) return p.izq;
        
        Nodo q = p.izq;
        while (q.der !=null) {
            q = q.der;
        }
        p.elem = q.elem;
        p.izq = eliminar(p.izq,p.elem);
        return p;
    }
    
    
    
}
