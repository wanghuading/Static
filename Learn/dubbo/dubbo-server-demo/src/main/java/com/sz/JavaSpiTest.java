package com.sz;

import java.sql.Driver;
import java.util.ServiceLoader;

public class JavaSpiTest {
	public static void main(String[] args) {
		ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
		for (Driver driver : serviceLoader) {
			System.out.println(driver.getMajorVersion());
		}
	}
}
