package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.QLSVController;

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class UserLogin_Students extends JFrame {

    private static final long serialVersionUID = 1L;
    public JTextField textField;
	public JPasswordField passwordField;
    private JButton btnSignIn;
    private JPanel contentPane;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin_Students frame = new UserLogin_Students();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public UserLogin_Students() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(getMaximumSize());
        this.setTitle("Đồ Án Cuối Kỳ-Java Swing");
        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        java.net.URL url_image_home=qlsvmain.class.getResource("students.png");
		Image img=Toolkit.getDefaultToolkit().createImage(url_image_home);
		this.setIconImage(img);
		
        JLabel lblNewLabel = new JLabel("Login (Students)");
        lblNewLabel.setForeground(new Color(0, 255, 64));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 46));
        lblNewLabel.setBounds(712, 170, 327, 93);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(652, 303, 422, 68);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(652, 417, 422, 68);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 31));
        lblUsername.setBounds(449, 313, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 31));
        lblPassword.setBounds(449, 427, 193, 52);
        contentPane.add(lblPassword);

        btnSignIn = new JButton("Sign In");
        btnSignIn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
        btnSignIn.setBounds(776, 587, 167, 73);
        btnSignIn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) { 
            	
                String userName = textField.getText();
                String password = passwordField.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/swing_demo",
                        "root", "");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select user_name_student, password_student,ID from students where user_name_student=? and password_student=?");
                    
                    st.setString(1, userName);
                    st.setString(2, password);

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        //dispose();
                        UserHome_student ah = new UserHome_student(userName);
                        ah.setTitle("Welcome");
                        ah.setVisible(true);
                        dispose();
                        JOptionPane.showMessageDialog(btnSignIn, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(btnSignIn, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
            
        });

        contentPane.add(btnSignIn);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1550, 98);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\zalo\\vkufake.png"));
        lblNewLabel_1.setBounds(3, 0, 130, 100);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon("D:\\zalo\\green.jfif"));
        lblNewLabel_2.setBounds(143, 0, 1407, 100);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("D:\\zalo\\logovkuu.jpg"));
        lblNewLabel_3.setBounds(10, 754, 1334, 41);
        contentPane.add(lblNewLabel_3);
        
        JLabel jl_cmnm = new JLabel("New label");
        jl_cmnm.setIcon(new ImageIcon("D:\\do an\\cay.jpg"));
        jl_cmnm.setBounds(0, 133, 209, 622);
        contentPane.add(jl_cmnm);
        
        JLabel dangki = new JLabel("Click Here! If You Do Not Already Have An Account");
        dangki.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new register_student();
			}
		});
        dangki.setForeground(new Color(0, 128, 255));
        dangki.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        dangki.setBounds(236, 512, 697, 52);
        contentPane.add(dangki);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 102, 1550, 28);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1540, 28);
        panel_1.add(menuBar);
        
        JMenu mnNewMenu = new JMenu("Home");
        mnNewMenu.setIcon(new ImageIcon("D:\\SQL_2019\\home (1).png"));
        mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mnNewMenu.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new qlsvmain();
			}
		});
        menuBar.add(mnNewMenu);
        
        JMenu mnNewMenu_1 = new JMenu("Manage");
        mnNewMenu_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(rootPane,"Please Sign In !");
			}
		});
        mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(mnNewMenu_1);
        
        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setIcon(new ImageIcon("D:\\do an\\cay.jpg"));
        lblNewLabel_2_1.setBounds(1334, 133, 206, 622);
        contentPane.add(lblNewLabel_2_1);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
        chckbxNewCheckBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(chckbxNewCheckBox.isSelected()) {
        			passwordField.setEchoChar((char)0);
        			
        		}else {
        			passwordField.setEchoChar('*');

        		}
        	}
        });
        chckbxNewCheckBox.setForeground(new Color(0, 51, 255));
        chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        chckbxNewCheckBox.setBounds(970, 500, 284, 42);
        contentPane.add(chckbxNewCheckBox);
        setVisible(true);
       
    }
   
	
}