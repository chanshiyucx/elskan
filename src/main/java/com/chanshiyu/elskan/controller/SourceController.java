package com.chanshiyu.elskan.controller;

import com.chanshiyu.elskan.model.Source;
import com.chanshiyu.elskan.model.vo.CommonResult;
import com.chanshiyu.elskan.service.SourceService;
import com.chanshiyu.elskan.utils.CodeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author SHIYU
 * @date 2020/3/21 14:57
 * @description 来源 Controller
 */
@RestController
@RequestMapping("/source")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SourceController {

    private final SourceService sourceService;

    /**
     * 创建来源
     */
    @GetMapping("/create")
    public CommonResult<Source> create(@RequestParam String url) throws Exception {
        Source source = new Source();
        source.setCode(CodeUtil.generate(url));
        source.setCreateTime(new Date());
        this.sourceService.create(source);
        return CommonResult.ok(source);
    }

}
