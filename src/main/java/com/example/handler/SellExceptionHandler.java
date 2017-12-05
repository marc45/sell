package com.example.handler;

import com.example.config.ProjectUrlConfig;
//import com.example.exception.ResponseBankException;
import com.example.exception.SellException;
import com.example.exception.SellerAuthorizeException;
import com.example.utils.ResultVOUtil;
import com.example.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 2017-07-30 17:44
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    /**
     * 拦截登录异常
     */
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
        .concat(projectUrlConfig.getWechatOpenAuthorize())
        .concat("/sell/wechat/qrAuthorize")
        .concat("?returnUrl=")
        .concat(projectUrlConfig.getSell())
        .concat("/sell/seller/login"));
    }

    /**
     * 抛出SellException后，自定义返回结果
     */
    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    /**
     * 补充: HTTP头返回403
     */
//    @ExceptionHandler(value = ResponseBankException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public void handlerResponseBankException() {
//    }
}
