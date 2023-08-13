package io.spring.beans;

class Student{
	private String name;
	private String pnum;
	
	public Student(String name, String pnum) {
		super();
		this.name = name;
		this.pnum = pnum;
	}

	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	
	@Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + pnum;
    }

}
public class DTest {

	public static void main(String[] args) {
		Student s=new Student();
		s.setName("Hari");
		s.setPnum("9550034775");
		System.out.println(s.hashCode());
		System.out.println(s);
	
		Student s1=new Student();
		s1.setName("Madhu");
		s1.setPnum("9550000007");
		System.out.println(s1.hashCode());
		System.out.println(s1);
	}

}
