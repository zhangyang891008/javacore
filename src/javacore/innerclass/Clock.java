package javacore.innerclass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

/**
 * �ڲ�����Է��ʸ������ڵ��������е��������ݣ�����������
 * �԰��е����������أ�����д�ص�����
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
