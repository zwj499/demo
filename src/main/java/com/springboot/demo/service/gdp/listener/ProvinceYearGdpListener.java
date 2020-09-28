package com.springboot.demo.service.gdp.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.mongodb.MongoException;
import com.springboot.demo.common.constant.CollectionPreDefinition;
import com.springboot.demo.entity.mongo.ProvinceYearGdp;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zwj * @since 1.0
 */
public class ProvinceYearGdpListener extends AnalysisEventListener<Map<Integer, String>> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MongoTemplate mongoTemplate;

    public ProvinceYearGdpListener(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    List<ProvinceYearGdp> list = Lists.newArrayList();

    Map<Integer, String> head = new HashMap<>();

    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext analysisContext) {
        if (MapUtils.isEmpty(head)) {
            head.putAll(data);
        } else {
            loadProvinces(data);
//            if (list.size() > BATCH_COUNT) {
//                save();
//                list.clear();
//            }
        }
    }

    private void loadProvinces(Map<Integer, String> data) {
        if (MapUtils.isEmpty(data))
            return;
        String province = data.get(0);
        // todo 校验 省份信息 。。。if (province) ...
        data.remove(0);
        for (Map.Entry entry : data.entrySet()) {
            ProvinceYearGdp pyg = buildProvince(province, entry);
            if (pyg != null)
                list.add(pyg);
        }
    }

    private ProvinceYearGdp buildProvince(String province, Map.Entry<Integer, String> entry) {
        ProvinceYearGdp pyg = new ProvinceYearGdp();
        pyg.setProvince(province);
        pyg.setValue(Double.valueOf(entry.getValue()));
        String year = head.get(entry.getKey());
        if (StringUtils.isBlank(year) || year.length() != 5)
            return null;
        pyg.setYear(Integer.valueOf(year.substring(0, 4)));
        return pyg;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        save();
    }

    private void save() {
        try {
            mongoTemplate.dropCollection(CollectionPreDefinition.PROVINCE_YEAR_GDP);
            mongoTemplate.insert(list, CollectionPreDefinition.PROVINCE_YEAR_GDP);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new MongoException("插入mongodb失败");
        }
    }

}
