public class TextServiceImpl implements TextService {

    @Override
    public String staticText() {
        return "Some static text";
    }

    @Override
    public String variable(String variable) {
        return variable;
    }

    @Override
    public String exception(String text) throws RuntimeException {
        throw new DoingHomeworkAtNightException(text);
    }
}
