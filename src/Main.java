import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Cliente> cadastroCliente = new ArrayList<>();
        cadastroCliente.add(new Cliente("Catarine", 16, "01234567890", "Rua 0, numero 1", false));
        cadastroCliente.add(new Cliente("Cristina", 17, "01236756750", "Rua 1, numero 2", false));
        cadastroCliente.add(new Cliente("lucas", 23, "65283497453", "Rua 2, numero 3", false));

        ArrayList<Funcionario> cadastroFuncionario = new ArrayList<>();
        cadastroFuncionario.add(new Funcionario("Ana Beatriz", 16, "12345678901", 500, 4));

        ArrayList<Produto> cadastroProduto = new ArrayList<>();
        cadastroProduto.add(new Produto("frango com ervilha", "Frango com ervilha gourmet", "frango", 18, 400,  false, true));
        cadastroProduto.add(new Produto("torta de queijo", "torta recheada com catupiry e mussarela", "queijo", 20, 300, true, false));


        int opcao;

        do {
            System.out.println("\nMenu Principal ");
            System.out.println("1 Buscar Cliente");
            System.out.println("2 Buscar Funcionário");
            System.out.println("3 Buscar Produto");
            System.out.println("4 Cliente de maior idade");
            System.out.println("5 Cliente mais jovem");
            System.out.println("6 Quantidade de clientes maiores de 60 anos");
            System.out.println("7 Quantidade de clientes menores de 18 anos");
            System.out.println("8 Idade média dos clientes");
            System.out.println("9 Produto mais caro");
            System.out.println("10 Produto mais barato");
            System.out.println("11 Média de preço dos produtos");
            System.out.println("12 Quantidade de produtos com preço acima da média");
            System.out.println("13 Cadastrar cliente");
            System.out.println("14 Excluir cliente");
            System.out.println("15 Cadastrar funcionário");
            System.out.println("16 Excluir funcionário");
            System.out.println("17 Cadastrar produto");
            System.out.println("18 Excluir produto");
            System.out.println("0 Sair");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); // Consumir a quebra de linha pendente

            switch (opcao) {
                case 1:
                    System.out.println("\nBusca (Cliente): ");
                    String prefixoCliente = teclado.nextLine();
                    for (Cliente cliente : cadastroCliente) {
                        if (cliente.getNome().toLowerCase().startsWith(prefixoCliente.toLowerCase())) {
                            cliente.exibir();
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nBusca (Funcionário): ");
                    String prefixoFuncionario = teclado.nextLine();
                    for (Funcionario funcionario : cadastroFuncionario) {
                        if (funcionario.getNome().toLowerCase().startsWith(prefixoFuncionario.toLowerCase())) {
                            funcionario.exibir();
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nBusca (Produto): ");
                    String prefixoProduto = teclado.nextLine();
                    for (Produto produto : cadastroProduto) {
                        if (produto.getDescricao().toLowerCase().startsWith(prefixoProduto.toLowerCase()) ||
                                produto.getNomeProd().toLowerCase().startsWith(prefixoProduto.toLowerCase()) ||
                                produto.getIngPrincipal().toLowerCase().startsWith(prefixoProduto.toLowerCase())) {
                            produto.exibir();
                        }
                    }
                    break;
                case 4:
                    Cliente clienteMaisVelho = clienteMaisVelho(cadastroCliente);
                    if (clienteMaisVelho != null) {
                        System.out.println("Cliente de maior idade:");
                        clienteMaisVelho.exibir();
                    } else {
                        System.out.println("Não há clientes cadastrados.");
                    }
                    break;
                case 5:
                    Cliente clienteMaisJovem = clienteMaisJovem(cadastroCliente);
                    if (clienteMaisJovem != null) {
                        System.out.println("Cliente mais jovem:");
                        clienteMaisJovem.exibir();
                    } else {
                        System.out.println("Não há clientes cadastrados.");
                    }
                    break;
                case 6:
                    int qtdMaiores60 = quantidadeClientesMaiores60(cadastroCliente);
                    System.out.println("Clientes +60: " + qtdMaiores60);
                    break;
                case 7:
                    int qtdMenores18 = quantidadeClientesMenores18(cadastroCliente);
                    System.out.println("Clientes -18: " + qtdMenores18);
                    break;
                case 8:
                    double idadeMedia = idadeMediaClientes(cadastroCliente);
                    System.out.println("Idade média clientes: " + idadeMedia);
                    break;
                case 9:
                    Produto produtoMaisCaro = produtoMaisCaro(cadastroProduto);
                    if (produtoMaisCaro != null) {
                        System.out.println("Produto mais caro:");
                        produtoMaisCaro.exibir();
                    } else {
                        System.out.println("Não há produtos cadastrados.");
                    }
                    break;
                case 10:
                    Produto produtoMaisBarato = produtoMaisBarato(cadastroProduto);
                    if (produtoMaisBarato != null) {
                        System.out.println("Produto mais barato:");
                        produtoMaisBarato.exibir();
                    } else {
                        System.out.println("Não há produtos cadastrados.");
                    }
                    break;
                case 11:
                    double mediaPrecoProdutos = mediaPrecoProdutos(cadastroProduto);
                    System.out.println("Média de preço dos produtos: " + mediaPrecoProdutos);
                    break;
                case 12:
                    int qtdProdutosAcimaMedia = quantidadeProdutosAcimaMedia(cadastroProduto);
                    System.out.println("Quantidade de produtos com preço acima da média: " + qtdProdutosAcimaMedia);
                    break;
                case 13:
                    cadastrarNovoCliente(teclado, cadastroCliente);
                    break;
                case 14:
                    excluirCliente(teclado, cadastroCliente);
                    break;
                case 15:
                    cadastrarNovoFuncionario(teclado, cadastroFuncionario);
                    break;
                case 16:
                    excluirFuncionario(teclado, cadastroFuncionario);
                    break;
                case 17:
                    cadastrarNovoProduto(teclado, cadastroProduto);
                    break;
                case 18:
                    excluirProduto(teclado, cadastroProduto);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void cadastrarNovoCliente(Scanner teclado, ArrayList<Cliente> cadastroCliente) {
        System.out.println("\n===== Cadastro de Cliente =====");
        System.out.print("Digite o nome do cliente: ");
        String nome = teclado.nextLine();
        System.out.print("Digite a idade do cliente: ");
        int idade = teclado.nextInt();
        teclado.nextLine(); // Consumir a quebra de linha pendente
        System.out.print("Digite o CPF do cliente: ");
        String cpf = teclado.nextLine();
        System.out.print("Digite o endereço do cliente: ");
        String endereco = teclado.nextLine();
        System.out.print("O cliente é vegetariano? (true/false): ");
        boolean vegetariano = teclado.nextBoolean();
        teclado.nextLine(); // Consumir a quebra de linha pendente

        Cliente novoCliente = new Cliente(nome, idade, cpf, endereco, vegetariano);
        cadastroCliente.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public static void excluirCliente(Scanner teclado, ArrayList<Cliente> cadastroCliente) {
        System.out.println("\n===== Exclusão de Cliente =====");
        System.out.print("Digite o CPF do cliente a ser excluído: ");
        String cpf = teclado.nextLine();

        boolean clienteEncontrado = false;
        for (Cliente cliente : cadastroCliente) {
            if (cliente.getCpf().equals(cpf)) {
                cadastroCliente.remove(cliente);
                System.out.println("Cliente excluído com sucesso!");
                clienteEncontrado = true;
                break;
            }
        }

        if (!clienteEncontrado) {
            System.out.println("Cliente não encontrado!");
        }
    }

    public static void cadastrarNovoFuncionario(Scanner teclado, ArrayList<Funcionario> cadastroFuncionario) {
        System.out.println("\n===== Cadastro de Funcionário =====");
        System.out.print("Digite o nome do funcionário: ");
        String nome = teclado.nextLine();
        System.out.print("Digite a idade do funcionário: ");
        int idade = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Digite o CPF do funcionário: ");
        String cpf = teclado.nextLine();
        System.out.print("Digite o salário do funcionário: ");
        double salario = teclado.nextDouble();
        teclado.nextLine();
        System.out.print("Digite o número de dependentes do funcionário: ");
        int numDependentes = teclado.nextInt();
        teclado.nextLine();

        Funcionario novoFuncionario = new Funcionario(nome, idade, cpf, salario, numDependentes);
        cadastroFuncionario.add(novoFuncionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public static void excluirFuncionario(Scanner teclado, ArrayList<Funcionario> cadastroFuncionario) {
        System.out.println("\n===== Exclusão de Funcionário =====");
        System.out.print("Digite o CPF do funcionário a ser excluído: ");
        String cpf = teclado.nextLine();

        boolean funcionarioEncontrado = false;
        for (Funcionario funcionario : cadastroFuncionario) {
            if (funcionario.getCpf().equals(cpf)) {
                cadastroFuncionario.remove(funcionario);
                System.out.println("Funcionário excluído com sucesso!");
                funcionarioEncontrado = true;
                break;
            }
        }

        if (!funcionarioEncontrado) {
            System.out.println("Funcionário não encontrado!");
        }
    }

    public static void cadastrarNovoProduto(Scanner teclado, ArrayList<Produto> cadastroProduto) {
        System.out.println("\n===== Cadastro de Produto =====");
        System.out.print("Digite o nome do produto: ");
        String nome = teclado.nextLine();
        System.out.print("Digite a descrição do produto: ");
        String descricao = teclado.nextLine();
        System.out.print("Digite o ingrediente principal do produto: ");
        String ingredientePrincipal = teclado.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = teclado.nextDouble();
        System.out.println("Digite o peso do produto ");
        double peso = teclado.nextDouble();
        System.out.print("O produto é vegetariano? (true/false): ");
        boolean cVegetariana  = teclado.nextBoolean();
        teclado.nextLine();
        System.out.print("O produto é fitness? (true/false): ");
        boolean fitness = teclado.nextBoolean();
        teclado.nextLine();

        Produto novoProduto = new Produto(nome, descricao, ingredientePrincipal, preco, peso, cVegetariana, fitness);
        cadastroProduto.add(novoProduto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void excluirProduto(Scanner teclado, ArrayList<Produto> cadastroProduto) {
        System.out.println("\n===== Exclusão de Produto =====");
        System.out.print("Digite o nome do produto a ser excluído: ");
        String nomeProduto = teclado.nextLine();

        boolean produtoEncontrado = false;
        for (Produto produto : cadastroProduto) {
            if (produto.getNomeProd().equalsIgnoreCase(nomeProduto)) {
                cadastroProduto.remove(produto);
                System.out.println("Produto excluído com sucesso!");
                produtoEncontrado = true;
                break;
            }
        }

        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado!");
        }
    }

    public static Cliente clienteMaisVelho(ArrayList<Cliente> clientes) {
        Cliente maisVelho = null;
        int idadeMax =Integer.MIN_VALUE;
        for (Cliente cliente : clientes) {
            if (cliente.getIdade() > idadeMax) {
                idadeMax = cliente.getIdade();
                maisVelho = cliente;
            }
        }
        return maisVelho;
    }

    public static Cliente clienteMaisJovem(ArrayList<Cliente> clientes) {
        Cliente maisJovem = null;
        int idadeMin = Integer.MAX_VALUE;
        for (Cliente cliente : clientes) {
            if (cliente.getIdade() < idadeMin) {
                idadeMin = cliente.getIdade();
                maisJovem = cliente;
            }
        }
        return maisJovem;
    }

    public static int quantidadeClientesMaiores60(ArrayList<Cliente> clientes) {
        int qtdMaiores60 = 0;
        for (Cliente cliente : clientes) {
            if (cliente.getIdade() > 60) {
                qtdMaiores60++;
            }
        }
        return qtdMaiores60;
    }

    public static int quantidadeClientesMenores18(ArrayList<Cliente> clientes) {
        int qtdMenores18 = 0;
        for (Cliente cliente : clientes) {
            if (cliente.getIdade() < 18) {
                qtdMenores18++;
            }
        }
        return qtdMenores18;
    }

    public static double idadeMediaClientes(ArrayList<Cliente> clientes) {
        double totalIdades = 0;
        for (Cliente cliente : clientes) {
            totalIdades += cliente.getIdade();
        }
        return totalIdades / clientes.size();
    }

    public static Produto produtoMaisCaro(ArrayList<Produto> produtos) {
        Produto maisCaro = null;
        double precoMax = Double.MIN_VALUE;
        for (Produto produto : produtos) {
            if (produto.getPreco() > precoMax) {
                precoMax = produto.getPreco();
                maisCaro = produto;
            }
        }
        return maisCaro;
    }

    public static Produto produtoMaisBarato(ArrayList<Produto> produtos) {
        Produto maisBarato = null;
        double precoMin = Double.MAX_VALUE;
        for (Produto produto : produtos) {
            if (produto.getPreco() < precoMin) {
                precoMin = produto.getPreco();
                maisBarato = produto;
            }
        }
        return maisBarato;
    }

    public static double mediaPrecoProdutos(ArrayList<Produto> produtos) {
        double totalPreco = 0;
        for (Produto produto : produtos) {
            totalPreco += produto.getPreco();
        }
        return totalPreco / produtos.size();
    }

    public static int quantidadeProdutosAcimaMedia(ArrayList<Produto> produtos) {
        double mediaPreco = mediaPrecoProdutos(produtos);
        int qtdAcimaMedia = 0;
        for (Produto produto : produtos) {
            if (produto.getPreco() > mediaPreco) {
                qtdAcimaMedia++;
            }
        }
        return qtdAcimaMedia;
    }
}