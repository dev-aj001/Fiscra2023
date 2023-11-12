import org.jdesktop.swingx.JXImageView;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImageSelectorExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image Selector Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JXImageView imageView = new JXImageView();
            JButton selectImageButton = new JButton("Seleccionar Imagen");

            selectImageButton.addActionListener(e -> {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    
                    // Cargar la imagen original
                    ImageIcon originalIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    
                    // Redimensionar la imagen
                    Image originalImage = originalIcon.getImage();
                    Image resizedImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    
                    // Crear un nuevo ImageIcon con la imagen redimensionada
                    ImageIcon resizedIcon = new ImageIcon(resizedImage);
                    
                    // Establecer la imagen redimensionada en el JXImageView
                    imageView.setImage(resizedIcon.getImage());
                }
            });

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(selectImageButton, BorderLayout.NORTH);
            panel.add(imageView, BorderLayout.CENTER);

            frame.getContentPane().add(panel);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
