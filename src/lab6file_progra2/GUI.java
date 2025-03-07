/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6file_progra2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.*;

/**
 *
 * @author LENOVO
 */
public class GUI {
    // atributos
    frame Frame;
    panel mainPanel;
    panel filePanel;
    panel colorPanel;
    JLabel fuente;
    JLabel tam;
    JComboBox fuenteBox;
    JComboBox tamBox;
    JComboBox colorBox;
    scroller Scroll;
    GridBagManager gbm;
     
    // numeros
    Dimension textBoxSize = new Dimension(300, 300);
    
    
    public GUI () {
        //
        
        //
        Frame = new frame(new Dimension(600, 600), "WORD");
        mainPanel = new panel(Color.GRAY, new BorderLayout(), this);
        filePanel = new panel(Color.WHITE, null, this);
        colorPanel = new panel(Color.GRAY, new GridLayout(), this);
        fuente = new JLabel("Fuente: ");
        tam = new JLabel("Tamano: ");
        Scroll = new scroller(Color.WHITE, new BorderLayout(), false, this);
        gbm = new GridBagManager();
        
        //
        Scroll.setPreferredSize(new Dimension(300, 300));
        
        //
        colorPanel.setPreferredSize(new Dimension(300, 150));
        mainPanel.add(colorPanel, BorderLayout.NORTH);
        mainPanel.add(Scroll, BorderLayout.CENTER);
        mainPanel.add(tam, BorderLayout.NORTH);
        mainPanel.add(fuente, BorderLayout.NORTH);
        mainPanel.setPreferredSize(new Dimension(400, 550));
        
        //
        filePanel.setPreferredSize(new Dimension(150, 550));
        
        //
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLayout(new BorderLayout());
        Frame.add(mainPanel, BorderLayout.CENTER);
        Frame.add(filePanel, BorderLayout.WEST);
        
        Frame.setVisible(true);
    }
    
}

class frame extends JFrame {

    public frame (Dimension size, String title) {
        // configuracion principal
        super(title);
        setSize(size);
        
    }
    
    JButton crearBtn (Color color) {
        JButton btn = new JButton();
        btn.setBackground(color);
        return btn;
    }
    
}

class panel extends JPanel {
    private GUI gui;
    
    public panel (Color color, LayoutManager layout, GUI gui) {
        setBackground (color);  
        setLayout(layout);
        this.gui = gui;
    } 
    
    
}

class scroller extends JScrollPane {
    private JPanel containerPanel;
    private JTextArea testo;
    private GUI gui;
    
    public scroller (Color color, LayoutManager layout, boolean horizontal, GUI gui) {
        // configuracion
        containerPanel = new JPanel();
        testo = new JTextArea();
        this.gui = gui;
        if (horizontal == true) {
            setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        } else {
            setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        }
        
        setSize(gui.textBoxSize);
        
        // componentes 
        containerPanel.setSize(this.getSize());
        testo.setSize(containerPanel.getSize());
        testo.setWrapStyleWord(true);
        testo.setLineWrap(true);
        containerPanel.add(testo);
        
        // visibilidad
        setViewportView(containerPanel);
        setVisible(true);
    }
    
    public void update () {
        setViewportView(containerPanel);
        revalidate();
        repaint();
    }
}