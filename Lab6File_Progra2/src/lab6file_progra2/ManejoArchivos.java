/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6file_progra2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author chung
 */
public class ManejoArchivos {
    File file = null;
    static StringBuilder temp = null;
    StringBuilder main = null;
    
    public void setDireccion(String direccion){
          file = new File(direccion + ".docx");
    }
    
    public boolean crearArchivo() throws IOException{
        return file.createNewFile();
    }
    
    public boolean crearFolder(){
        return file.mkdirs();
    }
    
    public boolean borrar(File file){
        if(file.isDirectory()){
            for(File hijos: file.listFiles()){
                borrar(hijos);
            }
        }
        return file.delete();
    }
    
    public void escribir(String contenido)throws IOException{
        if (file.isFile()){
            try(FileWriter writer = new FileWriter(file,false)){
                writer.write(contenido);
            }
        }
    }
    
    public StringBuilder leer() throws IOException{
        
        if(file.isFile()){
            temp = main;
            main = null;
            try(FileReader reader = new FileReader(file)){
                int caracter;
                while((caracter = reader.read()) != -1){
                main.append((char)caracter);
                }
            }
        }
        
        return main;
    }
    
    public DefaultMutableTreeNode estructuraTree() {
        if (file == null) {
            return null;
        }
        return crearNodos(file);
    }

    private DefaultMutableTreeNode crearNodos(File file) {
        DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(file.getName());
        
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    nodo.add(crearNodos(child));
                }
            }
        }
        return nodo;
    }
}
