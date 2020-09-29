package com.springboot.demo.controller.dnf;

import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.controller.base.AbstractController;
import com.springboot.demo.controller.dnf.request.CreateAccountRequest;
import com.springboot.demo.controller.dnf.request.SelectAccountPageRequest;
import com.springboot.demo.entity.dnf.Account;
import com.springboot.demo.mapper.dnf.AccountMapper;
import com.springboot.demo.service.dnf.AccountService;
import org.springframework.web.bind.annotation.*;

/**
 * @author zwj * @since 1.0
 */
@RestController
@RequestMapping("/dnf/account")
public class AccountController extends AbstractController<Account, AccountMapper, AccountService> {

    @GetMapping("/list")
    public ApiBaseResponse selectAll() {
        return super.selectAll();
    }

    @PostMapping("/selectPage")
    public ApiBaseResponse selectPage(@RequestBody SelectAccountPageRequest request) {
        try {
            return setResponseSuccess(service.selectPage(request));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

    @PostMapping
    public ApiBaseResponse insert(@RequestBody CreateAccountRequest request) {
        try {
            super.insert(request.adapt(currentUser()));
            return setResponseSuccess();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

}
