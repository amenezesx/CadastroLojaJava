public class Cliente extends Pessoa implements IPessoa{

    private String endereco;
    private boolean vegetariano;

    public Cliente(String nome, int idade, String cpf, String endereco, boolean vegetariano) {
        super(nome, idade,cpf);
        this.endereco = endereco;
        this.vegetariano = vegetariano;
    }

    public boolean isVegetariano() {
        return vegetariano;
    }

    public void setVegetariano(boolean vegetariano) {
        this.vegetariano = vegetariano;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public void exibir() {
        System.out.println("\nNome: " + nome + "\nIdade: " + idade + "\nCPF: " +cpf + "\nEndereço: " + endereco + "\nVegetariano: " + vegetariano);

    }
}
