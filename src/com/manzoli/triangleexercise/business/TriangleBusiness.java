package com.manzoli.triangleexercise.business;

import com.manzoli.trianglesexercise.enumerate.TriangleType;
import com.manzoli.trianglesexercise.model.Triangle;

/**
 * This class consists exclusively of static methods to validate the triangle Conditions.
 * For this example I don't want to validate floating point numbers or edges and vertices, 
 * it's only for basics conditions. 
 * 
 * @author Jose Luiz Manzoli
 *
 */
public class TriangleBusiness {
	
	/**
	 * General method to classify a triangle
	 * 
	 * @param triangle
	 * @return TriangleType
	 * @see Triangle
	 * @see TriangleType
	 */
	public static TriangleType classify(Triangle triangle){
		
		if (cantBeAnyTriangleType(triangle)){
			return TriangleType.INVALID;
		}
		
		if (isEquilateral(triangle)){
			return TriangleType.EQUILATERAL;
		}
		
		if (isScalene(triangle)){
			return TriangleType.SCALENE;
		}
		
		if (isIsosceles(triangle)){
			return TriangleType.ISOSCELES;
		}

		//if the triangle wasn't able to pass for any condition above, then it is an invalid triangle for sure
		return TriangleType.INVALID;
	}

	/**
	 * Inequality triangle validation
	 * An inequality triangle is a a triangle that the sum of the lengths of any two sides must be greater than or equal 
	 * to the length of the remaining side.
	 * 
	 * @param triangle
	 * @return true or false
	 * @see Triangle
	 */
	private static boolean cantBeAnyTriangleType(Triangle triangle) {
		
		boolean sideOneValidation = triangle.getSideOne() > triangle.getSideTwo() + triangle.getSideThree();
		boolean sideTwoValidation = triangle.getSideTwo() > triangle.getSideOne() + triangle.getSideThree();
		boolean sideThreeValidation = triangle.getSideThree() > triangle.getSideTwo() + triangle.getSideOne();
		
		return sideOneValidation || sideTwoValidation || sideThreeValidation;
	}
	
	/**
	 * Equilateral triangle validation
	 * An equilateral triangle is a triangle in which all three sides are equal.
	 * 
	 * @param triangle
	 * @return true or false
	 * @see Triangle
	 */
	private static boolean isEquilateral(Triangle triangle) {
		return triangle.getSideOne().equals(triangle.getSideTwo()) && triangle.getSideTwo().equals(triangle.getSideThree());
	}

	/**
	 * Scalene triangle validation
	 * A scalene triangle is a triangle that has three unequal sides
	 * 
	 * @param triangle
	 * @return true or false
	 * @see Triangle
	 */
	private static boolean isScalene(Triangle triangle) {
		
		boolean sideOneValidation = !triangle.getSideOne().equals(triangle.getSideTwo());
		boolean sideTwoValidation = !triangle.getSideTwo().equals(triangle.getSideThree());
		boolean sideThreeValidation = !triangle.getSideThree().equals(triangle.getSideOne());
		
		return sideOneValidation && sideTwoValidation && sideThreeValidation; 
	}
	
	/**
	 * Isosceles triangle validation
	 * An isosceles triangle is a triangle with (at least) two equal sides.
	 * 
	 * @param triangle
	 * @return true or false
	 * @see Triangle
	 */
	private static boolean isIsosceles(Triangle triangle) {
		
		boolean sideOneValidation = triangle.getSideOne().equals(triangle.getSideTwo());
		boolean sideTwoValidation = triangle.getSideTwo().equals(triangle.getSideThree());
		boolean sideThreeValidation = triangle.getSideThree().equals(triangle.getSideOne());
		
		return sideOneValidation || sideTwoValidation || sideThreeValidation;
	}
}
