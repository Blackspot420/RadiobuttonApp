

import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;


public class MainApp {

    public static class RadioButtonApp extends JFrame {
        private final JLabel imageLabel;
        private final ButtonGroup group;
    
        public RadioButtonApp() {
            setTitle("RadioButtonApp");
            setSize(350, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new FlowLayout());
    
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
            JRadioButton birdButton = new JRadioButton("Bird");
            JRadioButton catButton = new JRadioButton("Cat");
            JRadioButton dogButton = new JRadioButton("Dog");
            JRadioButton rabbitButton = new JRadioButton("Rabbit");
            JRadioButton pigButton = new JRadioButton("Pig");
    
            group = new ButtonGroup();
            group.add(birdButton);
            group.add(catButton);
            group.add(dogButton);
            group.add(rabbitButton);
            group.add(pigButton);
    
            panel.add(birdButton);
            panel.add(catButton);
            panel.add(dogButton);
            panel.add(rabbitButton);
            panel.add(pigButton);
    
            imageLabel = new JLabel();
            imageLabel.setPreferredSize(new Dimension(150, 150));
    
            add(panel);
            add(imageLabel);
    
            ActionListener listener = e -> {
                String selected = e.getActionCommand();
                updateImage(selected);
                JOptionPane.showMessageDialog(null, "You selected: " + selected);
            };
    
            birdButton.addActionListener(listener);
            catButton.addActionListener(listener);
            dogButton.addActionListener(listener);
            rabbitButton.addActionListener(listener);
            pigButton.addActionListener(listener);
    
            birdButton.setActionCommand("Bird");
            catButton.setActionCommand("Cat");
            dogButton.setActionCommand("Dog");
            rabbitButton.setActionCommand("Rabbit");
            pigButton.setActionCommand("Pig");
        }
    
        private void updateImage(String pet) {
            String path = "resources/" + pet.toLowerCase() + ".png";
            URL imageUrl = getClass().getClassLoader().getResource(path);
    
            if (imageUrl == null) {
                System.out.println("Image not found: " + path);
                return;
            }
    
            ImageIcon icon = new ImageIcon(imageUrl);
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

            imageLabel.setIcon(new ImageIcon(resizedImage));
            }

                public static void main(String[] args) {
                    SwingUtilities.invokeLater(() -> {
                        new RadioButtonApp().setVisible(true);
                    });
                }
            }
        }
    
    














