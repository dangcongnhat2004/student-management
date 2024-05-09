package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Icon;
public class register extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JPasswordField passwordField;
    private JButton btnNewButton;

    /**
     * Launch the application.
     */
 

    public register() {
    	setSize(getMaximumSize());
    	setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        java.net.URL url_image_home=qlsvmain.class.getResource("students.png");
		Image img=Toolkit.getDefaultToolkit().createImage(url_image_home);
		this.setIconImage(img);
		
        JLabel lblNewUserRegister = new JLabel("New User Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 42));
        lblNewUserRegister.setBounds(618, 170, 370, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
        lblName.setBounds(244, 313, 135, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setBounds(244, 404, 135, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
        lblEmailAddress.setBounds(244, 475, 158, 36);
        contentPane.add(lblEmailAddress);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(473, 313, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(473, 389, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();
        email.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String nhapemail=email.getText();
				String n = "^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$";
				if(nhapemail.length()>0) {
					if(!nhapemail.matches(n)) {
						JOptionPane.showMessageDialog(rootPane, "Email Wrong!");
						
					}
				}
				}
			
		});
        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(473, 464, 228, 50);
        contentPane.add(email);
        email.setColumns(10);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(1078, 305, 228, 50);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
        lblUsername.setBounds(816, 313, 135, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
        lblPassword.setBounds(816, 395, 135, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
        lblMobileNumber.setBounds(816, 473, 181, 41);
        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        mob.setBounds(1078, 464, 228, 50);
        contentPane.add(mob);
        mob.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(1078, 389, 228, 50);
        contentPane.add(passwordField);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
          
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String emailId = email.getText();
                String userName = username.getText();
                String mobileNumber = mob.getText();
                int len = mobileNumber.length();
                String password = passwordField.getText();

                String msg = "" + firstName;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }else {
                	 dispose();
                 	new UserLogin();
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/swing_demo","root", "");

                    String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userName + "','" +
                        password + "','" + emailId + "','" + mobileNumber + "')";                  
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                        
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                       
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                
                }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
        btnNewButton.setBounds(633, 570, 259, 74);
        contentPane.add(btnNewButton);
        
        JLabel backto = new JLabel("Back To Sign In ?");
        backto.addMouseListener(new MouseListener() {
			
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
			    new UserLogin();	
			}
		});
        backto.setForeground(new Color(0, 128, 255));
        backto.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
        backto.setBounds(312, 517, 331, 57);
        contentPane.add(backto);
        
        JLabel jl_image_logo_university = new JLabel();
        jl_image_logo_university.setIcon(new ImageIcon("D:\\zalo\\vkufake.png"));
        jl_image_logo_university.setBounds(0, 0, 141, 94);
        contentPane.add(jl_image_logo_university);
        
        JLabel image_blue = new JLabel("New label");
        image_blue.setIcon(new ImageIcon("D:\\zalo\\lonxon.jpg"));
        image_blue.setBounds(137, 0, 1393, 94);
        contentPane.add(image_blue);
        
        JLabel jl_cmnm = new JLabel("New label");
        jl_cmnm.setIcon(new ImageIcon("D:\\zalo\\grenn.jpg"));
        jl_cmnm.setBounds(0, 140, 209, 627);
        contentPane.add(jl_cmnm);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 93, 1540, 37);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JMenuBar jmbar = new JMenuBar();
        jmbar.setBounds(0, 0, 1530, 37);
        panel.add(jmbar);
        
        JMenu jm_home = new JMenu("Home");
        jm_home.setIcon(new ImageIcon("D:\\SQL_2019\\home (1).png"));
        jm_home.addMouseListener(new MouseListener() {
			
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
        jm_home.setFont(new Font("Segoe UI", Font.BOLD, 16));
        jmbar.add(jm_home);
        
        JMenu jm_start_program = new JMenu("Manage");
        jm_start_program.addMouseListener(new MouseListener() {
			
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
        jm_start_program.setFont(new Font("Segoe UI", Font.BOLD, 16));
        jmbar.add(jm_start_program);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("D:\\zalo\\grenn.jpg"));
        lblNewLabel_2.setBounds(1331, 140, 209, 627);
        contentPane.add(lblNewLabel_2);
        
        JLabel jl_image_nhanban = new JLabel(new ImageIcon("D:\\zalo\\logovkuu.jpg"));
        jl_image_nhanban.setBounds(0, 762, 1520, 41);
        contentPane.add(jl_image_nhanban);
        setVisible(true);
        
    }
}