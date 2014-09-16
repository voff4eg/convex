package convex;

import sort.SortAlgorithmDHeap;
import utils.Utils;

public class ConvexHull {
	private SortAlgorithmDHeap sortAlgorithm;

    public ConvexHull(SortAlgorithmDHeap sortAlgorithm) {
            super();
            this.sortAlgorithm = sortAlgorithm;
    }
    
    public int convex(Point[] a) {

            // ����� ������������������� ��������
            // � ���������� �����������
            Point c = a[0];
            int m = 0;
            for (int i = 1; i < a.length; i++) {
                    if (a[i].getX() < c.getX()) {
                            c = a[i];
                            m = i;
                    } else if (a[i].getX() > c.getX()) {
                            // �� ���������� ������������ ����� �� �������
                            // ���������/����������� (������ ��������)
                            continue;
                    }
                    if (a[i].getY() < c.getY()) {
                            c = a[i];
                            m = i;
                    }
            }
            Utils.swap(a, 0, m);
            m = 0;

            // ��������� ������ ������� ��������� � ����� c
            for (int i = 0; i < a.length; i++) {
                    a[i] = Point.minus(a[i], c);
            }

            // ������������������ ���������� � �������� ������� ���������
            sortAlgorithm.sort(a);

            // ����� ������� ��� � ���������
            for (int i = 1; i < a.length; i++) {
                    if (i != m) {
                            if (m >= 1) {
                                    while ((m >= 1)
                                                    && (Point.det(Point.minus(a[m], a[i]),
                                                                    Point.minus(a[m - 1], a[m])) >= 0)) {
                                            m--;
                                    }
                            }
                            m++;
                            Utils.swap(a, m, i);
                    }
            }

            // ��������������� ������ ���������� ������� ���������
            for (int i = 0; i < a.length; i++) {
                    a[i] = Point.plus(a[i], c);
            }

            // ��������� ������ ���������� �������� �������
            return m;

    }
    
    @Override
    public String toString(){
            return "���������� �������� �������� ��������� ��������� ����� ������� �������. " + sortAlgorithm.toString();
    }
}