package presentation;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import data.DataIO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {
	
	public MainGUI() {
		
				getContentPane().setBackground(new Color(240, 240, 240));
				getContentPane().setLayout(null);
				
				JLabel lblText = new JLabel("Customer Manager Application");
				lblText.setFont(new Font("Tahoma", Font.BOLD, 24));
				lblText.setBounds(32, 90, 379, 58);
				getContentPane().add(lblText);
				setBackground(new Color(220, 220, 220));
				setFont(new Font("Dialog", Font.BOLD, 25));
				this.initialize();
			getContentPane().setBackground(new Color(240, 240, 240));
			getContentPane().setLayout(null);

	}
		
	public void initialize() {
		this.setTitle("Main GUI");
		this.setBounds(600, 200, 450, 300);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar mnuMain = new JMenuBar();
		setJMenuBar(mnuMain);
		
		JMenu mnuManager = new JMenu("Manager");
		mnuManager.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnuMain.add(mnuManager);
		
		JMenuItem mnuCustomerGUI = new JMenuItem("Customer GUI");
		mnuCustomerGUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				   DataIO dIO = new DataIO();
				   int ch = dIO.checkTableCust();
				   
					if(ch == 0) {
						dIO.createTableCustomer();
						JOptionPane.showMessageDialog(null, "The table was created");
						CustomerGUI custg = new CustomerGUI();
						custg .setVisible(true);
					}
					if(ch == 1){
						CustomerGUI custg = new CustomerGUI();
						custg .setVisible(true);
						JOptionPane.showMessageDialog(null, "The DB was connected.");
					}
						dIO = null;

					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "You can not connect to DB");
					}
				 catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				}
			}
		});
		mnuCustomerGUI.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mnuManager.add(mnuCustomerGUI);
		
		JMenuItem mnuProductGUI = new JMenuItem("Product GUI");
		mnuProductGUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					   DataIO dIO = new DataIO();
					   int ch = dIO.checkTableProd();

						if(ch == 0) {
							dIO.createTableProduct();
							JOptionPane.showMessageDialog(null, "The table was created");
							ProductGUI prodg = new ProductGUI();
							prodg .setVisible(true);
						}
						if(ch == 1){
							ProductGUI prodg = new ProductGUI();
							prodg .setVisible(true);
							JOptionPane.showMessageDialog(null, "The DB was connected.");
						}
							dIO = null;
						} catch (SQLException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "You can not connect to DB");
						}
					 catch (ClassNotFoundException e2) {
						e2.printStackTrace();
					}
				}
			});
		mnuProductGUI.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mnuManager.add(mnuProductGUI);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnuMain.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(MainGUI.this, "Do you want to close the app?",  "Confirmation window", JOptionPane.YES_NO_OPTION, EXIT_ON_CLOSE);
				if(option == JOptionPane.YES_OPTION) {
				System.exit(0);
				}		
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mnNewMenu.add(mntmNewMenuItem);
	}
}
