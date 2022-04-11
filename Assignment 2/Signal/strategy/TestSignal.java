

public class TestSignal {

	public static void main(String[] args) {
		SignalWindow window = new SignalWindow();
		Signal signal = new Signal(window.getTextArea());
		signal.setTheSampler(new SinusStrategy(0.0, 0.1));
		// replace the default strategy with the sinus
	}

}
