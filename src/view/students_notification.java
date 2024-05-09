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
import java.awt.SystemColor;

public class students_notification extends JFrame  {
    
	private java.io.File files;
	private JPanel jpmain;
	private JPanel jp_baodong_ngoaicung;
    QLSVController dieukhien;
	public ButtonGroup btg;
	public Tinh model;
	private JLabel labelClock;
	private JTable table;
	public JLabel tf_not;
	

	public students_notification() {
		
    
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
		panel_5.setBackground(SystemColor.activeCaption);
		panel_5.setBounds(219, 10, 1125, 602);
		jp_baodong_anh.add(panel_5);
		panel_5.setLayout(null);
		
		
		 
		 JLabel lblName_1 = new JLabel("");
		 lblName_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		 lblName_1.setBounds(202, 153, 60, 43);
		 panel_5.add(lblName_1);
		 
		 JPanel panel = new JPanel();
		 panel.setBackground(new Color(0, 0, 255));
		 panel.setBounds(21, 10, 262, 75);
		 panel_5.add(panel);
		 panel.setLayout(null);
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setLayout(null);
		 panel_1.setBackground(new Color(255, 215, 0));
		 panel_1.setBounds(10, 10, 242, 56);
		 panel.add(panel_1);
		 
		 JLabel lblNewLabel_1 = new JLabel("From INFO@VKU.VN");
		 lblNewLabel_1.setIcon(new ImageIcon("D:\\anh\\email.png"));
		 lblNewLabel_1.setForeground(Color.RED);
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		 lblNewLabel_1.setBackground(new Color(255, 215, 0));
		 lblNewLabel_1.setBounds(10, 10, 226, 36);
		 panel_1.add(lblNewLabel_1);
		 
		 JPanel panel_2 = new JPanel();
		 panel_2.setBounds(150, 125, 845, 219);
		 panel_5.add(panel_2);
		 panel_2.setLayout(null);
		 
		 tf_not = new JLabel("");
		 tf_not.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		 tf_not.setBounds(10, 10, 825, 201);
		 panel_2.add(tf_not);
			     
			     
		
		
		
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
				new students_profile();
			}
		});
		jm_start_program.setFont(new Font("Segoe UI", Font.BOLD, 16));
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
				new UserLogin_Students();
				
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
		new students_notification();
	}
}