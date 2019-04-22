package CreditCard.View;

import java.util.Arrays;
import java.util.List;

import Default.View.DefaultMainView;

public class CreditCardMainView extends DefaultMainView {
	
	public CreditCardMainView() {
		this.setTitle("Credit Card ");
		List<String> list = Arrays.asList("Name" , "CC Number" ,"Exp date" , "Type" , "Balance") ; 
		setJScrollPane(list);
	}
	

}
