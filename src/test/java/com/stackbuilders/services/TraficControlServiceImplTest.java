/**
 * 
 */
package com.stackbuilders.services;

import org.junit.Test;

import com.stackbuilders.services.impl.TraficControlServiceImpl;

/**
 * @author gsimba
 *
 */
public class TraficControlServiceImplTest {

	@Test
	public void testPicoYPlacaPredictor() {
		TraficControlService t= new TraficControlServiceImpl();
		System.out.println(t.predictPicoPlaca("PBO6963", "16/08/2016", "19:01"));
	}

}
