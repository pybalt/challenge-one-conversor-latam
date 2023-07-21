package latam.one.challenge.conversor;
import latam.one.challenge.lib.*;

public class App {
	public static void main(String[] args) {
		ConversionRatios ratios = new ConversionRatios();
		System.out.println(
			ratios.convert(100, "ARS", "USD")
		);
	}
}
