/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbolpack;
import java.util.Random;
/**
 *
 * @author Tower
 */

import java.util.Random;

public class Arbol {
    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    // 1. Insertar
    public void insertar(int x) {
        raiz = insertar(raiz, x);
    }

    private Nodo insertar(Nodo p, int x) {
        if (p == null) {
            return new Nodo(x);
        } else {
            if (x < p.elem) {
                p.izq = insertar(p.izq, x);
            } else {
                if (x > p.elem) {
                    p.der = insertar(p.der, x);
                }
            }
        }
        return p;
    }

    // 2. PreOrden
    public void preOrden() {
        preOrden(raiz);
        System.out.println();
    }

    private void preOrden(Nodo p) {
        if (p == null) {
            return;
        } else {
            System.out.print(p.elem + " ");
            preOrden(p.izq);
            preOrden(p.der);
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

    // 4. PostOrden
    public void postOrden() {
        postOrden(raiz);
        System.out.println();
    }

    private void postOrden(Nodo p) {
        if (p == null) {
            return;
        } else {
            postOrden(p.izq);
            postOrden(p.der);
            System.out.print(p.elem + " ");
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

    // 6. Cantidad de nodos
    public int cantidad() {
        return cantidad(raiz);
    }

    private int cantidad(Nodo p) {
        if (p == null) {
            return 0;
        } else {
            return 1 + cantidad(p.izq) + cantidad(p.der);
        }
    }

    // 7. Suma de elementos
    public int suma() {
        return suma(raiz);
    }

    private int suma(Nodo p) {
        if (p == null) {
            return 0;
        } else {
            return p.elem + suma(p.izq) + suma(p.der);
        }
    }

    // 8. Menor elemento
    public int menor() {
        Nodo p = raiz;
        while (p.izq != null) {
            p = p.izq;
        }
        return p.elem;
    }

    // 9. Mayor elemento
    public int mayor() {
        Nodo p = raiz;
        while (p.der != null) {
            p = p.der;
        }
        return p.elem;
    }

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

    // 12. Generar elementos
    public void generarElem(int n, int a, int b) {
        Random r = new Random(); 
        int count = 0;
        while (count < n) {
            int x = r.nextInt(b - a + 1) + a;
            if (!seEncuentra(x)) {
                insertar(x);
                count++;
            }
        }
    }

    // 13. Descendente
    public void desc() {
        desc(raiz);
        System.out.println();
    }

    private void desc(Nodo p) {
        if (p == null) {
            return;
        } else {
            desc(p.der);
            System.out.print(p.elem + " ");
            desc(p.izq);
        }
    }

    // 14. Mostrar terminales
    public void mostrarTerm() {
        mostrarTerm(raiz);
        System.out.println();
    }

    private void mostrarTerm(Nodo p) {
        if (p == null) {
            return;
        } else {
            mostrarTerm(p.izq);
            if (p.izq == null && p.der == null) {
                System.out.print(p.elem + " ");
            }
            mostrarTerm(p.der);
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

    // 16. Inmediato superior
    public int inmediatoSup(int x) {
        Nodo p = raiz;
        Nodo sucesor = null;

        while (p != null) {
            if (x < p.elem) {
                sucesor = p;
                p = p.izq;
            } else {
                if (x > p.elem) {
                    p = p.der;
                } else {
                    if (p.der != null) {
                        p = p.der;
                        while (p.izq != null) {
                            p = p.izq;
                        }
                        return p.elem;
                    }
                    break;
                }
            }
        }

        if (sucesor != null) {
            return sucesor.elem;
        } else {
            return x;
        }
    }

    // 17. Inmediato inferior
    public int inmediatoInf(int x) {
        Nodo p = raiz;
        Nodo pred = null;

        while (p != null) {
            if (x > p.elem) {
                pred = p;
                p = p.der;
            } else {
                if (x < p.elem) {
                    p = p.izq;
                } else {
                    if (p.izq != null) {
                        p = p.izq;
                        while (p.der != null) {
                            p = p.der;
                        }
                        return p.elem;
                    }
                    break;
                }
            }
        }

        if (pred != null) {
            return pred.elem;
        } else {
            return x;
        }
    }

    // 18. ¿Están todos en otro árbol?
    public boolean estanTodos(Arbol A2) {
        return estanTodos(raiz, A2);
    }

    private boolean estanTodos(Nodo p, Arbol A2) {
        if (p == null) {
            return true;
        } else {
            if (!A2.seEncuentra(p.elem)) {
                return false;
            } else {
                return estanTodos(p.izq, A2) && estanTodos(p.der, A2);
            }
        }
    }

    // 19. ¿Mismos elementos?
    public boolean mismosElem(Arbol A2) {
        if (this.cantidad() == A2.cantidad() && this.estanTodos(A2)) {
            return true;
        } else {
            return false;
        }
    }
    //20
    public int altura() {
    return altura(raiz);
}

    private int altura(Nodo p) {
        if (p == null) {
            return -1; // árbol vacío = -1, un solo nodo = 0
        } else {
            int ai = altura(p.izq);
            int ad = altura(p.der);
            if (ai > ad) {
                return ai + 1;
            } else {
                return ad + 1;
            }
        }
    }
    //20
    public int cantidadInternos() {
        return cantidadInternos(raiz);
    }

    private int cantidadInternos(Nodo p) {
        if (p == null) {
            return 0;
        } else {
            if (p.izq != null || p.der != null) {
                return 1 + cantidadInternos(p.izq) + cantidadInternos(p.der);
            } else {
                return 0;
            }
        }
    }
    
    //20
    public int nivel(int x) {
    return nivel(raiz, x, 0);
    }

    private int nivel(Nodo p, int x, int nivel) {
        if (p == null) {
            return -1; // no existe
        } else {
            if (x == p.elem) {
                return nivel;
            } else {
                if (x < p.elem) {
                    return nivel(p.izq, x, nivel + 1);
                } else {
                    return nivel(p.der, x, nivel + 1);
                }
            }
        }
    }
    //20
    public void mostrarNivel(int k) {
    mostrarNivel(raiz, 0, k);
    System.out.println();
    }

    private void mostrarNivel(Nodo p, int nivelAct, int k) {
        if (p == null) {
            return;
        } else {
            if (nivelAct == k) {
                System.out.print(p.elem + " ");
            } else {
                mostrarNivel(p.izq, nivelAct + 1, k);
                mostrarNivel(p.der, nivelAct + 1, k);
            }
        }
    }
    //20
    public boolean balanceado() {
        return balanceado(raiz);
    }
    private boolean balanceado(Nodo p) {
        if (p == null) {
            return true;
        } else {
            int ai = altura(p.izq);
            int ad = altura(p.der);

            int dif;
            if (ai > ad) {
                dif = ai - ad;
            } else {
                dif = ad - ai;
            }

            if (dif > 1) {
                return false;
            } else {
                return balanceado(p.izq) && balanceado(p.der);
            }
        }
    }
}


