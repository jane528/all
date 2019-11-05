public class Demo2Varible{
	public static void main(String args[]){
		int a;
		int b = 2;
		a = 3;
		System.out.println(a+b);
		
		Byte c=30;//-128-127
		System.out.println(c);
		
		short d = 33;
		System.out.println(d);
		
		long l = 30000000;
		System.out.println(l);
		
		float e = 33.3F;
		System.out.println(e);
		
		double f = 33.21;
		System.out.println(f);
		
		char g = 'A';
		System.out.println(g);
		
		boolean h = true;
		System.out.println(h);
		
		int num1 = 3;
		int num2;
		num2 = num1;
		num1 = 5;
		System.out.println("num1="+num1);
		System.out.println("num2="+num2);
	}
}