package javacore.innerclass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;
/**
 * 局部内部类只在方法中可见
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
	public void start(final boolean beep) {  //入参必须声明final 在1.8之前
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
