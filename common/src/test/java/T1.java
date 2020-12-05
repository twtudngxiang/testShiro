import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;

import java.util.Map;

public class T1 {
    public static final String MODEL_KEY = "T1";

    private static final String DATA_KEY = "DATA_MODEL_KEY";

    private T1(boolean success, int code, String message) {
        this.success = success;
        this.message = message;
        this.code = code;
    }

    public static T1 create() {
        return new T1(true, 200, null);
    }

    public static T1 create(boolean success) {
        return create().setSuccess(success);
    }

    public static T1 create(boolean success, String message) {
        return create().setSuccess(success).setMessage(message);
    }

    public static T1 createFail() {
        return create(false);
    }

    public static T1 createFail(int code) {
        return create(false).setCode(code);
    }

    public static T1 createFail(String message) {
        return create(false).setMessage(message);
    }

    public static T1 createFail(int code, String message) {
        return create(false).setCode(code).setMessage(message);
    }

    private boolean success;

    private int code;

    private String message;

    private Map<String, Object> values;
    private Map<String, Object> values1;

    public T1 addVal(String key, Object val) {
        if (MapUtils.isEmpty(values)) {
            initMap();
        }
        values.put(key, val);
        return this;
    }

    public T1 addAllVal(Map<String, Object> data) {
        if (MapUtils.isEmpty(values)) {
            initMap();
        }
        values.putAll(data);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T getVal(String key) {
        if (MapUtils.isEmpty(values)) {
            initMap();
        }

        return (T) values.get(key);
    }

    private void initMap() {
        values = Maps.newHashMap();
        values1 = Maps.newHashMap();
    }

    public T1 setData(Object obj) {
        addVal(DATA_KEY, obj);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T getData() {
        return (T) getVal(DATA_KEY);
    }

    public boolean isSuccess() {
        return success;
    }

    public T1 setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public T1 setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public T1 setCode(int code) {
        this.code = code;
        return this;
    }

    public Map<String, Object> getValues() {
        return values;
    }

    public Map<String, Object> getValues1() {
        return values1;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }


    public static void main(String[] args) {
        T1 t = new T1(true,200,"this is oik!");
        String s = JSON.toJSONString(t);
        System.out.println(s);


    }

}
