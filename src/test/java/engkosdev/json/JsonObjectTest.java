package engkosdev.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Objects;

public class JsonObjectTest {
    @Test
    void createJson() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
                "firstname","budi",
                "lastname","nugraha",
                "age",30,
                "married",true,
                "addres", Map.of(
                        "street","jalan baru",
                        "city","jakarta",
                        "country","indonesia"
                )
        );
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);

    }

    @Test
    void readJson() throws JsonProcessingException {
        String json = """
                {
                  "age": 30,
                  "address": [ {
                  
                    "street": "Jalan belum ada",
                    "city": "Jakarta",
                    "country": "Indonesia"
                    }
                  ],
                  "firstName": "Budi",
                  "lastName": "Nugraha",
                  "married": true
                }
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> person = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });

        Assertions.assertEquals("Budi", person.get("firstName"));
        Assertions.assertEquals("Nugraha", person.get("lastName"));
    }
}
