public class Produto {

    private String nomeProd, descricao, ingPrincipal;
    private double preco, peso;
    private boolean cVegetariana, fitness;

    public boolean isFitness() {
        return fitness;
    }

    public void setFitness(boolean fitness) {
        this.fitness = fitness;
    }

    public boolean iscVegetariana() {
        return cVegetariana;
    }

    public void setcVegetariana(boolean cVegetariana) {
        this.cVegetariana = cVegetariana;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getIngPrincipal() {
        return ingPrincipal;
    }

    public void setIngPrincipal(String ingPrincipal) {
        this.ingPrincipal = ingPrincipal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public Produto(String nomeProd, String descricao, String ingPrincipal, double preco, double peso, boolean cVegetariana, boolean fitness) {
        this.descricao = descricao;
        this.nomeProd = nomeProd;
        this.ingPrincipal = ingPrincipal;



        if(preco<0){
            throw new PrecoNegativoException();
        } else {
            this.preco = preco;
        }

        if(peso<0){
            throw new PesoNegativoException();
        } else {
            this.peso = peso;
        }

        this.cVegetariana = cVegetariana;
        this.fitness = fitness;
    }
    public void exibir(){
        System.out.println("Nome: " + nomeProd+ " Descricao: " + descricao+ " ingrediente principal "+ ingPrincipal + " preço: "+ preco+ " peso: " + peso + " vegetariano: "+cVegetariana+" fitness: "+fitness);
    }
}
