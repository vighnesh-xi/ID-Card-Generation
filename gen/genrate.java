package gen;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class genrate extends JFrame implements ActionListener{
    JFrame f3;
    JLabel myImg;
    Image image;
    JLabel labelImg;
    JFileChooser upload;
    Font myFont,myFont2;
    JButton attach;
    File selectedImageFile;
    public JTextField txt,crn,btxt,uno_1,bGroup;
    JComboBox uin_age,u_brnch;
    JComboBox u_yr;
    JButton submit,print;
    JTextArea userAddress;
    public genrate(){
//        File selectedImageFile=new File();
        JFrame f2=new JFrame();
        Font myFont3=new Font("Roboto",Font.BOLD,20);
        Font myFont4=new Font("Roboto",Font.BOLD,16);
        ImageIcon background_image=new ImageIcon("login2.jpg");
        Image img=background_image.getImage();
        Image temp_img=img.getScaledInstance(900,900,Image.SCALE_SMOOTH);
        background_image=new ImageIcon(temp_img);
        JLabel background=new JLabel("",background_image,JLabel.CENTER);
        background.setBounds(0,0,900,900);
        f2.add(background);

        String [] addList=new String[100];
        JLabel log=new JLabel("DETAILS FOR ID GENERATION");
        //Label log=new Label("Hi");
        log.setBounds(230,10,480,50);
        log.setBackground(new Color(0,0,0,90));
        log.setOpaque(true);
        log.setFont(new Font("Roboto", Font.BOLD, 30));
        background.add(log);

        labelImg=new JLabel("myImage");
        background.add(labelImg);
        labelImg.setBounds(420,480,140,140);

        JLabel name=new JLabel("Enter your name:");
        name.setBounds(120,120,177,60);
        name.setFont(myFont3);
        background.add(name);

        txt=new JTextField();
        txt.setBounds(300,135,130,30);
        txt.setFont(myFont4);
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int ch=e.getKeyChar();
                if(Character.isLetter(ch)|| Character.isWhitespace(ch)||Character.isISOControl(ch)){
                    txt.setEditable(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Only Characters are allowed");

                }
            }
        });
        background.add(txt);

        JLabel age=new JLabel("Enter your CRN:");
        age.setBounds(470,135,160,30);
        age.setFont(new Font("Verdana", Font.BOLD, 17));
        background.add(age);

         crn=new JTextField();
         crn.setFont(myFont4);
        crn.setBounds(623,135,130,30);
        crn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char ch= e.getKeyChar();
                if(Character.isDigit(ch) || Character.isISOControl(ch) || Character.isAlphabetic(ch)|| (ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE) || (ch == KeyEvent.VK_SHIFT)){

                }
                else{
                    JOptionPane.showMessageDialog(null,"Only numbers are allowed");
                    crn.setText(" ");
                }
            }
        });
        background.add(crn);

        JLabel uage=new JLabel("Enter your age:");
        uage.setBounds(120,159,165,90);
        uage.setFont(new Font("Verdana", Font.BOLD,17));
        background.add(uage);

        for(int i=0;i<=99;i++)
        {
            String ch=Integer.toString(i);
            addList[i]=ch;
        }

        uin_age= new JComboBox(addList);
        uin_age.setBounds(300,190,130,30);
        background.add(uin_age);

        JLabel dob=new JLabel("DOB:");
        dob.setFont(new Font("Verdana", Font.BOLD,17));
        dob.setBounds(470,190,130,30);
        background.add(dob);

        btxt=new JTextField();
        btxt.setFont(myFont4);
        btxt.setBounds(625,190,130,30);
        background.add(btxt);

        JLabel branch=new JLabel("Branch:");
        branch.setFont(new Font("Verdana", Font.BOLD,17));
        branch.setBounds(120,220,75,90);
        background.add(branch);

        String [] brnch ={"CM","CE","EE","IF","AIML","ME"};
        u_brnch=new JComboBox(brnch);
        u_brnch.setBounds(300,250,140,30);
        background.add(u_brnch);
        //String myBranch= (String) u_brnch.getSelectedItem();

        JLabel yr=new JLabel("Select Year:");
        yr.setFont(new Font("Verdana", Font.BOLD,17));
        yr.setBounds(470,250,130,30);
        background.add(yr);

        String [] yr_select={"FY-1","FY-2","FY-3","SY-1","SY-2","SY-3","TY-1","TY-2","TY-3"};
        u_yr=new JComboBox(yr_select);
        u_yr.setBounds(625,250,130,30);
        background.add(u_yr);

        JLabel uno =new JLabel("Phone no.:");
        uno.setBounds(120,310,100,30);
        background.add(uno);
        uno.setFont(new Font("Verdana", Font.BOLD,17));

        uno_1=new JTextField();
        uno_1.setFont(myFont4);
        uno_1.setBounds(300,310,130,30);
        background.add(uno_1);

        JLabel userBloodGroup=new JLabel("Blood group:");
        userBloodGroup.setBounds(470,310,120,30);
        background.add(userBloodGroup);
        userBloodGroup.setFont(new Font("Verdana", Font.BOLD,17));

        bGroup=new JTextField();
        bGroup.setFont(myFont4);
        bGroup.setBounds(625,310,130,30);
        background.add(bGroup);

        JLabel address=new JLabel("Address:");
        background.add(address);
        address.setBounds(120,370,200,40);
        address.setFont(new Font("Verdana", Font.BOLD,17));

        userAddress=new JTextArea(40,40);
        background.add(userAddress);
        userAddress.setBounds(300,380,270,80);
        userAddress.setFont(myFont4);

        submit =new JButton("Submit");
        submit.setBounds(290,660,90,30);
        background.add(submit);
        submit.addActionListener(this);

        print=new JButton("Print");
        print.setBounds(400,660,90,30);
        background.add(print);
        print.addActionListener(this);

        uno_1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char ch= e.getKeyChar();
                if(Character.isDigit(ch)){

                }
                else{
                    JOptionPane.showMessageDialog(null,"Only numbers are allowed");
                    uno_1.setText(" ");
                }
            }
        });
        background.add(uno_1);


        attach=new JButton("Upload Image");
        attach.setBounds(510,660,140,30);
        background.add(attach);
        attach.addActionListener(this);
        upload=new JFileChooser();

        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setSize(900,900);
        f2.setLayout(null);
        f2.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String n=txt.getText();//name
        String no= crn.getText();//// crn
        String age= uin_age.getSelectedItem().toString();//age
        String birth=btxt.getText();//dob
        String br=u_brnch.getSelectedItem().toString();//branch
        String year=u_yr.getSelectedItem().toString();//year select
        String phn=uno_1.getText();//PHONE
        String blood=bGroup.getText();//BLOOD GROUP
        String addr=userAddress.getText();//ADDRESS

        if(ae.getSource()==submit){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mp","root","");
                String sql="insert into generate values (?,?,?,?,?,?,?,?,?)";
                PreparedStatement pstmt=con.prepareStatement(sql);
                pstmt.setString(1,n);
                pstmt.setString(2,no);
                pstmt.setString(3,age);
                pstmt.setString(4,birth);
                pstmt.setString(5,br);
                pstmt.setString(6,year);
                pstmt.setString(7,phn);
                pstmt.setString(8,blood);
                pstmt.setString(9,addr);

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data submitted successfully");
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        } else if (ae.getSource()==print)
        {
            f3=new JFrame("ID CARD");
            f3.setSize(600,700);
            f3.setVisible(true);
            f3.setLayout(null);

            ImageIcon background_image=new ImageIcon("login.jpg");

            Image img=background_image.getImage();
            Image temp_img=img.getScaledInstance(600,700,Image.SCALE_SMOOTH);
            background_image=new ImageIcon(temp_img);
            JLabel background=new JLabel("",background_image,JLabel.CENTER);
            background.setBounds(0,0,600,700);
            f3.add(background);


            myFont=new Font("Roboto", Font.BOLD,25);
            myFont2=new Font("Roboto", Font.BOLD,16);

            JLabel title=new JLabel("KK WAGH POLYTECHNIC");
            title.setBounds(140,2,320,100);
            title.setFont(myFont);
            background.add(title);

            JLabel nm=new JLabel("NAME:");
            nm.setFont(myFont2);
            nm.setBounds(90,80,130,90);
            background.add(nm);

//            String uname=txt.getText();
            JLabel print_nm=new JLabel();
            print_nm.setText(n);
            print_nm.setFont(myFont2);
            print_nm.setBounds(150,80,130,90);
            background.add(print_nm);

            JLabel myCrn=new JLabel("CRN NO.:");
            myCrn.setFont(myFont2);
            myCrn.setBounds(330,80,130,90);
            background.add(myCrn);

            JLabel print_crn=new JLabel();
            print_crn.setText(no);
            print_crn.setFont(myFont2);
            print_crn.setBounds(410,80,130,90);
            background.add(print_crn);

            JLabel myAge=new JLabel("AGE:");
            myAge.setFont(myFont2);
            myAge.setBounds(90,140,130,90);
            background.add(myAge);

            JLabel print_age=new JLabel();
            print_age.setText(age);
            print_age.setFont(myFont2);
            print_age.setBounds(150,140,130,90);
            background.add(print_age);

            JLabel myDate=new JLabel("DOB:");
            myDate.setFont(myFont2);
            myDate.setBounds(330,140,130,90);
            background.add(myDate);

            JLabel print_dob=new JLabel();
            print_dob.setText(birth);
            print_dob.setFont(myFont2);
            print_dob.setBounds(410,140,130,90);
            background.add(print_dob);

            JLabel myBranch=new JLabel("BRANCH:");
            myBranch.setFont(myFont2);
            myBranch.setBounds(90,200,130,90);
            background.add(myBranch);

            JLabel print_br=new JLabel();
            print_br.setFont(myFont2);
            print_br.setText(br);
            print_br.setBounds(170,200,100,90);
            background.add(print_br);

            JLabel myYear=new JLabel("YEAR:");
            myYear.setFont(myFont2);
            myYear.setBounds(330,200,130,90);
            background.add(myYear);

            JLabel print_year=new JLabel();
            print_year.setText(year);
            print_year.setFont(myFont2);
            print_year.setBounds(410,200,130,90);
            background.add(print_year);

            JLabel myPhone=new JLabel("PHONE NO.:");
            myPhone.setBounds(90,260,130,90);
            myPhone.setFont(myFont2);
            background.add(myPhone);

            JLabel print_phone=new JLabel();
            print_phone.setText(phn);
            print_phone.setFont(myFont2);
            print_phone.setBounds(189,260,130,90);
            background.add(print_phone);

            JLabel myBlood=new JLabel("BLOOD GROUP:");
            myBlood.setFont(myFont2);
            myBlood.setBounds(330,260,130,90);
            background.add(myBlood);

            JLabel print_blood=new JLabel();
            print_blood.setText(blood);
            print_blood.setFont(myFont2);
            print_blood.setBounds(470,260,130,90);
            background.add(print_blood);

            JLabel myAddress=new JLabel("ADDRESS:");
            myAddress.setFont(myFont2);
            myAddress.setBounds(90,320,130,90);
            background.add(myAddress);

            JLabel print_addr=new JLabel();
            print_addr.setFont(myFont2);
            print_addr.setText(addr);
            print_addr.setBounds(190,325,670,80);
            background.add(print_addr);

            myImg=new JLabel("hii");
            myImg.setIcon(new ImageIcon(image));
            myImg.setBounds(200,400,150,100);
            background.add(myImg);
        } else if(ae.getSource()==attach) {
            /* MainCode
            int myImg=upload.showDialog(null,"Upload my image");
            if (myImg==JFileChooser.APPROVE_OPTION){
                JOptionPane.showMessageDialog(null,"Selected file is:"+upload.getSelectedFile().getAbsolutePath());

            }
            else {
                JOptionPane.showMessageDialog (null,"No selection");
            }*/
//            upload =new JFileChooser();
//            int showOpenDialog=upload.showOpenDialog(null);
//            if (showOpenDialog==JFileChooser.APPROVE_OPTION){
//                File selectedImageFile=upload.getSelectedFile();
////                File selectedImageFile=upload.getSelectedFile();
//                String selectedImageFilePath=selectedImageFile.getAbsolutePath();
//                JOptionPane.showMessageDialog(null,selectedImageFilePath);

            JFileChooser browseImageFile = new JFileChooser();
            //Filter image extensions
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
            browseImageFile.addChoosableFileFilter(fnef);
            int showOpenDialogue = browseImageFile.showOpenDialog(null);

            if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
                File selectedImageFile = browseImageFile.getSelectedFile();
                String selectedImagePath = selectedImageFile.getAbsolutePath();
                JOptionPane.showMessageDialog(null, selectedImagePath);
                //Display image on jlable
                ImageIcon ii = new ImageIcon(selectedImagePath);
//            Resize image to fit jlabel
                 image = ii.getImage().getScaledInstance(labelImg.getWidth(),labelImg.getHeight(), Image.SCALE_SMOOTH);
                labelImg.setIcon(new ImageIcon(image));
            }

            }
        }

    public static void main(String []arg)
    {
        new genrate();
    }
}