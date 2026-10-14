package src;


import javax.swing.*;

import java.awt.*;


public class login extends JFrame
{
    JLabel titleJLabel;
    JLabel accountJLabel;
    JLabel pinJLabel;
    JTextField accounTextField;
    JPasswordField pinField;
    JButton logiButton;

    public static String currentpin="0123";

    login()
    {
        setTitle("ATM Management System");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(15,23,42));
        setVisible(true);


     //TitleJlabel    

        titleJLabel=new JLabel("ATM MACHINE");
        titleJLabel.setFont(new Font("Arial",Font.BOLD,28));
        titleJLabel.setBounds(500,30,220,40);
        titleJLabel.setForeground(Color.WHITE);
        add(titleJLabel);

     //account number & account field

        accountJLabel=new JLabel("Account Number");
        accountJLabel.setBounds(400,200,120,30);
        accountJLabel.setFont(new Font("Arial",Font.BOLD,14));
        accountJLabel.setForeground(Color.WHITE);
        add(accountJLabel);


        accounTextField=new JTextField();
        accounTextField.setBounds(650,200,200,30);
        add(accounTextField);

      //pinJlabel & pinfeild 

        pinJLabel=new JLabel("PIN");
        pinJLabel.setBounds(450,300,120,30);
        pinJLabel.setFont(new Font("Arial",Font.BOLD,14));
        pinJLabel.setForeground(Color.WHITE);
        add(pinJLabel);

        pinField=new JPasswordField();
        pinField.setBounds(650,300,200,30);
        add(pinField);


      //Login button

        logiButton=new JButton("Login");
        logiButton.setBounds(550,450,120,40);
        logiButton.setForeground(Color.WHITE);
        logiButton.setBackground(Color.BLUE);
        add(logiButton);

        logiButton.addActionListener(e ->{

        String AccountNumber=accounTextField.getText();
        String PIN=new String(pinField.getPassword());
        if(AccountNumber.equals("12345") && PIN.equals(login.currentpin))
        {
             new Dashboard();


             this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Invalid Account Number or Pin");
        }

        });

    }

    public static void main(String[]args)
    {
         new login();
           

    }






    
}
