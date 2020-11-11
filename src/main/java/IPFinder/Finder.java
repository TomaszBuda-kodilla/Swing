package IPFinder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Finder extends JFrame implements ActionListener {
    JLabel label;
    JButton button;
    JTextField textField;

    Finder() {
        super("IP Generator");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        label = new JLabel("Enter URL");
        label.setBounds(140, 20, 120, 20);

        textField = new JTextField("www.");
        textField.setBounds(140, 60, 120, 20);
        textField.addActionListener(this);

        button = new JButton("Generate");
        button.setBounds(140, 100, 120, 20);
        button.addActionListener(this);

        add(button);
        add(textField);
        add(label);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String url = textField.getText();
        try {
            InetAddress inetAddress = InetAddress.getByName(url);
            String ip = inetAddress.getHostAddress();
            JOptionPane.showMessageDialog(this, ip);
        } catch (UnknownHostException unknownHostException) {
            JOptionPane.showMessageDialog(this, unknownHostException.toString());
        }
    }

    public static void main(String[] args) {
        new Finder();
    }
}
