package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import business.Customer;
import business.Product;
import business.Province;
import data.DataIO;
import data.Validator;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ProductGUI extends JFrame {
	private JTextField txtProductId;
	private JTextField txtProductName;
	private JTextField txtPrice;
	private JTextField txtMax;
	private JTextField txtMin;
	public ProductGUI() {
		
		try {
		DataIO dIO = new DataIO();
			
		getContentPane().setBackground(new Color(240, 240, 240));
		setBackground(new Color(220, 220, 220));
		setFont(new Font("Dialog", Font.BOLD, 25));
		getContentPane().setLayout(null);
		
		this.setTitle("Product GUI");
		this.setBounds(200, 200, 894, 380);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblProductId.setBounds(32, 66, 138, 40);
		getContentPane().add(lblProductId);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblProductName.setBounds(32, 117, 138, 40);
		getContentPane().add(lblProductName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrice.setBounds(32, 168, 138, 40);
		getContentPane().add(lblPrice);
		
		txtProductId = new JTextField();
		txtProductId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProductId.setColumns(10);
		txtProductId.setBounds(180, 71, 190, 33);
		getContentPane().add(txtProductId);
		
		txtProductName = new JTextField();
		txtProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProductName.setColumns(10);
		txtProductName.setBounds(180, 122, 224, 33);
		getContentPane().add(txtProductName);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrice.setColumns(10);
		txtPrice.setBounds(180, 173, 190, 33);
		getContentPane().add(txtPrice);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
	
		JPanel panel = new JPanel();
		panel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		panel.setBounds(414, 11, 424, 273);
		panel.setLayout(new BorderLayout());
		
		JScrollPane scrpane = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrpane);
		getContentPane().add(panel);
		
		txtMax = new JTextField();
		txtMax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMax.setColumns(10);
		txtMax.setBounds(283, 234, 105, 33);
		getContentPane().add(txtMax);
		
		txtMin = new JTextField();
		txtMin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMin.setColumns(10);
		txtMin.setBounds(151, 234, 105, 33);
		getContentPane().add(txtMin);
		
		JLabel lblMax = new JLabel("max");
		lblMax.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMax.setBounds(323, 217, 36, 14);
		getContentPane().add(lblMax);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMin.setBounds(190, 217, 36, 14);
		getContentPane().add(lblMin);
		
//SAVE Product to the table
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Validator.isProductId(txtProductId, "Product ID")) {
					String ProductId = txtProductId.getText();
				
				if(Validator.isProductName(txtProductName, "Product Name")) {
					String ProductName = txtProductName.getText();
				
				if(Validator.isPrice(txtPrice, "Product Price")) {
					String Price = txtPrice.getText();
				
				DataIO dIO;
				try {
					dIO = new DataIO();
					int prodId = (dIO.lastProd());
					Product product = new Product();
					if(prodId == 0) {
						prodId=1;
					txtProductId.setText(String.valueOf(prodId));
					product.setProductId(prodId);
					product.setProductName(txtProductName.getText());
					product.setListPrice(Double.parseDouble(txtPrice.getText()));
					dIO.insertProduct(product);
					JOptionPane.showMessageDialog(null, "The product is saved with ID " + prodId);
					}else {
					prodId = (dIO.lastProd()+1);
					txtProductId.setText(String.valueOf(prodId));
					product.setProductId(prodId);
					product.setProductName(txtProductName.getText());
					product.setListPrice(Double.parseDouble(txtPrice.getText()));
					dIO.insertProduct(product);
					JOptionPane.showMessageDialog(null, "The product is saved with ID " + prodId);
					}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				 catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				}
			}	}}}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setBounds(450, 295, 87, 34);
		getContentPane().add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Validator.isNotProductId(txtProductId, "Product ID - ")) {
					String ProductId = txtProductId.getText();

					if(Validator.isProductName(txtProductName, "Product Name")) {
					String ProductName = txtProductName.getText();

					if(Validator.isPrice(txtPrice, "Product Price")) {
					String Price = txtPrice.getText();
					
						DataIO dIO;
						try {
//							txtArea.setText("");
							dIO = new DataIO();
							int prodId = (Integer.parseInt(txtProductId.getText()));
							Product product = new Product();
							product .setProductName(txtProductName.getText());
							product .setListPrice(Double.parseDouble(txtPrice.getText()));
							dIO.updateRecordProd(product, prodId);
							JOptionPane.showMessageDialog(null, "The product is updated ");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					 catch (ClassNotFoundException e2) {
						e2.printStackTrace();
					}
				}}
			}}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(547, 295, 97, 34);
		getContentPane().add(btnUpdate);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Validator.isFind(txtProductId,txtProductName, txtMin, txtMax, "Find Product")) {
					String Min = txtMin.getText();
					
					if(Validator.isFindMaxLessMin(txtMin, txtMax, "MaxPrice is Wrong")) {
						String Max = txtMax.getText();
						
				DataIO dIO;
				try {
					dIO = new DataIO();
					if(!txtProductName.getText().isEmpty()) {
						String name = txtProductName.getText();
					
						ArrayList<Product> products = dIO.displayProductsName(name);
						for(Product p : products) {
							txtArea.append(p.toString());					
							}
					}
					if(!txtProductId.getText().isEmpty()) {
						int prodId = (Integer.parseInt(txtProductId.getText()));
					
						ArrayList<Product> products = dIO.displayProductsId(prodId);
						for(Product p : products) {
							txtArea.append(p.toString());					
							}
					}
					
					if(!(txtMax.getText().isEmpty()) && !(txtMin.getText().isEmpty()))  {
						int min = (Integer.parseInt(txtMin.getText()));
						int max = (Integer.parseInt(txtMax.getText()));
						ArrayList<Product> products = dIO.displayProductsMinMax(min, max);
						for(Product p : products) {
							txtArea.append(p.toString());					
							}
					}
					
				} catch (ClassNotFoundException e1) {	
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
		}
		}}
		});

		btnFind.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFind.setBounds(654, 295, 103, 34);
		getContentPane().add(btnFind);

		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);
				 dispose();
			}
		});
		
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(767, 295, 87, 34);
		getContentPane().add(btnExit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataIO dIO;	
				try {
					dIO = new DataIO();
					txtProductId.setText("");
					txtProductName.setText("");
					txtPrice.setText("");
					txtMin.setText("");	
					txtMax.setText("");	
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}	
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBounds(224, 295, 87, 34);
		getContentPane().add(btnClear);
		
		JLabel lblPriceRate = new JLabel("Price rate");
		lblPriceRate.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPriceRate.setBounds(32, 227, 109, 40);
		getContentPane().add(lblPriceRate);
	
		dIO = null;
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	 catch (ClassNotFoundException e2) {
		e2.printStackTrace();
	}	
	}
}



