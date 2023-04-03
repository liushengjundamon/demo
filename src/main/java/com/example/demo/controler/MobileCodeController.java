//package com.example.demo.controler;
//
//import com.alibaba.fastjson.JSONObject;
//import com.example.demo.entity.ResponseEntity;
//import com.example.demo.util.DemoResponseCode;
//import com.zhenzi.sms.ZhenziSmsClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//
///**
// * 手机验证码controller
// */
//@RestController
//@RequestMapping(value = "mobileCode")
//public class MobileCodeController {
//
//    /**
//     * 发送验证码（需先安装sdk,下载榛子云ZhenziSmsSDK.jar）
//     *
//     * @param request
//     * @param mobile
//     * @return
//     */
//    @GetMapping("/sendSms")
//    public ResponseEntity<Object> sendSms(HttpServletRequest request, String mobile) {
//        try {
//            JSONObject json = null;
//            //生成6位验证码
//            String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
//            //发送短信
//            ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "112950", "b30ebdee-db78-406f-b2ef-095152ad7f0e");
//            //参数类型
//            Map<String, Object> params = new HashMap<String, Object>();
//            //前台输入的手机号
//            params.put("number", mobile);
//            //这个模板id对应的是榛子云个人中心的模板id
//            params.put("templateId", 11333);
//            //参数占位符,不同的模板有不同的参数个数 目前用的模板有两个参数
//            String[] templateParams = new String[2];
//            //第一个参数 随机生成的六位验证码
//            templateParams[0] = verifyCode;
//            //第二个参数 x分钟
//            templateParams[1] = "5";
//            //把参数占位符放在整体参数中
//            params.put("templateParams", templateParams);
//
//            String result = client.send(params);
//            json = JSONObject.parseObject(result);
//            if (json.getIntValue("code") != 0) {//发送短信失败
//                return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "发送失败！");
//            }
//            //将验证码存到session中,同时存入创建时间
//            //以json存放，这里使用的是阿里的fastjson
//            //json = new JSONObject();
//            //json.put("verifyCode", verifyCode);
//            //json.put("createTime", System.currentTimeMillis());
//            // 将认证码存入SESSION
//            request.getSession().setAttribute("verifyCode", verifyCode);
//            return new ResponseEntity<>(DemoResponseCode.OK, "发送成功！");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * 验证码检测
//     *
//     * @param request
//     * @param inputCode
//     * @return
//     */
//    @GetMapping("/register")
//    public ResponseEntity<Object> loginCheck(HttpServletRequest request, String inputCode) {
//
//        //存在session里的手机验证码
//        String sessionCode = (String) request.getSession().getAttribute("verifyCode");
//        //校验验证码是否正确
//        if (inputCode == null || !inputCode.equals(sessionCode)) {
//            return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "验证码错误！");
//        }
//        return new ResponseEntity<>(DemoResponseCode.OK, "验证通过！");
//    }
//
//}
