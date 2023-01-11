public class ProdutoTeste {
    public static void main(String[] args) {
        Produto produtos[] = {
            new Produto("Lamborghini", 1000000),
            new Produto("Jipe", 46000),
            new Produto("Brasília", 16000),
            new Produto("Smart", 46000),
            new Produto("Fusca", 17000)
        };

        int maisBarato = buscarMenor(produtos, 0, 4);

        System.out.println("Carro mais barato: " + produtos[maisBarato].getNome());
        System.out.println("Preço: " + produtos[maisBarato].getPreco());

        System.out.println();

        selectionSort(produtos, produtos.length);
        // insertionSort(produtos, produtos.length);

        for (Produto produto : produtos) {
            System.out.println("O produto " + produto.getNome() + " custa " + produto.getPreco());
        }
    }

    
    private static void trocarProduto(Produto[] produtos, int primeiro, int segundo) {
        Produto primeiroProduto = produtos[primeiro];
        Produto segundoProduto = produtos[segundo];
        
        produtos[primeiro] = segundoProduto;
        produtos[segundo] = primeiroProduto;
    }
    
    private static int buscarMenor(Produto[] produtos, int inicio, int fim) {
        int maisBarato = inicio;
        
        for (int atual = inicio; atual < fim; atual++) {
            if (produtos[atual].getPreco() < produtos[maisBarato].getPreco()) {
                maisBarato = atual;
            }
        }
        
        return maisBarato;
    }
    
    private static void selectionSort(Produto[] produtos, int quantidadeDeElementos) {
        for (int atual = 0; atual < quantidadeDeElementos - 1; atual++) {
            int menor = buscarMenor(produtos, atual, quantidadeDeElementos);
            trocarProduto(produtos, atual, menor);
        }
    }

    private static void insertionSort(Produto[] produtos, int quantidadeDeElementos) {
        for (int atual = 1; atual < quantidadeDeElementos; atual++) {
            int analise = atual;
            while (analise > 0 && produtos[analise].getPreco() < produtos[analise - 1].getPreco()) {
                trocarProduto(produtos, analise, analise - 1);
                analise--;
            }
        }
    }
}
