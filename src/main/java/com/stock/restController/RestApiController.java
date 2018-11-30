package com.stock.restController;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dao.StockIndex;
import com.stock.dao.StockWatchlist;
import com.stock.service.StockService;

import pl.zankowski.iextrading4j.api.stocks.Quote;

@RestController
@RequestMapping("stock")
public class RestApiController {
	
	@Autowired
	private StockService stockService;
	
 
		
	@GetMapping("getQuotes")
	public List<StockIndex> getQuotes() {
		System.out.println("hello-----------");
	return stockService.getQuotes();
	}
	
	@GetMapping("getQuote/{id}")
	public StockIndex getQuote(@PathVariable String id) {
		
		return stockService.getQuote(id);
		
	}
	
	@GetMapping("getQuoteDetails/{id}")
	public Quote getQuoteDetails(@PathVariable String id) {
		
		return stockService.getQuoteDetails(id);
		
	}
	
	//setting value in database for watchlist
	@GetMapping("createQuoteWatchlist/{id}")
	public List<com.stock.dao.StockWatchlist> createQuoteWatchlist(@PathVariable String id,Principal pri) {
		
		
		
		return stockService.createQuoteWatchlist(id,pri);
		
	}
	
	@GetMapping("deleteQuoteWatchlist/{id}")
	public List<StockWatchlist> deleteQuoteWatchlist(@PathVariable String id,Principal pri) {
		
		System.out.println("deleteQuoteWatchlist--------------------");
		
		return stockService.deleteQuoteWatchlist(id,pri);
		
	}
	
	//getting value from database for watchlist
	@GetMapping("getQuoteWatchlist")
	public List<com.stock.dao.StockWatchlist> getQuoteWatchlist(Principal pri) {
 
 
		return stockService.getQuoteWatchlist(pri);
	}
	
/* portfolio */
	
	//setting value in database for Portfolio
		@GetMapping("createQuotePortfolio/{id}/{quantity}/{date}/{pricePaid}")
		public List<com.stock.dao.StockPortfolio> createQuotePortfolio(@PathVariable String id, Principal pri,@PathVariable BigDecimal quantity,@PathVariable String date,@PathVariable BigDecimal pricePaid) {
			
			System.out.println(pricePaid);
			System.out.println(quantity);
			return stockService.createQuotePortfolio(id,pri,quantity,date,pricePaid);
			  
	 
		
		}
		@GetMapping("deleteQuotePortfolio/{id}")
		public List<com.stock.dao.StockPortfolio> deleteQuotePortfolio(@PathVariable String id,Principal pri) {
			
			System.out.println("deleteQuotePortfolio--------------------");
			
			return stockService.deleteQuotePortfolio(id,pri);
			
		}
		@GetMapping("getQuotePortfolio")
		public List<com.stock.dao.StockPortfolio> getQuotePortfolio(Principal pri) {
		
			System.out.println("getQuotePortfolio--------------------");
			
			return stockService.getQuotePortfolio(pri);
			
		}
		
		@GetMapping("getUserDetail")
		public List<com.stock.dao.User> userDetail(Principal pri){
			System.out.println("<<<<<<<>>>>>>>");
			return stockService.getUserDetails(pri);
		
		}
		
		@GetMapping ("isUserAuthenticated")
		public String answer(Principal pri) {
			if(pri !=(null)) {
				return"yes";

			}
			return "no";
		}
	
	
}
