import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetSelector extends JFrame {
    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private JLabel imageLabel;
    private ButtonGroup group;

    public PetSelector() {
        setTitle("Pet Selector");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        add(birdButton);
        add(catButton);
        add(dogButton);
        add(rabbitButton);
        add(pigButton);

        imageLabel = new JLabel();
        add(imageLabel);

        birdButton.addActionListener(new RadioButtonListener());
        catButton.addActionListener(new RadioButtonListener());
        dogButton.addActionListener(new RadioButtonListener());
        rabbitButton.addActionListener(new RadioButtonListener());
        pigButton.addActionListener(new RadioButtonListener());
    }

    private class RadioButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton source = (JRadioButton) e.getSource();
            String selectedPet = source.getText();
            ImageIcon petImage = new ImageIcon("images/" + selectedPet.toLowerCase() + ".png");
            imageLabel.setIcon(petImage);
            imageLabel.setText("You selected: " + selectedPet);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PetSelector().setVisible(true);
            }
        });
    }
}
