public class TestCombined {
    
    
    public static void main(String[] args) {
        SignalWindow window = new SignalWindow();
        Signal signal = new Signal();
        signal.setSampler(new SinusStrategy(0.0, 0.1));
        signal.addSignalObserver(window);
        SignalObserver so = new SignalObserver() {

            @Override
            public void updateSignal(double value) {
                printStars((int) value);
            }
            
        };
        signal.addSignalObserver(so);
    }

    private static void printStars(int num) {
        for (int i = 0; i < num; i++)
            System.out.print("*");
        System.out.println();
    }
}
