package com.chanshiyu.elskan.controller;

import com.chanshiyu.elskan.model.Access;
import com.chanshiyu.elskan.model.vo.CommonResult;
import com.chanshiyu.elskan.service.AccessService;
import com.chanshiyu.elskan.utils.CodeUtil;
import com.chanshiyu.elskan.utils.IpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author SHIYU
 * @date 2020/3/21 15:16
 * @description
 */
@RestController
@RequestMapping("/access")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccessController {

    private final AccessService accessService;

    /**
     * 访问
     */
    @GetMapping("/{code}")
    public Object create(@PathVariable String code, HttpServletRequest request) throws Exception {
        String ip = IpUtil.getIpAddr(request);
        Access access = new Access();
        access.setCode(code);
        access.setIp(ip);
        access.setCreateTime(new Date());
        this.accessService.create(access);
        String url = CodeUtil.getUrl(code);
        if (url == null || url.isEmpty()) {
            url = "https://baidu.com/";
        }
        return new ModelAndView(new RedirectView(url));
    }

    @GetMapping("/list/{code}")
    public CommonResult<List<Access>> list(@PathVariable String code) throws Exception {
        List<Access> accessList = this.accessService.list(code);
        return CommonResult.ok(accessList);
    }

}
