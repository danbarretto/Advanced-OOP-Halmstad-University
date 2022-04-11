
import javax.swing.*;
import java.awt.event.*;

public class Signal {
	private final int SAMPLING = 1000;
	
	private Sampler sampler = new DefaultSampler();
	
	public void setTheSampler(Sampler s) {
		sampler = s;
	}
	
	public Signal(final JTextArea jta) {
		Timer t = new Timer(SAMPLING, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//double amplitude = Math.random() * 10;
				double amplitude = sampler.read();
				jta.append(""+String.format("%.6f", amplitude)+"\n");
				printStars((int)amplitude);
			}
		});
		t.start();
	}
	
	private static void printStars(int num) {
		for(int i=0; i < num; i++)
			System.out.print("*");
		System.out.println();
	}

	
}