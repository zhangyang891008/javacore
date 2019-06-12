package javacore.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ReflectMethodTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Dog myDog = (Dog) Class.forName("javacore.reflect.Dog").newInstance();
		myDog.description();
		
		System.out.println(myDog.getClass().getClassLoader().toString());
		System.out.println("Class "+myDog.getClass().getSimpleName()+" extends "+myDog.getClass().getSuperclass());
		Method[] methods = myDog.getClass().getMethods();
		System.out.println("*************");
		printMethods(methods);
		System.out.println("*************");
		printFields(myDog.getClass().getDeclaredFields());
		System.out.println("*************");
		printMethods(myDog.getClass().getDeclaredMethods());
		System.out.println("*************");
		printConstructors(myDog.getClass().getDeclaredConstructors());
	}
 

	public static void printFields(Field[] fields) {
		//System.out.println(fields.length);
		for(Field f:fields) {
			StringBuilder stringBuilder = new StringBuilder();
			String modifier = Modifier.toString(f.getModifiers());
			stringBuilder.append(" "+modifier);
			String paraString = f.getType().getName();
			stringBuilder.append(" "+paraString);
			String para = f.getName();
			stringBuilder.append(" " +para+";");
			
			System.out.println(stringBuilder.toString());
		}
	}
	
	public static void printConstructors(Constructor[] constructors) {
		for(Constructor c:constructors) {
			StringBuilder stringBuilder = new StringBuilder();
			String modifier = Modifier.toString(c.getModifiers());
			stringBuilder.append(" "+modifier);
			String name = c.getName();
			stringBuilder.append(" "+name+"(");
			for (Parameter p:c.getParameters()) {
				String type = p.getType().getName();
				String para = p.getName();
				stringBuilder.append(type+" " +para+",");
			}
			if(c.getParameters().length>0) {
				stringBuilder.deleteCharAt(stringBuilder.length()-1);
			}
			stringBuilder.append(")");
			System.out.println(stringBuilder.toString());
		}
	}


	public static void printMethods(Method[] methods) {
		for(Method m: methods) {
			StringBuilder stringBuilder = new StringBuilder();
			String modifier = Modifier.toString(m.getModifiers());
			stringBuilder.append(" "+modifier);
			Class retType= m.getReturnType();
			stringBuilder.append(" "+retType.getName());
			String methodName = m.getName();
			stringBuilder.append(" "+methodName+"(");
			Parameter[] parameters = m.getParameters();
			for(Parameter p:parameters) {
				String paraString = p.getType().getName();
				String paraArg = p.getName(); 
				stringBuilder.append(paraString+" " +paraArg+",");
			}
			if(parameters.length>0) {
			   stringBuilder.deleteCharAt(stringBuilder.length()-1);
			}
			stringBuilder.append(");");
			System.out.println(stringBuilder.toString());
		}
	}
}
