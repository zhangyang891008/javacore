package javacore.innerclass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

/**
 * 内部类可以访问该类所在的作用于中的所有数据，包括自有域，
 * 对包中的其他类隐藏；方便写回调函数
 * @author Administrator
 *
 */
public class Clock {
	int delay;
	boolean beep;
	public Clock(int delay, boolean beep) {
		this.delay = delay;
		this.beep = beep;
	}
	
	public void start() {
		TimePrinter listener = new TimePrinter(); 
		Timer timer = new Timer(delay, listener);
		timer.start();
	}
	
	public class TimePrinter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(beep) {
				System.out.println("printtime:"+new Date());
			}
		}
		
	}

}
