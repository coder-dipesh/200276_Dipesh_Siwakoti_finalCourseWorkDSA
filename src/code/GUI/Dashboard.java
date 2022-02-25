package code.GUI;

import javax.swing.*;
import java.awt.*;

 class Dashboard {

    Dashboard() {
        JFrame f = new JFrame("Dashboard - Choose Option");
        JButton addRoute, showRoute, addConnection, showConnection;
        JLabel titleLabel;

        titleLabel = new JLabel("Dashboard");
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 45));
        f.add(titleLabel);
        titleLabel.setBounds(100, 30, 3000, 100);

        addRoute = new JButton("Add route");
        f.add(addRoute);
        addRoute.setBounds(50, 150, 500, 50);


        showRoute = new JButton("View route");
        f.add(showRoute);
        showRoute.setBounds(50, 250, 500, 50);

        addConnection = new JButton("Add Connection");
        f.add(addConnection);
        addConnection.setBounds(50, 350, 500, 50);

        showConnection = new JButton("Show Connection");
        f.add(showConnection);
        showConnection.setBounds(50, 450, 500, 50);

        addRoute.addActionListener(e -> {
            f.dispose();
            new AddrouteFrame();
        });

        showRoute.addActionListener(e -> {
            f.dispose();
            new Viewroute();
        });

        addConnection.addActionListener(e -> {
            f.dispose();
            new AddConnectionFrame();
        });

        showConnection.addActionListener(e -> {
            f.dispose();
            new ViewConnection();
        });


        f.setLayout(null);
        f.setBounds(500, 100, 600, 450);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);


        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setBounds(390, 150, 600, 600);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        new Dashboard();
    }
}