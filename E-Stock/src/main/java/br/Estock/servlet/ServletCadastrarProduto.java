package br.Estock.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.Estock.dao.DaoProduto;
import br.Estock.pojo.Produto;

@WebServlet("/ServletCadastrarProduto")
public class ServletCadastrarProduto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletCadastrarProduto() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String descricao = request.getParameter("descricao");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dataAtualizacao, dataValidade;
        double preco = Double.parseDouble(request.getParameter("preco"));

        try {
            dataAtualizacao = format.parse(request.getParameter("dataAtualizacao"));
            dataValidade = format.parse(request.getParameter("dataValidade"));
        } catch (ParseException e) {
            dataAtualizacao = new Date();
            dataValidade = new Date();
            e.printStackTrace();
        }
       
        DaoProduto dao = new DaoProduto();
		dao.insert(new Produto(id,descricao,quantidade,dataAtualizacao,dataValidade,preco));
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "	<head>\r\n"
					+ "	<meta charset=\"ISO-8859-1\">\r\n"
					+ "	<title>Resultado</title>\r\n"
					+ "	</head>\r\n"
					+ "	<body>\r\n"
					+ "	\r\n"
					+ " <p>Produto " + descricao + " inserido</p>\r\n"
					+ "	\r\n"
					+ "	</body>\r\n"
					+ "\r\n"
					+ "</html>");
		out.println("<a href='index_forn.html'>Voltar</a>");

		
	}
}