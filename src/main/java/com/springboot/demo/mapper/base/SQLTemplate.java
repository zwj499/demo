package com.springboot.demo.mapper.base;

import com.springboot.demo.entity.base.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


/**
 * @author zwj * @since 1.0
 */
public class SQLTemplate<T extends BaseEntity> {

    private static final Logger logger = LoggerFactory.getLogger(SQLTemplate.class);

    private static final String PRIMARY_KEY = "id";

    public String selectAll(Map<String, Object> params) {
        String tableName = (String) params.get("tableName");
        return String.format("select * from %s", tableName);
    }

    private String tableName(T model) {
        return changeAttrToDatabase(model.getClass().getSimpleName());
    }

    private String changeAttrToDatabase(String attr) {
        StringBuffer newAttr = new StringBuffer();
        boolean isFirstChar = true;
        for (char c : attr.toCharArray()) {
            newAttr.append(Character.isUpperCase(c) ?
                    (isFirstChar ? Character.toLowerCase(c) : "_" + Character.toLowerCase(c)) : c);
            isFirstChar = false;
        }
        return newAttr.toString();
    }



}
