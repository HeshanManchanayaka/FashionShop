import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
class ViewCustomerForm extends JFrame{
	private JLabel lblTitle;
	
	private JTable tblCustomer;
	private DefaultTableModel dtm;
	
	private JButton btnReload;
	private CustomerCollection customerCollection;
	ViewCustomerForm(CustomerCollection customerCollection){
		this.customerCollection=customerCollection;
		setSize(400,300);
		setTitle("View Customer Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		lblTitle=new JLabel("View Customer Form");
		lblTitle.setFont(new Font("",1,30));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		add("North",lblTitle);
		
		String[] columnName={"Custmer ID","Name","Address","Salary"};
		dtm=new DefaultTableModel(columnName,0); //0->row count
		tblCustomer=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblCustomer);
		add("Center",tablePane);
		
		btnReload=new JButton("Reload");
		btnReload.setFont(new Font("",1,20));
		JPanel buttonPanel=new JPanel(); //default layout-->FlowLayout
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dtm.setRowCount(0);
				for(int i=0; i<customerCollection.size(); i++){
					Customer c1=customerCollection.get(i);
					Object[] rowData={c1.getId(),c1.getName(),c1.getAddress(),c1.getSalary()};
					dtm.addRow(rowData); 
				}
			}
		});
		buttonPanel.add(btnReload);
		add("South",buttonPanel);
	}
}

