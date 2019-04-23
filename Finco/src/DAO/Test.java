package DAO;

import java.util.*;

import model.*;

public class Test {

	public static void main(String[] args) {
		
		Address add = new Address();
		add.setCity("company city");
		add.setState("company State");
		add.setStreet("company Street");
		add.setZipCode("company 12345");
		
		Address add2 = new Address();
		add2.setCity("person city");
		add2.setState("person State");
		add2.setStreet("person Street");
		add2.setZipCode("person 12345");
		
		ICompany c = new Company("company1", "Emain1", 10, add);
		ICompany c2 = new Company("company2", "Emain2", 10, add);
		
		IPerson p = new Person("person1", "Emain1", add2);
		
		IPerson p2 = new Person("person2", "Emain2", add2);
		
		IAccount a = new Account(c,"comp1 Acc # 1", 0);
		c.addAccount(a);
		IAccount a1 = new Account(c2,"comp2 Acc # 1", 0);
		c2.addAccount(a1);
		IAccount a2 = new Account(p,"pers1 Acc # 1", 0);
		p.addAccount(a2);
		IAccount a3 = new Account(p2,"c Acc # 1", 0);
		p2.addAccount(a3);
		IAccount a4 = new Account(c,"comp1 Acc # 2", 0);
		c.addAccount(a4);
		IAccount a5 = new Account(c2,"comp2 Acc # 2", 0);
		c2.addAccount(a4);
		IAccount a6 = new Account(p,"pers1 Acc # 2", 0);
		p.addAccount(a5);
		IAccount a7 = new Account(p2,"pers Acc # 2", 0);
		p2.addAccount(a7);
		
		
		SystemDAOmanager m = new SystemDAOmanager();
		
		List<ICompany> clist = new ArrayList<>();
		List<IPerson> plist = new ArrayList<>();
		clist.add(c);
		clist.add(c2);
		plist.add(p);
		plist.add(p2);
		
		
		m.addCompanies(clist);
		m.addPersons(plist);
		
		

	}

}
