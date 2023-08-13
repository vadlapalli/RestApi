package io.spring.lifecycle;

public class UserDao {
	
	
	public void init() {
		System.out.println("getting db connectionn...");
	}
	
	public void getdata() {
		System.out.println("get data from db..");
	}
	
	public void destroy() {
		System.out.println("close the db connection..");
	}

}
