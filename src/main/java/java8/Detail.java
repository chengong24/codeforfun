package java8;

public class Detail {
	
	private  String  orderId;

	private Order order;

	private Comment comment;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Detail [orderId=" + orderId + ", order=" + order + ", comment=" + comment + "]";
	}

}
