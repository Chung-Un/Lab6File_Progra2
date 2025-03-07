/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6file_progra2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author chung
 */
public class ManejoArchivos {
    File file = null;
    static StringBuilder temp = null;
    StringBuilder main = null;
    
    public void setDireccion(String direccion){
          file = new File(direccion);
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
    
    public StringBuilder dir(){
        StringBuilder builder = new StringBuilder("");
        if(file.isDirectory()){
            builder.append(file.getName() + "\n");
            for(File child: file.listFiles()){
               builder.append(file.getName() +"\n");
            }
        }
        else if(file.isFile()){
         builder.append(file.getName());
        }
    return builder;
    }
}
