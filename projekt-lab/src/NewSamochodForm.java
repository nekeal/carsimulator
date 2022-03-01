import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class NewSamochodForm {
    private JFrame frame;
    private JTextField model;
    private JButton zapiszButton;
    private JTextField vmax;
    private JTextField nrRejest;
    private JPanel MainFrame;
    private JComboBox parentCBox;

    public NewSamochodForm(JComboBox samochodCBox) {
        parentCBox = samochodCBox;
        JFrame frame = new JFrame("NewSamochodForm");
        frame.setContentPane(this.MainFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);
        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Samochod s = Kontroler.getSamochod(nrRejest.getText(), model.getText(), Float.parseFloat(vmax.getText()));
                parentCBox.addItem(s);
                frame.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {

    }
}
