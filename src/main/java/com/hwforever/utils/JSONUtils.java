package com.hwforever.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwforever.exception.JSONException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:09 2017/11/19
 */
public class JSONUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(JSONUtils.class);

    public static <T> String convertObjectToString(T obj) throws JSONException {
        if (obj == null) {
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String result = null;

            try {
                result = mapper.writeValueAsString(obj);
                return result;
            } catch (JsonProcessingException var5) {
                JSONException se = new JSONException("无法序列化对象到JSON字符串");
                se.initCause(var5);
                LOGGER.error("{}", se);
                throw se;
            }
        }
    }

    public static <T> T convertJSONStrToObject(String json, Class<T> objClass) throws JSONException {
        if (StringUtils.isEmpty(json)) {
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            Object result = null;

            try {
                result = mapper.readValue(json, objClass);
                return (T) result;
            } catch (IOException var6) {
                JSONException se = new JSONException("无法将JSON字符串转换为对象");
                se.initCause(var6);
                LOGGER.error("{}", se);
                throw se;
            }
        }
    }

    public static Map<String, Object> convertJSONToMap(String json) throws JSONException {
        new HashMap();

        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = (Map)mapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });
            return map;
        } catch (Exception var4) {
            JSONException se = new JSONException("解析JSON内容失败");
            se.initCause(var4);
            LOGGER.error("{}", se);
            throw se;
        }
    }

    public static <T> T getValue(String str, String fieldPath, Class<T> targetClass) throws JSONException {
        List<T> ts = actuallyGetValue(str, fieldPath, targetClass, false);
        return ts.size() > 0 ? ts.get(0) : null;
    }

    public static <T> List<T> getValueList(String str, String fieldPath, Class<T> targetClass) throws JSONException {
        return actuallyGetValue(str, fieldPath, targetClass, true);
    }

    public static Map<String, Object> getValueMap(String str, String fieldPath) throws JSONException {
        new HashMap();

        try {
            Object obj = getValue(str, fieldPath, Object.class);
            Map<String, Object> result = convertJSONToMap(convertObjectToString(obj));
            return result;
        } catch (Exception var5) {
            JSONException se = new JSONException("转换JSON传到Map异常 " + str);
            se.initCause(var5);
            LOGGER.error("{}", se);
            throw se;
        }
    }

    private static <T> List<T> actuallyGetValue(String str, String fieldPath, Class<T> targetClass, boolean asCollection) throws JSONException {
        List<T> result = new ArrayList();
        if (StringUtils.isEmpty(fieldPath)) {
            try {
                return (List)(new ObjectMapper()).readValue(str, new TypeReference<List<T>>() {
                });
            } catch (IOException var15) {
                JSONException ex = new JSONException("无法转换对应属性到POJO，检查目标属性类型");
                ex.initCause(var15);
                LOGGER.error("{}", ex);
                throw ex;
            }
        } else {
            String[] pathes = fieldPath.split("\\.");
            List<String> fields = new ArrayList();
            String tmp = null;
            String regex = "\\w*(|\\[\\d+\\])";

            for(int i = 0; i < pathes.length; ++i) {
                tmp = pathes[i];
                if (!Pattern.matches(regex, tmp)) {
                    throw new JSONException("字段路径不合法");
                }

                fields.add(tmp);
            }

            ObjectMapper mapper = new ObjectMapper();

            JSONException se;
            try {
                JsonNode jsonNode = mapper.readTree(str);
                Iterator var20 = fields.iterator();

                while(var20.hasNext()) {
                    String field = (String)var20.next();
                    String fieldName = null;
                    int tmpIndex = -1;
                    if (field.contains("[")) {
                        fieldName = field.substring(0, field.indexOf(91));
                        tmpIndex = Integer.valueOf(field.substring(field.indexOf(91) + 1, field.length() - 1)).intValue();
                    } else {
                        fieldName = field;
                    }

                    jsonNode = jsonNode.get(fieldName);
                    if (jsonNode.isArray() && tmpIndex > 0) {
                        jsonNode = jsonNode.get(tmpIndex);
                    }
                }

                if (asCollection) {
                    if (jsonNode.isArray()) {
                        var20 = jsonNode.iterator();

                        while(var20.hasNext()) {
                            JsonNode node = (JsonNode)var20.next();
                            result.add(mapper.treeToValue(node, targetClass));
                        }
                    }
                } else {
                    result.add(mapper.treeToValue(jsonNode, targetClass));
                }

                return result;
            } catch (JsonProcessingException var16) {
                se = new JSONException("无法转换对应属性到POJO，检查目标属性类型");
                se.initCause(var16);
                LOGGER.error("{}", se);
                throw se;
            } catch (Exception var17) {
                se = new JSONException("JSON转换未知异常");
                se.initCause(var17);
                LOGGER.error("{}", se);
                throw se;
            }
        }
    }

    private JSONUtils() {
    }
}
