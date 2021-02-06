package com.renato.biblioteca;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Long data = System.currentTimeMillis();
		Date dataExtenso = new Date(data);
		System.out.println(data);
		System.out.println(dataExtenso);
	}
	//1612543786299
	//1612543807595
	//1612543832729
}
