package com.edu.controller;

import com.edu.bean.Account;
import com.edu.service.AccountService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "账户管理")
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    //http://localhost:8080/account/selectAccountList
    @ApiOperation(value = "查询所有账户信息", notes = "参数可以传也可以不传")
    @GetMapping("/selectAccountList")
    public PageInfo<Account> selectAccountList(@RequestParam(value = "pageNo",defaultValue = "1",required = false) Integer pageNo){
        PageInfo<Account> pageInfo = accountService.selectAccountList(pageNo);
        return pageInfo;
    };
    @ApiOperation(value = "根据id查询账户信息", notes = "参数不可少")
    @ApiImplicitParam(paramType = "path", dataType = "Integer",
            name = "id", value = "用户编号", required = true, example = "1")
    @GetMapping("/selectAccountById/{id}")
    public Account selectAccountById(@PathVariable("id") Integer id){
        Account account = accountService.selectAccountById(id);
        return account;
    };
}
