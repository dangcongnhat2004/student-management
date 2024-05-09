package test;

import javax.swing.UIManager;
import view.qlsvmain;

public class test {

	public static void main(String[] args) {
		try {
		   	  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		   	  new qlsvmain();
		     }catch (Exception e) {
				// TODO: handle exception
		   	  e.printStackTrace();
			}
	}

}
