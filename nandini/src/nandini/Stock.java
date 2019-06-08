package nandini;

public class Stock {

	int stockId ;
	String stockName ;
	int quantity ;
	
	
	public Stock(int stockId, String stockName, int quantity) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.quantity = quantity;
	}
	
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
