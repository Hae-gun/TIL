package newMarket.vo;

import java.util.Date;

public class Order_List {
	
	private int order_id;
	private String nsn;
	private String id;
	private Date date;
	private int amount;

	public Order_List() {

	}

	public Order_List(int order_id, String nsn, String id, Date date, int amount) {
		this.order_id = order_id;
		this.nsn = nsn;
		this.id = id;
		this.date = date;
		this.amount = amount;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getNsn() {
		return nsn;
	}

	public void setNsn(String nsn) {
		this.nsn = nsn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Order_List [order_id=" + order_id + ", nsn=" + nsn + ", id=" + id + ", date=" + date + ", amount="
				+ amount + "]";
	}

}
