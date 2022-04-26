package com.coderman.controller;

import com.coderman.annotation.ApiReturnParam;
import com.coderman.annotation.ApiReturnParams;
import com.coderman.constant.SwaggerConstant;
import com.coderman.util.ResultUtil;
import com.coderman.vo.PageVO;
import com.coderman.vo.ResultVO;
import com.coderman.vo.user.UserVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author coderman @Title: 测试接口 @Description: TOD
 * @date 2022/4/422:04
 */
@RestController
@RequestMapping(value = "/${domain}")
public class TestController {

  @ApiOperation(httpMethod = SwaggerConstant.METHOD_GET, value = "分页测试")
  @GetMapping(value = "/page")
  @ApiImplicitParams({
    @ApiImplicitParam(
        name = "currentPage",
        dataType = SwaggerConstant.DATA_INT,
        value = "当前页",
        paramType = SwaggerConstant.PARAM_FORM,
        required = true),
    @ApiImplicitParam(
        name = "pageSize",
        dataType = SwaggerConstant.DATA_INT,
        value = "每页显示条数",
        paramType = SwaggerConstant.PARAM_FORM,
        required = true),
  })
  @ApiReturnParams({
    @ApiReturnParam(
        name = "ResultVO",
        value = {"code", "msg", "result"}),
    @ApiReturnParam(
        name = "PageVO",
        value = {"code", "total", "dataList"}),
    @ApiReturnParam(
        name = "UserVO",
        value = {"username", "nickname", "password"})
  })
  public ResultVO<PageVO<List<UserVO>>> page(Integer currentPage, Integer pageSize) {

    PageVO<List<UserVO>> page = new PageVO<>();
    page.setDataList(
        Arrays.asList(
            new UserVO("test", "test", "123456"),
            new UserVO("test", "test", "123456"),
            new UserVO("test", "test", "123456")));

    //        throw new BusinessException("test");
    return ResultUtil.getSuccessPage(UserVO.class, page);
  }
}
