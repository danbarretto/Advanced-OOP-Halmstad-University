package lecture10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if(args.length < 1) 
			return;
		String classToTest = args[0];
		System.out.println("We are going to find test methods in "+classToTest);
		
		Class<?> c = Class.forName(classToTest);
		
		Object o = c.getDeclaredConstructor().newInstance();
		
		System.out.println(o);
		
		for(Method m : c.getDeclaredMethods()) {
			Test t = m.getAnnotation(Test.class);
			if(t != null) {
				try {
					m.invoke(o);
				}catch(InvocationTargetException e) {
					Throwable cause = e.getCause();
					System.out.println(cause.getMessage());
				}
			}
		}
	}
	
	
}
