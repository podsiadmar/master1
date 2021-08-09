package common;

import lombok.SneakyThrows;
import utils.ConvertDataModelToJson;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.Objects;

import static utils.ConvertToDataModel.convertJsonFileToDataModel;
import static utils.ConvertToDataModel.convertJsonAsStringToDataModel;

@SuppressWarnings("SameParameterValue, unused")
public abstract class BaseEndpoint {

//    public String jsonFilePath;
    private Object[] dataModelAsArray;
    private String requestBody;

    //Get JSON as string from Data Model
    public String getRequestBody() {
        this.requestBody = convertDataModelToJson(false);
        return requestBody;
    }

    //Get JSON as string from Data Model as array
    public String getRequestBody(boolean isArray) {
        this.requestBody = convertDataModelToJson(isArray);
        return requestBody;
    }

    //Converts JSON file with array to data model as array and then to string.
    @SneakyThrows
    protected <T>void initRequestBody(Class<T[]> valueType, String jsonFilePath, boolean isArray) {
        this.dataModelAsArray = valueType.cast(convertJsonFileToDataModel(this.getClass().getClassLoader().getResourceAsStream(jsonFilePath), valueType));
        this.requestBody = convertDataModelToJson(isArray);
    }

    @SneakyThrows
    protected <T>void initRequestBody(Class<T[]> valueType, String jsonFilePath) {
        URL[] url = ((URLClassLoader) ClassLoader.getSystemClassLoader()).getURLs();
        String targetPath = Objects.requireNonNull(Arrays.stream(url).filter(el -> el.getPath().contains("target")).findFirst().orElse(null)).getPath();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(jsonFilePath);
        if (inputStream == null) {
            throw new NoSuchFileException("File not found. Path: " + targetPath + jsonFilePath);
        }
        this.dataModelAsArray = valueType.cast(convertJsonFileToDataModel(inputStream, valueType));
        this.requestBody = convertDataModelToJson(false);
    }

    //Converts JSON to data model as array
    @SneakyThrows
    protected <T>void convertJsonToDataModelArray(String response, Class<T[]> valueType) {
        this.dataModelAsArray = convertJsonAsStringToDataModel(response, valueType);
    }

    //Gets data model as an array
    @SneakyThrows
    protected <T>T getDataModelAsArray(Class<T> type) {
        if (dataModelAsArray.length != 0) {
            return type.cast(dataModelAsArray);
        } else {
            throw new Exception("Data model is empty! " + type.getSimpleName());
        }
    }

    protected void setDataModelAsArray(Object[] objectsList) {
        this.dataModelAsArray = objectsList;
    }

    protected String getValueFromField(String fieldName, Object object) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object).toString();
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void setValueOfField(String fieldName, Object value, Object object) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    private String convertDataModelToJson(boolean isArray) {
        if (isArray) {
            return new ConvertDataModelToJson(dataModelAsArray).getJson();
        } else {
            return new ConvertDataModelToJson(dataModelAsArray[0]).getJson();
        }
    }
}