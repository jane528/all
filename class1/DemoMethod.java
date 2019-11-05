/*
方法名称规则：小驼峰
 public static void 方法名称（参数类型 参数名）{
	 方法体
 }
 1.方法定义的先后顺序无所谓
 2.方法的定义不能产生嵌套包含关系，方法里面不能包含方法
 3.定义方法后不会执行，如果执行需要调用执行
 4.调用方法格式：方法名称（）;
*/
public class DemoMethod{
	public static void main(String args[]){
		farmer();
		seller();
		cook();
		me();
	}
	//我
	public static void me(){
		System.out.println("吃");
	}
	//厨师
	public static void cook(){
		System.out.println("洗菜");
		System.out.println("切菜");
		System.out.println("炒菜");
		System.out.println("装盘");
	}
	//小商贩
	public static void seller(){
		System.out.println("运输到农贸市场");
		System.out.println("抬高价格");
		System.out.println("吆喝");
		System.out.println("卖给厨子");
	}
	//农民
	public static void farmer(){
		System.out.println("播种");
		System.out.println("浇水");
		System.out.println("施肥");
		System.out.println("除虫");
		System.out.println("收割");
		System.out.println("卖给小商贩");
	}
	
	
}