package view;

import java.awt.EventQueue;

import javax.print.DocFlavor.URL;
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
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Label;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Toolkit;
public class qlsvmain extends JFrame  {

	private JPanel jpmain;
    
	
	public qlsvmain() {
		this.setTitle("Đồ Án Quản Lý Sinh Viên Cuối Kỳ I");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(getMaximumSize());
		
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
		
		JPanel jp_baodong_ngoaicung = new JPanel();
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
		jl_cmnm.setIcon(new ImageIcon("D:\\zalo\\cmnm.png"));
		jl_cmnm.setBounds(0, 0, 209, 612);
		panel_3.add(jl_cmnm);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(1354, 10, 176, 602);
		jp_baodong_anh.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\zalo\\aktv.png"));
		lblNewLabel_2.setBounds(0, 0, 176, 602);
		panel_4.add(lblNewLabel_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(219, 10, 1125, 602);
		jp_baodong_anh.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\zalo\\tet_yellow.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1115, 602);
		panel_5.add(lblNewLabel_1);
		
		ImageIcon imi_nb_kp_ps=new ImageIcon("D:/zalo/vkuuu.png");
		JLabel jl_image_nhanban = new JLabel(imi_nb_kp_ps);
		jl_image_nhanban.setBounds(10, 735, 1520, 41);
		jp_baodong_ngoaicung.add(jl_image_nhanban);
		
		JLabel jl_image_logo_university = new JLabel();
		jl_image_logo_university.setIcon(new ImageIcon("D:\\zalo\\vkufake.png"));
		jl_image_logo_university.setBounds(0, 0, 141, 84);
		jp_baodong_ngoaicung.add(jl_image_logo_university);
		
		JLabel image_blue = new JLabel("New label");
		image_blue.setIcon(new ImageIcon("D:\\zalo\\timvavang.jfif"));
		image_blue.setBounds(137, 0, 1393, 84);
		jp_baodong_ngoaicung.add(image_blue);
		
		Panel jp_baodong_menubar = new Panel();
		jp_baodong_menubar.setBounds(0, 87, 1530, 41);
		jp_baodong_ngoaicung.add(jp_baodong_menubar);
		jp_baodong_menubar.setLayout(null);
		
		JMenuBar jmbar = new JMenuBar();
		jmbar.setBounds(0, 0, 1530, 31);
		jp_baodong_menubar.add(jmbar);
		
	    java.net.URL url_image_home=qlsvmain.class.getResource("students.png");
		Image img=Toolkit.getDefaultToolkit().createImage(url_image_home);
		this.setIconImage(img);
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
				JOptionPane.showMessageDialog(jpmain, "Please Sign In!");
				
			}
		});
		jm_start_program.setFont(new Font("Segoe UI", Font.BOLD, 16));
		jm_start_program.setIcon(null);
		jmbar.add(jm_start_program);
		
		JMenu jm_account = new JMenu("Account");
		jm_account.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		jm_account.setIcon(null);
		jmbar.add(jm_account);
		
		JMenuItem jmi_sign_in = new JMenuItem("Sign In (Admin)");
		jmi_sign_in.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(jp_baodong_ngoaicung,"Welcom to Sign In !");
				 dispose();
				new UserLogin();
				
			}
		});

		jmi_sign_in.setFont(new Font("Segoe UI", Font.BOLD, 15));
		jm_account.add(jmi_sign_in);
		
		JMenuItem jmi_sign_in_1 = new JMenuItem("Sign In (Students)");
		jmi_sign_in_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new UserLogin_Students();
			}
		});
		jmi_sign_in_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		jm_account.add(jmi_sign_in_1);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new qlsvmain();
	}
	
}
