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
    private Map<Object, String> commonContextMapOfStrings = new HashMap<>();

    public void setCommonContextMapOfStrings(Object key, String value) {
        commonContextMapOfStrings.put(key, value);
    }

    public String getCommonContextMapOfStrings(Object key) {
        return commonContextMapOfStrings.get(key);
    }
}