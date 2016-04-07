package com.manzoli.triangleexercise.business;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import com.manzoli.trianglesexercise.enumerate.TriangleType;
import com.manzoli.trianglesexercise.model.Triangle;

/**
 * This class consists exclusively to test the TriangleBusiness class. 
 * 
 * @author Jose Luiz Manzoli
 *
 */
public class TriangleBusinessTest {

	@Test
	public void shouldBeAnInvalidTriangle(){
		Triangle triangle = new Triangle(1,3,5);
		assertTrue(TriangleType.INVALID.equals(TriangleBusiness.classify(triangle)));
		
		triangle = new Triangle(-2,-2,-2);
		assertTrue(TriangleType.INVALID.equals(TriangleBusiness.classify(triangle)));
	}
	
	@Test
	public void shouldBeAnEquilateralTriangle(){
		Triangle triangle = new Triangle(2,2,2);
		assertTrue(TriangleType.EQUILATERAL.equals(TriangleBusiness.classify(triangle)));
	}
	
	@Test
	public void shouldBeAnIsoscelesTriangle(){
		Triangle triangle = new Triangle(3,4,5);
		assertTrue(TriangleType.ISOSCELES.equals(TriangleBusiness.classify(triangle)));
	}
	
	@Test
	public void shouldBeAScaleneTriangle(){
		Triangle triangle = new Triangle(2,2,3);
		assertTrue(TriangleType.SCALENE.equals(TriangleBusiness.classify(triangle)));
	}
}
