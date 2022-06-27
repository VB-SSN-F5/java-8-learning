package com.java.eight.pracs.defaultmethods;

public class TestDefault implements Inter1,Inter2{

	@Override
	public void m1() {
		Inter2.super.m1();
		Inter1.super.m1();
	}
	
	public static void main(String[] args) {
		TestDefault t = new TestDefault();
		t.m1();
	}

}
