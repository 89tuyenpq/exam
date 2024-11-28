<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Player List</title>
</head>
<body>
<h2>Player List</h2>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Index Name</th>
        <th>Value</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="player" items="${players}">
        <tr>
            <td>${player.id}</td>
            <td>${player.name}</td>
            <td>${player.age}</td>
            <td>${player.indexName}</td>
            <td>${player.value}</td>
            <td>
                <a href="player?action=edit&id=${player.id}">Edit</a>
                <form action="player" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${player.id}">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="player?action=add">Add New Player</a>
</body>
</html>
