package com.springboot.demo.service.dnf;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.demo.controller.dnf.response.TreeNode;
import com.springboot.demo.entity.dnf.Career;
import com.springboot.demo.mapper.dnf.CareerMapper;
import com.springboot.demo.service.base.BaseService;
import io.lettuce.core.internal.LettuceLists;
import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CareerService extends BaseService<Career, CareerMapper> {

    /**
     * 获取职业树
     *
     * @return
     */
    public List<TreeNode> queryCareerTree() {
        List<Career> careerList = baseMapper.selectList(new QueryWrapper<Career>());
        Map<Integer, List<Career>> careerMap = careerList.stream().collect(Collectors.groupingBy(Career::getBaseCareer));
        if (CollectionUtils.isEmpty(careerMap.get(0)))
            return LettuceLists.newList();
        List<TreeNode> trees = LettuceLists.newList();
        for (Career baseCareer : careerMap.get(0)) {
            TreeNode baseTreeNode = new TreeNode(baseCareer.getCareer());
            List<Career> careers = careerMap.get(baseCareer.getId());
            if (CollectionUtils.isNotEmpty(careers)) {
                baseTreeNode.setChildren(Lists.newArrayList());
                baseTreeNode.getChildren().addAll(careers.stream().map(career -> new TreeNode(career.getCareer())).collect(Collectors.toList()));
            }
            trees.add(baseTreeNode);
        }
        return trees;
    }

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
