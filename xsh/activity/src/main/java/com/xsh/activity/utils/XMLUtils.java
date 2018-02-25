package com.xsh.activity.utils;

import com.xsh.activity.common.exception.ByException ;
import com.xsh.activity.common.exception.CodeEnum ;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.Writer;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

/**
 * xml公共类
 *
 * @author by@Deng
 * @create 2017-11-08 10:20
 */
public class XMLUtils{

    /**
     * 集合传入参数按照字段名的 ASCII 码从小到大排序且拼接
     * @param paraMap   要排序的Map对象,非空
     * @param urlEncode   是否需要URLENCODE
     * @return
     */
    public static String formatParaMap(Map<String, String> paraMap, boolean urlEncode) {
        String buff = "";
        Map<String, String> tmpMap = paraMap;
        try {
            List<Map.Entry<String, String>> infoIds = new ArrayList<>(tmpMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, String> item : infoIds) {
                if (StringUtils.isNotBlank(item.getKey())) {
                    String key = item.getKey();
                    String val = item.getValue();
                    if(urlEncode) {
                        val = URLEncoder.encode(val,"utf-8");
                    }
                    buf.append(key + "=" + val).append("&");
                }
            }
            buff = buf.toString();
            if (buff.isEmpty() == false) {
                buff = buff.substring(0, buff.length() - 1);
            }
        }catch (Exception e) {
            throw new ByException(CodeEnum.UNKNOW_ERROR.getCode(), CodeEnum.UNKNOW_ERROR.getMessage());
        }
        return buff;
    }


    /**
     * 集合传入参数按照字段名的 ASCII 码从小到大排序且拼接
     * @param paraMap   要排序的Map对象,非空
     * @param urlEncode   是否需要URLENCODE
     * @return
     */
    public static String formatObjectMap(Map<String, Object> paraMap, boolean urlEncode) {
        String buff = "";
        Map<String,Object> tmpMap = paraMap;
        try {
            List<Map.Entry<String, Object>> infoIds = new ArrayList<>(tmpMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, Object>>() {
                @Override
                public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, Object> item : infoIds) {
                if (StringUtils.isNotBlank(item.getKey())) {
                    String key = item.getKey();
                    Object val = item.getValue();
                    if(urlEncode && val instanceof String) {
                        val = URLEncoder.encode(val.toString(),"utf-8");
                    }
                    buf.append(key + "=" + val).append("&");
                }
            }
            buff = buf.toString();
            if (buff.isEmpty() == false) {
                buff = buff.substring(0, buff.length() - 1);
            }
        }catch (Exception e) {
            throw new ByException(CodeEnum.UNKNOW_ERROR.getCode(), CodeEnum.UNKNOW_ERROR.getMessage());
        }
        return buff;
    }


    /**
     * 对象传入参数按照字段名的 ASCII 码从小到大排序且拼接
     * @author by@Deng
     * @date 2017/11/9 下午1:55
     */
    public static String formatObject(Object object, boolean urlEncode) {
        String buff = "";
        Field[] fields = object.getClass().getDeclaredFields();

        try {
            List<Field> infoIds = Arrays.asList(fields);

            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Field>() {
                @Override
                public int compare(Field o1, Field o2) {
                    return o1.getName().toString().compareTo(o2.getName());
                }

            });
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Field item : infoIds) {
                if (StringUtils.isNotBlank(item.getName())) {
                    item.setAccessible(true);

                    String key = item.getName();
                    Object val = item.get(object);
                    if(val !=null ) {
                        if(urlEncode && val instanceof String){
                            val = URLEncoder.encode(val.toString(),"utf-8");
                        }
                        buf.append(key + "=" + val).append("&");
                    }
                }
            }
            buff = buf.toString();
            if (buff.isEmpty() == false) {
                buff = buff.substring(0, buff.length() - 1);
            }
        }catch (Exception e) {
            throw new ByException(CodeEnum.UNKNOW_ERROR.getCode(), CodeEnum.UNKNOW_ERROR.getMessage());
        }
        return buff;
    }


    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                //增加CDATA标记
                boolean cdata = true;

                @SuppressWarnings("rawtypes")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });


    /**
     * 对象转为xml
     * @author by@Deng
     * @date 2017/11/9 下午2:23
     */
    public static String objectToXML(Object object) {
        xstream.alias("xml", object.getClass());
        String xmlTemp = xstream.toXML(object);
        String xml = xmlTemp.replace("__", "_").replace("<![CDATA[", "").replace("]]>", "");
        return xml;
    }


    /**
     * 字符串xml转成map
     * @param xml
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXml(String xml) throws Exception {
        Map<String, String> map = new HashMap<String, String>();

        Document document = DocumentHelper.parseText(xml);
        Element root = document.getRootElement();
        List<Element> elementList = root.elements();

        for (Element e : elementList)
            map.put(e.getName(), e.getText());
        return map;
    }

}
