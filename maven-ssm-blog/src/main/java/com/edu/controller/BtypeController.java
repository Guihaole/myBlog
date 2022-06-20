package com.edu.controller;

import com.edu.bean.Blog;
import com.edu.bean.Btype;
import com.edu.service.BlogService;
import com.edu.service.BtypeService;
import com.edu.vo.ResultVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/btype")
public class BtypeController {
    @Autowired
    private BtypeService btypeService;
    @Autowired
    private BlogService blogService;

    //http://localhost:6060/blog/btype/getPageInfoBtypeList
    @GetMapping("/getPageInfoBtypeList")
    public PageInfo getPageInfoBtypeList(@RequestParam(defaultValue = "1") Integer pageNum) {
        PageInfo pageInfo = btypeService.getPageInfoBtypeList(pageNum);
        return pageInfo;
    }

    //http://localhost:6060/blog/btype/addBTypeBig
    @PostMapping("/addBTypeBig")
    public ResultVo addBTypeBig(String typename,String typedes){
       return btypeService.addBTypeBig(typename,typedes);
    }

    //http://localhost:6060/blog/btype/updateBTypeBig
    @PostMapping("/updateBTypeBig")
    public ResultVo updateBTypeBig(Integer typeid,String typename,String typedes){
        return btypeService.updateBTypeBig(typeid,typename,typedes);
    }

    //暂时没有考虑删除博客类别下的博客，小类博客，大类博客
    //http://localhost:6060/blog/btype/deleteBlogByTypeId
    @GetMapping("/deleteBlogByTypeId")
    public ResultVo deleteBlogByTypeId(@RequestParam("typeId") Integer typeid){
        try {
            btypeService.deleteBlogByTypeId(typeid);
            return new ResultVo("200","删除成功",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultVo("202","删除失败",null);
    }
    //http://localhost:6060/blog/btype/getPageInfoSmallByTypePid
    @GetMapping("/getPageInfoSmallByTypePid")
    public PageInfo getPageInfoSmallByTypePid(Integer pageNum,Integer typeid) {
        PageInfo pageInfo = btypeService.getPageInfoSmallByTypePid(pageNum, typeid);
        return pageInfo;
    }

    //暂时没有考虑删除这个博客类别下的博客
    //http://localhost:6060/blog/btype/deleteSmallBtypeByid
    @GetMapping("/deleteSmallBtypeByid")
    public ResultVo deleteSmallBtypeByid(Integer typeId){
        return btypeService.deleteSmallBtypeByid(typeId);
    }


    //http://localhost:6060/blog/btype/addTypeSmall
    @PostMapping("/addTypeSmall")
    public ResultVo addTypeSmall(Btype btype){
        System.out.println(btype);
        return btypeService.addTypeSmall(btype);
    }

    @GetMapping("/selectBtypeList")
    //http://localhost:6060/blog/btype/selectBtypeList
    public List<Btype> selectBtypeList(Integer bid){
        List<Btype> btypeList = btypeService.selectBtypeList(bid);
        return btypeList;
    }

    //http://localhost:6060/blog/btype/selectBtypeByBid
    @GetMapping("/selectBtypeByBid/{typeId}")
    public Btype selectBtypeByBid(@PathVariable("typeId") Integer typeId) {
        Btype btype = btypeService.selectBtypeByBid(typeId);
        return btype;
    }

    //删除大类信息并判断小类下有没有，没有可以删除，有不让它删除
    //http://localhost:6060/blog/btype/deleteBtypeBigByTypeId
    @GetMapping("/deleteBtypeBigByTypeId/{typeId}")
    public ResultVo deleteBtypeBigByTypeId(@PathVariable("typeId") Integer typeId){
        List<Btype> btypeList = btypeService.selectBtypeList(typeId);
        ResultVo vo=null;
        if(btypeList!=null && btypeList.size()>0){
            vo=new ResultVo("202","博客类别下有小类别，不能删除",null);
        }else {
            vo=btypeService.deleteSmallBtypeByid(typeId);
        }
        return vo;
    }


    //http://localhost:6060/blog/btype/deleteBtypeSmallByTypeId
    //删除小分类的信息时需要判断小类下有没有，博客
    @GetMapping("/deleteBtypeSmallByTypeId/{typeId}")
    public ResultVo deleteBtypeSmallByTypeId(@PathVariable("typeId") Integer typeId){
        List<Blog> blogList = blogService.selectBlogList(typeId);
        ResultVo vo = null;
        if (blogList!=null&&blogList.size()>0) {
            vo=new ResultVo("202","博客类别下有其他博客，不能删除",null);
        }else {
            vo=btypeService.deleteSmallBtypeByid(typeId);
        }
        return vo;
    }
}
