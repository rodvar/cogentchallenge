package com.rodvar.delivery;

import com.rodvar.delivery.PriceList.FLOWER_CODES;

public class BucketPrice {
	private static final float NO_PRICE = -1f;
	private FLOWER_CODES code;
	private int bucketSpace;
	private float price;

	public BucketPrice(FLOWER_CODES code, int bucketSpace) {
		this.code = code;
		this.bucketSpace = bucketSpace;
		this.price = NO_PRICE;
	}

	public BucketPrice(FLOWER_CODES code, int bucketSpace, float price) {
		this(code, bucketSpace);
		this.price = price;
	}

	public FLOWER_CODES getCode() {
		return code;
	}

	public int getBucketSpace() {
		return bucketSpace;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !this.getClass().equals(obj.getClass()))
			return false;
		if (this == obj)
			return true;
		BucketPrice price = (BucketPrice) obj;
		return (price.code.equals(this.code) && price.bucketSpace == this.bucketSpace);
	}

	@Override
	public int hashCode() {
		return this.code.hashCode() + this.bucketSpace;
	}

}
