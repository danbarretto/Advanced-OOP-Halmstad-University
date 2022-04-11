import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Signal {
	private final int SAMPLING = 1000;
	
	private List<SignalObserver> observers = new ArrayList<SignalObserver>();

	public void addSignalObserver(SignalObserver so) {
		observers.add(so);
	}
	
	public Signal() {
		Timer t = new Timer(SAMPLING, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amplitude = Math.random() * 10;
				// notify all observers with amplitude
				for(SignalObserver o : observers)
					o.updateSignal(amplitude);
			}
		});
		t.start();
	}
	
}