package nandini;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class StockPortfolioTester {

	
	List<Stock> stocks = new ArrayList();
	
	@Test
	public void testPortFolio(){
		Stock stockHdfc = new Stock(1 , "HDFC" , 15);
		stocks.add(stockHdfc);
		Stock stockIcici = new Stock(2 , "ICICI" , 10);
		stocks.add(stockIcici);
		StockService stockService = mock(StockService.class);
		Portfolio portfolio = new Portfolio();
		portfolio.setStock(stocks);
		portfolio.setService(stockService);
		
		when(stockService.getStockPrice(stockHdfc)).thenReturn(100.00);
		when(stockService.getStockPrice(stockIcici)).thenReturn(200.00);
		
		// marketValueExpected = 15*100 + 10*200 = 3500
		double marketValue  = portfolio.getMarketValue();
		assertEquals(3700.00,marketValue , 100.00);
	
	}
	
	}
