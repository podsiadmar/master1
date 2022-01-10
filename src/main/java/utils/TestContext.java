package utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
@Getter
@Setter
public class TestContext {
    private String userName;
    private String userPassword;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Map<String, String> commonContextMapOfStrings = new HashMap<>();
    private Map<Object, Object> commonContextMapOfObjects = new HashMap<>();

    public void setCommonContextMapOfStrings(String key, String value) {commonContextMapOfStrings.put(key, value);}

    public String getCommonContextMapOfStrings(String key) {
        return commonContextMapOfStrings.get(key);
    }

    public void setCommonContextMapOfObjects(Object key, Object value) {commonContextMapOfObjects.put(key, value);}

    public Object setCommonContextMapOfObjects(Object key) {return commonContextMapOfObjects.get(key);}
}