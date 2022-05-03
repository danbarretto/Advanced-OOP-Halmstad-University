package lecture10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.IllegalSelectorException;

import javax.swing.JButton;
import javax.swing.JFrame;

@ClassPreamble(
		author = "John Doe",
		date = "2002-03-07",
		currentVersion = 6,
		lastModified = "2004-04-12",
		lastModifiedBy = "Jane Doe",
		reviewers = { "Alice", "Bill", "Cindy" }		
)
@ClassPreamble(
		author = "John Doe",
		date = "2002-03-07",
		currentVersion = 6,
		lastModified = "2004-04-12",
		lastModifiedBy = "Jane Doe",
		reviewers = { "Alice", "Bill", "Cindy" }		
)
public class MyClass {

	private int counter;
	
	/**
	 * 
	 * @return the current value of the counter
	 */
	public int getCounter() {
		return counter;
	}
	
	public void setCounter(int v) {
		counter = v;
	}
	
	public void incCounter() {
		counter++;
		if(counter < 0) throw new IllegalStateException("Counter is negative");
	}
	
	@Test
	public void testCounter() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//setCounter(Integer.MAX_VALUE);
		Field f = this.getClass().getDeclaredField("counter");
		f.setAccessible(true);
		f.set(this, Integer.MAX_VALUE);
		incCounter();
	}
	
	public static void main(String[] args) {
		Object o = new JButton();
		
		Class<?> clazz = o.getClass();
		
		for(Method m : clazz.getDeclaredMethods()) {
			// System.out.println(m.getName());
		}
		for(Annotation c : clazz.getAnnotations()) {
			System.out.println(c.annotationType().getName());
		}
		// System.out.println(clazz.getAnnotation(ClassPreamble.class));
		
	}
}
