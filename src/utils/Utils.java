/**
 * @author Vladimir Egorov
 *
 * Вспомогательный класс
 * 
 * Меняем местами объекты с индексами a и b
 */

package utils;

public class Utils {
	
	public static void swap(Object[] data, int a, int b){
        Object tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
	}
	
}
