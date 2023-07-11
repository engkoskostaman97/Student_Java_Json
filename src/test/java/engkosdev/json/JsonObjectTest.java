package engkosdev.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
}
