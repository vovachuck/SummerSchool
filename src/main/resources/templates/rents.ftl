<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Rents</title>
    <style>
        .table-center {
            display: flex;
            place-content: center;
        }
    </style>
    <#include "css/tableStyle.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<h1>Hello, Rents! </h1>
<div class="table-center">
    <div class="table-center" style="width: 80%; display: flex; align-content: center">
        <table class="table table-dark table-striped">
            <thead>
            <th> ID </th>
            <th> Name</th>
            <th> Description</th>
            <th> Created At</th>
            <th> Updated At</th>
            <th> Start Date</th>
            <th> End Date</th>
            </thead>
            <tbody
            <#list rents as rent >
                <tr>
                    <td>${rent.id}</td>
                    <td>${rent.name}</td>
                    <td>${rent.description}</td>
                    <td>${rent.createdAt}</td>
                    <td>${rent.updatedAt?if_exists}</td>
                    <td>${rent.startDate}</td>
                    <td>${rent.endDate}</td>
                    <td><a href="/ui/v1/rents/del/${rent.id}"><button type="button" class="btn btn-danger">Del</button></a></td>
                    <td><a href="/ui/v1/rents/edit/${rent.id}"><button type="button" class="btn btn-info">Edit</button></a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>

<a href="/ui/v1/rents/add">CREATE</a>
</body>
</html>