package latam.one.challenge.lib;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class ConversionRatios {
	private Map<String, Map<String, Object>> ratios = new HashMap<String, Map<String, Object>>();
	final String PATH = "src/conversion-rates-from-eur.json";
	public ConversionRatios() {
		try {
			String jsonString = new String(Files.readAllBytes(
					Paths.get(PATH)
					)
					);
			final JSONObject JSON = new JSONObject(jsonString);
			JSON.keySet().forEach(key -> this.ratios.put(key, JSON.getJSONObject(key).toMap()));
			System.out.println("JSON has been loaded.");
		}
		catch(IOException e){
			System.out.println(e);
			System.out.println("Error reading the file. Check if the file exists in */src/");
		}

	}
	/**
	 * This has the EUR as default currency
	 * From EUR to the desired currency
	 * @return double
	 */
	public BigDecimal getRatio(String to) {
		to = to.toLowerCase();
		return (BigDecimal) this.ratios.get(to).get("rate");
	}
	/**
	 * This has the EUR as default currency
	 * From the desired currency to EUR
	 * @return double
	 */
	public BigDecimal getInverseRatio(String to){
		return (BigDecimal) this.ratios.get(to).get("inverseRate");
	}
	/**
	 * This has the EUR as default currency
	 * From the desired currency to another currency, making three conversions
	 * @return double
	 */
	public BigDecimal getRatio(String from, String to) {
		from = from.toLowerCase();
		to = to.toLowerCase();
		BigDecimal rate = (BigDecimal) this.ratios.get(to).get("rate");
		BigDecimal inverseRate = (BigDecimal) ratios.get(from).get("inverseRate");
		return rate.multiply(inverseRate);
	}
	/**
	 * Convert a certain quantity <b>from</b> determined currency <b>to</b> another
	 * @param quantity
	 * @param from
	 * @param to
	 * @return BigDecimal
	 */
	public BigDecimal convert(Integer quantity, String from, String to) {
		BigDecimal bigDecimalQuantity = new BigDecimal(quantity);
		BigDecimal ratio = this.getRatio(from, to);
		return ratio.multiply(bigDecimalQuantity);
	}
}
