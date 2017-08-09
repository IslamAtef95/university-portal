/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Teacher  {
		
		String salary;
		 
		String T_name;
		 
		String T_id;
		String email;
		String Mobnum;
		String Subject1;
		String Subject2;
		String Subject3;
	

		public String getSalary() {
			return salary;
		}

		public void setSalary(String salary) {
			this.salary = salary;
		}

		 

		public String getT_name() {
			return T_name;
		}

		public void setT_name(String t_name) {
			T_name = t_name;
		}

		 

		public String getT_id() {
			return T_id;
		}

		public void setT_id(String t_id) {
			T_id = t_id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMobnum() {
			return Mobnum;
		}

		public void setMobnum(String mobnum) {
			Mobnum = mobnum;
		}

		public String getSubject1() {
			return Subject1;
		}

		public void setSubject1(String subject1) {
			Subject1 = subject1;
		}

		public String getSubject2() {
			return Subject2;
		}

		public void setSubject2(String subject2) {
			Subject2 = subject2;
		}

		public String getSubject3() {
			return Subject3;
		}

		public void setSubject3(String subject3) {
			Subject3 = subject3;
		}


		public Teacher() //default 
		{
			salary="";
			
			T_name="";
			 
			T_id="";
			email="";
			Mobnum="";
			Subject1="";
			Subject2="";
			Subject3="";
		}

		  
                 
                 public void ADD_T(String filename,Teacher nn)throws Exception{
                     try{
                         BufferedWriter out=new BufferedWriter(new FileWriter(filename));  
                       
                         
                         out.write(nn.T_name);
                         out.newLine();
                         out.write(nn.T_id);
                         out.newLine();
                         out.write(nn.email);
                         out.newLine();
                         out.write(nn.Mobnum);
                         out.newLine();
                         out.write(nn.salary);
                         out.newLine();
                         out.write(nn.Subject1);
                         out.newLine();
                         out.write(nn.Subject2);
                         out.newLine();
                         out.write(nn.Subject3);
                         out.newLine();
                                                 
                         out.close();
                 }catch(Exception e)
                 {
                     throw new Exception("Error file location"+e.getMessage());
                 }



}
                 
                 
        
}
