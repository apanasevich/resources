package examples;

import com.google.gson.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;

public final class ResourceRefDeserializer implements JsonDeserializer<ResourceRef<Object>> {
    public ResourceRef<Object> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        final String ref = jsonObject.get("ref").getAsString();
        try {
            return new ResourceRef<Object>(ref);
        } catch (IOException e) {
            throw new JsonParseException(e);
        } catch (URISyntaxException e) {
            throw new JsonParseException(e);
        }
    }
}
