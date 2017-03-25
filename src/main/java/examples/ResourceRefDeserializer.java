package examples;

import com.google.gson.*;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

public final class ResourceRefDeserializer implements JsonDeserializer<ResourceRef<Resource>> {
    @Override
    @NotNull
    public ResourceRef<Resource> deserialize(@NotNull JsonElement jsonElement,
                                             @NotNull Type type,
                                             @NotNull JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        final String ref = jsonObject.get("ref").getAsString();
        return new ResourceRef<>(ref);
    }
}
