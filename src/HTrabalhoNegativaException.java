public class HTrabalhoNegativaException extends RuntimeException{

    @Override
    public String getMessage(){
        return "A Horas Trabalhadas por dia não podem ser negativas";
    }
}
