/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FormatoNumeroTelefonico extends JTextField {

    public FormatoNumeroTelefonico() {
        this.setText("");  // Establecemos el texto inicial como vacío

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // No necesitamos implementar este método
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String texto = FormatoNumeroTelefonico.this.getText();
                StringBuilder nuevoTexto = new StringBuilder();

                for (char c : texto.toCharArray()) {
                    if (Character.isDigit(c)) {
                        nuevoTexto.append(c);
                    }
                }

                FormatoNumeroTelefonico.this.setText(aplicarFormato(nuevoTexto.toString()));
            }

            private String aplicarFormato(String texto) {
                StringBuilder resultado = new StringBuilder();
                int contadorDigitos = 0;

                for (char c : texto.toCharArray()) {
                    resultado.append(c);
                    contadorDigitos++;

                    if (contadorDigitos == 3 || contadorDigitos == 6) {
                        resultado.append('-');
                    }
                }

                return resultado.toString();
            }
        });
    }
}
