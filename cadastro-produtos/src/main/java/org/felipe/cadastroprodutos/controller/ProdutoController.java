package org.felipe.cadastroprodutos.controller;

import jakarta.persistence.Entity;
import org.felipe.cadastroprodutos.model.Produto;
import org.felipe.cadastroprodutos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;


    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", repository.findAll());
        return "listaProdutos";
    }
    //Listar Produtos
    @GetMapping("/produtos/novo")
    public String novoProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "formProduto";
    }
    //Salvar Produto
    @PostMapping("/produtos")
    public String salvarProduto(Produto produto) {
        repository.save(produto);
        return "redirect:/produtos";
    }
       //Ediatar Produto
    @GetMapping("/produtos/editar/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        Produto produto = repository.findById(id).orElseThrow();
        model.addAttribute("produto", produto);
        return "formProduto";
    }
    //Excluir Produto
    @GetMapping("/produtos/excluir/{id}")
    public String excluirProduto(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/produtos";
    }
}
