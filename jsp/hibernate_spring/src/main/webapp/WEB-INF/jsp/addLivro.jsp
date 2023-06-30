<%--
  Created by IntelliJ IDEA.
  User: alencarmachado
  Date: 04/07/2022
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adicionar Livro</title>
    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${addLivroSucesso}">
    <div>Livro com ISBN: ${livroSalvo.isbn} salvo com sucesso!</div>
</c:if>

<c:url var="add_book_url" value="/livro/addLivro"/>
<form:form action="${add_book_url}" method="post" modelAttribute="livro">
    <form:label path="isbn">ISBN:</form:label> <form:input type="text" path="isbn"/>
    <form:label path="nome">Nome:</form:label> <form:input type="text" path="nome"/>
    <form:label path="autor">Autor1:</form:label> <form:input type="text" path="autor"/>
    <input type="submit" value="submit">
</form:form>

<c:if test="${not empty livros}">
    <table>
        <thead>
        <tr>
            <th>ISBN</th>
            <th>Nome</th>
            <th>Autor</th>
        </tr>
        </thead>
        <tbody>
        <a href="/app_bic/livro/addLivro">Add Livro</a>
        <c:forEach items="${livros}" var="livro">
            <tr>
                <td>${livro.isbn}</td>
                <td>${livro.nome}</td>
                <td>${livro.autor}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<a href="/app_bic/livro/lista">Listar livro</a>
</body>
</html>
