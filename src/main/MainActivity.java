/**
 * @author Vladimir Egorov
 *
 */

package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sort.SortAlgorithmDHeap;
import convex.ConvexHull;
import convex.Point;

public class MainActivity {
	
	/**
     * @param args
     */
    public static void main(String[] args) {
            BufferedReader reader = null;
            try {
                    reader = new BufferedReader(new InputStreamReader(System.in));
                    start();
            } catch (NumberFormatException e) {
                    System.err.println("Неверный формат. Вводите валидные значения! " + e.getLocalizedMessage() );
                    e.printStackTrace();
            } catch (IOException e) {
                    System.err.println("Ошибка ввод/вывода! " + e.getLocalizedMessage() );
                    e.printStackTrace();
            } catch (Exception e) {
                    System.err.println("Неизвестная ошибка! " + e.getLocalizedMessage());
                    e.printStackTrace();
            } finally {
                    try {
                            reader.readLine();
                    } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                    }
            }
    }
    
    public static void start() throws IOException{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Нахождение выпуклой оболочки конечного множества точек метогом Грэхема");
            ConvexHull convexHull = null;
            convexHull = new ConvexHull(new SortAlgorithmDHeap());
            System.out.println("Введите количество точек: ");
            int n = Integer.valueOf(reader.readLine());
            List<Point> points = new ArrayList<Point>();
            for (int i = 0; i < n; i++) {
                System.out.println("Введите координаты точки " + i + " :");
                System.out.print("x: ");
                Float x = Float.valueOf(reader.readLine());
                System.out.print("y: ");
                Float y = Float.valueOf(reader.readLine());
                points.add(new Point(x,y));
            }
            Point[] ps = (Point[]) points.toArray(new Point[]{});
            int m = convexHull.convex(ps);
            printResult(Arrays.asList(Arrays.copyOf(ps, m + 1)),points);
            //System.out.println("Точки на границе: " + Arrays.asList(Arrays.copyOf(ps, m + 1)));
    }
    
    public static void printResult(List<Point> Res,List<Point> points){
        int ResSize = Res.size();
        System.out.print("[");
        if(ResSize > 0){
        	for(int i=0; i<= ResSize - 1; i++ ){
            	System.out.print(points.indexOf(Res.get(i))+1);
            	if((i+1) != ResSize){
            		System.out.print(", ");
            	}
            }
        }
        System.out.print("]");
    }
}
