package javacore.innerclass;

/**内部类：是类之间的关系，不是对象的关系，内部类对象和外部类对象不是一一对应的
 * 静态内部类适用于只需要隐藏但是不需要引用外围类的情况，定义为static可以取消引用
 * 内部类可以有静态方法和静态域
 * @author Administrator
 *
 */
public class StaticInnerClassTest {
	public static void main(String[] args) {
		CompareClass.Pair pair = new CompareClass().getMinMax(new int[] {15,3,24,55,24,34});
		System.out.println("min:"+pair.min+", max:"+pair.max);
	}
}

class CompareClass {
	
	public Pair getMinMax(int[] values) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i:values) {
			if(i<min) min = i;
			if(i>max) max = i;
		}
		return new Pair(min, max);
	}
	
	static class Pair{
		int min;
		int max;
		public Pair(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}
}