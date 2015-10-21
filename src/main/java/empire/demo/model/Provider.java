package empire.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	protected String definition;
	protected Integer providerId;
	protected String providerName;
	protected String providerStreet;
	protected String providerCity;	
	protected String providerState;	
	protected Integer providerZip;
	protected String hrrDescription;	
	protected Integer totDischarges;	
	protected Double avgCoveredCharges;	
	protected Double avgTotPayments;
	protected Double avgMedicarePayments;
	
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getProviderStreet() {
		return providerStreet;
	}
	public void setProviderStreet(String providerStreet) {
		this.providerStreet = providerStreet;
	}
	public String getProviderCity() {
		return providerCity;
	}
	public void setProviderCity(String providerCity) {
		this.providerCity = providerCity;
	}
	public String getProviderState() {
		return providerState;
	}
	public void setProviderState(String providerState) {
		this.providerState = providerState;
	}
	public Integer getProviderZip() {
		return providerZip;
	}
	public void setProviderZip(Integer providerZip) {
		this.providerZip = providerZip;
	}
	public String getHrrDescription() {
		return hrrDescription;
	}
	public void setHrrDescription(String hrrDescription) {
		this.hrrDescription = hrrDescription;
	}
	public Integer getTotDischarges() {
		return totDischarges;
	}
	public void setTotDischarges(Integer totDischarges) {
		this.totDischarges = totDischarges;
	}
	public Double getAvgCoveredCharges() {
		return avgCoveredCharges;
	}
	public void setAvgCoveredCharges(Double avgCoveredCharges) {
		this.avgCoveredCharges = avgCoveredCharges;
	}
	public Double getAvgTotPayments() {
		return avgTotPayments;
	}
	public void setAvgTotPayments(Double avgTotPayments) {
		this.avgTotPayments = avgTotPayments;
	}
	public Double getAvgMedicarePayments() {
		return avgMedicarePayments;
	}
	public void setAvgMedicarePayments(Double avgMedicarePayments) {
		this.avgMedicarePayments = avgMedicarePayments;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Object toSqlInsert() {
		
		return String.format("INSERT INTO provider \n"
				+ "(definition,providerId,providerName,providerStreet,providerCity,providerState," 
				+ "providerZip,hrrDescription,totDischarges,avgCoveredCharges,avgTotPayments,"
				+ "avgMedicarePayments)\n"
				+ "VALUES\n"
				+ "('%s',%d,'%s','%s','%s','%s',%d,'%s',%d,%f,%f,%f);", 
				getDefinition(), getProviderId(),getProviderName(),getProviderStreet(),
				getProviderCity(),getProviderState(), getProviderZip(), getHrrDescription(), 
				getTotDischarges(),	getAvgCoveredCharges(),getAvgTotPayments(),getAvgMedicarePayments());
	}

}
