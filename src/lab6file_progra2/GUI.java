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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.BadLocationException;

/**
 *
 * @author LENOVO
 */
public class GUI {
    // atributos
    frame Frame;
    panel mainPanel;
    panel filePanel;
    JButton color;
    JButton fuente;
    JButton tam;
    scroller Scroll;
    GridBagManager gbm;
    ManejoArchivos MA; 
    JTree tree;
    JButton newFile;
    JButton open;
    JButton save;
    
    private texto Texto;
    private JTextPane txtPane;
    
    // numeros
    Dimension textBoxSize = new Dimension(300, 300);
    
    
    public GUI () {
        //
        
        //
        Frame = new frame(new Dimension(600, 600), "WORD");
        mainPanel = new panel(Color.GRAY, new BorderLayout(), this);
        filePanel = new panel(Color.WHITE, null, this);
        color = new JButton(" color ");
        fuente = new JButton(" fuente ");
        tam = new JButton(" tamano ");
        gbm = new GridBagManager();
        Texto = new texto((txtPane = new JTextPane()));
        Scroll = new scroller(Color.WHITE, new BorderLayout(), false, this,Texto);
        MA= new ManejoArchivos();
        tree = new JTree();
        save = new JButton("save");
        newFile = new JButton("new");
        open = new JButton("open");
        
        JPanel btns = new JPanel(new GridLayout(1, 6));
        btns.add(tam);
        btns.add(color);
        btns.add(fuente);
        btns.add(save);
        btns.add(newFile);
        btns.add(open);
        
        tam.addActionListener(e -> Texto.cambiarTamano());
        color.addActionListener(e -> Texto.cambiarColor());
        fuente.addActionListener(e -> Texto.cambiarFuente());
        save.addActionListener(e -> {
            try{
                if (MA.getFile() == null){    
                    MA.setDireccion(JOptionPane.showInputDialog("Ingrese el nombre"));
                    MA.crearArchivo();
                }
                MA.escribir(Texto.getTextPane().getStyledDocument());
            }catch (IOException f) {
                System.out.println("popop");
            } 
            catch (BadLocationException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        newFile.addActionListener(e -> {new Lab6File_Progra2();});
        open.addActionListener(e -> {
              
            MA.setDireccion(JOptionPane.showInputDialog("Ingrese el nombre"));
            try{
                Texto.getTextPane().setText;
            }catch (IOException g){
                System.out.println("opopopo");
            }
        });
        
        //
        Scroll.setPreferredSize(new Dimension(300, 300));
        
        //
        mainPanel.add(btns, BorderLayout.NORTH);
        mainPanel.add(Scroll, BorderLayout.CENTER);
        mainPanel.add(filePanel, BorderLayout.WEST);
        mainPanel.setPreferredSize(new Dimension(400, 550));
        
        //
        filePanel.setPreferredSize(new Dimension(150, 550));
        filePanel.add(tree);
        
        //
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLayout(new BorderLayout());
        Frame.add(mainPanel, BorderLayout.CENTER);

        
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
    private texto Texto;
    private GUI gui;
    
    public scroller (Color color, LayoutManager layout, boolean horizontal, GUI gui, texto Texto) {
        // configuracion
        containerPanel = new JPanel();
        this.Texto = Texto;
        this.gui = gui;
        if (horizontal == true) {
            setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        } else {
            setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        }
        
        setSize(gui.textBoxSize);
        
        // componentes 
        containerPanel.setSize(this.getSize());
        Texto.getTextPane().setSize(containerPanel.getSize());      
        containerPanel.add(Texto.getTextPane());
        
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