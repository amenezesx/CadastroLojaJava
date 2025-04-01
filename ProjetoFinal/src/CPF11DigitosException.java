public class CPF11DigitosException extends RuntimeException{

    @Override
    public String getMessage(){
        return "O CPF deve ter 11 digitos!";
    }
}
