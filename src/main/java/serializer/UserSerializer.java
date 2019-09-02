package serializer;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import model.User;

import java.io.IOException;

public class UserSerializer extends JsonSerializer<User>{

    @Override
    public void serialize(User t, JsonGenerator jg, SerializerProvider sp) throws IOException {
        jg.writeStartObject();
        jg.writeStringField("ime", t.getName());
        jg.writeStringField("creator", t.getUsername());
        jg.writeStringField("prezime", t.getLastname());
        jg.writeEndObject();
    }

}
