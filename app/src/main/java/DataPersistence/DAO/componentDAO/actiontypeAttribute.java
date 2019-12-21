package DataPersistence.DAO.componentDAO;

import DataPersistence.DAO.RestrictAttribute;

public class actiontypeAttribute extends RestrictAttribute {
    String[] limit={"click","focus_lose","focus_get","long_click","before_input","after_input"};
    @Override
    public boolean setValue(String updateValue) {
        if(super.Comparsion(limit,updateValue)){
            super.value=updateValue;
            return true;
        }else return false;
    }

    @Override
    public boolean setName(String updateName) {
        return super.setName(updateName);
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
