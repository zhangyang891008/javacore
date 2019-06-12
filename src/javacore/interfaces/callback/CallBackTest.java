package javacore.interfaces.callback;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

/**
 * 回调：指定某个特定事件发生时应该采取的动作。
 * @author Administrator
 *
 */
public class CallBackTest {

	public static void main(String[] args) {
		/**
		new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(System.currentTimeMillis()+",time:"+new Date());
				Toolkit.getDefaultToolkit().beep();
				
			}
		}).start();
		*/
		
		new Timer(1000, e->{System.out.println(new Date());}) .start();
		
		while(true) {
			
		}
	}
}
