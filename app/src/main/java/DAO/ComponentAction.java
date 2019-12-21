package DAO;

public class ComponentAction {
    private String ValueType="";
    private String ActionName="";
    private String DefaultValue="";


    public String getActionName() {
        return ActionName;
    }

    public void setActionName(String actionName) {
        ActionName = actionName;
    }

    public String getDefaultValue() {
        return DefaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        DefaultValue = defaultValue;
    }

    public String getValueType() {
        return ValueType;
    }

    public void setValueType(String valueType) {
        ValueType = valueType;
    }
}
