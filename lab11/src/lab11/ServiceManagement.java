package lab11;

import java.util.ArrayList;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.InstantiationException;
import java.lang.IllegalAccessException;

public class ServiceManagement {
	public static <T extends Hub> int findIndexByNum(ArrayList<T> tList, int num) {
		for(int i=0; i<tList.size(); i++) {
			if(tList.get(i).getNumber() == num) {
				return i;
			}
		}
		return -1;
	}
	public static <T extends Hub> T raisePerBox(T t, double rate) {
		t.setPrice_per_box(t.getPrice_per_box() * rate);
		return t;
	}
	public static <T extends Hub> ArrayList<T> raiseAll(Class<T> c, ArrayList<T> tList, double rate){
		for(T elem:tList) {
			elem.setPrice_per_box(rate*elem.getPrice_per_box());
		}
		
		try {
			Field f = c.getField("init_price_per_box");
			double value = f.getDouble(null);
			f.setDouble(null,  value*rate);
		}catch(NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return tList;
	}
	public static <T extends Hub> void packageBoxes(String[] descriptions, Class<T> classtype, ArrayList<T> tList) {
		try {
			for(int i=0; i<descriptions.length; i++) {
				Constructor<T> constructor = classtype.getConstructor(String.class);
				T object = constructor.newInstance(descriptions[i]);
				tList.add(object);
			}
		}catch(NoSuchMethodException | InstantiationException | SecurityException | InvocationTargetException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	public static <T extends Hub, U extends Hub> void changeHub(
			ArrayList<T> tList, int index, Class<U> classtype, ArrayList<U> uList){
		try {
			T t = tList.get(index);
			Constructor<U> constructor = classtype.getConstructor(String.class);
			U object = constructor.newInstance(t.getDescription());
			tList.set(index, null);
			ServiceManagement.<U>raisePerBox(object, 0.9);
			uList.add(object);
		}catch(NoSuchMethodException | InstantiationException | SecurityException | InvocationTargetException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
