package javacore.innerclass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;
/**
 * �ֲ��ڲ���ֻ�ڷ����пɼ�
 * @author Administrator
 *
 */
public class InnerClassTest3 {
	
	public static void main(String[] args) {
		MyClock clock = new MyClock();
		clock.start(true);
 
		while(true) {}
	}
	

}

class MyClock{
	public void start(final boolean beep) {  //��α�������final ��1.8֮ǰ
		class TimerPrint implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(beep)
					System.out.println("time print:"+new Date());
			}
		}
		
		Timer timer = new Timer(1000,new TimerPrint());
		timer.start();
	}
}
