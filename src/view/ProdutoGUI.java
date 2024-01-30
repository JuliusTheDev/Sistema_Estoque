package view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import dao.ProdutoDAO;
import dao.ProdutoBD;
import model.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProdutoGUI extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final ProdutoDAO dao = null;
	
	private JTextField textoCodigo;
	private JTextField textoDescricao;
	private JTextField textoCategoria;
	private JTextField textoPrecoCusto;
	private JTextField textoPrecoVenda;
	private JTextField textoQuantidade;
	private JTextField textoDataEntrada;

	private JLabel labelCodigo;
	private JLabel labelDescricao;
	private JLabel labelCategoria;
	private JLabel labelPrecoCusto;
	private JLabel labelPrecoVenda;
	private JLabel labelQuantidade;
	private JLabel labelDataEntrada;
	
	private JButton botaoSalvar;
	private JButton botaoAlterar;
	private JButton botaoRemover;
	private JButton botaoLimpar;
	
	private JPanel tela;
		
	public JPanel getPainel() {
        if (tela == null) {
            tela = new JPanel();
            tela.setLayout(null);

            tela.add(getLabelCodigo());
            tela.add(getTextoCodigo());
            tela.add(getLabelDescricao());
            tela.add(getTextoDescricao());
            tela.add(getLabelCategoria());
            tela.add(getTextoCategoria());
            tela.add(getLabelPrecoCusto());
            tela.add(getTextoPrecoCusto());
            tela.add(getLabelPrecoVenda());
            tela.add(getTextoPrecoVenda());
            tela.add(getLabelQuantidade());
            tela.add(getTextoQuantidade());
            tela.add(getLabelDataEntrada());
            tela.add(getTextoDataEntrada());
            tela.add(getBotaoSalvar());
            tela.add(getBotaoAlterar());
            tela.add(getBotaoRemover());
            tela.add(getBotaoLimpar());
        }

        return tela;
    }
	
	private JLabel getLabelCodigo() {
        if (labelCodigo == null) {
            labelCodigo = new JLabel("Código");
            labelCodigo.setBounds(15, 15, 60, 30);
        }
        return labelCodigo;
    }

    private JTextField getTextoCodigo() {
        if (textoCodigo == null) {
        	textoCodigo = new JTextField();
        	textoCodigo.setBounds(100, 15, 300, 30);
        }
        return textoCodigo;
    }

    private JLabel getLabelDescricao() {
        if (labelDescricao == null) {
            labelDescricao = new JLabel("Descrição");
            labelDescricao.setBounds(15, 50, 60, 30);
        }
        return labelDescricao;
    }

    private JTextField getTextoDescricao() {
        if (textoDescricao == null) {
            textoDescricao = new JTextField();
            textoDescricao.setBounds(100, 50, 300, 30);
        }
        return textoDescricao;
    }

    private JLabel getLabelCategoria() {
        if (labelCategoria == null) {
            labelCategoria = new JLabel("Categoria");
            labelCategoria.setBounds(15, 100, 200, 30);
        }
        return labelCategoria;
    }

    private JTextField getTextoCategoria() {
        if (textoCategoria == null) {
            textoCategoria = new JTextField();
            textoCategoria.setBounds(100, 100, 300, 30);
        }
        return textoCategoria;
    }

    private JLabel getLabelPrecoCusto() {
        if (labelPrecoCusto == null) {
            labelPrecoCusto = new JLabel("Preço Custo");
            labelPrecoCusto.setBounds(15, 140, 120, 30);
        }
        return labelPrecoCusto;
    }

    private JTextField getTextoPrecoCusto() {
        if (textoPrecoCusto == null) {
            textoPrecoCusto = new JTextField();
            textoPrecoCusto.setBounds(100, 140, 300, 30);
        }
        return textoPrecoCusto;
    }

    private JLabel getLabelPrecoVenda() {
        if (labelPrecoVenda == null) {
            labelPrecoVenda = new JLabel("Preço Venda");
            labelPrecoVenda.setBounds(15, 180, 120, 30);
        }
        return labelPrecoVenda;
    }

    private JTextField getTextoPrecoVenda() {
        if (textoPrecoVenda == null) {
            textoPrecoVenda = new JTextField();
            textoPrecoVenda.setBounds(100, 180, 300, 30);
        }
        return textoPrecoVenda;
    }

    private JLabel getLabelQuantidade() {
        if (labelQuantidade == null) {
            labelQuantidade = new JLabel("Quantidade");
            labelQuantidade.setBounds(15, 220, 120, 30);
        }
        return labelQuantidade;
    }

    private JTextField getTextoQuantidade() {
        if (textoQuantidade == null) {
            textoQuantidade = new JTextField();
            textoQuantidade.setBounds(100, 220, 300, 30);
        }
        return textoQuantidade;
    }

    private JLabel getLabelDataEntrada() {
        if (labelDataEntrada == null) {
            labelDataEntrada = new JLabel("Data Entrada");
            labelDataEntrada.setBounds(15, 250, 150, 30);
        }
        return labelDataEntrada;
    }

    private JFormattedTextField getTextoDataEntrada() {
        if (textoDataEntrada == null) {
            MaskFormatter formatter = null;
            try {
                formatter = new MaskFormatter("##/##/####");
                formatter.setPlaceholderCharacter('_');
            } catch (ParseException p) {
                p.printStackTrace();
            }
            textoDataEntrada = new JFormattedTextField(formatter);
            textoDataEntrada.setBounds(100, 260, 300, 30);
        }
        return (JFormattedTextField) textoDataEntrada;
    }

    private JButton getBotaoSalvar() {
        if (botaoSalvar == null) {
            botaoSalvar = new JButton("Salvar");
            botaoSalvar.setToolTipText("Salvar no BD");
            botaoSalvar.setBounds(30, 300, 100, 30);
            botaoSalvar.addActionListener(eventoClique);
        }
        return botaoSalvar;
    }

    private JButton getBotaoAlterar() {
        if (botaoAlterar == null) {
            botaoAlterar = new JButton("Alterar");
            botaoAlterar.setToolTipText("Altera informações do Produto");
            botaoAlterar.setBounds(130, 300, 100, 30);
            botaoAlterar.addActionListener(eventoClique);
        }
        return botaoAlterar;
    }

    private JButton getBotaoRemover() {
        if (botaoRemover == null) {
            botaoRemover = new JButton("Remover");
            botaoRemover.setToolTipText("Remove do Banco de Dados");
            botaoRemover.setBounds(230, 300, 100, 30);
            botaoRemover.addActionListener(eventoClique);
        }
        return botaoRemover;
    }

    private JButton getBotaoLimpar() {
        if (botaoLimpar == null) {
            botaoLimpar = new JButton("Limpar");
            botaoLimpar.setToolTipText("Limpa os Campos");
            botaoLimpar.setBounds(330, 300, 100, 30);
            botaoLimpar.addActionListener(eventoClique);
        }
        return botaoLimpar;
    }


    private void iniciar() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Produto");
        setModal(true);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setContentPane(getPainel());
        setVisible(true);
    }

 public ProdutoGUI() {
	 iniciar();
 }

 private final EventoBotoes eventoClique = new EventoBotoes();

 public class EventoBotoes implements ActionListener {
     @Override
     public void actionPerformed(ActionEvent p) {
         if (p.getSource() == getBotaoSalvar()) {
             lerSalvar();
         } else if (p.getSource() == getBotaoAlterar()) {
             lerAlterar();
         } else if (p.getSource() == getBotaoRemover()) {
             deletarProduto();
         } else if (p.getSource() == getBotaoLimpar()) {
             limparCampos();
         }
     }


     private void lerSalvar() {
         String descricao = getTextoDescricao().getText();
         String categoria = getTextoCategoria().getText();
         double precoCusto = 0.0;
         double precoVenda = 0.0;

         try {
             String precoCusto2 = getTextoPrecoCusto().getText();
             if (!precoCusto2.isEmpty()) {
                 precoCusto = Double.parseDouble(precoCusto2.replace(",", "."));
             }

             String precoVenda2 = getTextoPrecoVenda().getText();
             if (!precoVenda2.isEmpty()) {
                 precoVenda = Double.parseDouble(precoVenda2.replace(",", "."));
             }

             int qtdade = Integer.parseInt(getTextoQuantidade().getText());

             Produto produto = new Produto();
             
             produto.setDescricao(descricao);
             produto.setCategoria(categoria);
             produto.setPrecoCusto(precoCusto);
             produto.setPrecoVenda(precoVenda);
             produto.setQuantidade(qtdade);

             ProdutoDAO produtoDao = new ProdutoDAO();

             Connection conexao = ProdutoBD.conexaoOn();

             produtoDao.setConnection(conexao);
             if (!getTextoCodigo().getText().isEmpty()) {
                 JOptionPane.showMessageDialog(null, "O Codigo só é necessario na remoção, consulte o BD!");
                 return;
             }

             try {
                 String dataString = getTextoDataEntrada().getText();
                 java.util.Date utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);
                 java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                 produto.setDataEntrada(sqlDate);

                 dao.salvar(produto);
                 JOptionPane.showMessageDialog(null, "Produto salvo com êxito!");
             } catch (SQLException ex) {
                 ex.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Erro ao salvar o produto.");
             } catch (ParseException p) {
                 throw new RuntimeException(p);
             }
         } catch (NumberFormatException p) {
             p.printStackTrace();
             JOptionPane.showMessageDialog(null, "Erro ao converter.");
         }


     }

     private void deletarProduto() {
         int codigo = Integer.parseInt(getTextoCodigo().getText());

         ProdutoDAO dao = new ProdutoDAO();
         Connection conexao = ProdutoBD.conexaoOn();
         dao.setConnection(conexao);

         try {
             boolean removido = dao.deletar(codigo);
             if (removido) {
                 JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                 limparCampos();
             } else {
                 JOptionPane.showMessageDialog(null, "Código não existe");
             }
         } catch (SQLException excecao) {
             excecao.printStackTrace();
             JOptionPane.showMessageDialog(null, "Erro ao remover o produto.");
         }
     }

     private void lerAlterar() {
         int codigo = Integer.parseInt(getTextoCodigo().getText());

         ProdutoDAO dao = new ProdutoDAO();
         Connection conexao = ProdutoBD.conexaoOn();
         dao.setConnection(conexao);

         try {

             if (!dao.verificaCodigo(codigo)) {
                 JOptionPane.showMessageDialog(null, "Código não existe.");
                 return;
             }


         String descricao = getTextoDescricao().getText();
         String categoria = getTextoCategoria().getText();
         double precoCusto = Double.parseDouble(getTextoPrecoCusto().getText().replace(",", "."));
         double precoVenda = Double.parseDouble(getTextoPrecoVenda().getText().replace(",", "."));
         int quantidade = Integer.parseInt(getTextoQuantidade().getText());

         Produto produto = new Produto();
         produto.setCodigo(codigo);
         produto.setDescricao(descricao);
         produto.setCategoria(categoria);
         produto.setPrecoCusto(precoCusto);
         produto.setPrecoVenda(precoVenda);
         produto.setQuantidade(quantidade);

         try {
             String dataString = getTextoDataEntrada().getText();
             java.util.Date utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);
             java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
             produto.setDataEntrada(sqlDate);

             dao.alterar(produto);
             JOptionPane.showMessageDialog(null, "Produto alterado.");
         } catch (SQLException excecao) {
             excecao.printStackTrace();
             JOptionPane.showMessageDialog(null, "Erro ao alterar.");
         } catch (ParseException p) {
             throw new RuntimeException(p);
         }
         } catch (SQLException excecao) {
        	 excecao.printStackTrace();
             JOptionPane.showMessageDialog(null, "Erro ao alterar.");
         }
     }

     private void limparCampos() {
         getTextoCodigo().setText("");
         getTextoDescricao().setText("");
         getTextoCategoria().setText("");
         getTextoPrecoCusto().setText("");
         getTextoPrecoVenda().setText("");
         getTextoQuantidade().setText("");
         getTextoDataEntrada().setText("");
     }
 }
}
