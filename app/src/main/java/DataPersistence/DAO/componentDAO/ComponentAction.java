package DataPersistence.DAO.componentDAO;

import DataPersistence.DAO.ComponentLabel;
import DataPersistence.DAO.RestrictAttribute;

public class ComponentAction extends ComponentLabel {
    actiontypeAttribute actionType;

    /**
     * 为actionType设置新的值
     * @param actionTypeValue
     */
    public void setActionType(String actionTypeValue) {
        if(actionType==null)actionType=new actiontypeAttribute();
        actionType.setValue(actionTypeValue);
    }

    public String getActionType(){
        return actionType.getValue();
    }
}
