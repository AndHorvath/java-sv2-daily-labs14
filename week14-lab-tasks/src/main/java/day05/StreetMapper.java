package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreetMapper {

    public Map<String, List<Integer>> createHousesToStreets(Path path) {
        List<String> sourceLines = readFile(path);
        Map<String, List<Integer>> rawDataToStreets = createRawDataToStreets(sourceLines);

        return createHousesToStreets(rawDataToStreets);
    }

    public long getNumberOfEvenHousesByStreet(String street, Path path) {
        return createHousesToStreets(path).get(street).stream()
            .filter(house -> house % 2 == 0)
            .count();
    }

    // --- private methods ----------------------------------------------------

    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot read file.", exception);
        }
    }

    private Map<String, List<Integer>> createRawDataToStreets(List<String> sourceLines) {
        Map<String, List<Integer>> rawDataToStreets = new HashMap<>();
        String street;
        int house;
        for (String line : sourceLines) {
            street = line.split(" ")[0];
            house = Integer.parseInt(line.split(" ")[1]);
            if (!rawDataToStreets.containsKey(street)) {
                rawDataToStreets.put(street, new ArrayList<>());
            }
            rawDataToStreets.get(street).add(house);
        }
        return rawDataToStreets;
    }

    private Map<String, List<Integer>> createHousesToStreets(Map<String, List<Integer>> rawDataToStreets) {
        Map<String, List<Integer>> housesToStreets = new HashMap<>();
        for (String street : rawDataToStreets.keySet()) {
            List<Integer> houses = new ArrayList<>();
            int lastEvenHouse = 0;
            int lastOddHouse = -1;
            for (int rawDigit : rawDataToStreets.get(street)) {
                if (rawDigit == 0) {
                    lastEvenHouse += 2;
                    houses.add(lastEvenHouse);
                } else {
                    lastOddHouse += 2;
                    houses.add(lastOddHouse);
                }
            }
            housesToStreets.put(street, houses);
        }
        return housesToStreets;
    }
}