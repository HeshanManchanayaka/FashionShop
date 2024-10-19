class CustomerCollection{
	private Customer[] customerArray;
	
	CustomerCollection(){
		customerArray=new Customer[0];
	}
	public boolean add(Customer customer){
		extendsArray();
		customerArray[customerArray.length-1]=customer;
		return true;
	}
	private void extendsArray(){
		Customer[] tempCustomerArray=new Customer[customerArray.length+1];
		for (int i = 0; i < customerArray.length; i++){
			tempCustomerArray[i]=customerArray[i];
		}
		customerArray=tempCustomerArray;
	}
	public boolean remove(int index){
		if(index>=0 && index<customerArray.length){
			for (int i = index; i <customerArray.length-1; i++){
				customerArray[i]=customerArray[i+1];
			}
			Customer[] tempCustomerArray=new Customer[customerArray.length-1];
			for (int i = 0; i < tempCustomerArray.length; i++){
				tempCustomerArray[i]=customerArray[i];
			}
			customerArray=tempCustomerArray;
			return true;
		}
		return false;
	}
	public boolean remove(Customer customer){
		int index=search(customer);
		return remove(index);
	}
	public boolean contains(Customer customer){
		return search(customer)!=-1;
	}
	public int search(Customer customer){
		for (int i = 0; i < customerArray.length; i++){
			if(customerArray[i].equals(customer)){
				return i;
			}
		}
		return -1;
	}
	public boolean update(Customer customer){
		int index=search(customer);
		if(index!=-1){
			customerArray[index]=customer;
			return true;
		}
		return false;
	}
	public Customer[] toArray(){
		Customer[] tempCustomerArray=new Customer[customerArray.length];
		for (int i = 0; i < customerArray.length; i++){
			tempCustomerArray[i]=customerArray[i];
		}
		return tempCustomerArray;
	}
	public Customer get(int index){
		if(index>=0 && index<customerArray.length){
			return customerArray[index];
		}
		return null;
	}
	public int size(){
		return customerArray.length;
	}
	public Customer search(String id){
		for (int i = 0; i < customerArray.length; i++){
			if(id.equalsIgnoreCase(customerArray[i].getId())){
				return customerArray[i];
			}
		}
		return null;
		
	}
}
