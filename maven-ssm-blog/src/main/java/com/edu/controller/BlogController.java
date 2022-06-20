package com.edu.controller;

import com.edu.bean.Blog;
import com.edu.service.BlogService;
import com.edu.vo.ResultVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    //http://localhost:6060/blog/blog/getPageInfoBlog
    @GetMapping("/getPageInfoBlog")
    public PageInfo<Blog> getPageInfoBlog(@RequestParam(defaultValue = "1") Integer pageNum){
        PageInfo<Blog> pageInfoBlog = blogService.getPageInfoBlog(pageNum);
        return pageInfoBlog;
    }

    //http://localhost:6060/blog/blog/deleteBlogByBid
    @GetMapping("/deleteBlogByBid/{bid}")
    public ResultVo deleteBlogByBid(@PathVariable("bid") Integer bid){
        try {
            blogService.deleteBlogByBid(bid);
            return new ResultVo("200","删除成功",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultVo("202","删除失败",null);
    }

    //http://localhost:6060/blog/blog/getBlogByBid
    @GetMapping("/getBlogByBid/{bid}")
    public Blog getBlogByBid(@PathVariable("bid") Integer bid){
        Blog blog = blogService.getBlogByBid(bid);
        return blog;
    }

    //http://localhost:6060/blog/blog/addBlog
    @PostMapping("/addBlog")
    public ResultVo addBlog(Blog blog, HttpSession session) {
        String userSession = (String)session.getAttribute("userSession");
        if (userSession==null) {
            return new ResultVo("203","请先登录，在进行添加",null);
        }
        blog.setuFk((Integer) session.getAttribute("userId"));
        blog.setDate(new Date());
        ResultVo vo = blogService.addBlog(blog);
        return vo;
    }
}
