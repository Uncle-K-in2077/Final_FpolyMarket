
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NewMain {
    
    public static void copyFile(File sourceFile, File destFile) {
        if (!destFile.exists()) {
            try {
                destFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        FileChannel source = null;
        FileChannel destination = null;
        
        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        } catch (IOException e) {
        } finally {
            if (source != null) {
                try {
                    source.close();
                } catch (IOException ex) {
                    Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (destination != null) {
                try {
                    destination.close();
                } catch (IOException ex) {
                    Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void main(String[] args) {
////        icon.
//        File file = new File("src/IMAGE/mirinda.png");
//        ImageIcon icon = new ImageIcon(file.getPath());
//        copyFile(file, new File("src/TEXT/file.png"));

        JFileChooser c = new JFileChooser();
//Setting Up The Filter
        FileFilter imageFilter = new FileNameExtensionFilter(
                "Image files", ImageIO.getReaderFileSuffixes());

//Attaching Filter to JFileChooser object
        c.setFileFilter(imageFilter);

//Displaying Filechooser
        int rVal = c.showOpenDialog(new JPanel());
        System.out.println(c.getSelectedFile().getAbsolutePath());
        if (rVal == JFileChooser.APPROVE_OPTION) {
            File file = new File(c.getSelectedFile().getAbsolutePath());
            copyFile(file, new File("src/TEXT/" + file.getName()));
        }
    }
    
}
