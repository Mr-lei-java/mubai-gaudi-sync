package com.mubai.sync.controller;

import com.mubai.sync.bean.ResponseBean;
import com.mubai.sync.enums.ConstantResultCode;
import com.mubai.sync.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author leitengfei
 */
@RestController
@RequestMapping("api/web/v1/updateInterface")
public class UpdateWebController {
    private static final Logger logger = LoggerFactory.getLogger(UpdateWebController.class);
    /**
     * 同步销售订单
     */
    @RequestMapping(value = "/private/updateOrderList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseBean updateOrderList(@RequestBody Map<String, String> map) throws BusinessException {
        String beginTime = map.get("beginTime");
        String endTime = map.get("endTime");
        String orderCode = map.get("orderCode");
        return new ResponseBean<>(ConstantResultCode.OK, "OK");
    }

    /**
     * 同步新创建品号
     */
    @RequestMapping(value = "/private/updateMaterialList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseBean updateMaterialList(@RequestBody Map<String, String> map) throws BusinessException {
        String beginTime = map.get("beginTime");
        String endTime = map.get("endTime");
        return new ResponseBean<>(ConstantResultCode.OK, "OK");
    }
}
