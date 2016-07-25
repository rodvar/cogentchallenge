package com.rodvar.delivery;

import java.util.List;

import com.rodvar.delivery.order.OrderItem;

public interface BucketArrangementStrategy {

	BucketArrangement buildBucketArrangement(OrderItem orderItem,
			List<BucketPrice> priceList);
	
}
