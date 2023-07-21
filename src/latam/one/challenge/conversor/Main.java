package latam.one.challenge.conversor;
import latam.one.challenge.lib.*;

public class Main {

	public static void main(String[] args) {
		ConversionRatios ratios = new ConversionRatios();
		System.out.println(
			ratios.getRatio("AUD", "USD")
		);
	}
}
