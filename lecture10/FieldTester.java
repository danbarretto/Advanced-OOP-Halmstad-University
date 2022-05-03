package lecture10;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.swing.JFrame;

public class FieldTester {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		System.out.println(spyFields(new JFrame()));
	}
	
	public static String spyFields(Object o) throws IllegalArgumentException, IllegalAccessException {
		String result = "";
		for(Field f : o.getClass().getDeclaredFields()) {
			if(!Modifier.isStatic(f.getModifiers())) {
				f.setAccessible(true);
				result += f.getType()+" "+f.getName()+ " = "+f.get(o)+"\n";
			}
		}
		return result;
	}

}
