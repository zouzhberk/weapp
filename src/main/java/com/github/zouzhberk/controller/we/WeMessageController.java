package com.github.zouzhberk.controller.we;


import com.github.zouzhberk.bean.TextMessage;
import com.github.zouzhberk.utils.MPConst;
import com.github.zouzhberk.utils.WeUtils;
import com.github.zouzhberk.utils.WeXmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by berk on 3/12/16.
 */
@RequestMapping("/_mp")
@RestController
public class WeMessageController {
    private final static Logger LOG = LoggerFactory.getLogger(WeMessageController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String validateSignature(@RequestParam("signature") String signature, @RequestParam("timestamp") long
            timestamp, @RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) {

//        RxWe rxWe = RxWe.Builder.builder().build();
//        TokenEntity tokenEntity = rxWe.create(BaseSupportApi.class).getToken(MPConst.GRANT_TYPE, MPConst.APP_ID,
//                MPConst.SECRET_ID).toBlocking().first();
        String newsigature = WeUtils.generateSignature(MPConst.TOKEN, timestamp + "", nonce);
        System.out.println(echostr);
        if (newsigature.equals(signature)) {
            return echostr;
        }

        return "error";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String receiveMessage(@RequestParam("signature") String signature, @RequestParam("timestamp") long
            timestamp, @RequestParam("nonce") String nonce, @RequestBody String recvMsg) {

        LOG.info("berk, recv msg = " + recvMsg);
//        RxWe rxWe = RxWe.Builder.builder().build();
//        TokenEntity tokenEntity = rxWe.create(BaseSupportApi.class).getToken(MPConst.GRANT_TYPE, MPConst.APP_ID,
//                MPConst.SECRET_ID).toBlocking().first();
        String newsigature = WeUtils.generateSignature(MPConst.TOKEN, timestamp + "", nonce);
        if (newsigature.equals(signature)) {

            TextMessage recvMsgEntity = WeXmlUtils.fromWeXml(recvMsg, TextMessage.class);

            LOG.info("berk, recv msg = " + recvMsgEntity);
            TextMessage message = new TextMessage();
            message.setToUserName(recvMsgEntity.getFromUserName());
            message.setFromUserName(recvMsgEntity.getToUserName());
            message.setContent("ok,i known. " + recvMsgEntity.getContent());
            message.setMsgType("text");
            return WeXmlUtils.toWeXml(message);
        }

        return "success";
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String testapi(@RequestParam("signature") String signature) {
        return "hello world " + signature;
    }

}
