package view;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Label;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import controller.QLSVController;
import java.util.Date.*;
import java.util.Vector;

import model.Tinh;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;

public class students_profile extends JFrame  {
    
	private java.io.File files;
	private JPanel jpmain;
	public JTextField tf_name;
	public JTextField tf_class;
	public JTextField tf_birth;
	private JPanel jp_baodong_ngoaicung;
    QLSVController dieukhien;
	public JComboBox comboBox_address;
	public ButtonGroup btg;
	public Tinh model;
	public JRadioButton male;
	public JRadioButton female;
	private JLabel labelClock;
	public JTextField tf_id;
	private JTable table;
	private JTextField tf_send;
	public JLabel image;
	public JLabel tf_noti;
	public JLabel tf_tb;
	

	public students_profile() {
		
    
		this.model=new Tinh();
		this.dieukhien=new QLSVController();
		setTitle("Đồ Án Quản Lý Sinh Viên Cuối Kỳ I");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(getMaximumSize());
		
		 java.net.URL url_image_home=qlsvmain.class.getResource("students.png");
			Image img=Toolkit.getDefaultToolkit().createImage(url_image_home);
			this.setIconImage(img);
			
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu file = new JMenu("File");
		menuBar.add(file);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		file.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		file.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		file.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		file.add(mntmNewMenuItem_3);
		
		JMenu exit = new JMenu("Exit");
		menuBar.add(exit);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		exit.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("New menu item");
		exit.add(mntmNewMenuItem_5);
		jpmain = new JPanel();
		jpmain.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(jpmain);
		jpmain.setLayout(null);
		
		jp_baodong_ngoaicung = new JPanel();
		jp_baodong_ngoaicung.setBounds(0, 0, 1530, 823);
		jpmain.add(jp_baodong_ngoaicung);
		jp_baodong_ngoaicung.setLayout(null);
		
		JPanel jp_baodong_anh = new JPanel();
		jp_baodong_anh.setBackground(new Color(255, 255, 255));
		jp_baodong_anh.setBounds(0, 117, 1530, 622);
		jp_baodong_ngoaicung.add(jp_baodong_anh);
		jp_baodong_anh.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 10, 209, 612);
		jp_baodong_anh.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel jl_cmnm = new JLabel("New label");
		jl_cmnm.setIcon(new ImageIcon("D:\\zalo\\đenuong.jpg"));
		jl_cmnm.setBounds(0, 0, 209, 612);
		panel_3.add(jl_cmnm);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(1354, 10, 176, 602);
		jp_baodong_anh.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\zalo\\đenuong.jpg"));
		lblNewLabel_2.setBounds(0, 0, 176, 602);
		panel_4.add(lblNewLabel_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(128, 255, 255));
		panel_5.setBounds(219, 10, 1125, 602);
		jp_baodong_anh.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblName.setBounds(107, 226, 135, 43);
		panel_5.add(lblName);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblClass.setBounds(107, 279, 135, 43);
		panel_5.add(lblClass);
		
		JLabel lblDayOfBirth = new JLabel("Day Of Birth");
		lblDayOfBirth.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblDayOfBirth.setBounds(107, 337, 155, 43);
		panel_5.add(lblDayOfBirth);
		
		JLabel lblSex = new JLabel("Gender");
		lblSex.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblSex.setBounds(107, 390, 135, 43);
		panel_5.add(lblSex);
		
		tf_name = new JTextField();
		tf_name.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tf_name.setColumns(10);
		tf_name.setBounds(309, 218, 228, 50);
		panel_5.add(tf_name);
		
		tf_class = new JTextField();
		tf_class.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tf_class.setColumns(10);
		tf_class.setBounds(309, 279, 228, 50);
		panel_5.add(tf_class);
		
		tf_birth = new JTextField();
		tf_birth.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tf_birth.setColumns(10);
		tf_birth.setBounds(309, 339, 228, 50);
		panel_5.add(tf_birth);
		
		btg=new ButtonGroup();
		 male = new JRadioButton("Male");
		male.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		male.setBounds(283, 404, 122, 21);
		male.setSelected(true);
		btg.add(male);
		panel_5.add(male);
		
		 female = new JRadioButton("Female");
		female.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		female.setBounds(431, 404, 122, 21);
		btg.add(female);
		panel_5.add(female);
		
		comboBox_address = new JComboBox();
		ArrayList<Tinh> listtinh=Tinh.luugiatritinh();
		for (Tinh tinh : listtinh) {
			comboBox_address.addItem(tinh.getTentinh());
		}
		
		comboBox_address.setBounds(309, 443, 221, 43);
		panel_5.add(comboBox_address);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblAddress.setBounds(107, 439, 135, 43);
		panel_5.add(lblAddress);
		 
		 JButton button_update = new JButton("Update");
		 button_update.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
			        try {
		
	                	int id=Integer.parseInt(tf_id.getText());
						String hoten=tf_name.getText()+"";
						String lop=tf_class.getText()+"";
						String ngaysinh =tf_birth.getText()+"";
						String gioitinh= "";
						if(male.isSelected()) {
							gioitinh = "Male";
						}
						else {
							gioitinh = "Female";
						}
						String address=comboBox_address.getSelectedItem()+"";
						String avt="";
						try {
						 avt=files.getAbsolutePath();
						}catch (Exception ex) {
                         System.out.println(ex);
						}
	                    System.out.println("update Student name " + hoten);
	                    System.out.println("update Student");

	                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/swing_demo","root", "");
	                    String sql = "UPDATE `students` SET `Name`=?,`Class`=?,`Day Of Birth`=?,`Sex`=?,`Address`=?,`Avatar`=? WHERE ID=?";
	                    PreparedStatement st =  con.prepareStatement(sql);

	                    st.setString(1, hoten);
	                    st.setString(2, lop);
	                    st.setString(3, ngaysinh);
	                    st.setString(4, gioitinh);
	                    st.setString(5, address);
	                    st.setString(6, avt);
	                    st.setInt(7, id);
	                    st.executeUpdate();
	                    JOptionPane.showMessageDialog(jpmain, "Students has been successfully changed");    
	        			tf_id.setText("");
	        			tf_class.setText("");
	        			tf_name.setText("");
	        			tf_birth.setText("");
	        			btg.clearSelection();
	        			comboBox_address.setSelectedIndex(-1);

	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
			          
				 

			        }
			 
		});
		 button_update.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		 button_update.setBounds(338, 530, 140, 43);
		 panel_5.add(button_update);
		 
		 JLabel lblName_1 = new JLabel("");
		 lblName_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		 lblName_1.setBounds(202, 153, 60, 43);
		 panel_5.add(lblName_1);
		 
		 tf_id = new JTextField();
		 tf_id.setFont(new Font("Tahoma", Font.PLAIN, 32));
		 tf_id.setColumns(10);
		 tf_id.setBounds(309, 153, 228, 50);
		 panel_5.add(tf_id);
		 
		 tf_send = new JTextField();
		 tf_send.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 tf_send.setBounds(691, 73, 381, 266);
		 panel_5.add(tf_send);
		 tf_send.setColumns(10);
		 
		 JLabel lblSendALetter = new JLabel("SEND A LETTER TO ADMIN");
		 lblSendALetter.setForeground(Color.BLUE);
		 lblSendALetter.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		 lblSendALetter.setBounds(713, 20, 334, 43);
		 panel_5.add(lblSendALetter);
		 
		 JButton button_update_1 = new JButton("Send");
		 button_update_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
		 		int id=Integer.valueOf(tf_id.getText());
		 		String send=tf_send.getText()+"";
		 		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/swing_demo","root", "");

                String query = "INSERT INTO notifications values('" + id + "','"+send+"')";                  
                Statement sta = connection.createStatement();
               
                int x = sta.executeUpdate(query);
                if (x == 0) {
                    JOptionPane.showMessageDialog(jpmain, "This is alredy exist");
                    
                } else {
                    JOptionPane.showMessageDialog(jpmain,
                        "You have successfully sent the mail!");
                   
                }
                tf_id.setText("");
		 		tf_send.setText("");
            } catch (Exception exception) {
               System.out.println(exception.getMessage());
            }
		 	}
		 });
		 button_update_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		 button_update_1.setBounds(816, 381, 140, 43);
		 panel_5.add(button_update_1);
		 
		 JPanel panel = new JPanel();
		 panel.setBounds(63, 10, 247, 137);
		 panel_5.add(panel);
		 panel.setLayout(null);
		 image = new JLabel();
		 image.setBounds(10, 10, 228, 120);
		 panel.add(image);
		 image.setBackground(Color.WHITE);
		 image.setForeground(Color.RED);
		 image.setFont(new Font("Tahoma", Font.BOLD, 16));
		 image.setText("Click here! To Set Avatar");
		 
		 JLabel lblName_1_1 = new JLabel("Enter ID Of You :");
		 lblName_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		 lblName_1_1.setBounds(47, 153, 252, 43);
		 panel_5.add(lblName_1_1);
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setLayout(null);
		 panel_1.setBounds(338, 10, 250, 72);
		 panel_5.add(panel_1);
		 
		 tf_noti = new JLabel("Notification");
		 tf_noti.addMouseListener(new MouseListener() {
				
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
					dieukhien =new QLSVController();
					dispose();
					dieukhien.hienthithuadmin();
				}
			});
		 tf_noti.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		 tf_noti.setBounds(10, 10, 141, 43);
		 panel_1.add(tf_noti);
		 
		 JLabel lblNotification_1 = new JLabel("");
		 lblNotification_1.setIcon(new ImageIcon("D:\\anh\\notification (1).png"));
		 lblNotification_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		 lblNotification_1.setBounds(144, 10, 24, 43);
		 panel_1.add(lblNotification_1);
		 
		 tf_tb = new JLabel("");
		 tf_tb.setForeground(Color.RED);
		 tf_tb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		 tf_tb.setBounds(161, 10, 24, 24);
		 panel_1.add(tf_tb);
		 
		 JButton btnNewButton_1_4 = new JButton("Cancel");
		 btnNewButton_1_4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
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
		                    JOptionPane.showMessageDialog(jpmain, "No Notification!");
		                }

		                // Đóng kết nối
		                conn.close();

		            } catch (Exception ex) {
		                System.out.println(ex);
		            }
		 	}
		 });
		 btnNewButton_1_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		 btnNewButton_1_4.setBounds(835, 530, 101, 43);
		 panel_5.add(btnNewButton_1_4);
		 
		 
		 image.addMouseListener(new MouseListener() {
			
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
				JFileChooser filechooser=new JFileChooser();
				filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnvalue=filechooser.showOpenDialog(panel_5);
				if(returnvalue==JFileChooser.APPROVE_OPTION) {
				// file=filechooser.getSelectedFile();
					files=filechooser.getSelectedFile();
					String pathFile=files.getAbsolutePath();
					BufferedImage b;
					try {
						b=ImageIO.read(files);
						image.setIcon(new ImageIcon(b));
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
			     
			     
		
		
		
		ImageIcon imi_nb_kp_ps=new ImageIcon("D:/zalo/vkuuu.png");
		JLabel jl_image_nhanban = new JLabel(imi_nb_kp_ps);
		jl_image_nhanban.setBounds(10, 735, 1520, 41);
		jp_baodong_ngoaicung.add(jl_image_nhanban);
		
		JLabel jl_image_logo_university = new JLabel();
		jl_image_logo_university.setIcon(new ImageIcon("D:\\zalo\\vkufake.png"));
		jl_image_logo_university.setBounds(0, 0, 141, 90);
		jp_baodong_ngoaicung.add(jl_image_logo_university);
		
		Panel jp_baodong_menubar = new Panel();
		jp_baodong_menubar.setBounds(0, 87, 1530, 41);
		jp_baodong_ngoaicung.add(jp_baodong_menubar);
		jp_baodong_menubar.setLayout(null);
		
		JMenuBar jmbar = new JMenuBar();
		jmbar.setBounds(0, 0, 1530, 31);
		jp_baodong_menubar.add(jmbar);
		
	    
		JMenu jm_home = new JMenu("Home");
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
		jm_home.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(qlsvmain.class.getResource("home (1).png"))));
		jmbar.add(jm_home);
		
		JMenu jm_account = new JMenu("Account");
		jm_account.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		jm_account.setIcon(null);
		jmbar.add(jm_account);
		
		JMenuItem jmi_sign_in = new JMenuItem("Sign Out");
		jmi_sign_in.setIcon(new ImageIcon("D:\\zalo\\logout (1).png"));
		jmi_sign_in.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(jp_baodong_ngoaicung,"You Was Sign Out !");
				 dispose();
				new UserLogin();
				
			}
		});
		
		
		jmi_sign_in.setFont(new Font("Segoe UI", Font.BOLD, 15));
		jm_account.add(jmi_sign_in);
		
		 
		
	        // dóng chương trình khi đóng của sổ
	       
	        // thiết lập lại đồng hồ sau mỗi 1 giây
	        
	        
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\zalo\\bautroi.jpg"));
		lblNewLabel.setBounds(136, 0, 1394, 90);
		jp_baodong_ngoaicung.add(lblNewLabel);
		setVisible(true);
	}
	 
	public static void main(String[] args) {
		new students_profile();
	}
}