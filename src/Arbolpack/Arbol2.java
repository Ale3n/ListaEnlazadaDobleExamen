/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbolpack;

/**
 *
 * @author Tower
 */
import java.util.ArrayList;
import java.util.Random;

public class Arbol2 {
    private Nodo raiz;

    public Arbol2() {
        raiz = null;
    }

    // 1. generarElem
    public void generarElem(int n, int a, int b) {
        if (n > 0) {
            generarElem(n - 1, a, b);
            Random r = new Random();
            int x = r.nextInt(b - a + 1) + a;
            if (!seEncuentra(x)) insertar(x);
        }
    }

    // 2. insertar
    public void insertar(int x) {
        raiz = insertar(raiz, x);
    }

    private Nodo insertar(Nodo p, int x) {
        if (p == null) return new Nodo(x);
        if (x < p.elem) p.izq = insertar(p.izq, x);
        else if (x > p.elem) p.der = insertar(p.der, x);
        return p;
    }

    // 3. preOrden
    public void preOrden() {
        preOrden(raiz);
    }

    private void preOrden(Nodo p) {
        if (p == null) return;
        System.out.print(p.elem + " ");
        preOrden(p.izq);
        preOrden(p.der);
    }

    // 4. inOrden
    public void inOrden() {
        inOrden(raiz);
    }

    private void inOrden(Nodo p) {
        if (p == null) return;
        inOrden(p.izq);
        System.out.print(p.elem + " ");
        inOrden(p.der);
    }

    // 5. postOrden
    public void postOrden() {
        postOrden(raiz);
    }

    private void postOrden(Nodo p) {
        if (p == null) return;
        postOrden(p.izq);
        postOrden(p.der);
        System.out.print(p.elem + " ");
    }

    // 6. niveles
    public void niveles() {
        niveles(raiz, 1);
    }

    private void niveles(Nodo p, int nivel) {
        if (p == null) return;
        niveles(p.izq, nivel + 1);
        System.out.println(p.elem + "\t" + nivel);
        niveles(p.der, nivel + 1);
    }

    // 7. desc
    public void desc() {
        desc(raiz);
    }

    private void desc(Nodo p) {
        if (p == null) return;
        desc(p.der);
        System.out.print(p.elem + " ");
        desc(p.izq);
    }

    // 8. seEncuentra
    public boolean seEncuentra(int x) {
        return seEncuentra(raiz, x);
    }

    private boolean seEncuentra(Nodo p, int x) {
        if (p == null) return false;
        if (p.elem == x) return true;
        if (x < p.elem) return seEncuentra(p.izq, x);
        return seEncuentra(p.der, x);
    }

    // 9. cantidad
    public int cantidad() {
        return cantidad(raiz);
    }

    private int cantidad(Nodo p) {
        if (p == null) return 0;
        return cantidad(p.izq) + cantidad(p.der) + 1;
    }

    // 10. suma
    public int suma() {
        return suma(raiz);
    }

    private int suma(Nodo p) {
        if (p == null) return 0;
        return suma(p.izq) + suma(p.der) + p.elem;
    }

    // 11. menor
    public int menor() {
        return menor(raiz);
    }

    private int menor(Nodo p) {
        if (p.izq == null) return p.elem;
        return menor(p.izq);
    }

    // 12. mayor
    public int mayor() {
        return mayor(raiz);
    }

    private int mayor(Nodo p) {
        if (p.der == null) return p.elem;
        return mayor(p.der);
    }

    // 13. preOrden(L1)
    public void preOrden(ArrayList<Integer> L1) {
        preOrden(raiz, L1);
    }

    private void preOrden(Nodo p, ArrayList<Integer> L1) {
        if (p == null) return;
        L1.add(p.elem);
        preOrden(p.izq, L1);
        preOrden(p.der, L1);
    }

    // 14. inOrden(L1)
    public void inOrden(ArrayList<Integer> L1) {
        inOrden(raiz, L1);
    }

    private void inOrden(Nodo p, ArrayList<Integer> L1) {
        if (p == null) return;
        inOrden(p.izq, L1);
        L1.add(p.elem);
        inOrden(p.der, L1);
    }

    // 15. postOrden(L1)
    public void postOrden(ArrayList<Integer> L1) {
        postOrden(raiz, L1);
    }

    private void postOrden(Nodo p, ArrayList<Integer> L1) {
        if (p == null) return;
        postOrden(p.izq, L1);
        postOrden(p.der, L1);
        L1.add(p.elem);
    }

    // 16. niveles(L1)
    public void niveles(ArrayList<Integer> L1) {
        int h = alturaMayor();
        for (int i = 0; i <= h; i++)
            niveles(raiz, i, L1);
    }

    private void niveles(Nodo p, int n, ArrayList<Integer> L1) {
        if (p == null) return;
        if (n == 0) L1.add(p.elem);
        else {
            niveles(p.izq, n - 1, L1);
            niveles(p.der, n - 1, L1);
        }
    }

    // 17. mostrarNivel
    public void mostrarNivel() {
        mostrarNivel(raiz, 0);
    }

    private void mostrarNivel(Nodo p, int n) {
        if (p == null) return;
        System.out.println(p.elem + " -> nivel " + n);
        mostrarNivel(p.izq, n + 1);
        mostrarNivel(p.der, n + 1);
    }

    // 18. sumarNivel
    public void sumarNivel(ArrayList<Integer> L1) {
        sumarNivel(raiz, 0, L1);
    }

    private void sumarNivel(Nodo p, int n, ArrayList<Integer> L1) {
        if (p == null) return;
        if (L1.size() <= n) L1.add(0);
        L1.set(n, L1.get(n) + p.elem);
        sumarNivel(p.izq, n + 1, L1);
        sumarNivel(p.der, n + 1, L1);
    }

    // 19. alturaMayor
    public int alturaMayor() {
        return alturaMayor(raiz);
    }

    private int alturaMayor(Nodo p) {
        if (p == null) return -1;
        return 1 + Math.max(alturaMayor(p.izq), alturaMayor(p.der));
    }

    // 20. alturaMenor
    public int alturaMenor() {
        return alturaMenor(raiz);
    }

    private int alturaMenor(Nodo p) {
        if (p == null) return Integer.MAX_VALUE;
        if (p.izq == null && p.der == null) return 0;
        return 1 + Math.min(alturaMenor(p.izq), alturaMenor(p.der));
    }

    // 21. mostrarTerm
    public void mostrarTerm() {
        mostrarTerm(raiz);
    }

    private void mostrarTerm(Nodo p) {
        if (p == null) return;
        mostrarTerm(p.izq);
        if (p.izq == null && p.der == null)
            System.out.print(p.elem + " ");
        mostrarTerm(p.der);
    }

    // 22. cantidadTerm
    public int cantidadTerm() {
        return cantidadTerm(raiz);
    }

    private int cantidadTerm(Nodo p) {
        if (p == null) return 0;
        if (p.izq == null && p.der == null) return 1;
        return cantidadTerm(p.izq) + cantidadTerm(p.der);
    }

    // 23. lineal
    public boolean lineal() {
        return lineal(raiz);
    }

    private boolean lineal(Nodo p) {
        if (p == null) return true;
        if (p.izq != null && p.der != null) return false;
        return lineal(p.izq) && lineal(p.der);
    }

    // 24. inmediatoSup
    public int inmediatoSup(int x) {
        return inmediatoSup(raiz, x, x);
    }

    private int inmediatoSup(Nodo p, int x, int cand) {
        if (p == null) return cand;
        if (p.elem > x) return inmediatoSup(p.izq, x, p.elem);
        return inmediatoSup(p.der, x, cand);
    }

    // 25. inmediatoInf
    public int inmediatoInf(int x) {
        return inmediatoInf(raiz, x, x);
    }

    private int inmediatoInf(Nodo p, int x, int cand) {
        if (p == null) return cand;
        if (p.elem < x) return inmediatoInf(p.der, x, p.elem);
        return inmediatoInf(p.izq, x, cand);
    }
}

