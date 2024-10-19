import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddCustomerForm extends JFrame{
	private JLabel lblTitle;
	
	private JButton btnAdd;
	private JButton btnCancel;
	
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblAddress;
	private JLabel lblSalary;
	
	
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAddess;
	private JTextField txtSalary;
	
	private CustomerCollection customerCollection;
	
	AddCustomerForm(CustomerCollection customerCollection){
		this.customerCollection=new CustomerCollection();
		setSize(400,300);
		setTitle("Add Customer Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		lblTitle=new JLabel("Add Customer Form");
		lblTitle.setFont(new Font("",1,30));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		add("North",lblTitle);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnAdd=new JButton("Add");
		btnAdd.setFont(new Font("",1,20));
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=txtId.getText();
				String name=txtName.getText();
				String address=txtAddess.getText();
				double salary=Double.parseDouble(txtSalary.getText());
				Customer customer=new Customer(id,name,address,salary);
				boolean isAdded=customerCollection.add(customer);
				if(isAdded){
					JOptionPane.showMessageDialog(null,"Added Success");
					txtId.setText(generateCustomerId());
					txtName.requestFocus();
					txtName.setText("");
					txtAddess.setText("");
					txtSalary.setText("");
				}

			}
		});
		buttonPanel.add(btnAdd);
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20));
		buttonPanel.add(btnCancel);
		
		add("South",buttonPanel);
		
		JPanel labelPanel=new JPanel(new GridLayout(4,1));
		lblId=new JLabel("Customer ID");
		lblId.setFont(new Font("",1,20));
		labelPanel.add(lblId);
		
		lblName=new JLabel("Name");
		lblName.setFont(new Font("",1,20));
		labelPanel.add(lblName);
		
		lblAddress=new JLabel("Address");
		lblAddress.setFont(new Font("",1,20));
		labelPanel.add(lblAddress);
		
		lblSalary=new JLabel("Salary");
		lblSalary.setFont(new Font("",1,20));
		labelPanel.add(lblSalary);
		
		add("West",labelPanel);
		
		JPanel textPanel=new JPanel(new GridLayout(4,1));
		
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtId=new JTextField(5);
		txtId.setFont(new Font("",1,20));
		txtId.setEditable(false);
		txtId.setText(generateCustomerId());
		idTextPanel.add(txtId);
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(10);
		txtName.setFont(new Font("",1,20));
		txtName.requestFocus();
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameTextPanel.add(txtName);
		textPanel.add(nameTextPanel);
		
		txtAddess=new JTextField(15);
		txtAddess.setFont(new Font("",1,20));
		JPanel addressTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		addressTextPanel.add(txtAddess);
		textPanel.add(addressTextPanel);
		
		txtSalary=new JTextField(6);
		txtSalary.setFont(new Font("",1,20));
		JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		salaryTextPanel.add(txtSalary);
		textPanel.add(salaryTextPanel);
		
		
		add("East",textPanel);
	}
	private String generateCustomerId(){
		if(customerCollection.size()==0){
			return "C0001";
		}
		String lastId=customerCollection.get(customerCollection.size()-1).getId();
		String lastNumber=lastId.substring(1);	
		int lastNo=Integer.parseInt(lastNumber);
		String newId=String.format("C%04d",lastNo+1);
		return newId;
	}
}

