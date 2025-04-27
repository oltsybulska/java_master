
import labs.lab4.controller.JsonManager;
import labs.lab3.model.University;
import labs.lab3.Run;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UniversityJsonTest {

    @Test
    public void testUniversityJsonSerialization() throws IOException {

        University oldUniversity = Run.createTypicalUniversity();

        JsonManager jsonManager = new JsonManager();

        String filePath = "university.json";

        jsonManager.writeUniversityToFile(oldUniversity, filePath);

        University newUniversity = jsonManager.readUniversityFromFile(filePath);

        assertEquals(oldUniversity, newUniversity, "Університет не співпадає з оригінальним");

        assertEquals(oldUniversity.getName(), newUniversity.getName(), "Назви не співпадають");

        assertEquals(oldUniversity.getFaculties().size(), newUniversity.getFaculties().size(),
                "Кількість факультетів не співпадає");

        System.out.println("Виконано успішно!");
    }
}
