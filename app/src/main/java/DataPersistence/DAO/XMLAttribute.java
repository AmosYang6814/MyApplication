package DataPersistence.DAO;

public interface XMLAttribute {
    boolean setValue(String updateValue);
    String getValue();

    boolean setName(String updateName);
    String getName();
}
