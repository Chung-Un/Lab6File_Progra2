/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lab6file_progra2;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class texto {
    
    private JTextPane textPane;

    public texto(JTextPane textPane) {
        this.textPane = textPane;
    }
    
    public void cambiarColor() {
        Color color = JColorChooser.showDialog(null, "Seleccionar Color", Color.BLACK);
        if (color != null) {
            SimpleAttributeSet attrs = new SimpleAttributeSet();
            StyleConstants.setForeground(attrs, color);
            textPane.setCharacterAttributes(attrs, false);
            
        }
    }
     public void cambiarFuente() {
        String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        String fuenteSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccionar fuente", "Fuente", JOptionPane.PLAIN_MESSAGE, null, fuentes, fuentes[0]);
        if (fuenteSeleccionada != null) {
            SimpleAttributeSet attrs = new SimpleAttributeSet();
            StyleConstants.setFontFamily(attrs, fuenteSeleccionada);
            textPane.setCharacterAttributes(attrs, false);
        }
    }
      public void cambiarTamano() {
        String tamanoStr = JOptionPane.showInputDialog(null, "Ingresar tamaño de fuente:");
        if (tamanoStr != null) {
            try {
                int tamano = Integer.parseInt(tamanoStr);
                SimpleAttributeSet attrs = new SimpleAttributeSet();
                StyleConstants.setFontSize(attrs, tamano);
                textPane.setCharacterAttributes(attrs, false);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
