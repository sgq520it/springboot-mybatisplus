package com.sgq.xcx.Utils;


import com.sgq.xcx.Entity.WX.WxMsg;
import com.thoughtworks.xstream.XStream;

public class WxMsgUtil {
    public static String textMessageToXml(WxMsg textMessage) {

        XStream xstream = new XStream();
        xstream.alias("xml", textMessage.getClass());

        return xstream.toXML(textMessage);
    }
}
