/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listaD;

/**
 *
 * @author Tower
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ListaD n = new ListaD();
        n.insertarPrim(1);
        n.insertarPrim(2);        
        n.insertarPrim(3);
        n.insertarPrim(4);
        System.out.println(n);
         ListaD n2 = new ListaD();
        n2.insertarPrim(1);
        n2.insertarPrim(2);        
        //n2.insertarPrim(3);
        //n2.insertarPrim(4);
        n.eliminarSiEstaEn(n2);
        System.out.println(n);
        
        
        
        

    }
    
}
