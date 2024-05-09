package view;

import java.awt.EventQueue;
import java.sql.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.*;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.*;
import org.jfree.ui.RefineryUtilities;

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
import java.awt.LayoutManager;
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
import javax.swing.SwingConstants;

public class mark_students extends JFrame  {
    
	private java.io.File files;
	private JPanel jpmain;
	private JPanel jp_baodong_ngoaicung;
    QLSVController dieukhien;
	public ButtonGroup btg;
	public Tinh model;
	private JLabel labelClock;
	public JTable table;
	private JTextField tf_id;
	private JTextField tf_mark;
	private PieDataset dataset1;
	public JButton bt_tk;
	public JLabel tf_tk;
	

	public mark_students() {
		
    
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
		
		 table = new JTable();
		 table.addMouseListener(new MouseAdapter() {
		     	@Override
		     	public void mouseClicked(MouseEvent e) {
		     		 DefaultTableModel model = (DefaultTableModel) table.getModel();
		     		  int selectedIndex = table.getSelectedRow();	     		        
		     		  tf_id.setText(model.getValueAt(selectedIndex, 0).toString());
		     		  tf_mark.setText(model.getValueAt(selectedIndex, 1).toString());		        
		      }
		     });   
	     table.setModel(new DefaultTableModel(
	     	new Object[][] {
	     	},
	     	new String[] {
	     		"ID", "Mark"
	     	}
	     ));
	     table.setFont(new Font("Times New Roman", Font.BOLD, 12));
	     table.setBounds(10, 107, 380, 587);
	     JScrollPane thanhcuontable=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	     thanhcuontable.setViewportView(table);
	     thanhcuontable.setBounds(673, 23, 546, 183);
		 jp_baodong_anh.add(thanhcuontable);
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblId.setBounds(239, 23, 135, 43);
		jp_baodong_anh.add(lblId);
		
		tf_id = new JTextField();
		tf_id.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tf_id.setColumns(10);
		tf_id.setBounds(384, 23, 228, 50);
		jp_baodong_anh.add(tf_id);
		
		JLabel lblMark = new JLabel("Mark");
		lblMark.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblMark.setBounds(239, 105, 135, 43);
		jp_baodong_anh.add(lblMark);
		
		tf_mark = new JTextField();
		tf_mark.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tf_mark.setColumns(10);
		tf_mark.setBounds(384, 97, 228, 50);
		jp_baodong_anh.add(tf_mark);
		
		JButton bt_Insert = new JButton("Insert");
		bt_Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					
					JOptionPane.showMessageDialog(jpmain, "You Was Entered: ");
					int masinhvien=Integer.valueOf(tf_id.getText());
					int diem=Integer.valueOf(tf_mark.getText());
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/swing_demo","root", "");

                    String query = "INSERT INTO mark_students values('" + masinhvien + "','" +diem+ "')";                  
                    Statement sta = connection.createStatement();
                   
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(jpmain, "This is alredy exist");
                        
                    } else {
                        JOptionPane.showMessageDialog(jpmain,
                            "Student "+masinhvien+" has been created successfully");
                       dieukhien=new QLSVController();
                       dieukhien.hienthidiem();
                    
                    }
                   
                } catch (Exception exception) {
                   System.out.println(exception.getMessage());
                }
               
			}
		
		});
		bt_Insert.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		bt_Insert.setBounds(447, 163, 101, 43);
		jp_baodong_anh.add(bt_Insert);
		
		 DefaultPieDataset dataset = new DefaultPieDataset();
		JFreeChart chart = ChartFactory.createPieChart("Percentage statistics %", dataset, true, true, false);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setCircular(true);
        //day ne
       
        dataset.setValue("Good", 30.9999);
        dataset.setValue("Rather", 30.9999);
        dataset.setValue("Medium", 30.9999);
        
      

        // Định dạng biểu đồ
        chart.setBackgroundPaint(Color.white);
       
        plot.setLabelGenerator(null);           // Không hiển thị label
        plot.setSectionPaint(0, Color.red);     // Đặt màu cho từng phần của biểu đồ
        plot.setSectionPaint(1, Color.green);
        plot.setSectionPaint(2, Color.blue);
        plot.setSectionPaint(3, Color.orange);

        // Đưa biểu đồ vào trong JFrame
       
    
    ChartPanel panel = new ChartPanel(chart);
	panel.setBounds(356, 230, 607, 370);
	jp_baodong_anh.add(panel);    
			     
		 
		// Tạo bảng JFreeChart
		
		
		 bt_tk = new JButton("Statistical");
		bt_tk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new mark_students();
			        ResultSet rs = null;
			        try {
	                
				            Connection conn = null;
				            Statement stmt1 = null;
				            ResultSet rs1 = null;
				         
		                    conn = DriverManager.getConnection("jdbc:mysql://localhost/swing_demo","root", "");
				                stmt1 = conn.createStatement();
				                rs1 = stmt1.executeQuery("SELECT COUNT(*) FROM mark_students");
				                rs1.next();
				                int totalStudents1 = rs1.getInt(1);
				                rs1 = stmt1.executeQuery("SELECT COUNT(*) FROM mark_students WHERE Mark BETWEEN 0 AND 4");
				                rs1.next();
				                int mark0to41 = rs1.getInt(1);
				                rs1 = stmt1.executeQuery("SELECT COUNT(*) FROM mark_students WHERE Mark BETWEEN 5 AND 6");
				                rs1.next();
				                int mark5to61 = rs1.getInt(1);
				                rs1 = stmt1.executeQuery("SELECT COUNT(*) FROM mark_students WHERE Mark BETWEEN 7 AND 8");
				                rs1.next();
				                int mark7to81 = rs1.getInt(1);
				                rs1 = stmt1.executeQuery("SELECT COUNT(*) FROM mark_students WHERE Mark BETWEEN 9 AND 10");
				                rs1.next();
				                int mark9to101 = rs1.getInt(1);
				                
				                // Tính toán phần trăm của từng khoảng điểm
				                double percent0to41 = mark0to41 * 100.0 / totalStudents1;
				                double percent5to61 = mark5to61 * 100.0 / totalStudents1;
				                double percent7to81 = mark7to81 * 100.0 / totalStudents1;
				                double percent9to101 = mark9to101 * 100.0 / totalStudents1;
				                
				                // Tạo bộ dữ liệu
				                DefaultPieDataset dataset1 = new DefaultPieDataset();
				                dataset1.setValue("0 - 4", percent0to41);
				                dataset1.setValue("5 - 6", percent5to61);
				                dataset1.setValue("7 - 8", percent7to81);
				                dataset1.setValue("9 - 10", percent9to101);
				                 dieukhien=new QLSVController();
				                 dieukhien.hienthidiemA();
				              
			            }catch (Exception ex) {
			            	
							// TODO: handle exception
						}
					      
					
					

					




			        
			}
		});
		bt_tk.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		bt_tk.setBounds(1063, 435, 135, 43);
		jp_baodong_anh.add(bt_tk);
		
		tf_tk = new JLabel("");
		tf_tk.setBounds(1015, 240, 294, 141);
		jp_baodong_anh.add(tf_tk);
		
		
		
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
		new mark_students();
	}
	public void bang() {
	 String url = "jdbc:mysql://localhost/swing_demo";
     String username = "root";
     String password = "";
     String query = "SELECT * FROM mark_students";

     try {
         // Tạo kết nối đến cơ sở dữ liệu
         Connection conn = DriverManager.getConnection(url, username, password);

         // Thực hiện truy vấn và lấy dữ liệu
         JDBCPieDataset dataset = new JDBCPieDataset(conn, query);

         // Tạo bảng JFreeChart
         JFreeChart chart = ChartFactory.createPieChart("Marks of students", dataset);

         // Hiển thị bảng JFreeChart
         ChartFrame frame = new ChartFrame("Marks of students", chart);
         frame.pack();
         frame.setVisible(true);

         // Đóng kết nối
         conn.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
}