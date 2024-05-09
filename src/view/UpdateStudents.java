package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;

public class UpdateStudents extends JFrame {
    public manage qlsv;
	private JPanel contentPane;
	private JTextField tensinhvien;
	private JTextField masinhvien;
	private JTextField lop;
	private JTextField ngaysinh;
    QLSVController dieukhien;
	
	public UpdateStudents() {
		this.dieukhien=new QLSVController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 663, 451);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(0, 128, 255));
		lblId.setBounds(81, 26, 27, 30);
		lblId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(0, 128, 255));
		lblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblName.setBounds(81, 82, 135, 43);
		contentPane.add(lblName);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setForeground(new Color(0, 128, 255));
		lblClass.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblClass.setBounds(81, 135, 135, 43);
		contentPane.add(lblClass);
		
		JLabel lblDayOfBirth = new JLabel("Day Of Birth");
		lblDayOfBirth.setForeground(new Color(0, 128, 255));
		lblDayOfBirth.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblDayOfBirth.setBounds(81, 188, 155, 43);
		contentPane.add(lblDayOfBirth);
		
		JLabel lblSex = new JLabel("Gender");
		lblSex.setForeground(new Color(0, 128, 255));
		lblSex.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblSex.setBounds(81, 241, 135, 43);
		contentPane.add(lblSex);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(0, 128, 255));
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblAddress.setBounds(81, 295, 135, 43);
		contentPane.add(lblAddress);
		
		tensinhvien = new JTextField();
		tensinhvien.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tensinhvien.setColumns(10);
		tensinhvien.setBounds(270, 83, 228, 42);
		contentPane.add(tensinhvien);
		
		masinhvien = new JTextField();
		masinhvien.setFont(new Font("Tahoma", Font.PLAIN, 32));
		masinhvien.setColumns(10);
		masinhvien.setBounds(270, 26, 228, 42);
		contentPane.add(masinhvien);
		
		lop = new JTextField();
		lop.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lop.setColumns(10);
		lop.setBounds(270, 135, 228, 42);
		contentPane.add(lop);
		
		ngaysinh = new JTextField();
		ngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 32));
		ngaysinh.setColumns(10);
		ngaysinh.setBounds(270, 188, 228, 42);
		contentPane.add(ngaysinh);
		
		ButtonGroup btgs=new ButtonGroup();
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setForeground(Color.RED);
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		rdbtnNewRadioButton.setBounds(214, 255, 122, 21);
		contentPane.add(rdbtnNewRadioButton);
		btgs.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setForeground(Color.RED);
		rdbtnFemale.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		rdbtnFemale.setBounds(351, 256, 122, 21);
		contentPane.add(rdbtnFemale);
		btgs.add(rdbtnFemale);
		
		JComboBox comboBox_address = new JComboBox();
		comboBox_address.setBounds(270, 295, 221, 43);
		contentPane.add(comboBox_address);
		
		JButton btnNewButton_1_4 = new JButton("Cancel");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1_4.setBounds(351, 361, 101, 43);
		contentPane.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_4_1 = new JButton("Ok");
		btnNewButton_1_4_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				  try {
					  dispose();
						qlsv=new manage();
			          DefaultTableModel model = (DefaultTableModel) qlsv.table.getModel();
		                int selectedIndex = qlsv.table.getSelectedRow();
	                	int masinhvien = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
						String hoten=tensinhvien.getText()+"";
						String lophoc=lop.getText()+"";
						String ngaysinhstudent =ngaysinh.getText()+"";
						String gioitinh= "";
						if(qlsv.male.isSelected()) {
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
	                    st.setString(2, lophoc);
	                    st.setString(3, ngaysinhstudent);
	                    st.setString(4, gioitinh);
	                    st.setString(5, address);
	                    st.setInt(6, masinhvien);
	                    st.executeUpdate();
	                    JOptionPane.showMessageDialog(contentPane, "Students has been successfully changed");    
	                    dispose();
		                dieukhien.hienthisinhvien();

	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
			   
			}
		});
		btnNewButton_1_4_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1_4_1.setBounds(208, 361, 101, 43);
		contentPane.add(btnNewButton_1_4_1);
		this.setVisible(true);
	}
}
