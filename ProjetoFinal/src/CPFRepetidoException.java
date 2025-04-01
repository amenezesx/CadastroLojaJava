public class CPFRepetidoException extends RuntimeException {
    public CPFRepetidoException() {
        super("CPF já foi utilizado");
    }
}
