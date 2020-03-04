package com.springboot.demo.common.base;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author zwj * @since 1.0
 */
public class SQLTemplate<T extends BaseEntity> {

    private static final Logger logger = LoggerFactory.getLogger(SQLTemplate.class);

    private static final String PRIMARY_KEY = "id";

    public String selectAll(Map<String, Object> params) {
        T entity = (T) params.get("entity");
        return String.format("select * from %s", tableName(entity));
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
