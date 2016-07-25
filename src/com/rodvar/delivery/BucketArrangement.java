package com.rodvar.delivery;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import com.rodvar.delivery.PriceList.FLOWER_CODES;

/**
 * 
 * @author rodrigo
 * 
 */
public class BucketArrangement {

	private String code;
	private Map<BucketPrice, Integer> arrangementMap;
	private int total;
	private float totalPrice;
	private int totalBuckets;

	public BucketArrangement(String code, int total) {
		this.arrangementMap = new HashMap<BucketPrice, Integer>();
		this.totalPrice = 0.0f;
		this.totalBuckets = 0;
		this.code = code;
		this.total = total;
	}

	public void add(int howMany, BucketPrice bucketPrice) {
		if (howMany > 0) {
			this.arrangementMap.put(bucketPrice, Integer.valueOf(howMany));
			this.totalPrice += howMany * bucketPrice.getPrice();
			this.totalBuckets += howMany;
		}
	}

	public int bucketTotalQuantity() {
		return this.totalBuckets;
	}

	public int bucketTotalFlowersQuantity() {
		return this.total;
	}

	public float totalPrice() {
		return this.totalPrice;
	}

	public int bucketQuantity(int bucketSpace) {
		return this.arrangementMap.get(
				new BucketPrice(FLOWER_CODES.valueOf(this.code), bucketSpace))
				.intValue();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(this.total + " " + this.code + " $" + new DecimalFormat("#.##").format(this.totalPrice) + "\n");
		for (BucketPrice bucketPrice : this.arrangementMap.keySet()) {
			sb.append("\t" + this.arrangementMap.get(bucketPrice) + " x "
					+ bucketPrice.getBucketSpace() + " $"
					+ new DecimalFormat("#.##").format(bucketPrice.getPrice()) + "\n");
		}
		return sb.toString();
	}

}
