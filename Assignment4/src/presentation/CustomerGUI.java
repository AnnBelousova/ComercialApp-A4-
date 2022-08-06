package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import data.DataIO;
import data.Validator;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.FileNotFoundException;

import javax.swing.JTextField;

import business.Customer;
import business.Province;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerGUI extends JFrame {

	private JTextField txtCustID;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtStreet;
	private JTextField txtCity;
	private JTextField txtPostalCode;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public CustomerGUI() {
		
		try {
		DataIO dIO = new DataIO();
	
		getContentPane().setBackground(new Color(240, 240, 240));
		setBackground(new Color(220, 220, 220));
		setFont(new Font("Dialog", Font.BOLD, 25));
		getContentPane().setLayout(null);
		
		this.setTitle("Customer Registration");
		this.setBounds(270, 300, 1254, 633);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel lblCustomertId = new JLabel("Customer ID");
		lblCustomertId.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCustomertId.setBounds(67, 68, 138, 40);
		getContentPane().add(lblCustomertId);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFirstName.setBounds(67, 119, 138, 40);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLastName.setBounds(67, 170, 138, 40);
		getContentPane().add(lblLastName);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPhone.setBounds(67, 220, 138, 42);
		getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmail.setBounds(67, 273, 138, 42);
		getContentPane().add(lblEmail);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblStreet.setBounds(67, 326, 138, 42);
		getContentPane().add(lblStreet);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCity.setBounds(67, 379, 138, 42);
		getContentPane().add(lblCity);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblProvince.setBounds(67, 432, 138, 42);
		getContentPane().add(lblProvince);
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		lblPostalCode.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPostalCode.setBounds(67, 485, 138, 42);
		getContentPane().add(lblPostalCode);
		
		txtCustID = new JTextField();
		txtCustID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCustID.setColumns(10);
		txtCustID.setBounds(215, 73, 190, 33);
		getContentPane().add(txtCustID);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(215, 124, 224, 33);
		getContentPane().add(txtFirstName);
		
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLastName.setColumns(10);
		txtLastName.setBounds(215, 175, 224, 33);
		getContentPane().add(txtLastName);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhone.setColumns(10);
		txtPhone.setBounds(215, 226, 190, 33);
		getContentPane().add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(215, 279, 190, 33);
		getContentPane().add(txtEmail);
		
		txtStreet = new JTextField();
		txtStreet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtStreet.setColumns(10);
		txtStreet.setBounds(215, 332, 224, 33);
		getContentPane().add(txtStreet);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCity.setColumns(10);
		txtCity.setBounds(215, 385, 224, 33);
		getContentPane().add(txtCity);
		
//Fill combobox from Province table		
		JComboBox cmbProvince = new JComboBox();
		cmbProvince.setBounds(215, 440, 190, 33);
		ArrayList<Province> provinces = dIO.getProvince();
		for(Province p : provinces) {
			cmbProvince.addItem(p);		
		}
		getContentPane().add(cmbProvince);
		
		txtPostalCode = new JTextField();
		txtPostalCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPostalCode.setColumns(10);
		txtPostalCode.setBounds(215, 491, 190, 33);
		getContentPane().add(txtPostalCode);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JPanel panel = new JPanel();
		panel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		panel.setBounds(500, 85, 718, 440);
		panel.setLayout(new BorderLayout());
		
		JScrollPane scrpane = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrpane);
		getContentPane().add(panel);
		
//display FIRST row in the table			
		JButton btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DataIO dIO;
				try {
					dIO = new DataIO();
					int numb = 1;		
					String[] customers = dIO.findRow(numb);
					for(String c : customers) {
						txtArea.setText("");
						txtCustID.setText(customers[0]);
						txtFirstName.setText(customers[1]);
						txtLastName.setText(customers[2]);
						txtPhone.setText(customers[3]);
						txtEmail.setText(customers[4]);
						txtStreet.setText(customers[5]);
						txtCity.setText(customers[6]);
						String pr = customers[7];
						cmbProvince.removeAllItems();
						cmbProvince.addItem(pr);
						txtPostalCode.setText(customers[8]);				
					}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				 catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				}
			}

		});

		buttonGroup.add(btnFirst);
		btnFirst.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFirst.setBounds(10, 11, 97, 34);
		getContentPane().add(btnFirst);

//display LAST row in the table	
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Validator.isCustIDIsNull(txtCustID, "We could not find. \n")) {
					String CustID = txtCustID.getText();
				
				DataIO dIO;
				try {
					dIO = new DataIO();
					int numb = (Integer.parseInt(txtCustID.getText()) - 1);	
					if(!(numb == 0)) {
					String[] customers = dIO.findRow(numb);
					for(String c : customers) {
						txtArea.setText("");
						txtCustID.setText(customers[0]);
						txtFirstName.setText(customers[1]);
						txtLastName.setText(customers[2]);
						txtPhone.setText(customers[3]);
						txtEmail.setText(customers[4]);
						txtStreet.setText(customers[5]);
						txtCity.setText(customers[6]);
						String pr = customers[7];
						cmbProvince.removeAllItems();
						cmbProvince.addItem(pr);
						txtPostalCode.setText(customers[8]);				
					}
					}else {
						JOptionPane.showMessageDialog(null, "It was first customer in the list");
					}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				 catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				}
			}}
		});
		buttonGroup.add(btnPrevious);
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPrevious.setBounds(117, 11, 128, 34);
		getContentPane().add(btnPrevious);
		
//display LAST row in the table		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Validator.isCustIDIsNull(txtCustID, "We could not find. \n")) {
					String CustID = txtCustID.getText();
				
				DataIO dIO;
				try {
					dIO = new DataIO();
					int numb = (Integer.parseInt(txtCustID.getText())+1);
					if(!(numb == (dIO.lastCust()+1))){					
					String[] customers = dIO.findRow(numb);
					for(String c : customers) {
						txtArea.setText("");
						txtCustID.setText(customers[0]);
						txtFirstName.setText(customers[1]);
						txtLastName.setText(customers[2]);
						txtPhone.setText(customers[3]);
						txtEmail.setText(customers[4]);
						txtStreet.setText(customers[5]);
						txtCity.setText(customers[6]);
						String pr = customers[7];
						cmbProvince.removeAllItems();
						cmbProvince.addItem(pr);
						txtPostalCode.setText(customers[8]);				
					}
					}else {
						JOptionPane.showMessageDialog(null, "It was last customer in the list");
					}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				 catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				}
			}}
		});

		buttonGroup.add(btnNext);
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNext.setBounds(255, 11, 97, 34);
		getContentPane().add(btnNext);
		
//SET customer information into txt fields and combobox	
		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				DataIO dIO;
				try {
					dIO = new DataIO();
					int numb = dIO.lastCust();	
					String[] customers = dIO.findRow(numb);
					for(String c : customers) {
						txtArea.setText("");
						txtCustID.setText(customers[0]);
						txtFirstName.setText(customers[1]);
						txtLastName.setText(customers[2]);
						txtPhone.setText(customers[3]);
						txtEmail.setText(customers[4]);
						txtStreet.setText(customers[5]);
						txtCity.setText(customers[6]);
						String pr = customers[7];
						cmbProvince.removeAllItems();
						cmbProvince.addItem(pr);
						txtPostalCode.setText(customers[8]);
					}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				 catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				}
			}
		});
		buttonGroup.add(btnLast);
		btnLast.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLast.setBounds(362, 11, 97, 34);
		getContentPane().add(btnLast);
		
		
//SAVE New Customer into table
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Validator.isFirstName(txtFirstName, "First Name")) {
					String firstName = txtFirstName.getText();
				
				if(Validator.isLastName(txtLastName, "Last Name")) {
					String lastName = txtLastName.getText();
				
				if(Validator.isPhone(txtPhone, "Phone")) {
					String phone = txtPhone.getText();	
				
				if(Validator.isEmail(txtEmail, "Email")) {
					String email = txtEmail.getText();

				if(Validator.isStreet(txtStreet, "Street")) {
					String street = txtStreet.getText();
				
				if(Validator.isCity(txtCity, "City")) {		
					String city = txtCity.getText();
						
				if(Validator.isPostalCode(txtPostalCode, "Postal Code")) {		
					String postalCode = txtPostalCode.getText();
						
				DataIO dIO;
				try {
					dIO = new DataIO();
					int custId = (dIO.lastCust());
					Customer customer = new Customer();
					if(custId == 0) {
						custId=1;
					txtCustID.setText(String.valueOf(custId));
					customer.setCustomerId(custId);
					customer.setFirstName(txtFirstName.getText());
					customer.setLastName(txtLastName.getText());
					customer.setPhone(txtPhone.getText());
					customer.setEmail(txtEmail.getText());
					customer.setStreet(txtStreet.getText());
					customer.setCity(txtCity.getText());
					customer.setProvince(cmbProvince.getItemAt(cmbProvince.getSelectedIndex()).toString());
					customer.setPostalCode(txtPostalCode.getText());
					dIO.insertCustomer(customer);
					JOptionPane.showMessageDialog(null, "The customer is saved with ID " + custId);
					} else {
					custId = (dIO.lastCust() + 1);
					txtCustID.setText(String.valueOf(custId));
						customer.setCustomerId(custId);
						customer.setFirstName(txtFirstName.getText());
						customer.setLastName(txtLastName.getText());
						customer.setPhone(txtPhone.getText());
						customer.setEmail(txtEmail.getText());
						customer.setStreet(txtStreet.getText());
						customer.setCity(txtCity.getText());
						customer.setProvince(cmbProvince.getItemAt(cmbProvince.getSelectedIndex()).toString());
						customer.setPostalCode(txtPostalCode.getText());
						dIO.insertCustomer(customer);
						JOptionPane.showMessageDialog(null, "The customer is saved with ID " + custId);
					}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				 catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				}
			}
				}}}}}}}
		});
		
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setBounds(704, 546, 87, 34);
		getContentPane().add(btnSave);
		
//UPDATE row based on cust id	
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Validator.isCustIDIsNull(txtCustID, "The Customer ID is empty.")) {
					String CustID = txtCustID.getText();
					
					if(Validator.isFirstName(txtFirstName, "First Name")) {
						String firstName = txtFirstName.getText();
					
					if(Validator.isLastName(txtLastName, "Last Name")) {
						String lastName = txtLastName.getText();
					
					if(Validator.isPhone(txtPhone, "Phone")) {
						String phone = txtPhone.getText();	
					
					if(Validator.isEmail(txtEmail, "Email")) {
						String email = txtEmail.getText();

					if(Validator.isStreet(txtStreet, "Street")) {
						String street = txtStreet.getText();
					
					if(Validator.isCity(txtCity, "City")) {		
						String city = txtCity.getText();
							
					if(Validator.isPostalCode(txtPostalCode, "Postal Code")) {		
						String postalCode = txtPostalCode.getText();	
					
					
				DataIO dIO;
				try {
					txtArea.setText("");
					dIO = new DataIO();
					int custId = (Integer.parseInt(txtCustID.getText()));
					Customer customer = new Customer();
					customer.setFirstName(txtFirstName.getText());
					customer.setLastName(txtLastName.getText());
					customer.setPhone(txtPhone.getText());
					customer.setEmail(txtEmail.getText());
					customer.setStreet(txtStreet.getText());
					customer.setCity(txtCity.getText());
					customer.setProvince(cmbProvince.getItemAt(cmbProvince.getSelectedIndex()).toString());
					customer.setPostalCode(txtPostalCode.getText());
					dIO.updateRecord(customer, custId);
					JOptionPane.showMessageDialog(null, "The customer is updated");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			 catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			}
		}}}}}}}}}	
	});
		buttonGroup.add(btnUpdate);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(469, 11, 111, 34);
		getContentPane().add(btnUpdate);
		
//DISPLAY row(s) based on entering first/last name		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Validator.isFirstNameLastNameNull(txtFirstName, txtLastName, "The First and Last Name are empty")) {
					String FirstName = txtFirstName.getText();
					
				DataIO dIO;
				try {
					dIO = new DataIO();
					if(!(txtFirstName.getText().isEmpty())) {
						String nameF = txtFirstName.getText();
					
						ArrayList<Customer> customers = dIO.displayCustomersF(nameF);
						for(Customer c : customers) {
							txtArea.append(c.toString());					
							}
					}
					
					if(!txtLastName.getText().isEmpty()) {
						String nameL = txtLastName.getText();				
						ArrayList<Customer> customers = dIO.displayCustomersL(nameL);
						for(Customer c : customers) {
							txtArea.append(c.toString());
							}
					}
									
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}}
		});
		
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDisplay.setBounds(800, 546, 103, 34);
		getContentPane().add(btnDisplay);
		
//SET CustomerGUI not Visible		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);
				 dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(913, 546, 87, 34);
		getContentPane().add(btnExit);
		
//CLEAR all txt fields		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataIO dIO;	
				try {
					dIO = new DataIO();
					txtCustID.setText("");
					txtFirstName.setText("");
					txtLastName.setText("");
					txtPhone.setText("");
					txtEmail.setText("");
					txtStreet.setText("");
					txtCity.setText("");
					txtPostalCode.setText("");
					cmbProvince.removeAllItems();
					ArrayList<Province> provinces;
					provinces = dIO.getProvince();
					for(Province p : provinces) {
						cmbProvince.addItem(p);		
					}
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}	
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBounds(265, 546, 87, 34);
		getContentPane().add(btnClear);

		dIO = null;
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	 catch (ClassNotFoundException e2) {
		e2.printStackTrace();
	}			
}
}
