package com.github.zouzhberk.utils;


import com.github.zouzhberk.bean.TextMessage;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Reader;
import java.io.StringReader;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.time.Instant;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by berk on 3/12/16.
 */
public class WeXmlUtils {

    public static <T> T fromWeXml(String xml, Class<T> clazz) {

        return JAXB.unmarshal(new StringReader(xml), clazz);
    }

    public static <T> T fromWeXml(Reader xml, Class<T> clazz) {
        return JAXB.unmarshal(xml, clazz);
    }

    public static <T> String toWeXml(final T object) {

        StringBuilder sb1 = new StringBuilder();
        String rootname = object.getClass().getAnnotation(XmlRootElement.class).name();
        sb1.append("<");
        sb1.append(rootname);
        sb1.append(">");
        String ret = Stream.of(TextMessage.class.getDeclaredFields()).map(x -> {
            XmlElement element = x.getAnnotation(XmlElement.class);
            if (element == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("<");
            sb.append(element.name());
            sb.append(">");

            Object value = null;
            try {
                x.setAccessible(true);
                value = x.get(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value == null) {
                return null;
            }

            if (x.getAnnotation(CDATA.class) == null) {
                sb.append(value);
            } else {
                sb.append(String.format(CDATA.CDATA_VALUE, value));
            }

            sb.append("</");
            sb.append(element.name());
            sb.append(">");

            return sb.toString();
        }).filter(Objects::nonNull).collect(Collectors.joining("\n"));
        sb1.append(ret);
        sb1.append("</");
        sb1.append(rootname);
        sb1.append(">");
        return sb1.toString();

    }

    public static void main(String[] args) throws Exception {
        TextMessage object = new TextMessage();
        object.setContent("helloworld");
        object.setCreateTime(Instant.now().getEpochSecond());
        object.setFromUserName("dev");
        object.setMsgId("123");
        object.setToUserName("berk");

        TextMessage object1 = JAXB.unmarshal("file:///home/berk/IdeaProjects/wxapp/src/test/resources/recevier-text" +
                        "-message.xml",
                TextMessage.class);
        System.out.println(object1);

    }

    /**
     * Created by berk on 3/13/16.
     */
    @Retention(RUNTIME)
    @Target({FIELD, METHOD, PARAMETER})
    public static @interface CDATA {

        public String values() default "";

        public final static String CDATA_VALUE = "<![CDATA[%s]]>";
    }
}
