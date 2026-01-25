/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaD;

/**
 *
 * @author Tower
 */
public class Nodo {
    public Nodo ant;
    public int elem;
    public Nodo prox;

    public Nodo(Nodo ant, int elem, Nodo prox) {
        this.ant = ant;
        this.elem = elem;
        this.prox = prox;
    }   
}
