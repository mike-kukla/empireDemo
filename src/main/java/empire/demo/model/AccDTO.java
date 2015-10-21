package empire.demo.model;

import java.text.NumberFormat;

public class AccDTO {
	
	public AccDTO(Double accAvg, String state) {
		super();
		this.accAvg = accAvg;
		this.state = state;
	}
	public Double getAccAvg() {
		return accAvg;
	}
	public String getAccAvgFormatted() {
		return format.format(accAvg);
	}
	public String getState() {
		return state;
	}
	private final Double accAvg;
	private final String state;
    
	private NumberFormat format = NumberFormat.getCurrencyInstance();
}
