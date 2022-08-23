<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payment Details</title>
    <style>
        .table-center {
            display: flex;
            place-content: center;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<h1>Hello, Payment Details! </h1>
<div class="table-center">
    <div class="table-center" style="width: 80%; display: flex; align-content: center">
        <table class="table table-dark table-striped">
            <thead>
            <th> ID </th>
            <th> Name</th>
            <th> Description</th>
            <th> Created At</th>
            <th> Updated At</th>
            <th> IBAN</th>
            <th> Card Number</th>
            <th> Security Code</th>
            <th> Expiration Date</th>
            <th> DELETE</th>
            <th> EDIT</th>
            </thead>
            <tbody
            <#list paymentDetails as paymentDetail >
                <tr>
                    <td>${paymentDetail.id}</td>
                    <td>${paymentDetail.name}</td>
                    <td>${paymentDetail.description}</td>
                    <td>${paymentDetail.createdAt}</td>
                    <td>${paymentDetail.updatedAt?if_exists}</td>
                    <td>${paymentDetail.iban}</td>
                    <td>${paymentDetail.cardNumber}</td>
                    <td>${paymentDetail.securityCode}</td>
                    <td>${paymentDetail.expirationDate}</td>
                    <td><a href="/ui/v1/paymentDetails/del/${paymentDetail.id}"><button type="button" class="btn btn-danger">Del</button></a></td>
                    <td><a href="/ui/v1/paymentDetails/edit/${paymentDetail.id}"><button type="button" class="btn btn-info">Edit</button></a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>

<a href="/ui/v1/paymentDetails/add">CREATE</a>
</body>
</html>