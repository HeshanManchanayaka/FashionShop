import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class SearchCustomerForm extends JFrame{
	private JLabel lblTitle;
	
	private JButton btnSearch;
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
	
	SearchCustomerForm(CustomerCollection customerCollection){
		this.customerCollection=customerCollection;
		setSize(400,300);
		setTitle("Search Customer Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		lblTitle=new JLabel("Search Customer Form");
		lblTitle.setFont(new Font("",1,30));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		add("North",lblTitle);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnSearch=new JButton("Search");
		btnSearch.setFont(new Font("",1,20));
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				Customer c1=customerCollection.search(txtId.getText());
				if(c1==null){
					JOptionPane.showMessageDialog(null,"Customer not found..");
					txtId.setText("");
					txtId.requestFocus();
				}else{
					txtName.setText(c1.getName());
					txtAddess.setText(c1.getAddress());
					txtSalary.setText(c1.getSalary()+"");
				}
			}
		});
		buttonPanel.add(btnSearch);
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20));
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose(); 
			}
		});
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
		txtId.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				Customer c1=customerCollection.search(txtId.getText());
				if(c1==null){
					JOptionPane.showMessageDialog(null,"Customer not found..");
					txtId.setText("");
					txtId.requestFocus();
				}else{
					txtName.setText(c1.getName());
					txtAddess.setText(c1.getAddress());
					txtSalary.setText(c1.getSalary()+"");
				}
			}
		});
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

}

