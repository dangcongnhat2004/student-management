package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import view.UserLogin_Students;
import view.admin_notification;
import view.manage;
import view.mark_students;
import view.qlsvmain;
import view.students_notification;
import view.students_profile;


public class QLSVController implements ActionListener{
	public manage qlsv;
	public admin_notification admin;
	private String header[] = {"ID", "Name", "Class", "Day Of Birth", "Sex", "Address"};
	private String headertb[] = {"ID", "Notifications"};
	private String headerdiem[] = {"ID", "Notifications"};

	public students_profile std;
	private int id;
	private JComboBox cmbCondition;
	private PreparedStatement insert;
	public UserLogin_Students us;

		@Override
		public void actionPerformed(ActionEvent e) {
			String ac=e.getActionCommand();
			JOptionPane.showMessageDialog(qlsv,"You Was Entered "+ac);
		}
		
			public  void search() {
				
			}
		public void themsinhvien() {
			qlsv=new manage();
			qlsv.dispose();
			qlsv.tf_id.setText("");
			qlsv.tf_class.setText("");
			qlsv.tf_class.setText("");
			qlsv.tf_birth.setText("");
			qlsv.btg.clearSelection();
			qlsv.comboBox_address.setSelectedIndex(-1);
		}
		public void hienthisinhvien() {
			qlsv=new manage();
			DefaultTableModel tblModel = new DefaultTableModel(header, 0);
			try { 
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Swing_demo","root","");
			 // Câu lệnh xem dữ liệu
			 String sql = "select * from Students ";
			 // Tạo đối tượng thực thi câu lệnh Select
			 Statement st = conn.createStatement();
			 // Thực thi 
			 ResultSet rs = st.executeQuery(sql);
		
			 tblModel.setRowCount(0);
			 // Nếu hojc sinh không tồn tại
			 if (rs.isBeforeFirst() == false) {
			  JOptionPane.showMessageDialog(qlsv, "The student is not available!");
			  return;
			 }
			 // Trong khi chưa hết dữ liệu
			 while (rs.next()) {
			   Vector  data = new Vector();
			   data.add(rs.getInt("ID"));
			   data.add(rs.getString("Name"));
			   data.add(rs.getString("Class"));
			   data.add(rs.getString("Day Of Birth"));
			   data.add(rs.getString("Sex"));
			   data.add(rs.getString("Address"));
			   // Thêm một dòng vào table model
			   tblModel.addRow(data);
			 }
			 qlsv.table.setModel(tblModel); // Thêm dữ liệu vào table
			} catch (Exception e) {
			  e.printStackTrace();
			}
		}
		public void  delete() {
			qlsv=new manage(); 
			
	    }
		public void updateDB() {
			final String username="root";
		      final String password="";
		      final String dataConn ="jdbc:mysql://localhost/swing_demo";
		    //===============================Function Declaration======================================
			 Connection sqlConn =null;
			    PreparedStatement pst = null;
			    ResultSet rs=null;
			     int q, i, id, deleteItem;

		        //int q, i;
		         try
		        {
		           
		           Class.forName("com.mysql.jdbc.Driver"); 
		            sqlConn = DriverManager.getConnection(dataConn,username,password);
		            pst = sqlConn.prepareStatement("select * from studentdata");
		            
		            rs =pst.executeQuery();
		            ResultSetMetaData StData = rs.getMetaData();
		            
		            q = StData.getColumnCount();
		            
		            DefaultTableModel RecordTable = (DefaultTableModel)qlsv.table.getModel();
		            RecordTable.setRowCount(0);
		            
		            while(rs.next()){
		                
		                Vector columnData = new Vector();
		                
		                for (i = 1; i <= q; i++)
		                {
		                    columnData.add(rs.getString("ID"));
		                    columnData.add(rs.getString("Name"));
		                    columnData.add(rs.getString("Day Of Birth"));
		                    columnData.add(rs.getString("Class"));
		                    columnData.add(rs.getString("Sex"));
		                    columnData.add(rs.getString("Address"));
		                    
		                }
		                    RecordTable.addRow(columnData);                
		                
		            }
		         
		        }
		        catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, ex);
		        } 
		    
		    
		      
		}
		 public void hienthiimage() {
		    	try {  
		    		us=new UserLogin_Students();
					std=new students_profile();
				    String username = us.textField.getText();
				    String password = us.passwordField.getText();

					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Swing_demo","root","");
				 // Câu lệnh xem dữ liệu
				 String sql = "select * from students where user_name_student='"+username+"' and password_student='"+password+"' ";
				 // Tạo đối tượng thực thi câu lệnh Select
				 Statement st = conn.createStatement();
				 // Thực thi 
				 ResultSet rs = st.executeQuery(sql);
				 while (rs.next()) {			    	
					 std.image.setIcon(new ImageIcon(rs.getString(1)));
				 }
			}catch (Exception e) {
				
			}
			
			}
		 public void hienthithongbao() {
			 qlsv=new manage();
				DefaultTableModel tblModel = new DefaultTableModel(header, 0);
				try { 
					
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Swing_demo","root","");
				 // Câu lệnh xem dữ liệu
				 String sql = "select * from Students ";
				 // Tạo đối tượng thực thi câu lệnh Select
				 Statement st = conn.createStatement();
				 // Thực thi 
				 ResultSet rs = st.executeQuery(sql);
			
				 tblModel.setRowCount(0);
				 // Nếu hojc sinh không tồn tại
				 if (rs.isBeforeFirst() == false) {
				  JOptionPane.showMessageDialog(qlsv, "The student is not available!");
				  return;
				 }
				 // Trong khi chưa hết dữ liệu
				 while (rs.next()) {
				   Vector  data = new Vector();
				   data.add(rs.getInt("ID"));
				   data.add(rs.getString("Name"));
				   data.add(rs.getString("Class"));
				   data.add(rs.getString("Day Of Birth"));
				   data.add(rs.getString("Sex"));
				   data.add(rs.getString("Address"));
				   // Thêm một dòng vào table model
				   tblModel.addRow(data);
				   qlsv.tf_tb.setText("*");
				 }
				 qlsv.table.setModel(tblModel); // Thêm dữ liệu vào table
				} catch (Exception e) {
				  e.printStackTrace();
				}
				
		 }
		 public void hienthithu() {
				admin=new admin_notification();
				DefaultTableModel tblModel = new DefaultTableModel(headertb, 0);
				try { 
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Swing_demo","root","");
				 // Câu lệnh xem dữ liệu
				 String sql = "select * from notifications ";
				 // Tạo đối tượng thực thi câu lệnh Select
				 Statement st = conn.createStatement();
				 // Thực thi 
				 ResultSet rs = st.executeQuery(sql);
			
				 tblModel.setRowCount(0);
				 // Nếu hojc sinh không tồn tại
				 if (rs.isBeforeFirst() == false) {
				  JOptionPane.showMessageDialog(admin, "The Notification is not available!");
				  return;
				 }
				 // Trong khi chưa hết dữ liệu
				 while (rs.next()) {
				   Vector  data = new Vector();
				   data.add(rs.getInt("ID"));
				   data.add(rs.getString("Notification"));
				   
				   // Thêm một dòng vào table model
				   tblModel.addRow(data);
				   }
				 admin.table.setModel(tblModel); // Thêm dữ liệu vào table
				} catch (Exception e) {
				  e.printStackTrace();
				}
			}
		 public void hienthithuadmin() {
				students_notification not=new students_notification();
				
				try { 
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Swing_demo","root","");
				 // Câu lệnh xem dữ liệu
				 String sql = "select * from notification_admin ";
				 // Tạo đối tượng thực thi câu lệnh Select
				 Statement st = conn.createStatement();
				 // Thực thi 
				 ResultSet rs = st.executeQuery(sql);
			
				 // Nếu hojc sinh không tồn tại
				 if (rs.isBeforeFirst() == false) {
				  JOptionPane.showMessageDialog(not, "The Notification is not available!");
				  return;
				 }
				 // Trong khi chưa hết dữ liệu
				 while (rs.next()) {
				  not.tf_not.setText(rs.getString("Notification"));
				   // Thêm một dòng vào table model
				   }
				
				} catch (Exception e) {
				  e.printStackTrace();
				}
			}
		 public void hienthitb() {
				students_profile tb=new students_profile();
				
				try { 
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Swing_demo","root","");
				 // Câu lệnh xem dữ liệu
				 String sql = "select * from notification_admin ";
				 // Tạo đối tượng thực thi câu lệnh Select
				 Statement st = conn.createStatement();
				 // Thực thi 
				 ResultSet rs = st.executeQuery(sql);
			
				 // Nếu hojc sinh không tồn tại
				 if (rs.isBeforeFirst() == false) {
				  JOptionPane.showMessageDialog(tb, "The Notification is not available!");
				  return;
				 }
				 // Trong khi chưa hết dữ liệu
				 if (rs.next()) {
					tb.tf_tb.setText("*");
				   // Thêm một dòng vào table model
				   }
				
				} catch (Exception e) {
				  e.printStackTrace();
				}
			}
		 public void hienthidiem() {
			 mark_students diem=new mark_students();
				DefaultTableModel tblModel = new DefaultTableModel(headerdiem, 0);
				try { 
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Swing_demo","root","");
				 // Câu lệnh xem dữ liệu
				 String sql = "select * from mark_students ";
				 // Tạo đối tượng thực thi câu lệnh Select
				 Statement st = conn.createStatement();
				 // Thực thi 
				 ResultSet rs = st.executeQuery(sql);
			
				 tblModel.setRowCount(0);
				 // Nếu hojc sinh không tồn tại
				 if (rs.isBeforeFirst() == false) {
				  JOptionPane.showMessageDialog(qlsv, "The mark is not available!");
				  return;
				 }
				 // Trong khi chưa hết dữ liệu
				 while (rs.next()) {
				   Vector  data = new Vector();
				   data.add(rs.getInt("ID"));
				   data.add(rs.getInt("Mark"));
				   // Thêm một dòng vào table model
				   tblModel.addRow(data);
				  
				 }
				 diem.table.setModel(tblModel); // Thêm dữ liệu vào table
				} catch (Exception e) {
				  e.printStackTrace();
				}
			}
		 public void hienthidiemA() {
			 mark_students diem=new mark_students();
				DefaultTableModel tblModel = new DefaultTableModel(headerdiem, 0);
				try { 
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Swing_demo","root","");
				 // Câu lệnh xem dữ liệu
				 String sql = "select * from mark_students ";
				 // Tạo đối tượng thực thi câu lệnh Select
				 Statement st = conn.createStatement();
				 // Thực thi 
				 ResultSet rs = st.executeQuery(sql);
			
				 tblModel.setRowCount(0);
				 // Nếu hojc sinh không tồn tại
				 if (rs.isBeforeFirst() == false) {
				  JOptionPane.showMessageDialog(qlsv, "The mark is not available!");
				  return;
				 }
				 // Trong khi chưa hết dữ liệu
				 while (rs.next()) {
				   Vector  data = new Vector();
				   data.add(rs.getInt("ID"));
				   data.add(rs.getInt("Mark"));
				   // Thêm một dòng vào table model
				   tblModel.addRow(data);
				   diem.tf_tk.setText("6:33.3333%   7:33.3333%  8:33.3333%");
				 }
				 diem.table.setModel(tblModel); // Thêm dữ liệu vào table
				} catch (Exception e) {
				  e.printStackTrace();
				}
			}
}
