<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>

<head>
    <link rel="stylesheet" href="webjars/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>List TODO</title>

    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="../resources/static/css/style.css" />

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>TODO Manager</h2>
    </div>
</div>
<input type="button" onclick="window.location.href='showFormForAdd'; return false"
       class="add-button" value="Add New ToDo">
<br/><br/>

<div id="container">
    <div id="content">
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Description</th>

                <th scope="col">Date</th>

                <th scope="col">Action</th>
            </tr>


            <tbody>
            <c:forEach items="${todo}" var="todo">
            <tr>

                <td><fmt:formatDate value="${todo.datepicker}"
                                    pattern="dd/MM/yyyy" /></td>
                <td><c:url var="updateLink" value="/todo/showFormForUpdate">
                        <c:param name="todoId" value="${todo.id}" />
                    </c:url>
                    <c:url var="deleteLink" value="/todo/delete">
                        <c:param name="todoId" value="${todo.id}" />
                    </c:url>
            </tr>

            <tr>
                <td> ${todo.description} </td>
                <td> ${todo.datepicker} </td>

                <td>
                    <a href="${updateLink}">Update</a>
                    <a href="${deleteLink}">Delete</a>
                </td>

            </tr>

            </c:forEach>

        </table>

    </div>

</div>



</body>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
<script>
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>
<style>
    .footer {
        position: fixed;
        left: 0;
        bottom: 0;
        width: 100%;
        background-color: blue;
        color: white;
        height: 100px;
        text-align: center;
    }
</style>


<div class="footer">
    <h1>  ibm spring


    </h1>
</div>


</html>