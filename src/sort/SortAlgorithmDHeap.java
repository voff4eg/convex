/**
 * @author Vladimir Egorov
 *
 * Класс сортировки d-кучей
 * 
 */

package sort;

import utils.Utils;

public class SortAlgorithmDHeap {
	public static final SortAlgorithmDHeap SORT_ALGORITHM_2HEAP = new SortAlgorithmDHeap();

    @SuppressWarnings("rawtypes")
    private Comparable[] key = null;
    private Integer lenghtd = null;
  
    
    public SortAlgorithmDHeap() {
    	
    }
    
    public void sort(@SuppressWarnings("rawtypes") Comparable[] data) {
            key = data;
            sortDHeap();
    }

    /**
     * Сортирует массив key[] с помощью d-кучи
     */
    private void sortDHeap() {
            lenghtd = key.length - 1;
            createQueue();
            while (lenghtd >= 0) {
                    deleteMin();
            }
            
    };
    
    
    /**
     * Образуем очередь
     */
    private void createQueue() {
            for (int i = lenghtd; i >= 0; i--)
                    inbedding(i);
    };

    
    /**
     * Удаляем минимальный
     */
    private void deleteMin() {
    		Utils.swap(key, 0, lenghtd);
            if (--lenghtd >= 0){
                    inbedding(0);
            }
    };

    
    /**
     * Погружение
     * 
     * @param index
     */
    @SuppressWarnings("unchecked")
    private void inbedding(final int index)
    {
            int c = minChild(index);
            int i = index;
            // Знак сравнения изменен для сортировки непоубыванию
            while ((c != 0) && (key[c].compareTo(key[i]) > 0)) {
            		Utils.swap(key, i, c);
                    i = c;
                    c = minChild(c);
            }
    };

    
    /**
     * Последний потомок узла
     * 
     * @param index
     * @return
     */
    private int lastChild(final int index) {
            int k = firstChild(index);
            int f = k + 2 - 1;
            if (k == index)
                    return index;
            else if (f <= lenghtd)
                    return f;
            else
                    return lenghtd;
    };

    
    /**
     * Первый потомок узла
     * 
     * @param index
     * @return
     */
    private int firstChild(final int index) {
            int k = index * 2 + 1;
            if (k > lenghtd) {
                    return index;
            } else {
                    return k;
            }
    };

    
    /**
     * Позволяет находить непосредственного потомка узла с минимальным ключом
     * 
     * @param index
     * @return
     */
    @SuppressWarnings("unchecked")
    private int minChild(final int index) {
            int kf = firstChild(index);
            int kl;
            if (kf != 0){
                    kl = lastChild(index);
                    @SuppressWarnings("rawtypes")
                    Comparable min_key = key[kf];
                    int min_ch = kf;
                    for (int i = kf; i <= kl; i++){
                            // Знак сравнения изменен для сортировки непоубыванию
                            if (key[i].compareTo(min_key) > 0) {
                                    min_key = key[i];
                                    min_ch = i;
                            }
                    }
                    return min_ch;
            }
            return 0;
    };
    
    @Override
    public String toString(){
            return "Сортровка d кучей";
    }
    
}
