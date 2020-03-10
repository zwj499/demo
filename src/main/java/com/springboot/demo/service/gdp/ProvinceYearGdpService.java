package com.springboot.demo.service.gdp;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.springboot.demo.common.constant.CollectionPreDefinition;
import com.springboot.demo.common.utils.SplitUtils;
import com.springboot.demo.controller.gdp.request.ProvinceYearGdpRequest;
import com.springboot.demo.controller.gdp.response.ProvinceYearGdpResponse;
import com.springboot.demo.entity.mongo.ProvinceYearGdp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zwj * @since 1.0
 */
@Service
public class ProvinceYearGdpService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<ProvinceYearGdpResponse> queryProvinceYearGdp(ProvinceYearGdpRequest request) {
        Set<Integer> yearSet = SplitUtils.stringToIntegerSet(request.getYears(), ",");
        Criteria criteria = Criteria.where("year").in(yearSet);
        if (StringUtils.isNotBlank(request.getProvinces())) {
            criteria.and("province").in(SplitUtils.stringToSet(request.getProvinces(), ","));
        }
        Query query = new Query().addCriteria(criteria);
        List<ProvinceYearGdp> datas = mongoTemplate.find(query, ProvinceYearGdp.class, CollectionPreDefinition.PROVINCE_YEAR_GDP);

        List<ProvinceYearGdpResponse> responseList = Lists.newArrayList();

        List<Integer> yearList = Lists.newArrayList(yearSet);
        Collections.sort(yearList, (a, b) -> b - a);

        Map<String, List<ProvinceYearGdp>> provinceKeyMap = datas.stream().collect(Collectors.groupingBy(x -> x.getProvince()));

        for (Map.Entry<String, List<ProvinceYearGdp>> entryData : provinceKeyMap.entrySet()) {
            Map<Integer, Double> yearGdp = entryData.getValue().stream().collect(Collectors.toMap(x -> x.getYear(), x -> x.getValue()));
            ProvinceYearGdpResponse response = new ProvinceYearGdpResponse();
            response.setProvince(entryData.getKey());
            yearList.forEach(year -> {
                response.getYearGdpMap().put(year, yearGdp.get(year) == null ? 0d : yearGdp.get(year));
            });
            responseList.add(response);
        }
        Integer orderBy = request.getOrderBy() == null ? yearList.get(0) : request.getOrderBy();
        Boolean asc = request.getAsc() == null ? false : request.getAsc();

        if (asc) {
            Collections.sort(responseList, (first, second) ->
                    first.getYearGdpMap().get(orderBy).compareTo(second.getYearGdpMap().get(orderBy)));
        } else {
            Collections.sort(responseList, (first, second) ->
                    second.getYearGdpMap().get(orderBy).compareTo(first.getYearGdpMap().get(orderBy)));
        }
        return responseList;
    }


}
