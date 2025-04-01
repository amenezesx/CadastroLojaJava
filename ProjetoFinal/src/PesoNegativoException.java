public class PesoNegativoException extends RuntimeException{

    @Override
    public String getMessage(){
        return "O peso não pode ser negativo";
    }

}
