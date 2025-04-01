public class Funcionario extends Pessoa implements IPessoa{

    private double salario, hTrabalhadasD;

    public Funcionario(String nome, int idade, String cpf, double salario, double hTrabalhadasD) {
        super(nome, idade,cpf);

        if(salario<0){
            throw new SalarioNegativoException();
        } else {
            this.salario = salario;
        }

        if(hTrabalhadasD<0){
            throw new HTrabalhoNegativaException();
        } else {
            this.hTrabalhadasD = hTrabalhadasD;
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double gethTrabalhadasD() {
        return hTrabalhadasD;
    }

    public void sethTrabalhadasD(double hTrabalhadasD) {
        this.hTrabalhadasD = hTrabalhadasD;
    }

    @Override
    public void exibir() {

        System.out.println("\nNome: " + nome + "\nIdade: " + idade + "\nCPF: " + cpf + "\nSalário: " + salario + "\nHoras Trabalhadas por Dia: " + hTrabalhadasD);
        ;
    }
}
