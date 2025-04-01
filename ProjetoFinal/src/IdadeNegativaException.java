public class IdadeNegativaException extends RuntimeException{

    @Override
    public String getMessage(){
        return "A idade não pode ser negativa";
    }

}
