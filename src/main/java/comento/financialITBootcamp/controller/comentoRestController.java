package comento.financialITBootcamp.controller;

import java.util.List;

import comento.financialITBootcamp.dto.stockDetailDto;
import comento.financialITBootcamp.dto.stockDto;

import comento.financialITBootcamp.dto.stockListDto;
import comento.financialITBootcamp.response.defaultResponse;
import comento.financialITBootcamp.response.errorResponse;
import comento.financialITBootcamp.response.statusEnum;
import comento.financialITBootcamp.response.successResponse;
import comento.financialITBootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/stock")
public class comentoRestController {

	@Autowired
	StockService stockService;

	@RequestMapping(method = RequestMethod.GET, path = "/")
	public String sayHello() {
		return "Hello World!";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/theme", produces = "application/json")
	public ResponseEntity<? extends defaultResponse> getThemeName(@RequestParam String codeName) {
		if(codeName.length()==0){
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new errorResponse(statusEnum.BAD_REQUEST.getCodeNumber(), statusEnum.BAD_REQUEST.getCodeMessage()));
		}

		stockDto data = stockService.getThemeName(codeName);

		if(data==null){
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new errorResponse(statusEnum.NOT_FOUND.getCodeNumber(), statusEnum.NOT_FOUND.getCodeMessage()));
		}else{
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new successResponse<String>(statusEnum.OK.getCodeNumber(), statusEnum.OK.getCodeMessage(), data.getThemeName()));
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/sum", produces = "application/json")
	public ResponseEntity<? extends defaultResponse> getMarketSum(@RequestParam String market) {
		if(market.length()==0){
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new errorResponse(statusEnum.BAD_REQUEST.getCodeNumber(), statusEnum.BAD_REQUEST.getCodeMessage()));
		}

		stockDto data = stockService.getMarketSum(market);

		if(data==null){
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new errorResponse(statusEnum.NOT_FOUND.getCodeNumber(), statusEnum.NOT_FOUND.getCodeMessage()));
		}else{
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new successResponse<String>(statusEnum.OK.getCodeNumber(), statusEnum.OK.getCodeMessage(), data.getMarketCap()));
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/stockList", produces = "application/json")
	public ResponseEntity<? extends defaultResponse> getCode30(@RequestParam String market) {
		if(market.length() == 0){
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new errorResponse(statusEnum.BAD_REQUEST.getCodeNumber(), statusEnum.BAD_REQUEST.getCodeMessage()));
		}

		List<stockListDto> data = stockService.getCode30(market);

		if(data==null){
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new errorResponse(statusEnum.NOT_FOUND.getCodeNumber(), statusEnum.NOT_FOUND.getCodeMessage()));
		}else{
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new successResponse<List>(statusEnum.OK.getCodeNumber(), statusEnum.OK.getCodeMessage(), data));
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/stockListDetail", produces = "application/json")
	public ResponseEntity<? extends defaultResponse> getCodeDetail30(@RequestParam String market) {
		if(market.length() == 0){
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new errorResponse(statusEnum.BAD_REQUEST.getCodeNumber(), statusEnum.BAD_REQUEST.getCodeMessage()));
		}

		List<stockDetailDto> data = stockService.getCodeDetail30(market);

		if(data==null){
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new errorResponse(statusEnum.NOT_FOUND.getCodeNumber(), statusEnum.NOT_FOUND.getCodeMessage()));
		}else{
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new successResponse<List>(statusEnum.OK.getCodeNumber(), statusEnum.OK.getCodeMessage(), data));
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/stockInfo", produces = "application/json")
	public ResponseEntity<? extends defaultResponse> getCodeDetail(@RequestParam String code, String market) {
		if(market.length() == 0 || code.length() == 0){
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new errorResponse(statusEnum.BAD_REQUEST.getCodeNumber(), statusEnum.BAD_REQUEST.getCodeMessage()));
		}

		stockDetailDto data = stockService.getCodeDetail(market, code);

		if(data==null){
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new errorResponse(statusEnum.NOT_FOUND.getCodeNumber(), statusEnum.NOT_FOUND.getCodeMessage()));
		}else{
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new successResponse<stockDetailDto>(statusEnum.OK.getCodeNumber(), statusEnum.OK.getCodeMessage(), data));
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/maxRoe", produces = "application/json")
	public ResponseEntity<? extends defaultResponse> getMaxRoe() {

		stockDetailDto data = stockService.getMaxRoe();

		if(data==null){
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new errorResponse(statusEnum.NOT_FOUND.getCodeNumber(), statusEnum.NOT_FOUND.getCodeMessage()));
		}else{
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new successResponse<stockDetailDto>(statusEnum.OK.getCodeNumber(), statusEnum.OK.getCodeMessage(), data));
		}
	}
}
