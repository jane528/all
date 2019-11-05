public class DemoIf{
	public static void main(String args[]){
		int age = 19;
		if(age >= 18){
			System.out.println("come in");
		}
		System.out.println("回家吃饭");
		
		//判断一个变量是奇数还是偶数
		int num1 = 666;
		if(num1 % 2 == 0){
			System.out.println("偶数");
		}else{
			System.out.println("奇数");
		}
		
		int x = 10;
		int y;
		if(x >= 3){
			y = 2 * x + 1;
		}else if(x > -1 && x < 3){
			y = 2 * x;
		}else{
			y = 2 * x -1;
		}
		System.out.println(y);
	}
	
}