package java8;



public class Comment {
	
	
	
	private  String  orderId;
	
	
	private  String   content;


	public Comment(String orderId, String content) {
		super();
		this.orderId = orderId;
		this.content = content;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	

}
