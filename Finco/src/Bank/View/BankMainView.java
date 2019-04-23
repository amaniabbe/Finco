package Bank.View;

import java.util.Arrays;
import java.util.List;

import Default.View.DefaultMainView;

public class BankMainView extends DefaultMainView {
	
	public BankMainView() {
		this.setTitle("Bank View ");
		List<String> list = Arrays.asList("Street" , "City" ,"State" , "ZIP" , "P/CC" ,"Ch/S" , "Amount") ; 
		setJScrollPane(list);
	}
	

}
