import gen.genrate;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class myLog extends JFrame implements ActionListener {
    JLabel log,name,pass;
    JTextField t1;
    JPasswordField t2;
    JButton b1;
    JFrame f1;
    JLabel head;
    JPanel pan;
    myLog(){
        //backGround Image
//        Font myFont1=new Font("Roboto",Font.BOLD,20);

        ImageIcon background_image=new ImageIcon("login2.jpg");

        Image img=background_image.getImage();
        Image temp_img=img.getScaledInstance(700,900,Image.SCALE_SMOOTH);
        background_image=new ImageIcon(temp_img);
        JLabel background=new JLabel("",background_image,JLabel.CENTER);
        background.setBounds(0,0,700,900);
        add(background);

        Font f1=new Font("Roboto",Font.BOLD,20);
        Font f2=new Font("Roboto",Font.BOLD,18);

        head=new JLabel("LOGIN");
        head.setBounds(300,20,120,70);
        head.setFont(f1);
        background.add(head);

        pan=new JPanel();
        background.add(pan);
        pan.setBackground(new Color(0,0,0,30));
        pan.setLayout(null);
        pan.setBounds(120,100,440,590);

        name=new JLabel("Username:");
        pan.add(name);
        name.setFont(f2);
        name.setBounds(80,30,110,90);

        t1=new JTextField();
        pan.add(t1);
        t1.setFont(f2);
        t1.setBounds(187,63,120,25);

        pass=new JLabel("Password:");
        pan.add(pass);
        pass.setFont(f2);
        pass.setBounds(80,90,110,90);

        t2=new JPasswordField();
        pan.add(t2);
//        t2.setEchoChar('*');
        t2.setFont(f2);
        t2.setBounds(187,125,120,25);

        b1=new JButton("LOGIN");
        pan.add(b1);
        b1.setBounds(170,190,100,30);
//        b1.setBackground(Color.orange);
//        b1.setOpaque(true);
        b1.addActionListener(this);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        setSize(700,900);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mp","root","");

            String username=t1.getText();
            String pass=t2.getText();
            Statement stmt=con.createStatement();
            String sql="select * from login where username='"+username+"' and pass='"+pass+"'";
            ResultSet rs=stmt.executeQuery(sql);

            {
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"Login Successful");
                    new genrate();
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Wrong Login Details");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] arg)
    {
        new myLog();
    }
}