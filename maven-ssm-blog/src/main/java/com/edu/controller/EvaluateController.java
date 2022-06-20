package com.edu.controller;

import com.edu.bean.Evaluate;
import com.edu.service.EvaluateService;
import com.edu.vo.ResultVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluate")
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;

    //http://localhost:6060/blog/evaluate/getPageInfoEvaluate
    @GetMapping("/getPageInfoEvaluate")
    public PageInfo<Evaluate> getPageInfoEvaluate(@RequestParam(defaultValue = "1") Integer pageNum, String uname) {
        PageInfo<Evaluate> pageInfoEvaluate = evaluateService.getPageInfoEvaluate(pageNum, uname);
        return pageInfoEvaluate;
    }

    //http://localhost:6060/blog/evaluate/getPageInfoEvaluateByBid
    @GetMapping("/getPageInfoEvaluateByBid")
    public PageInfo<Evaluate> getPageInfoEvaluateByBid(@RequestParam(defaultValue = "1") Integer pageNum,Integer bid) {
        PageInfo<Evaluate> pageInfoEvaluate = evaluateService.getPageInfoEvaluateByBid(pageNum, bid);
        return pageInfoEvaluate;
    }

    //http://localhost:6060/blog/evaluate/deleteEvaluateByEid
    @GetMapping("/deleteEvaluateByEid/{eid}")
    public ResultVo deleteEvaluateByEid(@PathVariable("eid") Integer eid){
        ResultVo vo=evaluateService.deleteEvaluateByEid(eid);
        return vo;
    }
}
