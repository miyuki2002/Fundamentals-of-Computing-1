package midtest;
import java.util.*;
import java.io.*;

abstract class Employee{
	String ID;
	String name;
	float salary;
	Employee(){
		this.ID = "";
		this.name = "";
		this.salary = 0;
	}
	abstract float caculateSalary();
	void input() {
		Scanner ad = new Scanner(System.in);
		System.out.print("Nhap ID: ");
		ID = ad.next();
		System.out.print("Nhap ten: ");
		ad.nextLine();
		name = ad.nextLine();
		salary = caculateSalary();
	}
	void output() {
		System.out.println("ID: "+ID+" | Ten nhan vien: "+name+" | Luong: "+salary);
	}
	
}
class RegularEmployee extends Employee{
	float salaryGrading;
	float benefitGrading;
	RegularEmployee(){
		//salary = caculateSalary();
		this.salaryGrading = 0;
		this.benefitGrading = 0;
	}
	void input() {
		super.input();
		Scanner ad = new Scanner(System.in);
		System.out.print("Nhap luong: ");
		salaryGrading = ad.nextFloat();
		System.out.print("Nhap luong thuong: ");
		benefitGrading = ad.nextFloat();
	}
	float caculateSalary() {
		return (float) (10*(salaryGrading + benefitGrading));
	}
}
class ContractStaff extends Employee{
	float wage;
	float workday;
	float excessHoursGrading;
	ContractStaff(){
		this.wage = 0;
		this.workday = 0;
		this.excessHoursGrading = 0;
	}
	void input() {
		super.input();
		Scanner ad = new Scanner(System.in);
		wage = ad.nextFloat();
		workday = ad.nextFloat();
		excessHoursGrading = ad.nextFloat();
	}
	float caculateSalary() {
		return (float) wage* workday*(1+ excessHoursGrading);
	}
	
}
class EmployeeList{
	Employee list[]= new Employee[100];
	char asd,l;
	int n=0;
	void inputEmployee() throws IOException {
		do {
			System.out.print("Nhap nhan vien hoac staff (n/s): ");
			asd = (char) System.in.read();
			if(asd == 'n' || asd == 'N')
				list[n] = new RegularEmployee();
			else 
				list[n] = new ContractStaff();
			System.in.skip(asd);
			list[n++].input();
			System.out.print("Tiep tuc? (y/n): ");
			l = (char) System.in.read();
			System.in.skip(l);
			if(l == 'n' || l == 'N' || n == 100)
				break;
		}while(true);
	}
	void outputEmployee() {
		for(int i=0;i<n;i++)
			list[i].output();
	}
}


public class index {

	public static void main(String[] args) throws IOException {
		EmployeeList nhanvien = new EmployeeList();
		nhanvien.inputEmployee();
		nhanvien.outputEmployee();
	}

}
