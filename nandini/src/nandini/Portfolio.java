package nandini;

import java.util.List;

public class Portfolio {

	List<Stock> stocks;
	StockService service;
	public List<Stock> getStock() {
		return stocks;
	}
	public void setStock(List<Stock> stocks) {
		this.stocks = stocks;
	}
	public StockService getService() {
		return service;
	}
	public void setService(StockService service) {
		this.service = service;
	}
	
	public double getMarketValue() {
		double marketValue = 0.0 ;
		for(Stock stock : stocks){
			 marketValue += stock.quantity * service.getStockPrice(stock) ;

		}
		return marketValue;
		
	}
}
