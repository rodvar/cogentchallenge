package com.rodvar.delivery;

import java.util.List;

import com.rodvar.delivery.order.OrderItem;

public class MinShippingBucketArrangementStrategy implements
		BucketArrangementStrategy {

	@Override
	public BucketArrangement buildBucketArrangement(OrderItem orderItem,
			List<BucketPrice> priceList) {
		BucketArrangement arrangement;
		int flowersToArrange;
		int index = 0;
		do {
			arrangement = new BucketArrangement(orderItem.getCode(),
					orderItem.getQuantity());
			flowersToArrange = this.arrange(arrangement, index++, orderItem,
					priceList);
		} while (flowersToArrange > 0 && index < priceList.size());
		return arrangement;
	}

	private int arrange(BucketArrangement arrangement, int listIndex,
			OrderItem orderItem, List<BucketPrice> priceList) {
		BucketPrice bucketPrice;
		int flowersToArrange = orderItem.getQuantity();
		while (flowersToArrange > 0 && listIndex < priceList.size()) {
			bucketPrice = priceList.get(listIndex);
			arrangement.add(flowersToArrange / bucketPrice.getBucketSpace(),
					bucketPrice);
			flowersToArrange = flowersToArrange % bucketPrice.getBucketSpace();
			listIndex++;
		}
		return flowersToArrange;
	}

}
