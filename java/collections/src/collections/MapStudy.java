package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapStudy {
	public static void main(String[] args) {
		Map<String, Integer> genres = new HashMap<>();
		genres.put("hipop", 1000);
		genres.put("hipop", genres.getOrDefault("hipop", 0) + 1000);
		System.out.println("hipop : " + genres.get("hipop"));
		genres.put("pop", 2000);
		genres.put("ballad", 3000);
		genres.put("R&B", 2000);
		System.out.println("size : " + genres.size());
		
		Set<String> genreKey = genres.keySet();
		for(String key: genreKey) {
			System.out.println(key + " : " + genres.get(key));
		}
		
		Map<String, Integer> treeGenres = new TreeMap<>();
		treeGenres.put("hipop", 1000);
		treeGenres.put("hipop", treeGenres.getOrDefault("hipop", 0) + 1000);
		System.out.println("hipop : " + treeGenres.get("hipop"));
		treeGenres.put("pop", 2000);
		treeGenres.put("ballad", 3000);
		treeGenres.put("R&B", 1000);
		System.out.println("size : " + treeGenres.size());
		
		Set<String> treeGenresKey = treeGenres.keySet();
		for(String key: treeGenresKey) {
			System.out.println(key + " : " + treeGenres.get(key));
		}
	}
}
