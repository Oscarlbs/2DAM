

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class XMLFileHandler {
	

public static void main(String[] args) {
	
    // Crea el String con la cadena XML
    String texto = "<Libros><Libro><Titulo>El secreto</Titulo></Libro></Libros>";
    // Guarda en nombre el nombre del archivo que se creará.
    String nombre = "libros.xml";

    // Muestra un cuadro de diálogo para seleccionar la ubicación donde se guardará el archivo XML
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Guardar archivo XML");
    int userSelection = fileChooser.showSaveDialog(null);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        nombre = fileToSave.getAbsolutePath();
        try {
            // Se crea un Nuevo objeto FileWriter
            FileWriter fichero = new FileWriter(nombre);
            // Se escribe el fichero
            fichero.write(texto + "\r\n");
            // Se cierra el fichero
            fichero.close();
            JOptionPane.showMessageDialog(null, "Archivo XML guardado con éxito en: " + nombre, "Guardar archivo XML",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder al fichero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Muestra un cuadro de diálogo para seleccionar el archivo XML a leer
    fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Leer archivo XML");
    userSelection = fileChooser.showOpenDialog(null);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToOpen = fileChooser.getSelectedFile();
        try {
            // Aquí debes agregar código para leer el archivo XML y mostrar su contenido en pantalla
            JOptionPane.showMessageDialog(null, "Contenido del archivo XML: " + texto, "Leer archivo XML",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo XML", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
}
