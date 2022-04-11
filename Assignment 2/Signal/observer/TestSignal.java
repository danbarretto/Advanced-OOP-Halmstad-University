public class TestSignal {

	public static void main(String[] args) {
		SignalWindow window = new SignalWindow();
		Signal s = new Signal();
		s.addSignalObserver(window);
		s.addSignalObserver(new SignalObserver() {
			@Override
			public void updateSignal(double value) {
				//System.out.format("Current value: %.3f\n", value);
				printStars((int)value);
			}
		});
	}

	private static void printStars(int num) {
		for(int i=0; i < num; i++)
			System.out.print("*");
		System.out.println();
	}
}
