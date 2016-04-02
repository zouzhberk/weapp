package com.github.zouzhberk.service.bean;

import com.github.zouzhberk.utils.WeXmlUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by berk on 3/12/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class TextMessage {

    /**
     * 开发者微信号
     */
    @WeXmlUtils.CDATA
    @XmlElement(name = "ToUserName", required = true)
    private String toUserName;

    /**
     * 发送方帐号（一个OpenID）
     */
    @WeXmlUtils.CDATA
    @XmlElement(name = "FromUserName", required = true)
    private String fromUserName;


    @XmlElement(name = "CreateTime", required = true)
    private long createTime;

    @WeXmlUtils.CDATA
    @XmlElement(name = "MsgType")
    private String msgType;

    @XmlElement(name = "MsgId")
    private String msgId;

    @WeXmlUtils.CDATA
    @XmlElement(name = "Content")
    private String content;

    @WeXmlUtils.CDATA
    @XmlElement(name = "Event")
    private String event;

    @WeXmlUtils.CDATA
    @XmlElement(name = "EventKey")
    private String eventKey;

    @WeXmlUtils.CDATA
    @XmlElement(name = "MediaId")
    private String MediaId;

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {

        return "TextMessage{" +
                "toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime=" + createTime +
                ", MsgType='" + msgType + '\'' +
                ", msgId='" + msgId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

}
