package com.edu.service.impl;

import com.edu.bean.Blog;
import com.edu.bean.BlogExample;
import com.edu.bean.EvaluateExample;
import com.edu.mapper.BlogMapper;
import com.edu.mapper.EvaluateMapper;
import com.edu.service.BlogService;
import com.edu.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private EvaluateMapper evaluateMapper;
    /**
     * 查询所有博客带分页
     * @param pageNum  当前页
     * @return
     */
    @Override
    public PageInfo<Blog> getPageInfoBlog(Integer pageNum) {
        PageHelper.startPage(pageNum,3);
        List<Blog> blogList = blogMapper.getBlogList(null);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList, 3);
        return pageInfo;
    }

    /**
     * 删除博客记录信息根据bid
     * @param bid  删除博客id的主键
     * @return
     */
    @Transactional
    @Override
    public void deleteBlogByBid(Integer bid) {
        //1.删除评论信息
        EvaluateExample evaluateExample = new EvaluateExample();
        evaluateExample.createCriteria().andBFkEqualTo(bid);
        evaluateMapper.deleteByExample(evaluateExample);
        //2.删除博客信息
        blogMapper.deleteByPrimaryKey(bid);
    }

    /**
     * 根据bid查询博客记录
     * @param bid bid主键
     * @return
     */
    @Override
    public Blog getBlogByBid(Integer bid) {
        Blog blog = blogMapper.selectByPrimaryKey(bid);
        return blog;
    }

    /**
     * 添加博客
     * @param blog
     * @return
     */
    @Override
    public ResultVo addBlog(Blog blog) {
        int i = blogMapper.insertSelective(blog);
        if (i==0) {
            return new ResultVo("202","博客添加失败",null);
        }
        return new ResultVo("200","博客添加成功",null);
    }

    /**
     * 根据type_fk查询所有博客
     * @param typeFk
     * @return
     */
    @Override
    public List<Blog> selectBlogList(Integer typeFk) {
        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria().andTypeFkEqualTo(typeFk);
        List<Blog> blogList = blogMapper.selectByExample(blogExample);
        return blogList;
    }
}
