/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6file_progra2;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author LENOVO
 */
public class GridBagManager {
    
    GridBagConstraints setGBC (int x, int y, int gridWidth, int gridHeight, int fill, Insets insets) {
        GridBagConstraints GBC = new GridBagConstraints();
        
        GBC.gridx = x;
        GBC.gridy = y;
        GBC.gridwidth = gridWidth; // cuantas columnas de espacio abarca (default is 1)
        GBC.gridheight = gridHeight; // cuantas filas de espacio abarca (default is 1)
        GBC.fill = fill; // fill remaining space: none, horizontal or both
        GBC.insets = insets;
        
        return GBC;
    }
    
    GridBagConstraints setGBC (int x, int y, int gridWidth, int gridHeight) {
        GridBagConstraints GBC = new GridBagConstraints();
        
        GBC.gridx = x;
        GBC.gridy = y;
        GBC.gridwidth = gridWidth; // cuantas columnas de espacio abarca (default is 1)
        GBC.gridheight = gridHeight; // cuantas filas de espacio abarca (default is 1)
        GBC.insets = new Insets(5, 5, 5, 5);
        
        return GBC;
    }
    
    GridBagConstraints setGBC (int x, int y) {
        GridBagConstraints GBC = new GridBagConstraints();
        
        GBC.gridx = x;
        GBC.gridy = y;
        GBC.insets = new Insets (5, 5, 5, 5);
        
        return GBC;
    }
    
    GridBagConstraints setGBC (int x, int y, int fill) {
        GridBagConstraints GBC = new GridBagConstraints();
        
        GBC.gridx = x;
        GBC.gridy = y;
        GBC.fill = fill; // fill remaining space: none, horizontal or both
        GBC.insets = new Insets (5, 5, 5, 5);
        
        return GBC;
    }
}

