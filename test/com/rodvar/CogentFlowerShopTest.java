package com.rodvar;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.rodvar.delivery.BucketArrangement;
import com.rodvar.delivery.FlowerDelivery;

public class CogentFlowerShopTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testSimpleOrder1() {
		FlowerDelivery flowerDelivery = new CogentFlowerShop()
				.processOrder("20 R12");
		BucketArrangement R12Arrangement = flowerDelivery
				.bucketArrangement("R12");
		
		Assert.assertEquals(20, R12Arrangement.bucketTotalFlowersQuantity());
		Assert.assertEquals(2, R12Arrangement.bucketTotalQuantity());
		Assert.assertEquals(2, R12Arrangement.bucketQuantity(10));
	}
	
	@Test
	public void testSimpleOrder2() {
		FlowerDelivery flowerDelivery = new CogentFlowerShop()
				.processOrder("25 R12");
		BucketArrangement R12Arrangement = flowerDelivery
				.bucketArrangement("R12");
		
		Assert.assertEquals(25, R12Arrangement.bucketTotalFlowersQuantity());
		Assert.assertEquals(3, R12Arrangement.bucketTotalQuantity());
		Assert.assertEquals(2, R12Arrangement.bucketQuantity(10));
		Assert.assertEquals(1, R12Arrangement.bucketQuantity(5));
	}

	@Test
	public void testExamOrderDelivery() {
		FlowerDelivery flowerDelivery = new CogentFlowerShop()
				.processOrder("10 R12\n15 L09\n13 T58");
		System.out.println(flowerDelivery.toString());
		BucketArrangement R12Arrangement = flowerDelivery
				.bucketArrangement("R12");
		BucketArrangement L09Arrangement = flowerDelivery
				.bucketArrangement("L09");
		BucketArrangement T58Arrangement = flowerDelivery
				.bucketArrangement("T58");

		Assert.assertEquals(10, R12Arrangement.bucketTotalFlowersQuantity());
		Assert.assertEquals(1, R12Arrangement.bucketTotalQuantity());
		Assert.assertEquals(1, R12Arrangement.bucketQuantity(10));

		Assert.assertEquals(15, L09Arrangement.bucketTotalFlowersQuantity());
		Assert.assertEquals(2, L09Arrangement.bucketTotalQuantity());
		Assert.assertEquals(1, L09Arrangement.bucketQuantity(9));
		Assert.assertEquals(1, L09Arrangement.bucketQuantity(6));

		Assert.assertEquals(13, T58Arrangement.bucketTotalFlowersQuantity());
		Assert.assertEquals(3, T58Arrangement.bucketTotalQuantity());
		Assert.assertEquals(2, T58Arrangement.bucketQuantity(5));
		Assert.assertEquals(1, T58Arrangement.bucketQuantity(3));
	}

}
