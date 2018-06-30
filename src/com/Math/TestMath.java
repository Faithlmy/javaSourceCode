package com.Math;

import java.lang.Character.UnicodeBlock;

public class TestMath  {

	public static void main(String[] args)
	{
//		Math m = new Math();
//		System.out.println(Math.abs(Math.sin(30)));

		// my final and static
//		myStaticAndFinal fc = new myStaticAndFinal();
//		System.out.println(myStaticAndFinal.MyAll());
//		System.out.println(Math.class);
//		System.out.println(Boolean.compare(true, false));
//		char b = 't';
////		System.out.println(Character.hashCode(b));
//		
//		System.out.println(Character.BYTES);
//		
//		Character c  = new Character(b);
//		System.out.println(c.hashCode());
//		System.out.println(UnicodeBlock.ARROWS.toString());
		TestMath t = new TestMath();
		System.out.println(t.hashCode());
		
	}
    public final int hashCode() {
        return super.hashCode();
    }
}
