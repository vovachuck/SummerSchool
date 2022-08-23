<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payments</title>
    <style>
        .table-center {
            display: flex;
            place-content: center;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<h1>Hello, Payments! </h1>
<div class="table-center">
    <div class="table-center" style="width: 80%; display: flex; align-content: center">
        <table class="table table-dark table-striped">
            <thead>
            <th> ID </th>
            <th> Name</th>
            <th> Description</th>
            <th> Created At</th>
            <th> Updated At</th>
            <th> Amount</th>
            </thead>
            <tbody
            <#list payments as payment >
                <tr>
                    <td>${payment.id}</td>
                    <td>${payment.name}</td>
                    <td>${payment.description}</td>
                    <td>${payment.createdAt}</td>
                    <td>${payment.updatedAt?if_exists}</td>
                    <td>${payment.amount}</td>
                    <td><a href="/ui/v1/payments/del/${payment.id}"><button type="button" class="btn btn-danger">Del</button></a></td>
                    <td><a href="/ui/v1/payments/edit/${payment.id}"><button type="button" class="btn btn-info">Edit</button></a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>

<a href="/ui/v1/payments/add">CREATE</a>
</body>
</html>