package miniproject;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class StudentApp 
{
	static Scanner sc=new Scanner(System.in);

	ArrayList<Student> studentList=new ArrayList<Student>();
	public void viewAllStudentInfo()
	{   		
		System.out.println("==================================================================================================");

		if(studentList.size()==0)
		{
			System.out.println("No record found!!");
		}
		
		
		for(Student s:studentList)
		{
			
				System.out.println("Student Name:"+s.getStudentName()+"\t Class:"+s.getStudentClass()+"\t Address:"+s.getStudentAddress()+"\t Contact:"+s.getStudentContact());
			
		}
		System.out.println("==================================================================================================");

	}
	public void addStudentInfo() 
	{
		
		System.out.println("Enter student Id: ");
		int flag=0,studentId=sc.nextInt();
		for(Student s:studentList) {
			if(s.getStudentId()==studentId) {
				flag=1;
			}
		}
		if(flag==1) {
			System.out.println("StudentId already exists cannot add!!");
		}
		
		else {
		
		System.out.println("Enter student Name: ");
		String studentName=sc.next();
		System.out.println("Enter student Address: ");
		String studentAddress=sc.next();
		System.out.println("Enter student class: ");
		String studentClass=sc.next();
		System.out.println("Enter student Contact: ");
		long studentContact=sc.nextLong();
		
		Student s=new Student(studentId, studentName, studentAddress, studentClass, studentContact);
		
		studentList.add(s);
		}
	}
	public void viewStudentInfoById() 
	{
		System.out.println("Enter student id:");
		int studentId=sc.nextInt();//101
	    int flag=0;
		System.out.println("==================================================================================================");

		for(Student s:studentList)
		{
			if(studentId==s.getStudentId())//101==101
			{   flag=1;
				System.out.println("Student Name:"+s.getStudentName()+"\t Class:"+s.getStudentClass()+"\t Address:"+s.getStudentAddress()+"\t Contact:"+s.getStudentContact());
			}
		}
		
		if(flag==0)
			System.out.println("Student Id does not exist!!");
		System.out.println("==================================================================================================");
	
	}
	public void deleteAllStudentInfo()
	{
		System.out.println("==================================================================================================");

		if(studentList.size()>0)
		{
			studentList.clear();
			System.out.println("All records deleted successfully!!");
		}
		else
		{
			System.out.println("No record available!!");
		}
		System.out.println("==================================================================================================");

	}
	public void deleteStudentById() 
	{
		System.out.println("Enter student id :");
		int studentId=sc.nextInt();//101
		int index=0,flag=0;
		Student s=null;
		
		for(Student student:studentList)
		{
			if(studentId==student.getStudentId())//101
			{
				flag=1;
				index=studentList.indexOf(student);
				s=student;
				System.out.println(index);
				break;
			}
		}
		System.out.println("==================================================================================================");

		if(flag==0)
		{
			System.out.println("Student Id does not exist!!");
		}
		else
		{
			studentList.remove(s);
			System.out.println("Student record deleted successfully!!");
		}
		
		System.out.println("==================================================================================================");

	}
	public void updateStudentById()
	{
		System.out.println("Enter student id:");
		int studentId=sc.nextInt();
	    int flag=0,index = 0;
	    Student s=null;
	    for(Student student:studentList)
	    {
	    	if(student.getStudentId()==studentId)
	    	{
	    		flag=1;
	    		index=studentList.indexOf(student);
	    		s=student;
	    		break;
	    	}
	    }
	    
	    if(flag==1)
	    {
	    	System.out.println("Enter student Name: ");
			String studentName=sc.next();
			System.out.println("Enter student Address: ");
			String studentAddress=sc.next();
			System.out.println("Enter student class: ");
			String studentClass=sc.next();
			System.out.println("Enter student Contact: ");
			long studentContact=sc.nextLong();
			
			s.setStudentName(studentName);
			s.setStudentAddress(studentAddress);
			s.setStudentClass(studentClass);
			s.setStudentContact(studentContact);
			
			studentList.set(index,s);
			System.out.println("==================================================================================================");

			System.out.println("Student Details updated!!");
	    }
	    else
	    {
	    	System.out.println("Id does not exist!!");
	    }
		System.out.println("==================================================================================================");

	}
	
	public void writeToFile() throws IOException {
		System.out.println("Enter the location to store the file:");
		String location = sc.next();
		FileWriter fs = new FileWriter(location);
		fs.write("StudentId,StudentName,StudentAddress,StudenClass,StudentContact");
		for(Student s:studentList) {
			fs.write("\n"+s.getStudentId()+","+s.getStudentName()+","+s.getStudentAddress()+","+s.getStudentClass()+","+s.getStudentContact());
		}
		fs.close();
		
		System.out.println("File Written successfully!!!!!!!!");
	}
	
	public void readFromFile() throws IOException {
		System.out.println("Enter the locatioin of the CSV file to read from:");
		String location = sc.next();
		String line ="";
		studentList.clear();
		FileReader fs = new FileReader(location);
		BufferedReader b = new BufferedReader(fs);
		b.readLine();
		while((line=b.readLine())!=null) {
			String[] StuData = line.split(",");
			int id = Integer.parseInt(StuData[0]);
			String name = StuData[1];
			String Address = StuData[2];
			String Class = StuData[3];
			long Contact = Long.parseLong(StuData[4]);
			Student stu = new Student(id,name,Address,Class,Contact);
			studentList.add(stu);
			//System.out.println(StuData[0]);
		}
		b.close();
		
	}
	
	
	
	
	
	public static void main(String[] args) throws IOException {

		System.out.println("====================================================================");
		System.out.println("============= Student Management System =============================");
		System.out.println("====================================================================");
		String ch;
		StudentApp app=new StudentApp();
		do
		{
		
		System.out.println("\t\t 1)View Student Information\r\n"
				+ "\t\t 2)Insert student info by student id.\r\n"
				+ "\t\t 3)view all student information By Id.\r\n"
				+ "\t\t 4)Update student information by id.\r\n"
				+ "\t\t 5)delete student information by id.\r\n"
				+ "\t\t 6)delete all student information.\r\n"
				+ "\t\t 7)Write data into a csv file.\r\n"
				+ "\t\t 8)Read data from a csv file.");
		System.out.println("====================================================================");
		System.out.println("Enter your choice:");
		int choice=sc.nextInt();
		
		switch(choice)
		{
		
		case 1:	app.viewAllStudentInfo();
		break;
		case 2:	app.addStudentInfo();
		break;
		case 3:	app.viewStudentInfoById();
		break;
		case 4:	app.updateStudentById();
		break;
		case 5:	app.deleteAllStudentInfo();
		break;
		case 6: app.deleteStudentById();
		break;
		case 7: app.writeToFile();
		break;
		case 8: app.readFromFile();
		break;
	    default:System.out.println("Wrong choice!!"); 		   
		
	    
	    
		}
		
		System.out.println("Do you want to continue? (Y-Yes / N-No)");
		 ch=sc.next();
		}
		while(ch.equals("Y")||ch.equals("y"));
		System.out.println("====================================================================");

		System.out.println("Bye....");
	
		System.out.println("====================================================================");

		
		

	}

}