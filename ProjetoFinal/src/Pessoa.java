import java.util.HashSet;
import java.util.Set;

public abstract class Pessoa {

    private static Set<String> cpfsUsados = new HashSet<>();

    protected String nome, cpf;
    protected int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Pessoa(String nome, int idade, String cpf) {
        this.nome = nome;

        if (idade < 0) {
            throw new IdadeNegativaException();
        } else {
            this.idade = idade;
        }

        if (cpf.length() == 11) {
            synchronized (Pessoa.class) {
                if (cpfsUsados.contains(cpf)) {
                    throw new CPFRepetidoException();
                } else {
                    cpfsUsados.add(cpf);
                    this.cpf = cpf;
                }
            }
        } else {
            throw new CPF11DigitosException();
        }
    }
}
