public class DemoIf{
	public static void main(String args[]){
		int age = 19;
		if(age >= 18){
			System.out.println("come in");
		}
		System.out.println("�ؼҳԷ�");
		
		//�ж�һ����������������ż��
		int num1 = 666;
		if(num1 % 2 == 0){
			System.out.println("ż��");
		}else{
			System.out.println("����");
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