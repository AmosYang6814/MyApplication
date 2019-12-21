package DataPersistence.DAO;

public  class NoRestrictAttribute implements XMLAttribute {
    String value="";
    String name="";


   public boolean setValue(String updateValue){
       this.value=updateValue;
       return true;
   }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean setName(String updateName) {
       this.value=updateName;
       return true;
    }

    @Override
    public String getName() {
        return name;
    }


}
