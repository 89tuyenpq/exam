<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://jakarta.servlet.jsp.jstl.core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Player Information</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .table th, .table td {
            vertical-align: middle;
        }
        .header-text {
            font-size: 28px;
            font-weight: bold;
            color: #ff6600;
        }
        .form-control, .form-select {
            border-radius: 0.25rem;
        }
        .btn-warning {
            background-color: #ff6600;
            border-color: #ff6600;
        }
        .btn-warning:hover {
            background-color: #e65c00;
            border-color: #e65c00;
        }
        .btn-danger {
            background-color: #ff4d4d;
            border-color: #ff4d4d;
        }
        .btn-danger:hover {
            background-color: #e63b3b;
            border-color: #e63b3b;
        }
        footer {
            background-color: #ff6600;
            color: white;
            text-align: center;
            padding: 10px 0;
            margin-top: 30px;
        }
    </style>
</head>
<body>

<div class="container my-5">
    <h2 class="text-center header-text mb-4">Player Information</h2>

    <!-- Add Player Form -->
    <form action="player" method="post" class="row g-3 mb-4">
        <input type="hidden" name="action" value="add">
        <div class="col-md-3">
            <label for="name" class="form-label">Player name</label>
            <input type="text" id="name" name="name" class="form-control" placeholder="Player name" required>
        </div>
        <div class="col-md-3">
            <label for="age" class="form-label">Player age</label>
            <input type="number" id="age" name="age" class="form-control" placeholder="Player age" required>
        </div>
        <div class="col-md-3">
            <label for="index_name" class="form-label">Index name</label>
            <select id="index_name" name="index_name" class="form-select">
                <option value="speed">Speed</option>
                <option value="strength">Strength</option>
                <option value="accurate">Accurate</option>
            </select>
        </div>
        <div class="col-md-2">
            <label for="value" class="form-label">Value</label>
            <input type="number" id="value" name="value" class="form-control" placeholder="Value" required>
        </div>
        <div class="col-md-1 d-flex align-items-end">
            <button type="submit" class="btn btn-warning w-100">Add</button>
        </div>
    </form>

    <!-- Players Table -->
    <table class="table table-bordered table-hover text-center">
        <thead class="table-warning">
        <tr>
            <th>Id</th>
            <th>Player name</th>
            <th>Player age</th>
            <th>Index name</th>
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
                    <!-- Edit Button -->
                    <a href="player?action=edit&id=${player.id}" class="btn btn-sm btn-primary">Edit</a>
                    <!-- Delete Button -->
                    <form action="player" method="post" class="d-inline">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${player.id}">
                        <button type="submit" class="btn btn-sm btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<!-- Footer -->
<footer>
    <p class="mb-0">Số 8, Tôn Thất Thuyết, Cầu Giấy, Hà Nội</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
