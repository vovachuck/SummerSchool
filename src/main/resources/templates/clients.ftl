<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clients</title>
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
<button type="button" class="btn custom" onclick="location.href='http://localhost:8080/mainPage.html'"><ion-icon name="return-up-back-outline"></ion-icon></button>
<div class="title">
    <h1>Clients</h1>
</div>
<div class="table-center">
    <div class="table-center" style="width: 90%; display: flex; align-content: center">
        <table class="table table-hover border border-dark mt-5 table-bordered">
            <thead>
            <th> ID </th>
            <th> Name</th>
            <th> Description</th>
            <th> Created At</th>
            <th> Updated At</th>
            <th> Address</th>
            <th> Phone</th>
            <th> Contact Person</th>
            <th> EDIT</th>
            <th> DELETE</th>
            </thead>
            <tbody
            <#list clients as client >
                <tr>
                    <td>${client.id}</td>
                    <td>${client.name}</td>
                    <td>${client.description}</td>
                    <td>${client.createdAt}</td>
                    <td>${client.updatedAt?if_exists}</td>
                    <td>${client.address}</td>
                    <td>${client.phone}</td>
                    <td>${client.contactPerson}</td>
                    <td><a href="/ui/v1/clients/edit/${client.id}"><button type="button" class="btn btn-info"><ion-icon name="create-outline"></ion-icon></button></a></td>
                    <td><a href="/ui/v1/clients/del/${client.id}"><button type="button" class="btn btn-danger"><ion-icon name="trash-outline"></ion-icon></button></a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>

<a href="/ui/v1/clients/add">CREATE</a>

<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>