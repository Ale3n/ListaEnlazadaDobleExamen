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
public class ArbolEJEX {
     private Nodo raiz;

    public ArbolEJEX() {
        raiz = null;
    }

    // 1. Insertar
    public void insertar(int x) {
        raiz = insertar(raiz, x);
    }

    private Nodo insertar(Nodo p, int x) {
        if (p == null) {
            return new Nodo(x);
        } 
        if (x < p.elem) {
            p.izq = insertar(p.izq, x);
        } else {
            p.der = insertar(p.der, x);
        }     
        return p;
    }
    public void eliminar(int x){
        raiz = eliminar(x,raiz);
    }
    
    private Nodo eliminar(int x, Nodo p) {
        if (p == null) {
            return null;
        } 
        if(p.elem == x){
            p = eliminarNodo(p);
        }else{  
            if (x < p.elem) {
                p.izq = eliminar(x , p.izq);
            } else {
                p.der = eliminar(x,p.der);
            } 
        }
        return p;
        
    }
    private Nodo eliminarNodo(Nodo p){
        if (p.izq == null && p.der == null) return null;
        if (p.izq == null && p.der != null) return p.der;
        if (p.izq != null && p.der == null) return p.izq;
        Nodo q = p.izq;
        while (q.der!=null) {
            q = q.der;
        }
        p.elem = q.elem;
        p.izq=eliminar(q.elem, p.izq);
        return p;    
    }
    
    //-----------------------------------------------------------
    // 10. Cantidad de terminales
    public int cantidadTerm() {
        return cantidadTerm(raiz);
    }

    private int cantidadTerm(Nodo p) {
        if (p == null) {
            return 0;
        } else {
            if (p.izq == null && p.der == null) {
                return 1;
            } else {
                return cantidadTerm(p.izq) + cantidadTerm(p.der);
            }
        }
    }
    // 11. Suma de pares
    public int sumaPares() {
        return sumaPares(raiz);
    }

    private int sumaPares(Nodo p) {
        if (p == null) {
            return 0;
        } else {
            int s = sumaPares(p.izq) + sumaPares(p.der);
            if (p.elem % 2 == 0) {
                s = s + p.elem;
            }
            return s;
        }
    }
    
     // 15. postOrden(L1) 
    public void postOrden(ArrayList<Integer> L1){ 
        postOrden(raiz,L1); 
    } 
    private void postOrden(Nodo p,ArrayList<Integer> L1){ 
        if(p==null) return; 
        postOrden(p.izq,L1); 
        postOrden(p.der,L1); 
        L1.add(p.elem); 
    }
    // A1.niveles(L1) : Método que encuentra en la lista L1, el recorrido por niveles de los elementos del árbol A1.
    public void niveles()
    {
        LinkedList<Nodo> L1 = new LinkedList();
        if (raiz != null) L1.add(raiz);
        while (!L1.isEmpty()) {
            Nodo q = L1.removeFirst();
            if (q.izq != null) {
                L1.add(q.izq);
            }
            if (q.der != null) {
                L1.add(q.der);
            }
            System.out.println(q.elem);
        }
            
    }
    // 15. Árbol lineal
    public boolean lineal() {
        return lineal(raiz);
    }

    private boolean lineal(Nodo p) {
        if (p == null) {
            return true;
        } else {
            if (p.izq != null && p.der != null) {
                return false;
            } else {
                if (p.izq != null) {
                    return lineal(p.izq);
                } else {
                    return lineal(p.der);
                }
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    //Contar cuántos elementos son mayores que X
    public int mayoresQue(int x) {
    return mayoresQue(raiz, x);
}

    private int mayoresQue(Nodo p, int x) {
        if (p == null) {
            return 0;
        } else {
            if (p.elem > x) {
                return 1 + mayoresQue(p.izq, x) + mayoresQue(p.der, x);
            } else {
                return mayoresQue(p.der, x);
            }
        }
    }
    ///////////////////////////////////////////////////////////////////////////
    public void eliminarHojas() {
    raiz = eliminarHojas(raiz);
}

    private Nodo eliminarHojas(Nodo p) {
        if (p == null) {
            return null;
        } else {
            if (p.izq == null && p.der == null) {
                return null;
            } else {
                p.izq = eliminarHojas(p.izq);
                p.der = eliminarHojas(p.der);
                return p;
            }
        }
    }
    public void eliminarPares() {
    raiz = eliminarPares(raiz);
}

    private Nodo eliminarPares(Nodo p) {
        if (p == null) {
            return null;
        } else {
            p.izq = eliminarPares(p.izq);
            p.der = eliminarPares(p.der);

            if (p.elem % 2 == 0) {
                p = eliminarNodo(p);
            }
            return p;
        }
    }

    
    public void eliminar(ArrayList<Integer> L1) {
        for (int i = 0; i < L1.size(); i++) {
            int x = L1.get(i);
            if (seEncuentra(x)) {
                eliminar(x);
            }
        }
    }
    // 5. Buscar
    public boolean seEncuentra(int x) {
        return seEncuentra(raiz, x);
    }

    private boolean seEncuentra(Nodo p, int x) {
        if (p == null) {
            return false;
        } else {
            if (x == p.elem) {
                return true;
            } else {
                if (x < p.elem) {
                    return seEncuentra(p.izq, x);
                } else {
                    return seEncuentra(p.der, x);
                }
            }
        }
    }
    public void eliminarMenor() {
        if (raiz != null) {
            int m = menor();
            eliminar(m);
        }
    }
    // 11. menor
    public int menor() {
        return menor(raiz);
    }

    private int menor(Nodo p) {
        if (p.izq == null) return p.elem;
        return menor(p.izq);
    }
    
    public void eliminarNivel(int n) {
        raiz = eliminarNivel(raiz, 0, n);
    }

    private Nodo eliminarNivel(Nodo p, int nivelAct, int n) {
        if (p == null) {
            return null;
        } else {
            if (nivelAct == n) {
                return null;
            } else {
                p.izq = eliminarNivel(p.izq, nivelAct + 1, n);
                p.der = eliminarNivel(p.der, nivelAct + 1, n);
                return p;
            }
        }
    }


    // 3. InOrden
    public void inOrden() {
        inOrden(raiz);
        System.out.println();
    }

    private void inOrden(Nodo p) {
        if (p == null) {
            return;
        } else {
            inOrden(p.izq);
            System.out.print(p.elem + " ");
            inOrden(p.der);
        }
    }

    
}
