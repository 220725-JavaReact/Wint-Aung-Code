package com.revature.tests;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.junit.Test;

import com.revature.model.Inventory;
import com.revature.model.Product.PriceCategories;

@Retention(RUNTIME)
@Target(METHOD)
public @interface ProductTest {

	
}
