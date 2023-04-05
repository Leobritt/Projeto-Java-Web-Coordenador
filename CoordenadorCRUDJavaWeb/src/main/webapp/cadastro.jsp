<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro</title>
    <link rel="stylesheet" href="cadastro.css">
</head>
<body>
    <section class="area-login">
        <div class="login">
            <div>
                <img src="/img/transferir-removebg-preview.png" alt="">
            </div>

            <form method="POST">
                <input type="text" name="nomesobrenome" placeholder="Informe seu nome e sobrenome" autofocus>
                <input id="teste" type="text" name="email" placeholder="Informe seu email" autofocus>
                <input type="text" name="cep" placeholder="Informe seu CEP" autofocus>
                <input type="text" name="telelefone" placeholder="Informe seu telelefone" autofocus>
                <input type="text" name="cpf" placeholder="Informe seu CPF" autofocus>
                <input type="password" name="senha" placeholder="Informe sua senha" autofocus><br>
                <a class="botao" href="listacoord.jsp">Cadastrar</a>
            </form>
        </div>
    </section>
</body>
</html>