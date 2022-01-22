package comento.financialITBootcamp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class stockDetailDto {
    private String code; // stock_price, stock_finance, stock_kospi, stock_kosdaq, stock_invest_caution, stock_invest_danger
    private String codeName; // stock_price, stock_kospi, stock_kosdaq, stock_invest_caution, stock_invest_danger
    private String price; // stock_price
    private String diffRate; // stock_price
    private String volume; // stock_price
    private String marketCap; // stock_finance
    private String capitalStock; // stock_finance
    private String PER; // stock_finance
    private String PBR; // stock_finacne
    private String ROE; // stock_finance
    private String isCaution; //stock_invest_caution
    private String isDanger; //stock_invest_danger
}
