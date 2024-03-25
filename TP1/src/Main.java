import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoEletronico {
    private String nome;
    private String categoria;
    private double preco;
    private int qtdEstoque;

    public ProdutoEletronico(String nome, String categoria, double preco, int qtdEstoque) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    // Venda de produtos
    public void venderProduto(int qtdVendida) {
        if (qtdVendida <= this.qtdEstoque) {
            this.qtdEstoque -= qtdVendida;
            System.out.println("Venda realizada com sucesso.");
        } else { System.out.println("Estoque insuficiente.");}
    }

    // Adicionar estoque
    public void addEstoque (int qtd ) {
        if (qtd > 0) {
            this.qtdEstoque += qtd;
            System.out.println( qtd + " unidade adicionadas ao estoque");
        } else {
            System.out.println("ERRO: Digite um numero maior que 0.");}
    }

    // Informações do produto
    public void exibeInf() {
        System.out.println("Nome: " + nome);
        System.out.println("Categoria: " + categoria);
        System.out.println("Preço: " + preco);
        System.out.println("Estoque: " + qtdEstoque);
    }
}

public class Main {
    public static void main(String[] args) {
        ProdutoEletronico produto1 = new ProdutoEletronico("Iphone 15","Celular", 7899.90,15);

        produto1.venderProduto(6);

        produto1.addEstoque(5);

        produto1.exibeInf();
    }
}


 class ProdutoEletronicoTest {

    @Test
    public void testVenderProdutoWithSufficientStock() {
        ProdutoEletronico produto = new ProdutoEletronico("Iphone 15", "Celular", 7899.90, 15);
        produto.venderProduto(6);
        assertEquals(9, produto.getQtdEstoque());
    }

    @Test
    public void testVenderProdutoWithInsufficientStock() {
        ProdutoEletronico produto = new ProdutoEletronico("Iphone 15", "Celular", 7899.90, 5);
        produto.venderProduto(10);
        assertEquals(5, produto.getQtdEstoque());
    }

    @Test
    public void testAddEstoqueWithPositiveQuantity() {
        ProdutoEletronico produto = new ProdutoEletronico("Iphone 15", "Celular", 7899.90, 10);
        produto.addEstoque(5);
        assertEquals(15, produto.getQtdEstoque());
    }

    @Test
    public void testAddEstoqueWithNegativeQuantity() {
        ProdutoEletronico produto = new ProdutoEletronico("Iphone 15", "Celular", 7899.90, 10);
        produto.addEstoque(-5);
        assertEquals(10, produto.getQtdEstoque());
    }

}
