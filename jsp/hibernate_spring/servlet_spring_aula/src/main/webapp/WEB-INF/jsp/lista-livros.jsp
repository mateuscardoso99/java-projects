<%--
  Created by IntelliJ IDEA.
  User: alencarmachado
  Date: 04/07/2022
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Listar Livros</title>
    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
</head>
<body>

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

</body>
</html>
