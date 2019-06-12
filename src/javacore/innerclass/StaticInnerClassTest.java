package javacore.innerclass;

/**�ڲ��ࣺ����֮��Ĺ�ϵ�����Ƕ���Ĺ�ϵ���ڲ��������ⲿ�������һһ��Ӧ��
 * ��̬�ڲ���������ֻ��Ҫ���ص��ǲ���Ҫ������Χ������������Ϊstatic����ȡ������
 * �ڲ�������о�̬�����;�̬��
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