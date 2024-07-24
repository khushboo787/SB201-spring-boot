package com.masai.com.ui;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

	static EntityManagerFactory emf = null;

	static {
		emf = Persistence.createEntityManagerFactory("masai");
	}

	public static void main(String[] args) {
		System.out.println("All Entity Classes Created.");
	}
}
