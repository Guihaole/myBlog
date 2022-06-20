package com.edu.service;

import com.edu.bean.Blog;
import com.edu.vo.ResultVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BlogService {
    //查询所有博客带分页
    public PageInfo<Blog> getPageInfoBlog(Integer pageNum);
    //删除博客记录信息根据bid
    void deleteBlogByBid(Integer bid);
    //根据bid查询博客记录
    public Blog getBlogByBid(Integer bid);
    //添加博客
    public ResultVo addBlog(Blog blog);
    //根据type_fk查询所有博客
    public List<Blog> selectBlogList(Integer typeFk);
}
