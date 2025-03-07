/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6file_progra2;

import java.awt.Color;

public class texto {
    public void cambiarColor() {
        Color color = JColorChooser.showDialog(null, "Seleccionar Color", Color.BLACK);
        if (color != null) {
            SimpleAttributeSet attrs = new SimpleAttributeSet();
            StyleConstants.setForeground(attrs, color);
            textPane.setCharacterAttributes(attrs, false);
        }
    }
}
