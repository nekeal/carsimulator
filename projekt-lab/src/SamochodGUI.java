import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SamochodGUI {
    private JPanel mainPanel;
    private JProgressBar distanceProgress;
    private JTextField model;
    private JTextField maxPredkosc;
    private JTextField nrRejest;
    private JTextField x;
    private JTextField y;
    private JCheckBox wlacznik;
    private JButton obrotyUpBtn;
    private JTextField obroty;
    private JTextField MaxObroty;
    private JButton obrotyDownBtn;
    private JSpinner aktBieg;
    private JSpinner aktPrzelozenie;
    private JLabel label10;
    private JCheckBox stanSprzegla;
    private JProgressBar aktPredkosc;
    private JPanel mapaPanel;
    private JLabel positionLabel;
    private JLabel targetLabel;
    private JComboBox samochodCBox;
    private JButton addNewCarBtn;
    private JButton deleteCarBtn;
    private Samochod samochod;
    private ArrayList<Samochod> samochodList;

    public static void main(String[] args) {
        SamochodGUI s = new SamochodGUI();
        JFrame frame = new JFrame("SamochodGUI");
        frame.setVisible(true);
        frame.setContentPane(s.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1300, 800);
        System.out.println("RUN GUI");
    }

    private void createUIComponents() {
        obrotyUpBtn = new BasicArrowButton(SwingConstants.NORTH);
        obrotyDownBtn = new BasicArrowButton(SwingConstants.SOUTH);
        obrotyUpBtn.setPreferredSize(new Dimension(100, -1));
        obrotyDownBtn.setPreferredSize(new Dimension(100, -1));
    }

    public SamochodGUI() {
        this.samochodList = new ArrayList<Samochod>();
        samochodList.add(Kontroler.getPredefinedSamochod(1));
        samochodList.add(Kontroler.getPredefinedSamochod(2));
        System.out.println(new DefaultComboBoxModel(samochodList.toArray()).toString());
        samochodCBox.setModel(new DefaultComboBoxModel(samochodList.toArray()));
        samochod = Kontroler.getPredefinedSamochod(1);
        aktPredkosc.setMinimum(0);
        aktPredkosc.setMaximum((int)getWybranySamochod().getMaxPredkosc());
        aktPredkosc.setStringPainted(true);
        for(int i=0; i<samochodList.size(); i++)
            samochodList.get(i).start();
        odswiez();
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                odswiez();
            }
        });

        obrotyUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                getWybranySamochod().dodajGazu();

            }
        });
        obrotyDownBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                getWybranySamochod().hamuj();

            }
        });
        timer.setInitialDelay(500);
        timer.start();
        aktBieg.addComponentListener(new ComponentAdapter() {
        });
        aktBieg.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                int value = (int)aktBieg.getValue();
                if(value>getWybranySamochod().getAktBieg())
                    getWybranySamochod().nastepnyBieg();
                else if(value<getWybranySamochod().getAktBieg())
                    getWybranySamochod().poprzedniBieg();
            }
        });
        mapaPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                getWybranySamochod().setCel(new Pozycja(e.getX(), e.getY()));
                targetLabel.setBounds(e.getX(), e.getY(), 10,10);
                System.out.println("Ustawiam nowy cel: ");
                new Pozycja(e.getX(), e.getY()).print();
            }
        });
        wlacznik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(wlacznik.isSelected())
                    getWybranySamochod().wlacz();
                else
                    getWybranySamochod().wylacz();
            }
        });
        addNewCarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               NewSamochodForm form = new NewSamochodForm(samochodCBox);
            }
        });
        deleteCarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(samochodCBox.getItemCount() > 1)
                {
                    getWybranySamochod().stop();
                    samochodCBox.removeItem(getWybranySamochod());
                }
            }
        });
        stanSprzegla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(stanSprzegla.isSelected())
                    getWybranySamochod().wcisnijSprzeglo();
                else
                    getWybranySamochod().zwolnijSprzeglo();
            }
        });
    }
    public Samochod getWybranySamochod(){

        return (Samochod) samochodCBox.getSelectedItem();
    }
    private void odswiez(){
//        System.out.println("odswiezanie interfejsu");
        Samochod selected = getWybranySamochod();
        model.setText(selected.getModel());
        maxPredkosc.setText(Double.toString(selected.getMaxPredkosc()));
        nrRejest.setText(selected.getNrRejest());
        obroty.setText(Double.toString(selected.getAktObroty()));
        MaxObroty.setText(String.valueOf(selected.getMaxObroty()));
        wlacznik.setSelected(selected.getStanWlaczenia());

        x.setText(Double.toString(selected.getAktPozycja().getX()));
        y.setText(Double.toString(selected.getAktPozycja().getY()));

        aktBieg.setValue(selected.getAktBieg());
        aktPrzelozenie.setEnabled(false);
        aktPrzelozenie.setValue(selected.getAktPrzelozenie());
        stanSprzegla.setSelected(selected.getStanSprzegla());
        aktPredkosc.setValue((int)selected.getAktPredkosc());
        aktPredkosc.setString(Double.toString(selected.getAktPredkosc()) + '/' + selected.getMaxPredkosc());
        positionLabel.setBounds((int) selected.getAktPozycja().getX(), (int)selected.getAktPozycja().getY() ,10 ,10);
        if(selected.getCel() != null)
        {
            distanceProgress.setMaximum((int)selected.getStartowaPozycja().odleglosc(selected.getCel()));
            distanceProgress.setMinimum(0);
            distanceProgress.setValue((int)((selected.getAktPozycja().odleglosc(selected.getCel()))));
            distanceProgress.setString(Double.toString((selected.getAktPozycja().odleglosc(selected.getCel()))/(selected.getStartowaPozycja().odleglosc(selected.getCel()))));}
    }
}
