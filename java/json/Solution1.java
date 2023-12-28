package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.*;
import util.ResourceProviderUtil;

import java.io.InputStream;
import java.util.Locale;
import java.util.Set;

public class Solution1 {
    public static void main(String[] args) {
        String jsonData = "{\n" +
                "  \"name\": \"Name\"\n" +
                "}";
        validate(jsonData, "json/data.schema.json");
    }

    public static void validate(String jsonData, String jsonSchemaClasspath) {
        JsonSchema schema = getJsonSchemaFromClasspath(jsonSchemaClasspath);

        if (schema == null) {
            throw new IllegalArgumentException("Отсутствует json-схема");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node;
        try {
            node = objectMapper.readTree(jsonData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Set<ValidationMessage> errors = schema.validate(node);

        if (!errors.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON не соответствует схеме:");
            errors.forEach(error -> stringBuilder.append(" ").append(error.getMessage()));

            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private static JsonSchema getJsonSchemaFromClasspath(String name) {
        // По умолчанию бандлы в библиотеке - в кодировке ISO 8859-1.
        // Есть 2 варианта корректной интернационализации:
        // 1. Либо использовать Locale.ROOT - сообщения будут на английском.
        //    Они будут приходить в кодировке ISO-8859-1, но отображаться корректно
        // 2. Либо использовать нужную Locale(например new Locale("ru","RU")) - сообщения будут на русском.
        //    Они будут приходить в кодировке ISO 8859-1, и их нужно будет конвертировать в UTF-8
        // Если не установить Locale для config, будет взята локаль по умолчанию Locale.getDefault();
        SchemaValidatorsConfig config = new SchemaValidatorsConfig();
        config.setLocale(Locale.ROOT);

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012); // SpecVersion.VersionFlag - версия схемы
        InputStream is = ResourceProviderUtil.getResource(name);

        return factory.getSchema(is, config); // Можно использовать factory.getSchema(is), если конфиг отсутствует
    }
}
