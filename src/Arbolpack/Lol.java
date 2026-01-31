/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Arbolpack;

/**
 *
 * @author Tower
 */
public class Lol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArbolEJEX a = new ArbolEJEX();
        a.insertar(5);
        a.insertar(2);
        a.insertar(3);
        a.insertar(4);
        a.insertar(1);
        a.eliminar(5);
        a.eliminar(1);
        a.inOrden();
        
                
                
    }
    
}
