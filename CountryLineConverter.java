


	import java.util.ArrayList;
	import java.util.List;

	/**
	 * An implementation of LineConverter that converts Player objects
	 */
	public class CountryLineConverter implements LineConverter<Country> {

		@Override
		public String toLine(Country country) {
			return null;
			}

			//TODO convert object to String
			public List<Country> fromLines(List<String> lines) {
				List<Country> objects = new ArrayList<>();
				for (String line : lines) {
					objects.add(fromLine(line));
				}
				return objects;
			
			
			
		}

		@Override
		public Country fromLine(String line) {

			
			return new Country("", 0);
		}

	}






