package DataPersistence.DAO;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import DataPersistence.DAO.XMLAttribute;

public class ComponentLabel {
    HashMap<String ,XMLAttribute> attributesList=new HashMap<>();

    /**
     * 根据属性名字获取属性
     * @param attributeName
     * @return
     */
    public XMLAttribute getAttributeByName(String attributeName){
        if(attributeName!=null && !attributeName.equals(""))return attributesList.get(attributeName);
        else return null;
    }

    /**
     * 返回属性列表
     * @return
     */
    public List<XMLAttribute> getAttributes(){
        LinkedList<XMLAttribute> list=new LinkedList<>();
        for(Map.Entry<String,XMLAttribute> entry:attributesList.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }

    /**
     * 向列表中添加属性
     * @param attribute
     */
    public void addAttribute(XMLAttribute attribute){
        if(attribute!=null)attributesList.put(attribute.getName(),attribute);
    }

    /**
     * 根据名字删除属性值
     * @param attributeName
     */
    public boolean deleteAttribute(String attributeName){
        if(attributeName!=null && !attributeName.equals("")) {
          attributesList.remove(attributeName);
          return true;
        }
        else return false;
    }

    /**
     * 更新值
     * @param attributeName
     * @param newValue
     * @return
     */
    public boolean UpdateAttribute(String attributeName,String newValue){
        if(attributeName!=null && !attributeName.equals("")){
           return attributesList.get(attributeName).setValue(newValue);

        }
        else return false;
    }

}
