/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Usuario
 */
public class EventEscuchar implements WindowListener{
    public void windowActivated(WindowEvent e){
        System.out.println("Ventana Activada ");
        
    }

    public void windowClosed(WindowEvent e){
        System.out.println("Ventada Closed Dispose");
    }

    public void windowClosing(WindowEvent e){
        System.out.println("Ventana Closing");
    }

    public void windowDeactivated(WindowEvent e){
        System.out.println("Ventana Desactivada");
    }

    public void windowDeiconified(WindowEvent e){
        System.out.println("Windows de Maximizada a Normal");
    }

    public void windowIconified(WindowEvent e){
        System.out.println("Windows de Normal a Maximizada");
    }

    public void windowOpened(WindowEvent e){
        System.out.println("Windows Abierta");
    }

}
