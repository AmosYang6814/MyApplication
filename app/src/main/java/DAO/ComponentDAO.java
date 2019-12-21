package DAO;


/**
 * 1.解析出来的组件名字，通过控制反转注入目标语言的属性中，从而构造组件
 * 2.目标语言的调用：通过解析Acton参数，建立状态机，目标语言通过解析状态机，获取当前状态、
 */

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//组件持久化层，控制从xml解析出Component类
public class ComponentDAO {
     List<Component> components=new LinkedList<>();
     static ComponentDAO instance;


     //单例模式
     public static ComponentDAO getInstance(){
         if(instance==null){
             instance=new ComponentDAO();
         }
         return instance;
     }

     //获取所有的component对象
     public List<Component> getComponents(){
         return components;
     }

     //根据名字获取component对象
    public Component getComponentByName(String componentName){
         for(Component component:components){
             if(component.getComponentName().equals(componentName))return component;
         }
         return null;
    }

    /**
     * 通过组件的ID号获取ID的值
     * @param componentID
     * @return
     */
    public Component getComponentByID(int componentID){
         for(Component component:components){
             if(component.getComponentID()==componentID)return component;
         }
         return null;
    }

    private void getComponentFormParsingXML(String filepath){
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document d=builder.parse(filepath);
            NodeList list=d.getElementsByTagName("component");
            element(list);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }

    /**
     * 元素解析方法
     * @param list
     */
    private void element(NodeList list){
        for (int i = 0; i <list.getLength() ; i++) {
            Element element = (Element) list.item(i);
            NodeList childNodes = element.getChildNodes();
            for (int j = 0; j <childNodes.getLength() ; j++) {
                if (childNodes.item(j).getNodeType()== Node.ELEMENT_NODE) {
                    //获取节点
                    System.out.print(childNodes.item(j).getNodeName() + ":");
                    //获取节点值
                    System.out.println(childNodes.item(j).getAttributes().getNamedItem("background"));
                }
            }
        }
    }


    public static void main(String[] args){
        new ComponentDAO().getComponentFormParsingXML("G:\\MyApplication\\app\\src\\main\\assets\\ComponentDesrible\\ComponentDefinition");
    }
}
