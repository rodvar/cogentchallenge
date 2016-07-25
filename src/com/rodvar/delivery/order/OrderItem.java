package com.rodvar.delivery.order;

/**
 * 
 * @author rodrigo
 * 
 */
public class OrderItem {
	private String code;
	private Integer qty;

	public OrderItem(Integer qty, String code) {
		if (code == null || code.isEmpty() || qty == null)
			throw new IllegalArgumentException("Invalid arguments");
		this.code = code;
		this.qty = qty;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !obj.getClass().equals(this))
			return false;
		if (this == obj)
			return true;
		return this.code.equals(((OrderItem) obj).code);
	}

	@Override
	public int hashCode() {
		return this.code.hashCode();
	}

	public String getCode() {
		return this.code;
	}

	public int getQuantity() {
		return this.qty;
	}
}
