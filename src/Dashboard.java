package src;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Dashboard extends JFrame
{
    JButton balanceButton;
    JButton deposiButton;
    JButton withdrawButton;
    JButton ministateButton;
    JButton logoutButton;
    JButton changeButton; 

    private double balance=10000.00;
    private ArrayList<String> transactions=new ArrayList<>();

    public Dashboard()
    {
        setTitle("ATM Dashboard");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(null);
        getContentPane().setBackground(new Color(15,23,42));
        setVisible(true);

        JLabel title=new JLabel("ATM Dashboard");
        title.setBounds(450,20,300,40);
        title.setFont(new Font("Arial",Font.BOLD,28));
        title.setForeground(Color.WHITE);
        add(title);


  //Balance Button   

        balanceButton=new JButton("Check Balance");
        balanceButton.setBounds(170,110,240,45);
        balanceButton.setBackground(Color.BLUE);
        balanceButton.setForeground(Color.WHITE);
        add(balanceButton);

        balanceButton.addActionListener(e ->{
            JOptionPane.showMessageDialog(this,balance,"Balance",JOptionPane.INFORMATION_MESSAGE);

                    
       }

        );

 //deposite Button

      deposiButton=new JButton("Deposite Money");
      deposiButton.setBounds(700,110,240,45);
      deposiButton.setBackground(Color.BLUE);
      deposiButton.setForeground(Color.WHITE);
      add(deposiButton);

      deposiButton.addActionListener(e ->{
            
            String input=JOptionPane.showInputDialog(this,"Enter Deposite Amount");

            if(input==null)
            {
                  return ;
            }
            try{
                  double amount=Double.parseDouble(input);

                  if(amount<=0)
                  {
                        JOptionPane.showMessageDialog(this,"Please Enter Valid amount");
                  }
                  else
                  {
                        balance +=amount;
                        transactions.add("Deposite:" + amount);
                        JOptionPane.showMessageDialog(this,balance,"Deposite Successfully",JOptionPane.INFORMATION_MESSAGE);
                  }

            }
            catch(NumberFormatException ex)
            {
                  JOptionPane.showMessageDialog(this,"Please Enter Valid Amount ");
            }

            

            
                  
            }
      );

      

      
 //Withdraw Button
       withdrawButton=new JButton("Withdraw Money");
       withdrawButton.setBounds(700,250,240,45);
       withdrawButton.setBackground(Color.BLUE);
       withdrawButton.setForeground(Color.WHITE);
       add(withdrawButton);

       withdrawButton.addActionListener(e ->{

       String input=JOptionPane.showInputDialog(this,"Enter Withdrawal Amount");

            if(input==null)
            {
                  return ;
            }
            try{
                  double amount=Double.parseDouble(input);

                  if(amount<=0)
                  {
                        JOptionPane.showMessageDialog(this,"Please Enter Valid amount");
                  }
                  else
                  {
                        balance -=amount;
                        transactions.add("Withdrawal:" + amount);
                        JOptionPane.showMessageDialog(this,balance,"Withdrawal Successfully",JOptionPane.INFORMATION_MESSAGE);
                  }

            }
            catch(NumberFormatException ex)
            {
                  JOptionPane.showMessageDialog(this,"Please Enter Valid Amount ");
            }

            

            
                  
            }
      );


 //ministate Button
       ministateButton=new JButton("MiniStatement");
       ministateButton.setBounds(170,250,240,45);
       ministateButton.setBackground(Color.BLUE);
       ministateButton.setForeground(Color.WHITE);
       add(ministateButton);

       ministateButton.addActionListener(e ->{
            if(transactions.isEmpty())
            {
                  JOptionPane.showMessageDialog(this,"No trasactions yet","trasaction history",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                  StringBuilder statement=new StringBuilder();

                  statement.append("======Statement=======\n\n");
                  for(String trasaction:transactions)
                  {
                        statement.append(trasaction).append("\n");

                  }
                  statement.append("\n==Current Balance:").append(balance);

                  JOptionPane.showMessageDialog(this,statement.toString(),"MiniStatement",JOptionPane.INFORMATION_MESSAGE);
            }

       });

 //Logout Button
       logoutButton=new JButton("Logout");
       logoutButton.setBounds(170,390,240,45);
       logoutButton.setBackground(Color.BLUE);
       logoutButton.setForeground(Color.WHITE);
       add(logoutButton);

       logoutButton.addActionListener(e ->{
            int choice=JOptionPane.showConfirmDialog(this,"Are you sure you want to logout? ","Logout",JOptionPane.YES_NO_CANCEL_OPTION);

            if(choice==JOptionPane.YES_OPTION)
            {
                  new login();

                  this.dispose();;
                  
            }
       });


 //Change pin Button
       changeButton=new JButton("Change PIN");
       changeButton.setBounds(700,390,240,45);
       changeButton.setBackground(Color.BLUE);
       changeButton.setForeground(Color.WHITE);
       add(changeButton);

       changeButton.addActionListener(e ->{
            String oldpin=JOptionPane.showInputDialog(this,"Enter Your Current PIN");
            
            if(oldpin==null)
            {
                  return ;
            }
            if (!oldpin.equals(login.currentpin)) {
                  JOptionPane.showMessageDialog(this,"Incorrect currn PIN", "Change PIN",JOptionPane.ERROR_MESSAGE);
                  return ;
            }
            String newpin=JOptionPane.showInputDialog(this,"Enter Your New 4-digit PIN");
            if(newpin==null)
            {
                  return ;
            }
            if (!newpin.matches("\\d{4}")) {

                  JOptionPane.showMessageDialog(this,"PIN must contain exactly 4 digit","Invalid PIN",JOptionPane.WARNING_MESSAGE);
                  return ;
                  
            }
            if(newpin.equals(login.currentpin))
            {
                  JOptionPane.showMessageDialog(this, "New PIN must be different","Invalid PIN",JOptionPane.ERROR_MESSAGE);
                  return ;
            }
          login.currentpin=newpin;
            JOptionPane.showMessageDialog(this,"PIN changed Successfully","Success",JOptionPane.INFORMATION_MESSAGE);

       });

       
    
    }

    public static void main(String[]args)
    {
        new Dashboard();
    }



}
