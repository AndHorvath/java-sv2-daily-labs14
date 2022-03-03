package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StreetMapperTest {

    StreetMapper streetMapper;
    Path path;
    Throwable exception;

    @BeforeEach
    void setUp() {
        streetMapper = new StreetMapper();
        path = Path.of("src/test/resources/streets.txt");
    }

    @Test
    void createHousesToStreetsTest() {
        assertEquals(List.of(2, 4, 1, 3, 5, 7), streetMapper.createHousesToStreets(path).get("Kossuth"));
        assertEquals(List.of(1, 2, 4, 3, 6), streetMapper.createHousesToStreets(path).get("Petőfi"));

        exception = assertThrows(
            IllegalStateException.class,
            () -> streetMapper.createHousesToStreets(Path.of("src/test/resources/streets_.txt"))
        );
        assertEquals("Cannot read file.", exception.getMessage());
    }

    @Test
    void getNumberOfEvenHousesByStreetTest() {
        assertEquals(2, streetMapper.getNumberOfEvenHousesByStreet("Kossuth", path));
        assertEquals(3, streetMapper.getNumberOfEvenHousesByStreet("Petőfi", path));
    }
}