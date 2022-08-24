<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Trading Points</title>
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

<h1>Hello, Trading Points!</h1>
<div class="table-center">
    <div class="table-center" style="width: 80%; display: flex; align-content: center">
        <table class="table table-dark table-striped">
            <thead>
            <th> ID </th>
            <th> Name</th>
            <th> Description</th>
            <th> Created At</th>
            <th> Updated At</th>
            <th> Floor</th>
            <th> Square</th>
            <th> Price per Day</th>
            <th> Is Conditioner</th>
            <th> Is Available</th>
            </thead>
            <tbody
            <#list tradingPoints as tradingPoint >
                <tr>
                    <td>${tradingPoint.id}</td>
                    <td>${tradingPoint.name}</td>
                    <td>${tradingPoint.description}</td>
                    <td>${tradingPoint.createdAt}</td>
                    <td>${tradingPoint.updatedAt?if_exists}</td>
                    <td>${tradingPoint.floor}</td>
                    <td>${tradingPoint.square}</td>
                    <td>${tradingPoint.pricePerDay}</td>
                    <td>${tradingPoint.isConditioner}</td>
                    <td>${tradingPoint.isAvailable}</td>
                    <td><a href="/ui/v1/tradingPoints/del/${tradingPoint.id}"><button type="button" class="btn btn-danger">Del</button></a></td>
                    <td><a href="/ui/v1/tradingPoints/edit/${tradingPoint.id}"><button type="button" class="btn btn-info">Edit</button></a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>

<a href="/ui/v1/tradingPoints/add">CREATE</a>
</body>
</html>