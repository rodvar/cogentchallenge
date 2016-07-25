/**
 * 
 */
package com.rodvar.delivery;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author rodrigo
 * 
 */
public final class PriceList {

	public enum FLOWER_CODES {
		R12, L09, T58
	};

	public enum BUCKET_SIZES {
		THREE(3), FIVE(5), SIX(6), NINE(9), TEN(10);
		private int size;

		private BUCKET_SIZES(int size) {
			this.size = size;
		}

		public int get() {
			return this.size;
		}

	}

	private static boolean init = false;
	private Map<FLOWER_CODES, List<BucketPrice>> priceMap = new HashMap<FLOWER_CODES, List<BucketPrice>>();
	private static PriceList instance;

	public static PriceList getInstance() {
		if (instance == null)
			instance = new PriceList();
		return instance;
	}

	private PriceList() {
	}

	public List<BucketPrice> get(FLOWER_CODES code) {
		if (!this.init)
			this.init();
		return this.priceMap.get(code);
	}

	private void init() {
		List<BucketPrice> priceList = new LinkedList<BucketPrice>();
		priceList.add(new BucketPrice(FLOWER_CODES.R12, BUCKET_SIZES.TEN.get(),
				12.99f));
		priceList.add(new BucketPrice(FLOWER_CODES.R12,
				BUCKET_SIZES.FIVE.get(), 6.99f));
		this.priceMap.put(FLOWER_CODES.R12, priceList);

		priceList = new LinkedList<BucketPrice>();
		priceList.add(new BucketPrice(FLOWER_CODES.L09,
				BUCKET_SIZES.NINE.get(), 24.95f));
		priceList.add(new BucketPrice(FLOWER_CODES.L09, BUCKET_SIZES.SIX.get(),
				16.95f));
		priceList.add(new BucketPrice(FLOWER_CODES.L09, BUCKET_SIZES.THREE
				.get(), 9.95f));
		this.priceMap.put(FLOWER_CODES.L09, priceList);

		priceList = new LinkedList<BucketPrice>();
		priceList.add(new BucketPrice(FLOWER_CODES.T58,
				BUCKET_SIZES.NINE.get(), 16.99f));
		priceList.add(new BucketPrice(FLOWER_CODES.T58,
				BUCKET_SIZES.FIVE.get(), 9.95f));
		priceList.add(new BucketPrice(FLOWER_CODES.T58, BUCKET_SIZES.THREE
				.get(), 5.95f));
		this.priceMap.put(FLOWER_CODES.T58, priceList);

		this.init = true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
