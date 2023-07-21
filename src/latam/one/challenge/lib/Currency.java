package latam.one.challenge.lib;

public class Currency implements ICurrency{
	private String name;
	private String country;
	Currency(String name, String country){
		this.name = name;
		this.country = country;
	}
	public String getName() {
		return this.name;
	}
	public String getCountry() {
		return this.country;
	}
	public Integer convert() {
		return 1;
	}
}