<#import "/spring.ftl" as spring/>
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
<body class="mainBody">
<button type="button" class="btn custom" onclick="location.href='http://localhost:8080/mainPage.html'"><ion-icon name="return-up-back-outline"></ion-icon></button>
<div class="content">
    <div class="addNew">
        <h1>Trading Points</h1>
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
                <th> Floor</th>
                <th> Square</th>
                <th> Price per Day</th>
                <th> Is Conditioner</th>
                <th> Is Available</th>
                <th> EDIT</th>
                <th> DELETE</th>
                </thead>
                <tbody
                <#list tradingPoints as tradingPoint >
                    <tr id="values">
                        <td class="${tradingPoint.id}" id="id">${tradingPoint.id}</td>
                        <td class="${tradingPoint.id}" id="name">${tradingPoint.name}</td>
                        <td class="${tradingPoint.id}" id="description">${tradingPoint.description}</td>
                        <td class="${tradingPoint.id}" id="createdAt">${tradingPoint.createdAt}</td>
                        <td class="${tradingPoint.id}" id="updatedAt">${tradingPoint.updatedAt?if_exists}</td>
                        <td class="${tradingPoint.id}" id="floor">${tradingPoint.floor}</td>
                        <td class="${tradingPoint.id}" id="square">${tradingPoint.square}</td>
                        <td class="${tradingPoint.id}" id="pricePerDay">${tradingPoint.pricePerDay}</td>
                        <td class="${tradingPoint.id}" id="isConditioner">${tradingPoint.isConditioner?c}</td>
                        <td class="${tradingPoint.id}" id="isAvailable">${tradingPoint.isAvailable?c}</td>
                        <td><a><button type="button" class="btn update" onclick=onClickUpdate("${tradingPoint.id}")><ion-icon name="create" style="color: sandybrown;"></ion-icon></button></a></td>
                        <td><a href="/ui/v1/tradingPoints/del/${tradingPoint.id}"><button type="button" class="btn"><ion-icon name="trash" style="color: orangered;"></ion-icon></button></a></td>
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
            <form action="/ui/v1/tradingPoints/add" method="post">
                <div class="modal-body">
                    <p>Name: <input type="text" name="name" class="form-control"/></p>
                    <p>Description: <input type="text" name="description" class="form-control"/></p>
                    <p>Floor: <input type="text" name="floor" class="form-control"/></p>
                    <p>Square: <input type="text" name="square" class="form-control"/></p>
                    <p>Price per Day: <input type="text" name="pricePerDay" class="form-control"/></p>
                    <p>Is Conditioner: <input type="checkbox" name="isConditioner" class="form-control"/></p>
                    <p>Is Available: <input type="checkbox" name="isAvailable" class="form-control"/></p>
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
            <form action="/ui/v1/tradingPoints/edit/" method="post" id="updateForm">
                <div class="modal-body" id="updateModal">
                    <p>Name: <input type="text" name="name" value="" class="form-control update" id="nameUpdate"/></p>
                    <p>Description: <input type="text" name="description" value="" class="form-control update"/></p>
                    <p>Floor: <input type="text" name="floor" class="form-control"/></p>
                    <p>Square: <input type="text" name="square" class="form-control"/></p>
                    <p>Price per Day: <input type="text" name="pricePerDay" class="form-control"/></p>
                    <p>Is Conditioner: <input type="checkbox" name="isConditioner" class="form-control"/></p>
                    <p>Is Available: <input type="checkbox" name="isAvailable" class="form-control"/></p>
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