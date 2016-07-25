/**
 * 
 */
package com.rodvar.delivery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rodvar.delivery.order.CustomerOrder;
import com.rodvar.delivery.order.OrderItem;

/**
 * A flower delivery is a set of buckets arranged by code
 * 
 * @author rodrigo
 * 
 */
public class FlowerDelivery {

	private CustomerOrder customerOrder = new CustomerOrder();
	private Map<String, BucketArrangement> bucketArrangements = new HashMap<String, BucketArrangement>();
	private BucketArrangementStrategy bucketArrangementStrategy = new MinShippingBucketArrangementStrategy();

	public BucketArrangement bucketArrangement(String code) {
		if (!this.bucketArrangements.containsKey(code))
			throw new IllegalArgumentException(
					"Code does not exists in this delivery");
		return this.bucketArrangements.get(code);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (String code : this.bucketArrangements.keySet())
			sb.append(this.bucketArrangements.get(code).toString() + "\n");
		return sb.toString();
	}

	/**
	 * Register the order and prepares the bucket
	 * 
	 * @param orderItem
	 */
	public void process(OrderItem orderItem) {
		if (this.customerOrder.contains(orderItem))
			throw new IllegalStateException(
					"Cannot process an order for an already ordered item");
		this.customerOrder.add(orderItem);
		this.buildBucketArrangement(
				orderItem,
				PriceList.getInstance().get(
						PriceList.FLOWER_CODES.valueOf(orderItem.getCode())));
	}

	private void buildBucketArrangement(OrderItem orderItem,
			List<BucketPrice> priceList) {
		this.bucketArrangements.put(orderItem.getCode(),
				this.bucketArrangementStrategy.buildBucketArrangement(
						orderItem, priceList));
	}
}
