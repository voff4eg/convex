package utils;

public class Utils {
	
	public static void swap(Object[] data, int a, int b){
        Object tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
	}
	
}
