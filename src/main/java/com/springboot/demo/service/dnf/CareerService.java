package com.springboot.demo.service.dnf;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.demo.entity.dnf.Career;
import com.springboot.demo.mapper.dnf.CareerMapper;
import com.springboot.demo.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerService extends BaseService<Career, CareerMapper> {

    /**
     * 基础职业列表
     *
     * @return
     */
    public List<Career> queryBaseCareers() {
        return queryCareersByBaseCareerId(0);
    }

    /**
     * 基础职业下的转职列表
     *
     * @param baseCareerId
     * @return
     */
    public List<Career> queryCareersByBaseCareerId(Integer baseCareerId) {
        Wrapper<Career> wrapper = new QueryWrapper<Career>().eq("baseCareer", baseCareerId);
        return baseMapper.selectList(wrapper);
    }

}
