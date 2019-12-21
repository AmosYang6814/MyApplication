package DataPersistence.DAO.componentDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//组件实例化对象，访问显示描述文件，并通过显示描述文件加载界面组件（通过反射机制）
public class ComponentDAO  {
    private String componentName="";
    private int componentID=0;
    private HashMap<String,ComponentAttributes> attributeMap;
    private HashMap<String,ComponentAction> actionMap;


    /**
     * 获得组件名
     * @return
     */
    public String getComponentName() {
        return componentName;
    }

    /**
     * 设置组件名
     * @param componentName
     */
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    /**
     * 获取组件ID
     * @return
     */
    public int getComponentID() {
        return componentID;
    }

    /**
     * 设置组件ID
     * @param componentID
     */
    public void setComponentID(int componentID) {
        this.componentID = componentID;
    }

    /**
     * 设置属性
     * @param attributeMap
     */
    public void setAttributeMap(HashMap<String, ComponentAttributes> attributeMap) {
        this.attributeMap = attributeMap;
    }

    /**
     * 设置动作
     * @param actionMap
     */
    public void setActionMap(HashMap<String, ComponentAction> actionMap) {
        this.actionMap = actionMap;
    }

    /**
     * 获取属性描述
     * @param attributeName
     * @return
     */
    public ComponentAttributes getAttribute(String attributeName){
        if(attributeMap.get(attributeName)!=null)return attributeMap.get(attributeName);
        else return null;
    }

    /**
     * 获取动作描述链
     * @return
     */
    public List<ComponentAction> getActionList(){
        ArrayList<ComponentAction> actions=new ArrayList<>();
        for(Map.Entry<String,ComponentAction> entries:actionMap.entrySet()){
            actions.add(entries.getValue());
        }
        return actions;
    }

    /**
     * 获取动作描述
     * @param actionName
     * @return
     */
    public ComponentAction getActionByName(String actionName){
        if(actionMap.get(actionName)!=null)return  actionMap.get(actionName);
        else return null;
    }

    /**
     * 获取属性描述链
     * @return
     */
    public List<ComponentAttributes> getArrtibuteList(){
        ArrayList<ComponentAttributes> attributes=new ArrayList<>();
        for(Map.Entry<String,ComponentAttributes> entries:attributeMap.entrySet()){
            attributes.add(entries.getValue());
        }
        return attributes;
    }

}

