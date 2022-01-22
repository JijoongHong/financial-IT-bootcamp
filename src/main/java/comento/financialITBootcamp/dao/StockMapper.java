package comento.financialITBootcamp.dao;

import comento.financialITBootcamp.dto.stockDetailDto;
import comento.financialITBootcamp.dto.stockDto;
import comento.financialITBootcamp.dto.stockListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StockMapper {
	@Select("select code, thema_name themeName from stock_info " +
			"where code = (Select code from stock_kospi where code_name = #{codeName})")
	stockDto getThemeName(String codeName);

	@Select("select sum(market_cap) marketCap " +
			"from stock_finance f " +
			"inner join stock_${market} s " +
			"on f.code = s.code " +
			"where f.date = \"20210107\" " +
			"order by f.market_cap desc " +
			"limit 5")
	stockDto getMarketCap(String market);

	@Select("select s.code, s.code_name codeName " +
			"from stock_finance f, stock_${market} s " +
			"where f.code = s.code and f.date = \"20210107\" " +
			"order by f.market_cap desc limit 30")
	List<stockListDto> getCode30(String market);

	@Select("select s.code, s.code_name codeName, p.close price, p.d1_diff_rate diffRate, p.volume, f.market_cap marketCap, f.capital_stock capitalStock, f.PER, f.PBR, f.ROE, c.post_date isCaution, d.post_date isDanger " +
			"from stock_price p, stock_finance f, stock_${market} s left outer join stock_invest_caution c on c.code = s.code left outer join stock_invest_danger d on d.code = s.code " +
			"where s.code = #{code} and p.code = #{code} and f.code = #{code} and f.date = \"20210107\""
	)
	stockDetailDto getCodeDetail(String market, String code);

	@Select("select s.code, s.code_name codeName, p.close price, p.d1_diff_rate diffRate, p.volume, f.market_cap marketCap, f.capital_stock capitalStock, f.PER, f.PBR, f.ROE, c.post_date isCaution, d.post_date isDanger " +
			"from stock_price p, stock_finance f, stock_kosdaq s left outer join stock_invest_caution c on c.code = s.code left outer join stock_invest_danger d on d.code = s.code " +
			"where p.code = s.code and f.code = s.code and f.date = \"20210107\"" +
			"order by f.ROE desc limit 1"
	)
	stockDetailDto getMaxRoe();

	@Select("select s.code, s.code_name codeName, p.close price, p.d1_diff_rate diffRate, p.volume, f.market_cap marketCap, f.capital_stock capitalStock, f.PER, f.PBR, f.ROE, c.post_date isCaution, d.post_date isDanger " +
			"from stock_price p, stock_finance f, stock_${market} s left outer join stock_invest_caution c on c.code = s.code left outer join stock_invest_danger d on d.code = s.code " +
			"where p.code = s.code and f.code = s.code and f.date = \"20210107\" " +
			"order by f.market_cap desc limit 30")
	List<stockDetailDto> getCodeDetail30(String market);
}
