package com.offcn.servlet;

import cn.hutool.json.JSONUtil;
import com.offcn.bean.User;
import com.offcn.service.UserService;
import com.offcn.service.impl.UserServiceImpl;
import com.offcn.util.BaseServlet;
import com.offcn.util.PageUtils;
import com.offcn.vo.ResultVo;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/user")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 登录功能   http://localhost:6060/education/user?method=login
     *
     * @param request
     * @param response
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //数据处理
        User user = userService.selectUserByNameAndPwd(username, password);
        //响应vo
        ResultVo vo = null;
        if (user != null) {
            if (user.getRole() == 1 && user.getStatus() == 1) {
                vo = new ResultVo(200, "登录成功,欢迎你", user);
            } else {
                vo = new ResultVo(500, "权限不够或者账号被冻结", null);
            }
        } else {
            vo = new ResultVo(500, "用户名密码有错误", null);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * 添加用户 http://localhost:6060/education/user?method=addUser
     *
     * @param request
     * @param response
     */
    private void addUser(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        BeanUtils.populate(user, map);
        user.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //System.out.println(user);
        //数据处理
        int res = userService.addUser(user);
        ResultVo vo = null;
        if (res > 0) {
            vo = new ResultVo(200, "添加用户成功", res);
        } else {
            vo = new ResultVo(500, "添加用户失败", res);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * 用户模块---分页+模糊 http://localhost:6060/education/user?method=selectUserAll
     *
     * @param request
     * @param response
     */
    private void selectUserAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //模糊查询
        String search = request.getParameter("search");
        //默认查询---分页查询
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int totalCount = userService.selectTotalCount(search);
        String currentPage = request.getParameter("currentPage");
        PageUtils pageUtils = new PageUtils(pageSize, totalCount, currentPage);
        //查询所有
        List<User> userList = userService.selectUserAll(pageUtils.getStartIndex(), pageUtils.getPageSize(), search);
        ResultVo vo = null;
        Map<String, Object> map = new HashMap<>();
        map.put("userList", userList);
        map.put("pageUtils", pageUtils);
        if (userList != null) {
            vo = new ResultVo(200, "查询成功", map);
        } else {
            vo = new ResultVo(500, "查询失败", null);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * 修改用户信息功能 http://localhost:6060/education/user?method=updateUser
     *
     * @param request
     * @param response
     */
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        BeanUtils.populate(user, map);
        //调用业务代码
        int res = userService.updateUser(user);
        ResultVo vo = null;
        if (res > 0) {
            vo = new ResultVo(200, "修改成功", map);
        } else {
            vo = new ResultVo(500, "修改失败", null);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * 删除选中的用户 http://localhost:6060/education/user?method=deleteCheckedUser
     *
     * @param request
     * @param response
     */
    private void deleteCheckedUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String delarr = request.getParameter("delarr");
        //处理数据
        int res = userService.deleteCheckedUser(delarr);
        ResultVo vo = null;
        if (res > 0) {
            vo = new ResultVo(200, "删除成功,共删除了" + res + "数据", res);
        } else {
            vo = new ResultVo(500, "删除失败", null);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * 查询手机号是否已经存在 http://localhost:6060/education/user?method=selectByPhoneUser
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void selectByPhoneUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String phone = request.getParameter("phone");
        //处理数据
        User user = userService.selectByPhoneUser(phone);
        ResultVo vo = null;
        if (user != null) {
            vo = new ResultVo(500, "手机号存在", user);
        } else {
            vo = new ResultVo(200, "手机号可以注册", null);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * http://localhost:6060/education/user?method=loginBefore
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void loginBefore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        //数据处理
        User user = userService.selectUserByPhoneAndPwd(phone, password);
        //响应vo
        ResultVo vo = null;
        if (user != null) {
            vo = new ResultVo(200, "登录成功,欢迎你", user);
        } else {
            vo = new ResultVo(500, "用户名密码有错误", null);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }
}
