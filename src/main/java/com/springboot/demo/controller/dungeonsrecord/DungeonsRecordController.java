package com.springboot.demo.controller.dungeonsrecord;

import com.springboot.demo.controller.base.AbstractController;
import com.springboot.demo.entity.Dungeons;
import com.springboot.demo.mapper.DungeonsMapper;
import com.springboot.demo.service.dungeons.DungeonsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwj * @since 1.0
 */
@RestController
@RequestMapping("/dungeonsRecord")
public class DungeonsRecordController extends AbstractController<Dungeons, DungeonsMapper, DungeonsService> {

}
