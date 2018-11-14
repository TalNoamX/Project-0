package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import myMath.Monom;
import myMath.Polynom;

class Junit_Testing_Polynom {

	@Test
	public void polynomTest() {
		Monom m0 = new Monom(6,1);
		Monom m1 = new Monom(5.4,2);
		Monom m2 = new Monom(3.6,4);
		double arr[] = {6,5.4,3.6};
		int arr2[] = {1,2,4};
		
		Polynom p1 = new Polynom();
		p1.add(m0); p1.add(m1); p1.add(m2);
		Iterator<Monom> it = p1.iteretor();
		int i = 0;
		while(it.hasNext()) {
			assertEquals(arr[i],it.next().get_coefficient());
			i++;
		}
		i = 0;
		while(it.hasNext()) {
			assertEquals(arr2[i],it.next().get_power());
			i++;
		}
	}
	@Test
	public void StringTest() {
		Polynom p1 = new Polynom("5x^1");
		Monom m = new Monom(5,1);
		Polynom p2 = new Polynom();
		p2.add(m);
		if(!p1.equals(p2)) {
			fail("fail: Someting is wrong with the String consrtuctor");
		}
	}
	@Test
	public void CopyTest() {
		Polynom p1 = new Polynom("5x^3+8x^2+5x^1+7");
		Polynom p2 = new Polynom(p1);
		if(!p1.equals(p2)) {
			fail("fail: something is wrong with the copy constructor");
		}
	}
	@Test
	public void MultiplyTest(){
		Polynom p1 = new Polynom ("1*x^1+1");
		Polynom p2 = new Polynom ("1*x^2+2*x^1+1");
		p1.multiply(p1);
		assertTrue(p1.equals(p2));
	}
	@Test
	public void AddMonomTest() {
		Monom m = new Monom(2,2);
		Polynom p = new Polynom("2*x^2+2*x^4");
		Polynom p1 = new Polynom("4*x^2+2*x^4");
		p.add(m);
		assertTrue(p.equals(p1));
	}
	@Test
	public void addPolynomTest() {
		Polynom p1 = new Polynom("2*x^1+3*x^3");
		Polynom p2 = new Polynom("2*x^1+3*x^3");
		Polynom pEqual = new Polynom("4*x^1+6*x^3");
		p1.add(p2);
		if(!p1.equals(pEqual))
			fail("fail: something is wrong with the add Polynom function.");
	}
	@Test 
	public void fTest() {
		double x = 4;
		double outCome = 36;
		Polynom p = new Polynom("1*x^1+2*x^2");
		assertEquals(outCome,p.f(x));
	}
	@Test 
	public void substractTest() {
		Monom m1 = new Monom(2,1);
		Polynom p1 = new Polynom();
		p1.add(m1);
		Polynom p2 = new Polynom("2*x^1+3*x^3");
		Polynom pEqual = new Polynom("3*x^3");
		p2.substract(p1);
		assertTrue(p2.equals(pEqual));
	}
}
