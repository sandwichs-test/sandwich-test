package com.hwforever.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XmlUtils {

	
	/**
	 * 传入xml字符串,和特征码return_code 得到特征码所对应的字段
	 * @param xml 传入的xml字符串
	 * @param return_code 特征码
	 * @return 返回特征码对应的字段
	 */
	public static String getInfo(String xml,String return_code){
		Map<String, String> map = new HashMap<>();// 用来导入导出的文件路径
		Document document=null;
		try {
			document = DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element prop = document.getRootElement();
		opertionElement(prop, map);
		System.out.println(map);
		return map.get(return_code);
	}
	/**
	 * 把传入的element中所有的节点及信息装进map集合
	 * @param e element节点
	 * @param map  要返回的map集合
	 * @return map 包含各节点信息,父节点的信息为父节点
	 */
	public static Map<String,String> opertionElement(Element e,Map<String,String> map){
		String name = e.getName();
		if(e.nodeCount()>1){
			//有子节点
			map.put(name, "父节点");
			List<Element> elements = e.elements();
			for(Element eChild:elements){
				opertionElement(eChild, map);
			}
		}else{
			//无子节点
			map.put(name, e.getText());
		}
		return map;
	}
	
	
}
