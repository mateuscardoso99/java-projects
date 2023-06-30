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
