package bai2;
import java.util.*;

class employee{
	public int empId;
	public String name;
	public double salary;
	public void input() {
		Scanner as = new Scanner(System.in);
		System.out.print("Nhap ID nhan vien: ");
		empId = as.nextInt();
		as.nextLine();
		System.out.print("Nhap ten nhan vien: ");
		name = as.nextLine();
		System.out.print("Nhap luong nhan vien: ");
		salary = as.nextDouble();
	}
	public void output(){
		System.out.println("ID: "+empId+" | Ten nhan vien: "+name+" | Luong: "+salary);
	}
}
public class index {
	
	public static void input(employee nhanvien[]) {
		for (int i=0;i<nhanvien.length;i++) {
			System.out.println("Nhap thong tin nhan vien thu "+(i+1)+" : ");
			nhanvien[i]=new employee();
			nhanvien[i].input();
		}
	}
	public static void output(employee nhanvien[]) {
		for (int i=0;i<nhanvien.length;i++) nhanvien[i].output();
	}
	
	public static void sapxep(employee nhanvien[]) {
		for(int i=0;i<nhanvien.length;i++) {
			for(int j=i+1;j<nhanvien.length;j++) {
				if(nhanvien[i].salary<nhanvien[j].salary) {
					double t = nhanvien[i].salary;
					nhanvien[i].salary=nhanvien[j].salary;
					nhanvien[j].salary = t;
				}
			}
		}
		output(nhanvien);
	}
	public static void tong(employee nhanvien[]) {
		double tong=0;
		for (int i=0;i<nhanvien.length;i++) tong=tong+nhanvien[i].salary;
		System.out.println("Tong luong nhan vien: "+tong);
	}
	public static void min(employee nhanvien[]) {
		double min = nhanvien[0].salary;
		System.out.println("Nhan vien co luong thap nhat: ");
		for (int i=0;i<nhanvien.length;i++)
			if(nhanvien[i].salary<min)
				min=nhanvien[i].salary;
		for (int i=0;i<nhanvien.length;i++)
			if(nhanvien[i].salary==min)
				nhanvien[i].output();
	}
	public static void max(employee nhanvien[]) {
		double max = nhanvien[0].salary;
		System.out.println("Nhan vien co luong cao nhat: ");
		for (int i=0;i<nhanvien.length;i++)
			if(nhanvien[i].salary>max)
				max=nhanvien[i].salary;
		for (int i=0;i<nhanvien.length;i++)
			if(nhanvien[i].salary==max)
				nhanvien[i].output();
	}
	

	public static void main(String[] args) {
		employee nhanvien[] = new employee[3];
		input(nhanvien);
		output(nhanvien);
		sapxep(nhanvien);
		tong(nhanvien);
		min(nhanvien);
		max(nhanvien);
	}

}
