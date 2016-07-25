package com.rodvar.delivery;

import com.rodvar.delivery.order.OrderItem;

/**
 * 
 * @author rodrigo
 * 
 */
public class FlowerDeliveryBuilder {

	private FlowerDelivery flowerDelivery;

	public FlowerDeliveryBuilder() {
		this.flowerDelivery = new FlowerDelivery();
	}

	public void add(OrderItem orderItem) {
		if (this.flowerDelivery == null)
			throw new IllegalStateException("Builder already used");
		this.flowerDelivery.process(orderItem);
	}

	public FlowerDelivery build() {
		FlowerDelivery delivery = this.flowerDelivery;
		this.flowerDelivery = null;
		return delivery;
	}

}
