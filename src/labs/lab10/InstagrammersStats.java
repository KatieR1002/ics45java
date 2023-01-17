package labs.lab10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A class for performing various analyses on a set of Instagrammers data
 *
 */
public class InstagrammersStats {
	
	/**
	 * Given a Stream of Instagrammers and a country, return the top Instagrammer
	 * (by rank) in the given country. If there are no Instagrammers in that country,
	 * return an empty Optional<Instagrammer>
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	country			country to search for
	 * 
	 * @return	top Instagrammer in country, or empty Optional, if none in country
	 */
	public static Optional<Instagrammer> problem1_getTopIGerInCountry(Stream<Instagrammer> instagrammers,
			String country) {
		Optional<Instagrammer> result=instagrammers.filter(p->p.getCountry().equals(country)).sorted((a,b)->a.getRank()-b.getRank()).findFirst();
		return result;
	}
	
	
	/**
	 * Given a Stream of Instagrammers and a category, return a List containing the 
	 * Instagrammer(s) in that category with the most followers. The list should only 
	 * contain multiple Instagrammers if there are multiple Instagrammers who have the 
	 * most followers. The order of the list should follow the order in which those 
	 * Instagrammers appear in the stream.
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	category		category to search for
	 * 
	 * @return	List containing top Instagrammer(s) in category
	 */
	public static List<Instagrammer> problem2_getMostFollowedIGerInCategory(Stream<Instagrammer> instagrammers,
			String category) {
		List<Instagrammer> result=instagrammers.filter(p->p.getCategory().equals(category)).sorted((a,b)->(int)(b.getNumFollowers()-a.getNumFollowers())).collect(Collectors.toList());
		if(result.isEmpty()) {
			return result;
		}
		long highestNum=result.get(0).getNumFollowers();
		result=result.stream().filter(p->p.getNumFollowers()==highestNum).collect(Collectors.toList());
		return result;
	}
	
	
	/**
	 * Given a Stream of Instagrammers, return a String that contains the names of all countries
	 * represented by the Instagrammers, ordered lexicographically, each name separated by ", ".
	 * Do not include blank country names.
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * 
	 * @return	a String containing the names of all countries represented in the stream, each name
	 * separated by ", "
	 */
	public static String problem3_getAllCountries(Stream<Instagrammer> instagrammers) {
		Set<String> countrySet = instagrammers.map(p -> p.getCountry()).collect(Collectors.toSet());
		ArrayList<String> contries = new ArrayList<>();
		contries.addAll(countrySet);
		Collections.sort(contries);
		contries.remove("");
		String result= String.join(", ", contries);
		return result;
	}
	
	
	/**
	 * Given a Stream of Instagrammers and a category String, return the number of Instagrammers in
	 * a category that contains the given category String (case-insensitive).
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	category		category search string
	 * 
	 * @return	number of Instagrammers in a category that contains the given category String (case-insensitive)
	 */
	public static long problem4_countIGersInCategory(Stream<Instagrammer> instagrammers, String category) {
		long number = instagrammers.filter(p -> p.getCategory().toLowerCase().contains(category.toLowerCase())).count();
		return number;
	}
	
	
	/**
	 * Given a Stream of Instragrammers, return a Map<String, Double> that maps each country to
	 * the average Instagrammer rank in that country
	 * 
	 * This map should be sorted lexicographically by country name.
	 * 
	 * If the stream is empty, return an empty map.
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * 
	 * @return	a mapping of country to average Instagrammer rank in that country
	 */
	public static Map<String, Double> problem5_getAvgRankPerCountry(Stream<Instagrammer> instagrammers) {
		Map<String, Double> result = new HashMap<>();
		Map<String, Integer> countOfContry = new HashMap<>();

		instagrammers.forEach(p -> {
			String country = p.getCountry();
			int rank = p.getRank();
			if (result.containsKey(country)) {
				result.put(country, result.get(country)+rank);
				countOfContry.put(country, countOfContry.get(country)+1);
			} else {
				result.put(country, (double) rank);
				countOfContry.put(country, 1);
			}
		});
		
		result.forEach((country, rank) -> {
			result.put(country, result.get(country)/countOfContry.get(country));
		});

		return result;

	}
	
	
	/**
	 * Given a Stream of Instagrammers, return a list of all categories, ordered from most
	 * frequent to least frequent. If two categories have the same number of Instagrammers,
	 * order them lexicographically by their category names.
	 * 
	 * @param instagrammers		stream of Instagrammers
	 * 
	 * @return	a list of all categories, ordered from most frequent to least frequent
	 */
	public static List<String> problem6_getCategories(Stream<Instagrammer> instagrammers) {
		Map<String, Long> categoryFrequency = new HashMap<>();
		categoryFrequency=instagrammers.collect(Collectors.groupingBy(p->p.getCategory(),Collectors.counting()));
		
		List<Map.Entry<String, Long>> list=new ArrayList<>(categoryFrequency.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String, Long>>() {
			@Override
			public int compare(Entry<String, Long> arg0, Entry<String, Long> arg1) {
				// TODO Auto-generated method stub
				if(arg0.getValue()!=arg1.getValue()) {
					return (int) (arg1.getValue()-arg0.getValue());
				}
				else {
					return arg0.getKey().compareTo(arg1.getKey());
				}
			}
		});

		return list.stream().map(p->p.getKey()).collect(Collectors.toList());
	}
	
	
	/**
	 * Given a Stream of Instagrammers and an integer n, return a list of the top n countries, 
	 * sorted in descending order by number of Instagrammers. If two countries have the same number
	 * of Instagrammers, order them lexicographically by country name. Ignore blank country
	 * names.
	 * 
	 * If there are < n countries represented in the stream, return them all, sorted in the order
	 * previously stated.
	 * 
	 * @param instagrammers		stream of Instagrammers
	 * @param n					number of results desired
	 * 
	 * @return	a list of the top n countries
	 */
	public static List<String> problem7_getTopNCountries(Stream<Instagrammer> instagrammers, int n) {
		Map<String, Long> categoryFrequency = new HashMap<>();
		categoryFrequency=instagrammers.collect(Collectors.groupingBy(p->p.getCountry(),Collectors.counting()));
		categoryFrequency.remove("");
		List<Map.Entry<String, Long>> list=new ArrayList<>(categoryFrequency.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String, Long>>() {
			@Override
			public int compare(Entry<String, Long> arg0, Entry<String, Long> arg1) {
				// TODO Auto-generated method stub
				if(arg0.getValue()!=arg1.getValue()) {
					return (int) (arg1.getValue()-arg0.getValue());
				}
				else {
					return arg0.getKey().compareTo(arg1.getKey());
				}
			}
		});
		
		return list.stream().limit(n).map(p->p.getKey()).collect(Collectors.toList());
	}
	
	
	/**
	 * Given a Stream of Instagrammers and two integers (min and max), return a String that 
	 * contains the names of all Instagrammers with an engagement number within that range,
	 * ordered lexicographically, each name separated by a single space
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	min				min engagement
	 * @param	max				max engagement
	 */
	public static String problem8_getAllIGersInEngagementRange(Stream<Instagrammer> instagrammers, 
			int min, int max) {
		List<String> result = instagrammers.filter(p -> p.getEngagement() >= min && p.getEngagement() <= max).sorted((a, b) -> a.compareTo(b)).map(p -> p.getName()).collect(Collectors.toList());
		return String.join(" ", result);
	}
	
	
	/**
	 * Given a Stream of Instagrammers and a string, return the first Instagrammer found 
	 * in the stream whose name contains that string (case-sensitive). 
	 * 
	 * If no Instagrammer name contains the string, or the stream is empty, return an 
	 * empty Optional<Instagrammer>
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	str				search string
	 * 
	 * @return	first Instagrammer found whose name contains the string (case-sensitive)
	 */
	public static Optional<Instagrammer> problem9_getFirstIGerContainingString(Stream<Instagrammer> instagrammers, 
			String str) {
		return instagrammers.filter(p -> p.getName().contains(str)).findFirst();
	}
	
	
	/**
	 * Given a Stream of Instagrammers and a boolean value distinct, return the number
	 * of Instagrammers in the stream, excluding duplicates if distinct is true.
	 * 
	 * A duplicate Instagrammer is one with the same name as another Instagrammer.
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	distinct		whether or not to exclude duplicates
	 * 
	 * @return	the number of Instagrammers in the stream
	 */
	public static long problem10_countInstagrammers(Stream<Instagrammer> instagrammers, 
			boolean distinct) {
		if (distinct) {
			return instagrammers.distinct().count();
		} 
		else {
			return instagrammers.count();
		}
	}
}