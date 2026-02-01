/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbolpack;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @author Tower
 */
public class ArbolE {
    private Nodo raiz;

    public ArbolE() {
        raiz = null;
    }
    
    public void insertar(int x){
        raiz = insertar(raiz,x);
    }
    public Nodo insertar(Nodo p,int x){
        if (p==null) {
            return new Nodo(x);
        }
        if (x<p.elem) {
            p.izq = insertar(p.izq,x);
        } else {
             p.der = insertar(p.der,x);
        }
        return p;
        
    }
    public void eliminar(int x){
        raiz = eliminar(raiz,x);
    }
    public Nodo eliminar(Nodo p,int x){
        if (p==null) {
            return null;
        }
        if (x ==p.elem) {
            p = eliminarNodo(p);
        } else {
            if (x<p.elem) {
            p.izq = insertar(p.izq,x);
        } else {
             p.der = insertar(p.der,x);
        }
        }
        return p;   
    }
    
    public Nodo eliminarNodo(Nodo p){
        if(p.izq ==null && p.der ==null) return null;
        if(p.izq !=null && p.der ==null) return p.izq;
        if(p.izq ==null && p.der !=null) return p.der;
        Nodo q = p.izq;
        while (q.der!=null) {
            q = q.der;
        }
        p.elem = q.elem;
        p.izq = eliminar(p.izq,q.elem);
        return p;
    }
    public int cantTerminos(){
        return cantTerminos(raiz);
    }
    public int cantTerminos(Nodo p){
        if (p==null) {
            return 0;
        } else {
            if (p.izq ==null && p.der ==null) {
                return 1;
            } else {
                return cantTerminos(p.izq) + cantTerminos(p.der);
            }
        }
    }
    
    public int sumaPares(){
        return sumaPares(raiz);
    }
    public int sumaPares(Nodo p){
        if (p==null) {
            return 0;
        } else {
            int s = sumaPares(p.izq) + sumaPares(p.der);
            if (p.elem % 2 == 0) {
                s+=p.elem;
            }
            return s;
        }
    }
    
    
    public void postOrden(ArrayList<Integer>l1){
        postOrden(l1,raiz);
    }
    public void postOrden(ArrayList<Integer>l1,Nodo p){
        if(p == null) return;
        postOrden(l1,p.izq);
        postOrden(l1,p.der);
        l1.add(p.elem);
    }
    
    public void niveles()
    {
        LinkedList<Nodo> l1 = new LinkedList();
        if(raiz!=null) l1.add(raiz);
        while (!l1.isEmpty()) {
            Nodo p = l1.removeFirst();
            if (p.izq!=null) {
                p = p.izq;
            }
            if (p.der!=null) {
                p = p.der;
            }
            System.out.println(p.elem);
        }
    }
    public void mostrarTerminales(){
        mostrarTerminales(raiz);
    }
    public void mostrarTerminales(Nodo p){
        if (p==null) {
            return;
        } else {
            mostrarTerminales(p.izq);
            if (p.izq ==null && p.der ==null) {
                System.out.println(p.elem);
            }
            mostrarTerminales(p.der);
        }
        
    }
    
    public void eliminarHojas(){
        raiz = eliminarHojas(raiz);
    }
    public Nodo eliminarHojas(Nodo p){
        if (p == null) {
            return null;
        } else {
            if (p.izq ==null && p.der ==null) {
                return null;
            } else {
                p.izq = eliminarHojas(p.izq);
                p.der = eliminarHojas(p.der);
                return p;
            }
        }
    }
    public void eliminarPares(){
        raiz = eliminarPares(raiz);
    }
    public Nodo eliminarPares(Nodo p){
        if (p == null) {
            return null;
        } else {
             p.izq = eliminarHojas(p.izq);
                p.der = eliminarHojas(p.der);
            if (p.elem % 2 == 0) {
                p = eliminarNodo(p);
            }
            return p;
        }
    }
    
    public void eliminar(ArrayList<Integer>l1){
        for (int i = 0; i < l1.size(); i++) {
            int x = l1.get(i);
            if (seEncuentra(x)) {
                eliminar(x);
            }
        }
    }
    public boolean seEncuentra(int x){
        return seEncuentra(raiz,x);
    }
    public boolean seEncuentra(Nodo p,int x){
        if (p == null) {
            return false;
        } else {
            if (x == p.elem) {
                return true;
            } else {
                if (x<p.elem) {
                    return seEncuentra(p.izq,x);
                } else {
                    return seEncuentra(p.der,x);
                }
            }
        }
    }
    
    public void eliminarMenor(){
        if(raiz!= null){
            int m = menor();
            eliminar(m);
        }
    }
    public int menor(){
        return menor(raiz);
    }
    public int menor(Nodo p){
        if (p.izq == null) {
            return p.elem;
        }
        return menor(p.izq);
    }
    
    public void eliminarNivel(int n){
        raiz = eliminarNivel(raiz,0,n);
    }
    public Nodo eliminarNivel(Nodo p,int actNivel,int n){
        if (p == null) {
            return null;
        } else {
            if (actNivel == n) {
                return null;
            } else {
                p.izq = eliminarNivel(p.izq,actNivel+1,n);
                p.der = eliminarNivel(p.der,actNivel+1,n);
                return p;
            }
        }
    }
    
    
    
    
    
    
}
