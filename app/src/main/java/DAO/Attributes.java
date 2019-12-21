package DAO;

public class Attributes {
    public static final int GRADIENT_ATTRIBUTE=102;
    public static final int MUTATION_ATTRIBUTE=103;
    private String attributesName="";
    private String attributesValue="";
    private String valueType="";
    private int attributeType=0;


    public String getAttributesName() {
        return attributesName;
    }

    public void setAttributesName(String attributesName) {
        this.attributesName = attributesName;
    }

    public String getAttributesValue() {
        return attributesValue;
    }

    public void setAttributesValue(String attributesValue) {
        this.attributesValue = attributesValue;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public int getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(int attributeType) {
        this.attributeType = attributeType;
    }



}
