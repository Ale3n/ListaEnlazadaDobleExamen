/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbolpack;

/**
 *
 * @author Tower
 */
public class Nodo {
    Nodo izq;
    int elem;
    Nodo der;

    public Nodo(int elem){
        this.elem = elem;
        izq = der = null;
    }
}
