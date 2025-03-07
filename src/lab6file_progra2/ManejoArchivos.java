/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6file_progra2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author chung
 */
public class ManejoArchivos {
    private File file = null;
    private StyledDocument document = new DefaultStyledDocument();
    private RTFEditorKit rtfKit = new RTFEditorKit();

    public void setDireccion(String direccion) {
        file = new File(direccion + ".rtf");
    }

    public boolean crearArchivo() throws IOException {
        return file.createNewFile();
    }

    public boolean crearFolder() {
        return file.mkdirs();
    }

    public boolean borrar(File file) {
        if (file.isDirectory()) {
            for (File hijos : file.listFiles()) {
                borrar(hijos);
            }
        }
        return file.delete();
    }

    public void escribir(StyledDocument doc) throws IOException, BadLocationException {
        if (file.isFile()) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                rtfKit.write(fos, doc, 0, doc.getLength());
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

    public StyledDocument leer() throws IOException {
        if (file.isFile()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                document = new DefaultStyledDocument();
                rtfKit.read(fis, document, 0);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
        return document;
    }

    public DefaultMutableTreeNode estructuraTree() {
        File src = new File("Lab6File_Progra2\\Lab6File_Progra2\\src");
        return (src == null? null:crearNodos(src));
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

    public File getFile() {
        return file;
    }
}