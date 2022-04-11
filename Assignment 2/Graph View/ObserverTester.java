import java.util.ArrayList;

/**
   A class for testing an implementation of the Observer pattern.
*/
public class ObserverTester
{
   /**
      Creates a DataModel and attaches barchart and textfield listeners
      @param args unused
   */
   public static void main(String[] args)
   {
      ArrayList<Double> data = new ArrayList<Double>();

      data.add(33.0d);
      data.add(44.0d);
      data.add(22.0d);
      data.add(22.0d);

      DataModel model = new DataModel(data);

      TextFrame frame = new TextFrame(model);

      BarFrame barFrame = new BarFrame(model);
      model.attach(barFrame);
      model.attach(frame);
   }
}
