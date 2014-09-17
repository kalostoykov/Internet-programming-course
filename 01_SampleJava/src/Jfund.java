
public class Jfund {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int f = 3;
		String c = "c";
		String d = "d";
		Class1 c1 = new Class1(10);
		Class1 c2 = new Class1(18);
		
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(c.equals(c));
		System.out.println(c.equals(d));
		
		for(int i = 0; i < b; i++) {
			System.out.println(c);
		}
		
		if(a != 1) {
			System.out.println(c);
		} else {
			System.out.println(d);
		}
		
		System.out.println(c1.equals(c2));
		System.out.println(c1 == c2);
	}
}

class Class1 {
	public int age;
	
	public Class1(int x) {
		age = x;
	}
}