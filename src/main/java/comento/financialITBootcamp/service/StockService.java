package comento.financialITBootcamp.service;

import comento.financialITBootcamp.dao.StockMapper;
import comento.financialITBootcamp.dto.stockDetailDto;
import comento.financialITBootcamp.dto.stockDto;
import comento.financialITBootcamp.dto.stockListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

	@Autowired
	StockMapper mapper;

	public stockDto getThemeName(String codeName) {
		stockDto data = mapper.getThemeName(codeName);
		return data;
	}

	public stockDto getMarketSum(String market) {
		stockDto data = mapper.getMarketCap(market);
		return data;
	}

	public stockDetailDto getCodeDetail(String market, String code) {
		stockDetailDto data = mapper.getCodeDetail(market, code);
		if(data.getIsCaution() == null) data.setIsCaution("false");
		else data.setIsCaution("true");

		if(data.getIsDanger() == null) data.setIsDanger("false");
		else data.setIsDanger("true");
		return data;
	}

	public List<stockListDto> getCode30(String market) {
		List<stockListDto> data = mapper.getCode30(market);

		return data;
	}

	public List<stockDetailDto> getCodeDetail30(String market) {
		List<stockDetailDto> data = mapper.getCodeDetail30(market);

		for (int i = 0; i<30; i++){
			if (data.get(i).getIsCaution() == null) data.get(i).setIsCaution("false");
			else data.get(i).setIsCaution("true");

			if (data.get(i).getIsDanger() == null) data.get(i).setIsDanger("false");
			else data.get(i).setIsDanger("true");
		}
		return data;
	}

	public stockDetailDto getMaxRoe() {
		stockDetailDto data = mapper.getMaxRoe();

		if(data.getIsCaution() == null) data.setIsCaution("false");
		else data.setIsCaution("true");

		if(data.getIsDanger() == null) data.setIsDanger("false");
		else data.setIsDanger("true");

		return data;
	}
}
