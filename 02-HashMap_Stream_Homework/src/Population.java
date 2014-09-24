import java.util.HashMap;
import java.util.Map;


public class Population {
	static Map<String, Integer> countryPopulation = new HashMap<String, Integer>();
	public static void main(String[] args) {
		CountryFilling();
		PrintCountrys();
	}

	private static void CountryFilling() {
		// TODO Auto-generated method stub
		countryPopulation.put("Bulgaria", 7245677);
		countryPopulation.put("Egypt", 82056378);
		countryPopulation.put("Romania", 21595302);
		countryPopulation.put("Poland", 37115000);
		countryPopulation.put("China", 1366910000);
		countryPopulation.put("Sweden", 9705005);
		countryPopulation.put("Cuba", 11167325);
	}
	
	private static void PrintCountrys() {
		for (Map.Entry<String, Integer> entry : countryPopulation.entrySet()) {
		    if(entry.getValue() > 10000000) {
		    	System.out.println(entry.getKey());
		    }
		}
	}
}
