package dacn;
import java.util.*;
import java.io.*;

abstract class sinhvien{
	String ID;
	String name;
	String nganh;
	sinhvien(){
		this.ID = "";
		this.name = "";
		this.nganh = "";
	}
	abstract float diem();
	void input() {
		Scanner ad = new Scanner(System.in);
		System.out.print("Nhap ID: ");
		ID = ad.next();
		System.out.print("Nhap ten: ");
		ad.nextLine();
		name = ad.nextLine();
		System.out.print("Nhap nganh: ");
		ad.nextLine();
		nganh = ad.nextLine();
	}
	void output() {
		System.out.println("ID: "+this.ID+" | Ten sinh vien: "+this.name+" | Nganh: "+this.nganh+" | Tong diem: "+diem());
	}
	
}
class SinhvienKT extends sinhvien{
	float toanc;
	float sale;
	SinhvienKT(){
		this.toanc = 0;
		this.sale = 0;
	}
	void input() {
		super.input();
		Scanner ad = new Scanner(System.in);
		System.out.print("Nhap diem toan: ");
		toanc = ad.nextFloat();
		System.out.print("Nhap diem sale: ");
		sale = ad.nextFloat();
	}
	float diem() {
		return (float) (10*(sale + toanc));
	}
}
class SinhvienIT extends sinhvien{
	float toancc;
	float fc1;
	float ltcs;
	SinhvienIT(){
		this.toancc = 0;
		this.fc1 = 0;
		this.ltcs = 0;
	}
	void input() {
		super.input();
		Scanner ad = new Scanner(System.in);
		toancc = ad.nextFloat();
		fc1 = ad.nextFloat();
		ltcs = ad.nextFloat();
	}
	float diem() {
		return (float) 10 * ((toancc + fc1 + ltcs)/3);
	}
	
}
class data{
	sinhvien list[]= new sinhvien[100];
	char asd,l;
	int n=10;
	void input() throws IOException {
//		do {
		FileInputStream abc = new FileInputStream("C:\\Users\\hoang\\Desktop\\data.txt");
        Scanner lmao = new Scanner(abc,"UTF-8");
        String temp = lmao.nextLine(); //doc dong mang trong file
        lmao.close();
        String [] item = temp.split(" ");
		for(int i=0;i<item.length;i++) {
	        try {
	        	FileInputStream f = new FileInputStream("C:\\Users\\hoang\\Desktop\\data.txt");
	        	ObjectInputStream asd = new ObjectInputStream(f);
	        	list[i] = (sinhvien) asd.readObject(); 
	        	asd.close();
	        	f.close();
	        } catch (IOException io) {
	        	System.out.println("co loi xay ra!");
	        } catch (ClassNotFoundException ex) {
	        	System.out.println("khong tim thay class");
	        }
		}
//			System.out.print("Sinh vien IT/KT (n/s): ");
//			asd = (char) System.in.read();
//			if(asd == 'n' || asd == 'N')
//				list[n] = new SinhvienKT();
//			else 
//				list[n] = new SinhvienIT();
//			System.in.skip(asd);
//			list[n++].input();
//			System.out.print("Tiep tuc? (y/n): ");
//			l = (char) System.in.read();
//			System.in.skip(l);
//			if(l == 'n' || l == 'N' || n == 100)
//				break;
//		}while(true);
	}
	void output() throws IOException {
//		File f = new File("C:\\Users\\hoang\\Desktop\\data.txt");
//	     FileWriter fw = new FileWriter(f);
//	     for(int i=0;i<n;i++)
//	    	 fw.write(list[i]);
//	     fw.close();
//		for(int i=0;i<n;i++)
//			list[i].output();
		for(int i=0;i<n;i++) {
			try {
				FileOutputStream f = new FileOutputStream("C:\\Users\\hoang\\Desktop\\data.txt");
				ObjectOutputStream asd = new ObjectOutputStream(f);
				asd.writeObject(list[i]); 
				asd.close();
				f.close();
			} catch (IOException e) {
				System.out.println("Co loi xay ra!");
			}
		}

		
		
//		
//        try {
//            FileInputStream f = new FileInputStream("C:\\Users\\hoang\\Desktop\\data.txt");
//            ObjectInputStream asd = new ObjectInputStream(f);
//            a1 = (sinhvien) asd.readObject(); 
//            oIT.close();
//            f.close();
//        } catch (IOException io) {
//            System.out.println("co loi xay ra!");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("khong tim thay class");
//        }
  
    
		
	}
}


public class demo {

	public static void main(String[] args) throws IOException {
		data hs = new data();
		hs.input();
		hs.output();
	}

}
