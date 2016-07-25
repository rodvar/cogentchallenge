/**
 * 
 */
package com.rodvar;

import com.rodvar.delivery.FlowerDelivery;
import com.rodvar.delivery.FlowerDeliveryBuilder;
import com.rodvar.delivery.order.OrderItem;

/**
 * @author rodrigo
 * 
 */
public class CogentFlowerShop {

	public static void main(String[] args) {
		FlowerDelivery flowerDelivery = new CogentFlowerShop()
				.processOrder("10 R12\n15 L09\n13 T58");
		System.out.println(flowerDelivery.toString());
	}

	public FlowerDelivery processOrder(String inputOrder) {
		if (inputOrder == null || inputOrder.isEmpty())
			throw new IllegalArgumentException("wrong order");
		FlowerDeliveryBuilder builder = new FlowerDeliveryBuilder();
		String[] order;
		for (String orderItem : inputOrder.split("\n")) {
			try {
				order = orderItem.split(" ");
				builder.add(new OrderItem(Integer.valueOf(order[0]), order[1]));
			} catch (Exception e) {
				// do some error-case handling to recover in production
				e.printStackTrace();
			}
		}
		return builder.build();
	}
}
