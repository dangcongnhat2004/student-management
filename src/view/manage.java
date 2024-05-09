package view;

import java.awt.EventQueue;

import javax.print.DocFlavor.URL;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
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
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.jdbc.Driver;

import controller.QLSVController;
import java.util.Date.*;
import java.util.Vector;

import model.Tinh;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;


public class manage extends JFrame  {
    
	
	private JPanel jpmain;
	public JTextField tf_id;
	public JTextField tf_name;
	public JTextField tf_class;
	public JTextField tf_birth;
	public  JTable table;
	public JTextField tf_search;
	private JPanel jp_baodong_ngoaicung;
    QLSVController dieukhien;
	public JComboBox comboBox_address;
	public ButtonGroup btg;
	public Tinh model;
	public JRadioButton male;
	public JRadioButton female;
	private JLabel labelClock;
	private JLabel avatar;
	public JLabel tf_tb;
	
	public manage() {
		
    
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
		jl_cmnm.setIcon(new ImageIcon("D:\\zalo\\nai.jpg"));
		jl_cmnm.setBounds(0, 0, 209, 612);
		panel_3.add(jl_cmnm);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(1354, 10, 176, 602);
		jp_baodong_anh.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\zalo\\nai.jpg"));
		lblNewLabel_2.setBounds(0, 0, 176, 602);
		panel_4.add(lblNewLabel_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 204, 153));
		panel_5.setBounds(219, 10, 1125, 602);
		jp_baodong_anh.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblId.setBounds(58, 82, 135, 43);
		panel_5.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblName.setBounds(58, 150, 135, 43);
		panel_5.add(lblName);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblClass.setBounds(58, 216, 135, 43);
		panel_5.add(lblClass);
		
		JLabel lblDayOfBirth = new JLabel("Day Of Birth");
		lblDayOfBirth.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblDayOfBirth.setBounds(60, 284, 155, 43);
		panel_5.add(lblDayOfBirth);
		
		JLabel lblSex = new JLabel("Gender");
		lblSex.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblSex.setBounds(58, 349, 135, 43);
		panel_5.add(lblSex);
		
		tf_id = new JTextField();
		tf_id.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tf_id.setColumns(10);
		tf_id.setBounds(265, 82, 228, 50);
		panel_5.add(tf_id);
		
		tf_name = new JTextField();
		tf_name.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tf_name.setColumns(10);
		tf_name.setBounds(265, 150, 228, 50);
		panel_5.add(tf_name);
		
		tf_class = new JTextField();
		tf_class.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tf_class.setColumns(10);
		tf_class.setBounds(265, 216, 228, 50);
		panel_5.add(tf_class);
		
		tf_birth = new JTextField();
		tf_birth.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tf_birth.setColumns(10);
		tf_birth.setBounds(265, 276, 228, 50);
		panel_5.add(tf_birth);
		
		btg=new ButtonGroup();
		 male = new JRadioButton("Male");
		male.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		male.setBounds(196, 363, 122, 21);
		male.setSelected(true);
		btg.add(male);
		panel_5.add(male);
		
		 female = new JRadioButton("Female");
		female.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		female.setBounds(343, 363, 122, 21);
		btg.add(female);
		panel_5.add(female);
		
		comboBox_address = new JComboBox();
		ArrayList<Tinh> listtinh=Tinh.luugiatritinh();
		for (Tinh tinh : listtinh) {
			comboBox_address.addItem(tinh.getTentinh());
		}
		
		comboBox_address.setBounds(265, 406, 221, 43);
		panel_5.add(comboBox_address);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblAddress.setBounds(58, 402, 135, 43);
		panel_5.add(lblAddress);
		
		 table = new JTable();
		 table.addMouseListener(new MouseAdapter() {
		     	@Override
		     	public void mouseClicked(MouseEvent e) {
		     		 DefaultTableModel model = (DefaultTableModel) table.getModel();
		     		  int selectedIndex = table.getSelectedRow();	     		        
		     		  tf_id.setText(model.getValueAt(selectedIndex, 0).toString());
		     		  tf_name.setText(model.getValueAt(selectedIndex, 1).toString());
		     		 tf_class.setText(model.getValueAt(selectedIndex, 2).toString());
		     		 tf_birth.setText(model.getValueAt(selectedIndex, 3).toString());
		     		 comboBox_address.setSelectedItem(model.getValueAt(selectedIndex, 4).toString());
		        
		      }
		     });   
	     table.setModel(new DefaultTableModel(
	     	new Object[][] {
	     	},
	     	new String[] {
	     		"ID", "Name", "Class", "Day Of Birth", "Gender", "Address"
	     	}
	     ));
	     table.getColumnModel().getColumn(3).setPreferredWidth(107);
	     table.getColumnModel().getColumn(5).setPreferredWidth(288);
	     table.setFont(new Font("Times New Roman", Font.BOLD, 12));
	     table.setBounds(10, 107, 380, 587);
	     JScrollPane thanhcuontable=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	     thanhcuontable.setViewportView(table);
	     thanhcuontable.setBounds(558, 170, 546, 403);
		 panel_5.add(thanhcuontable);
		 
		 tf_search = new JTextField();
		 tf_search.setFont(new Font("Tahoma", Font.PLAIN, 32));
		 tf_search.setColumns(10);
		 tf_search.setBounds(10, 22, 286, 50);
		 panel_5.add(tf_search);
		 
		 JButton button_search = new JButton("Search");
		 button_search.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	
				try {  
		    		String search=tf_search.getText();
		    		tf_search.setText("");
					 System.out.println("thanhcong");

					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Swing_demo","root","");
				 // Câu lệnh xem dữ liệu
				 String sql = "select * from students where ID='"+search+"'";
				 // Tạo đối tượng thực thi câu lệnh Select
				 Statement st = conn.createStatement();
				 // Thực thi 
				 ResultSet rs = st.executeQuery(sql);

				 while (rs.next()) {	
					 tf_id.setText(rs.getString("ID"));
					 tf_name.setText(rs.getString("Name"));
					 tf_class.setText(rs.getString("Class"));
					 tf_birth.setText(rs.getString("Day Of Birth"));
					 if (rs.getString("Sex").equals("Male")) {
		                    male.setSelected(true);
		                } else if (rs.getString("Sex").equals("Female")) {
		                    female.setSelected(true);
		                }
					 comboBox_address.setSelectedItem(rs.getString("Address"));
					 avatar.setIcon(new ImageIcon(rs.getString("Avatar")));
               
				 }
				 
				 
			}catch (Exception e2) {
				
			}
			
			
			
		 	}
		 });
		 
		 
		 button_search.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		 button_search.setBounds(343, 22, 135, 50);
		 panel_5.add(button_search);
		 
		 JButton btnNewButton_1_1 = new JButton("Delete");
		 btnNewButton_1_1.addActionListener(new ActionListener() {
			
			private PreparedStatement insert;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel model = (DefaultTableModel) table.getModel();
		          int selectedIndex = table.getSelectedRow();
		            try {  
		                
		            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
		            int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to Delete the student","Warning",JOptionPane.YES_NO_OPTION);
		            if(dialogResult == JOptionPane.YES_OPTION){
		 
		            	 Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/swing_demo","root", "");
		                    String sql = "delete from students where ID=?";
		                    PreparedStatement st1 =  con.prepareStatement(sql);
		        
		                    st1.setInt(1,id);
		                    st1.executeUpdate();
		            tf_id.setText("");
		            tf_name.setText("");
		            tf_birth.setText("");
		            tf_class.setText("");
		            dispose();
                    dieukhien.hienthisinhvien();
		            }
		 
		        } catch (SQLException ex) {
		            
		        }
			}
		});
		 btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		 btnNewButton_1_1.setBounds(167, 485, 101, 43);
		 panel_5.add(btnNewButton_1_1);
		 
		 JButton button_update = new JButton("Update");
		 button_update.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
				
				
			        try {
			        	
			          DefaultTableModel model = (DefaultTableModel) table.getModel();
		                int selectedIndex = table.getSelectedRow();
	                	int masinhvien = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
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
	                    System.out.println("update Student name " + hoten);
	                    System.out.println("update Student");

	                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/swing_demo","root", "");
	                    String sql = "UPDATE `students` SET `Name`=?,`Class`=?,`Day Of Birth`=?,`Sex`=?,`Address`=? WHERE ID=?";
	                    PreparedStatement st =  con.prepareStatement(sql);

	                    st.setString(1, hoten);
	                    st.setString(2, lop);
	                    st.setString(3, ngaysinh);
	                    st.setString(4, gioitinh);
	                    st.setString(5, address);
	                    st.setInt(6, masinhvien);
	                    st.executeUpdate();
	                    JOptionPane.showMessageDialog(jpmain, "Students has been successfully changed");    
	                    dispose();
		                dieukhien.hienthisinhvien();

	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
			          
				 

			        }
			 
		});
		 button_update.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		 button_update.setBounds(304, 485, 101, 43);
		 panel_5.add(button_update);
		 
		 JButton btnNewButton_1_3 = new JButton("Save");
		 btnNewButton_1_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			    dieukhien.themsinhvien();
				

				try {
					
					JOptionPane.showMessageDialog(jpmain, "You Was Entered: ");
					int masinhvien=Integer.valueOf(tf_id.getText());
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
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/swing_demo","root", "");

                    String query = "INSERT INTO students values('" + masinhvien + "','" + hoten + "','" + lop + "','" +
                    		ngaysinh +  "','" + gioitinh + "','" + address + "','" +' '+ "','" +' '+ "','" +' '+ "','" +' '+ "','" +' '+ "')";                  
                    Statement sta = connection.createStatement();
                   
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(jpmain, "This is alredy exist");
                        
                    } else {
                        JOptionPane.showMessageDialog(jpmain,
                            "Student "+hoten+" has been created successfully");
                       
                    }
                    dispose();
                } catch (Exception exception) {
                   System.out.println(exception.getMessage());
                }
                dieukhien.hienthisinhvien();
				dispose();
			}
			
		});
		
			
		 btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		 btnNewButton_1_3.setBounds(25, 485, 101, 43);
		 panel_5.add(btnNewButton_1_3);
		 
		 JButton btnNewButton_1_4 = new JButton("Cancel");
		 btnNewButton_1_4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
		 		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Swing_demo","root","");
				 // Câu lệnh xem dữ liệu
				 String sql = "select * from Notifications";
				 // Tạo đối tượng thực thi câu lệnh Select
				 java.sql.Statement st = conn.createStatement();
				 // Thực thi 
				 ResultSet rs = st.executeQuery(sql);
				 System.out.println("trong+");
	                // Kiểm tra xem có dữ liệu hay không
	                if (rs.next()) {
	                	 dispose();
	                	 dieukhien=new QLSVController();
	                	 tf_id.setText("");
	     				tf_class.setText("");
	     				tf_name.setText("");
	     				tf_birth.setText("");
	     				btg.clearSelection();
	     				comboBox_address.setSelectedIndex(-1);
	                     dieukhien.hienthithongbao();
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
		 btnNewButton_1_4.setBounds(436, 485, 101, 43);
		 panel_5.add(btnNewButton_1_4);
			     table.setFont(new Font("Times New Roman", Font.BOLD, 12));
			     
			     JPanel panel = new JPanel();
			     panel.setBackground(new Color(240, 240, 240));
			     panel.setBounds(558, 10, 202, 139);
			     panel_5.add(panel);
			     panel.setLayout(null);
			     
			      avatar = new JLabel("Image");
			      avatar.setForeground(new Color(51, 204, 0));
			      avatar.setFont(new Font("Tahoma", Font.ITALIC, 16));
			     avatar.setBounds(10, 10, 182, 119);
			     panel.add(avatar);
			     
			     JPanel panel_1 = new JPanel();
			     panel_1.setBounds(781, 10, 250, 72);
			     panel_5.add(panel_1);
			     panel_1.setLayout(null);
			     
			     JLabel lblNotification = new JLabel("Notification");
			     lblNotification.addMouseListener(new MouseListener() {
					
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
						dieukhien.hienthithu();
					}
				});
			     lblNotification.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
			     lblNotification.setBounds(10, 10, 141, 43);
			     panel_1.add(lblNotification);
			     
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
			     
			     JButton btnNewButton_1_4_1 = new JButton("Input Point");
			     btnNewButton_1_4_1.addActionListener(new ActionListener() {
			     	public void actionPerformed(ActionEvent e) {
			     		new mark_students();
				 	    dieukhien =new QLSVController();
				 	    dieukhien.hienthidiem();
			     	}
			     });
			     btnNewButton_1_4_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			     btnNewButton_1_4_1.setBounds(211, 549, 155, 43);
			     panel_5.add(btnNewButton_1_4_1);
			     
			     
		 
		 
		
		
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
		jmbar.setToolTipText("Notification");
		jmbar.setFont(new Font("Segoe UI", Font.BOLD, 16));
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
				dispose();
				
				dieukhien=new QLSVController();
				dieukhien.hienthisinhvien();
				
			}
		});
		jm_start_program.setFont(new Font("Segoe UI", Font.BOLD, 16));
		jm_start_program.setIcon(null);
		jmbar.add(jm_start_program);
		
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
		lblNewLabel.setIcon(new ImageIcon("D:\\zalo\\red.jpg"));
		lblNewLabel.setBounds(136, 0, 1394, 90);
		jp_baodong_ngoaicung.add(lblNewLabel);
		setVisible(true);
	}
	public static void main(String[] args) {
		new manage();
	}
}