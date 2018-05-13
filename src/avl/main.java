package avl;


import java.util.Iterator;

import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;

public class main {

	public static void main(String[] args) {
		// create treemap
		AvlTreeMap<String, Body> treeMap = new AvlTreeMap<>(new MyComparator());
		
		// add bodies to treemap
		// treeMap.insert("Kugel", new Sphere(3));
		// treeMap.insert("Zigarette", new Cylinder(0.3, 10));
		
		// print contents of treeMap
		double totalSurfaceArea = 0;
		Iterator<Body> iterator = treeMap.iterator();
		while(iterator.hasNext() == true) {
			Body body = iterator.next();
			totalSurfaceArea += body.getSurface();
		}

		System.out.println("Gesamtoberfläche aller Bodies in der TreeMap: " + totalSurfaceArea);
	}

}
