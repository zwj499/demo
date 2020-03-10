package com.springboot.demo.controller.dungeons;

import com.springboot.demo.controller.base.AbstractController;
import com.springboot.demo.entity.DungeonsRecord;
import com.springboot.demo.mapper.DungeonsRecordMapper;
import com.springboot.demo.service.dungeonsrecord.DungeonsRecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwj * @since 1.0
 */
@RestController
@RequestMapping("/dungeons")
public class DungeonsController extends AbstractController<DungeonsRecord, DungeonsRecordMapper, DungeonsRecordService> {

}
