package DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//组件实例化对象，访问显示描述文件，并通过显示描述文件加载界面组件（通过反射机制）
public class Component {
    private String componentName="";
    private int componentID=0;
    private HashMap<String,Attributes> attributeMap;
    private HashMap<String,ComponentAction> actionMap;


    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public int getComponentID() {
        return componentID;
    }

    public void setComponentID(int componentID) {
        this.componentID = componentID;
    }
    public void setAttributeMap(HashMap<String, Attributes> attributeMap) {
        this.attributeMap = attributeMap;
    }
    public void setActionMap(HashMap<String, ComponentAction> actionMap) {
        this.actionMap = actionMap;
    }

    //获取属性描述类
    public Attributes getAttribute(String attributeName){
        if(attributeMap.get(attributeName)!=null)return attributeMap.get(attributeName);
        else return null;
    }

    //获取行为描述链
    public List<ComponentAction> getActionList(){
        ArrayList<ComponentAction> actions=new ArrayList<>();
        for(Map.Entry<String,ComponentAction> entries:actionMap.entrySet()){
            actions.add(entries.getValue());
        }
        return actions;
    }

    //通过行为描述名找到行为描述对象
    public ComponentAction getActionByName(String actionName){
        if(actionMap.get(actionName)!=null)return  actionMap.get(actionName);
        else return null;
    }

    //获取属性描述链
    public List<Attributes> getArrtibuteList(){
        ArrayList<Attributes> attributes=new ArrayList<>();
        for(Map.Entry<String,Attributes> entries:attributeMap.entrySet()){
            attributes.add(entries.getValue());
        }
        return attributes;
    }

    //从文件中获取组件持久化对象


}

