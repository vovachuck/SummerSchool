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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body class="mainBody">
<button type="button" class="btn custom" onclick="location.href='http://localhost:8080/mainPage.html'"><ion-icon name="return-up-back-outline"></ion-icon></button>
<div class="content">
    <div class="addNew">
        <h1>Clients</h1>
        <button class="btn customButton btn-outline-dark" id="myBtn" onclick=""><h5>+ Add New</h5></button>
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

<!-- The Modal -->
<div id="myModal" class="customModal">
    <!-- Modal content -->
    <div class="customModal-content">
        <span class="close">&times;</span>
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
                    <input type="submit" value="Submit" class="btn btn-outline-success btn-lg"/>
                    <input type="reset" class="btn btn-outline-warning btn-lg" value="Clear" />
                </div>
            </form>
        </fieldset>
    </div>
</div>

<script>
    // Get the modal
    var modal = document.getElementById("myModal");

    // Get the button that opens the modal
    var btn = document.getElementById("myBtn");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks on the button, open the modal
    btn.onclick = function() {
        modal.style.display = "block";
    }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>

<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>