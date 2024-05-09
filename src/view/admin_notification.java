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


public class admin_notification extends JFrame  {
    
	
	private JPanel jpmain;
	public JTextField tf_id;
	public JTextField tf_no;
	public JTextField tf_rep;
	public  JTable table;
	public JTextField tf_search;
	private JPanel jp_baodong_ngoaicung;
    QLSVController dieukhien;
	public ButtonGroup btg;
	public Tinh model;
	private JLabel labelClock;
	
	public admin_notification() {
		
    
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
		panel_5.setBackground(new Color(240, 255, 240));
		panel_5.setBounds(219, 10, 1125, 602);
		jp_baodong_anh.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblId.setBounds(58, 82, 135, 43);
		panel_5.add(lblId);
		
		JLabel lblName = new JLabel("Notification");
		lblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblName.setBounds(10, 211, 135, 43);
		panel_5.add(lblName);
		
		JLabel lblDayOfBirth = new JLabel("Reply");
		lblDayOfBirth.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblDayOfBirth.setBounds(43, 403, 76, 43);
		panel_5.add(lblDayOfBirth);
		
		tf_id = new JTextField();
		tf_id.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tf_id.setColumns(10);
		tf_id.setBounds(215, 82, 228, 50);
		panel_5.add(tf_id);
		
		tf_no = new JTextField();
		tf_no.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tf_no.setColumns(10);
		tf_no.setBounds(149, 150, 387, 156);
		panel_5.add(tf_no);
		
		tf_rep = new JTextField();
		tf_rep.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tf_rep.setColumns(10);
		tf_rep.setBounds(151, 332, 385, 175);
		panel_5.add(tf_rep);
		
		 table = new JTable();
		 table.addMouseListener(new MouseAdapter() {
		     	@Override
		     	public void mouseClicked(MouseEvent e) {
		     		 DefaultTableModel model = (DefaultTableModel) table.getModel();
		     		  int selectedIndex = table.getSelectedRow();	     		        
		     		  tf_id.setText(model.getValueAt(selectedIndex, 0).toString());
		     		  tf_no.setText(model.getValueAt(selectedIndex, 1).toString());		        
		      }
		     });   
	     table.setModel(new DefaultTableModel(
	     	new Object[][] {
	     	},
	     	new String[] {
	     		"ID", "Notifications"
	     	}
	     ));
	     table.setFont(new Font("Times New Roman", Font.BOLD, 12));
	     table.setBounds(10, 107, 380, 587);
	     JScrollPane thanhcuontable=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	     thanhcuontable.setViewportView(table);
	     thanhcuontable.setBounds(569, 94, 546, 403);
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
				 String sql = "select * from notifications where ID='"+search+"'";
				 // Tạo đối tượng thực thi câu lệnh Select
				 Statement st = conn.createStatement();
				 // Thực thi 
				 ResultSet rs = st.executeQuery(sql);

				 if(rs.next()) {	
					 tf_id.setText(rs.getString("ID"));
					 tf_no.setText(rs.getString("Notification"));
				 }else {
					 JOptionPane.showMessageDialog(jp_baodong_ngoaicung, "NO NOTICE!");
				 }
				 
				 
			}catch (Exception e2) {
				
			}
			
			
			
		 	}
		 });
		 
		 button_search.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		 button_search.setBounds(343, 22, 135, 50);
		 panel_5.add(button_search);
		 
		 JButton btnNewButton_1_3 = new JButton("Send");
		 btnNewButton_1_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int ID=Integer.valueOf(tf_id.getText());
				String rep=tf_rep.getText();
				try {
					if(kiemTraTrungKhoaChinh()) {
	    				JOptionPane.showMessageDialog(jpmain, "This ID has been mailed!");
					}else {
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Swing_demo","root","");
						String insert="INSERT INTO notification_admin values('" + ID + "','"+rep+"')";
						Statement statm=con.createStatement();
						 int x = statm.executeUpdate(insert);
			                if (x == 0) {
			                    JOptionPane.showMessageDialog(jpmain, "This is alredy exist");
			                    
			                } else {
			                    JOptionPane.showMessageDialog(jpmain,
			                       "Submitted successfully!");
			                    tf_id.setText("");
			    				tf_rep.setText("");
			    				tf_no.setText("");
			                }
					}
				}catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		
			
		 btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		 btnNewButton_1_3.setBounds(133, 530, 101, 43);
		 panel_5.add(btnNewButton_1_3);
		 
		 JButton btnNewButton_1_4 = new JButton("Cancel");
		 btnNewButton_1_4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		tf_id.setText("");
				tf_rep.setText("");
				tf_no.setText("");
		 		
		 	}
		 });
		 btnNewButton_1_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		 btnNewButton_1_4.setBounds(342, 530, 101, 43);
		 panel_5.add(btnNewButton_1_4);
			     table.setFont(new Font("Times New Roman", Font.BOLD, 12));
			     
			     
		 
		 
		
		
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
				dieukhien.hienthithongbao();
				
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
		new admin_notification();
	}
	public boolean kiemTraTrungKhoaChinh() throws SQLException {
	    boolean ketQua = false;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int ID=Integer.valueOf(tf_id.getText());
	    try {
	    	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/swing_demo","root", "");
	        String sql = "SELECT * FROM notification_admin WHERE ID = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, ID);
	        rs = stmt.executeQuery();
	        if (rs.next()) {
	            ketQua = true; // Giá trị khóa chính đã tồn tại
	        }
	    } catch (SQLException ex) {
	        throw ex;
	    } finally {
	    }
	    return ketQua;
	}
}