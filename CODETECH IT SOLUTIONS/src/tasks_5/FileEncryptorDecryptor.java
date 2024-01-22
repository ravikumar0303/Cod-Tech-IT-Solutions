package tasks_5;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileEncryptorDecryptor {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FileEncryptorDecryptorGUI();
        });
    }
}

class FileEncryptorDecryptorGUI extends JFrame {

    private JTextArea textArea;
    private JTextField keyField;

    public FileEncryptorDecryptorGUI() {
        setTitle("File Encryptor/Decryptor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JLabel keyLabel = new JLabel("Enter Key:");
        controlPanel.add(keyLabel);

        keyField = new JTextField(5);
        controlPanel.add(keyField);

        JButton encryptButton = new JButton("Encrypt");
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encryptFile();
            }
        });
        controlPanel.add(encryptButton);

        JButton decryptButton = new JButton("Decrypt");
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decryptFile();
            }
        });
        controlPanel.add(decryptButton);

        add(controlPanel, BorderLayout.SOUTH);

        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void encryptFile() {
        int key = getKeyFromField();
        processFile(true, key);
    }

    private void decryptFile() {
        int key = getKeyFromField();
        processFile(false, key);
    }

    private int getKeyFromField() {
        try {
            return Integer.parseInt(keyField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid key. Please enter a valid integer key.");
            return -1;
        }
    }

    private void processFile(boolean encrypt, int key) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            File outputFile;

            if (encrypt) {
                outputFile = new File(selectedFile.getParent(), "encrypted_" + selectedFile.getName());
            } else {
                outputFile = new File(selectedFile.getParent(), "decrypted_" + selectedFile.getName());
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String processedLine = processLine(line, key, encrypt);
                    writer.write(processedLine);
                    writer.newLine();
                }

                JOptionPane.showMessageDialog(this, "Operation completed successfully.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage());
            }
        }
    }

    private String processLine(String line, int key, boolean encrypt) {
        StringBuilder result = new StringBuilder();

        for (char ch : line.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                int offset = (ch - base + (encrypt ? key : -key) + 26) % 26;
                result.append((char) (base + offset));
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
