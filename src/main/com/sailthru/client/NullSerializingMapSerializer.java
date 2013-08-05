package com.sailthru.client;

import com.google.gson.JsonSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonNull;
import java.lang.reflect.Type;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: dennisyu
 * Date: 8/5/13
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class NullSerializingMapSerializer implements JsonSerializer<Map> {
    private static final Gson gson = (new GsonBuilder()).serializeNulls().create();
    public JsonElement serialize(Map map, Type typeOfSrc, JsonSerializationContext context) {
        if(map == null) {
            return new JsonNull();
        }
        return new JsonPrimitive(gson.toJson(map));
    }
}