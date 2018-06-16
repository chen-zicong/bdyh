package com.bdyh.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
@Controller
/*@ControllerAdvice*/ //换成此注解则开始全局异常捕获
public class GlobalExceptionHandler extends Exception {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);  
	  
    /** 
     * 接口有参数未传 
     */  
    @ExceptionHandler(value = MissingServletRequestParameterException.class)  
    @ResponseBody  
    public JSONObject missActionParam(HttpServletRequest req, MissingServletRequestParameterException e) throws Exception {  
        return makeErrorObj("接口有参数未传", req, e);  
    }  
  

    /** 
     * 数字格式错误 
     */  
    @ExceptionHandler(value = NumberFormatException.class)  
    @ResponseBody  
    public JSONObject numberFormatError(HttpServletRequest req, NumberFormatException e) throws Exception {  
        return makeErrorObj("数字格式错误", req, e);  
    }  
  
    /** 
     * JSON格式解析错误 
     */  
    @ExceptionHandler(value = JSONException.class)  
    @ResponseBody  
    public JSONObject jsonError(HttpServletRequest req, JSONException e) throws Exception {  
        return makeErrorObj("JSON格式解析错误", req, e);  
    }  
  
    /** 
     * 服务器内部错误 
     */  
    @ExceptionHandler(value = NullPointerException.class)  
    @ResponseBody  
    public JSONObject nullError(HttpServletRequest req, NullPointerException e) throws Exception {  
        return makeErrorObj("服务器内部错误", req, e);  
    }  
    
    
    /**
     * 自定义的 异常错误
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = CustomException.class)  
    @ResponseBody 
    private JSONObject customError(HttpServletRequest req, CustomException e){
    	return makeErrorObj(e.getMessage(), req, e);
    }
   
    /** 
     * 未知错误 
     */  
    @ExceptionHandler(value = Exception.class)  
    @ResponseBody  
    public JSONObject scheduleError(HttpServletRequest req, Exception e) throws Exception {  
        return makeErrorObj("未知错误", req, e);  
    }  
  
    /** 
     * 构造错误信息 
     * @param msg 错误描述 
     * @param e   异常信息 
     * @return 
     */  
    private JSONObject makeErrorObj(String msg, HttpServletRequest req, Exception e) {  
        JSONObject obj = new JSONObject();  
        obj.put("status", "fail");  
        obj.put("msg", msg + " (" + e.getMessage() + ")");  
        JSONObject logObj = new JSONObject();  
        logObj.put("status", "fail");  
        logObj.put("msg", msg);  
        logObj.put("error", e.getMessage());  
        logObj.put("url", req.getRequestURL());  
        logObj.put("field", req.getParameterMap());  
        logger.error(logObj.toString(), e);  
        return obj;  
    }

    
}
