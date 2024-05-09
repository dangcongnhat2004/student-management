package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.QLSVController;

public class UserHome_student extends JFrame {

    private static final long serialVersionUID = 1 ;
    private JPanel contentPane;
    QLSVController dieukhien;
    UserLogin_Students hihi;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserHome_student frame = new UserHome_student();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserHome_student() {

    }

    /**
     * Create the frame.
     */
    public UserHome_student(String userSes) {
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JButton btnNewButton = new JButton("Start Program");
        btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 39));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                	 try {
                		 students_profile moi=new students_profile();
 						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Swing_demo","root","");
 						 // Câu lệnh xem dữ liệu
 						 String sql = "select * from Notification_admin";
 						 // Tạo đối tượng thực thi câu lệnh Select
 						 java.sql.Statement st = conn.createStatement();
 						 // Thực thi 
 						 ResultSet rs = st.executeQuery(sql); 
 						 System.out.println("trong+");
 			                // Kiểm tra xem có dữ liệu hay không
 			                if (rs.next()) {
 			                	dispose();
 			                   dieukhien=new QLSVController();
 			                   moi.dispose();
 			                   dieukhien.hienthitb();
 			                    // Nếu có dữ liệu thì hiển thị lên JLabel
 			                    System.out.println("ok");
 			                   
 			                } else {
 			                    // Nếu không có dữ liệu thì hiển thị thông báo
 			                	
 			                }

 			                // Đóng kết nối
 			                conn.close();

 			            } catch (Exception ex) {
 			                System.out.println(ex);
 			            }
                     
                    
                }
      
            }
        });
        btnNewButton.setBounds(247, 118, 491, 114);
        contentPane.add(btnNewButton);
        JButton button = new JButton("Change-password\r\n");
        button.setBackground(UIManager.getColor("Button.disabledForeground"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 ChangePassword_Student bo = new  ChangePassword_Student(userSes);
                bo.setTitle("Change Password");
                bo.setVisible(true);
                
            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 35));
        button.setBounds(247, 320, 491, 114);
        contentPane.add(button);
    }
 
   
}
