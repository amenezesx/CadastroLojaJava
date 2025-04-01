public class  SalarioNegativoException extends RuntimeException{

    @Override
    public String getMessage(){
        return "O salário não pode ser negativo";
    }
}
