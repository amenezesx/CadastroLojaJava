public class PrecoNegativoException extends RuntimeException{

    @Override
    public String getMessage(){
        return "O preço não pode ser negativo";
    }

}
