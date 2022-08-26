<#import "/spring.ftl" as spring/>
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
    <#include "css/tableStyle.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body class="mainBody">
<button type="button" class="btn custom" onclick="location.href='http://localhost:8080/mainPage.html'"><ion-icon name="return-up-back-outline"></ion-icon></button>
<div class="content">
    <div class="addNew">
        <h1>Payment Details</h1>
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
                <th> IBAN</th>
                <th> Card Number</th>
                <th> Security Code</th>
                <th> Expiration Date</th>
                <th> DELETE</th>
                <th> EDIT</th>
                </thead>
                <tbody
                <#list paymentDetails as paymentDetail >
                    <tr id="values">
                        <td class="${paymentDetail.id}" id="id">${paymentDetail.id}</td>
                        <td class="${paymentDetail.id}" id="name">${paymentDetail.name}</td>
                        <td class="${paymentDetail.id}" id="description">${paymentDetail.description}</td>
                        <td class="${paymentDetail.id}" id="createdAt">${paymentDetail.createdAt}</td>
                        <td class="${paymentDetail.id}" id="updatedAt">${paymentDetail.updatedAt?if_exists}</td>
                        <td class="${paymentDetail.id}" id="iban">${paymentDetail.iban}</td>
                        <td class="${paymentDetail.id}" id="cardNumber">${paymentDetail.cardNumber}</td>
                        <td class="${paymentDetail.id}" id="securityCode">${paymentDetail.securityCode}</td>
                        <td class="${paymentDetail.id}" id="expirationDate">${paymentDetail.expirationDate}</td>
                        <td><a><button type="button" class="btn update" onclick=onClickUpdate("${paymentDetail.id}")><ion-icon name="create" style="color: sandybrown;"></ion-icon></button></a></td>
                        <td><a href="/ui/v1/paymentDetails/del/${paymentDetail.id}"><button type="button" class="btn"><ion-icon name="trash" style="color: orangered;"></ion-icon></button></a></td>
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
            <form action="/ui/v1/paymentDetails/add" method="post">
                <div class="modal-body">
                    <p>Name: <input type="text" name="name" class="form-control"/></p>
                    <p>Description: <input type="text" name="description" class="form-control"/></p>
                    <p>IBAN: <input type="text" name="iban" class="form-control"/></p>
                    <p>Card Number: <input type="text" name="cardNumber" class="form-control"/></p>
                    <p>Security Code: <input type="text" name="securityCode" class="form-control"/></p>
                    <p>Expiration Date: <input type="text" name="expirationDate" class="form-control"/></p>
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
            <form action="/ui/v1/paymentDetails/edit/" method="post" id="updateForm">
                <div class="modal-body" id="updateModal">
                    <p>Name: <input type="text" name="name" class="form-control"/></p>
                    <p>Description: <input type="text" name="description" class="form-control"/></p>
                    <p>IBAN: <input type="text" name="iban" class="form-control"/></p>
                    <p>Card Number: <input type="text" name="cardNumber" class="form-control"/></p>
                    <p>Security Code: <input type="text" name="securityCode" class="form-control"/></p>
                    <p>Expiration Date: <input type="text" name="expirationDate" class="form-control"/></p>
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