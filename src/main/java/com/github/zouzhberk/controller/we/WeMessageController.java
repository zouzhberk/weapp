package com.github.zouzhberk.controller.we;


import com.github.zouzhberk.essence.rxwe.RxWe;
import com.github.zouzhberk.essence.rxwe.domain.TokenEntity;
import com.github.zouzhberk.essence.rxwe.features.BaseSupportApi;
import com.github.zouzhberk.utils.MPConst;
import com.github.zouzhberk.utils.WeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by berk on 3/12/16.
 */
@RequestMapping("/")
@RestController
public class WeMessageController {

    @RequestMapping(method = RequestMethod.GET)
    public String validateSignature(@RequestParam("signature") String signature, @RequestParam("timestamp") long
            timestamp, @RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) {

        RxWe rxWe = RxWe.Builder.builder().build();
        TokenEntity tokenEntity = rxWe.create(BaseSupportApi.class).getToken(MPConst.GRANT_TYPE, MPConst.APP_ID,
                MPConst.SECRET_ID).toBlocking().first();
        String newsigature = WeUtils.generateSignature(MPConst.TOKEN, timestamp + "", nonce);
        System.out.println(echostr);
        if (newsigature.equals(signature)) {
            return echostr;
        }

        return "error";
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String testapi(@RequestParam("signature") String signature) {
        return "hello world " + signature;
    }

}
