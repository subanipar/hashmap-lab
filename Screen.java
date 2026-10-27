import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;


public class Screen extends JPanel implements ActionListener {

    // instance variables
    private JButton viewInfo;
    private JButton deleteState;
    private JButton viewAll;
    private JTextField viewInfoIn;
    private JTextField deleteStateIn;
    private JTextField viewAllIn;
    // constructor
    public Screen() {

        // all the buttons
        viewInfoIn = new JTextField();
        viewInfoIn.setVisible(false);
        deleteStateIn = new JTextField();
        deleteStateIn.setVisible(false);
        viewAllIn = new JTextField();
        viewAllIn.setVisible(false);
        viewInfo = new JButton();
        viewInfo.setFont(new Font("Arial", Font.BOLD, 20));
        viewInfo.setHorizontalAlignment(SwingConstants.CENTER);
        viewInfo.setBounds(13, 101, 200, 47);
        viewInfo.setText("View state information");
        this.add(viewInfo);
        viewInfo.addActionListener(this);

        deleteState = new JButton();
        deleteState.setFont(new Font("Arial", Font.BOLD, 20));
        deleteState.setHorizontalAlignment(SwingConstants.CENTER);
        deleteState.setBounds(12, 57, 200, 30);
        deleteState.setText("Delete State");
        this.add(deleteState);
        deleteState.addActionListener(this);

        viewAll = new JButton();
        viewAll.setFont(new Font("Arial", Font.BOLD, 20));
        viewAll.setHorizontalAlignment(SwingConstants.CENTER);
        viewAll.setBounds(11, 13, 200, 30);
        viewAll.setText("View all states");
        this.add(viewAll);
        viewAll.addActionListener(this);
        
        // user input stuff
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        while (choice != 6) {
            System.out.println("MENU: \n1) View All States: \n2) Add State: \n3) Delete State: \n4) View State Information: \n5) Add Pictures to a State: \n6) Exit: ");
            choice = sc.nextInt();

            // choice 1
            if (choice == 1) {
                // SUBANI
            }
            
            // choice 2
            if (choice == 2) {
                // SUBANI
            }
            
            // choice 3
            if (choice == 3) {
                // KEIYONA
            }
            
            // choice 4
            if (choice == 4) {
                // KEIYONA
            }

            // choice 5
            if (choice == 5) {
                // SUBANI
            }    
        }
        
    }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == viewInfo) {
                viewInfoIn.setVisible(true);
            }
            else if(e.getSource() == viewAll) {
                view
            }
        }
