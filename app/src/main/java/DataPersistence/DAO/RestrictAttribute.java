package DataPersistence.DAO;

import DataPersistence.DAO.XMLAttribute;

public abstract class RestrictAttribute implements XMLAttribute {
    protected String value="";
    protected String name="";
   abstract public boolean setValue(String updateValue);
    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * 阈值比对方法，将获取到的属性值，于定义的值之间进行比对，如果在范围内，则返回true,否则返回false
     * @param limit 取值范围数组
     * @param value 属性取值
     * @return
     */
    public boolean Comparsion(String[] limit,String value){
        for(int i=0;i<limit.length;i++){
            if(value.equals(limit[i]))return true;
        }
        return false;
    }
}
