package com.springboot.demo.mapper.dnf;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.demo.controller.dnf.request.SelectDamagePageRequest;
import com.springboot.demo.controller.dnf.response.SelectDamagePageResponse;
import com.springboot.demo.entity.dnf.Damage;
import com.springboot.demo.mapper.base.BaseMapper;

import java.util.List;

public interface DamageMapper extends BaseMapper<Damage> {

}
