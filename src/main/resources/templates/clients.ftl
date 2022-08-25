<#import "/spring.ftl" as spring/>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body class="mainBody">
<button type="button" class="btn custom" onclick="location.href='http://localhost:8080/mainPage.html'"><ion-icon name="return-up-back-outline"></ion-icon></button>
<div class="content">
    <div class="addNew">
        <h1>Clients</h1>
        <button class="btn customButton btn-outline-dark" onclick=""><h5>+ Add New</h5></button>
    </div>

    <div class="customTable">
        <div class="table-center">
            <table class="table table-hover border border-dark mt-3 table-bordered">
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
                        <td><a href="/ui/v1/clients/edit/${client.id}"><button type="button" class="btn"><ion-icon name="create" style="color: sandybrown;"></ion-icon></button></a></td>
                        <td><a href="/ui/v1/clients/del/${client.id}"><button type="button" class="btn"><ion-icon name="trash" style="color: orangered;"></ion-icon></button></a></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div id="updatePopUp" class="modal fade">
    <fieldset>
        <form action="/ui/v1/clients/add" method="post">
            <div class="modal-body">
                <p>Name: <input type="text" name="name" class="form-control"/></p>
                <p>Description: <input type="text" name="description" class="form-control"/></p>
                <p>Address: <input type="text" name="address" class="form-control"/></p>
                <p>Phone: <input type="text" name="phone" class="form-control"/></p>
                <p>Contact Person: <input type="text" name="contactPerson" class="form-control"/></p>
            </div>
            <div class="modal-footer">
                <input type="submit" value="Submit" class="btn btn-primary"/>
                <input type="reset" class="btn btn-secondary" value="Reset" />
            </div>
        </form>
    </fieldset>
</div>

<div class="container">
    <h2>Modal Example</h2>
    <!-- Trigger the modal with a button -->
    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

    <div class="modal" tabindex="-1" role="dialog" id="myModal">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Modal body text goes here.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary">Save changes</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

</div>

<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>