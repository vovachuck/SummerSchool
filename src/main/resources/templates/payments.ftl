<#import "/spring.ftl" as spring/>
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
    <#include "css/tableStyle.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body class="mainBody">
<button type="button" class="btn custom" onclick="location.href='http://localhost:8080/mainPage.html'"><ion-icon name="return-up-back-outline"></ion-icon></button>
<div class="content">
    <div class="addNew">
        <h1>Payments</h1>
        <button class="btn customButton btn-outline-dark" id="myBtnAdd" onclick="onClickAdd()"><h5>+ Add New</h5></button>
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
                <th> Amount</th>
                <th> EDIT</th>
                <th> DELETE</th>
                </thead>
                <tbody
                <#list payments as payment >
                    <tr id="values">
                        <td class="${payment.id}" id="id">${payment.id}</td>
                        <td class="${payment.id}" id="name">${payment.name}</td>
                        <td class="${payment.id}" id="description">${payment.description}</td>
                        <td class="${payment.id}" id="createdAt">${payment.createdAt}</td>
                        <td class="${payment.id}" id="updatedAt">${payment.updatedAt?if_exists}</td>
                        <td class="${payment.id}" id="amount">${payment.amount}</td>
                        <td><a><button type="button" class="btn update" onclick=onClickUpdate("${payment.id}")><ion-icon name="create" style="color: sandybrown;"></ion-icon></button></a></td>
                        <td><a href="/ui/v1/payments/del/${payment.id}"><button type="button" class="btn"><ion-icon name="trash" style="color: orangered;"></ion-icon></button></a></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- The Modal -->
<div id="myModalAdd" class="customModal">
    <!-- Modal content -->
    <div class="customModal-content">
        <fieldset>
            <form action="/ui/v1/payments/add" method="post">
                <div class="modal-body">
                    <p>Name: <input type="text" name="name" class="form-control"/></p>
                    <p>Description: <input type="text" name="description" class="form-control"/></p>
                    <p>Amount: <input type="text" name="amount" class="form-control"/></p>
                </div>
                <div class="modal-footer">
                    <input type="submit" value="Submit" class="btn btn-outline-success btn-lg"/>
                    <input type="reset" class="btn btn-outline-warning btn-lg" value="Clear" />
                </div>
            </form>
        </fieldset>
    </div>
</div>

<!-- The Modal -->
<div id="myModalUpdate" class="customModal">
    <!-- Modal content -->
    <div class="customModal-content">
        <fieldset>
            <form action="/ui/v1/payments/edit/" method="post" id="updateForm">
                <div class="modal-body" id="updateModal">
                    <p>Name: <input type="text" name="name" value="" class="form-control update" id="nameUpdate"/></p>
                    <p>Description: <input type="text" name="description" value="" class="form-control update"/></p>
                    <p>Amount: <input type="text" name="amount" class="form-control"/></p>
                </div>
                <div class="modal-footer">
                    <input type="submit" value="Submit" class="btn btn-outline-success btn-lg"/>
                </div>
            </form>
        </fieldset>
    </div>
</div>
<script>
    // Get the modal
    var modal1 = document.getElementById("myModalAdd");

    function onClickAdd(){
        modal1.style.display = "block";
    }

</script>
<script>
    // Get the modal
    var modal = document.getElementById("myModalUpdate");

    var items = document.getElementsByClassName("form-control update");

    function onClickUpdate(idName){
        modal.style.display = "block";

        var updateForm = document.getElementById("updateForm")
        updateForm.action = updateForm.action + idName

        var ids = document.getElementsByClassName(idName)
        for (const item of items) {
            for (const id of ids){
                if(id.id == item.name){
                    item.value = id.textContent;
                }
            }
        }
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
        if (event.target == modal1) {
            modal1.style.display = "none";
        }
    }
</script>

<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>