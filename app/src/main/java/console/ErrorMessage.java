package console;

public class ErrorMessage {
    String errorLevel="";
    String errorMessage="";

    public String getErrorLevel() {
        return errorLevel;
    }

    public ErrorMessage setErrorLevel(String errorLevel) {
        this.errorLevel = errorLevel;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ErrorMessage setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public String getDeugFlag() {
        return DeugFlag;
    }

    public ErrorMessage setDeugFlag(String deugFlag) {
        DeugFlag = deugFlag;
        return this;
    }

    String DeugFlag="";
}
