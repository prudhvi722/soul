<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <title>Save New ToDo</title>
    <style>
        .error {color:red}
    </style>

    <link type="text/css"
          rel="stylesheet"
          href="css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="css/add-todo-style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>
.
<div id="wrapper">
    <div id="header">
        <h2><b>todo by prudhvi</b></h2>
    </div>
</div>

<div id="container">
    <h3>Save todo</h3>

    <form:form action="saveCustomer" modelAttribute="todo" method="POST">
        <form:hidden path="id" />
        <div class="form-group">
            <label>description:</label>
            <form:input path="description"/>
            <form:errors path="description" cssClass="error" />

        </div>


        <br/>
        <div class="form-group">
            <label path = "datepicker">Date </label>
            <input path = "datepicker" type="text" class="form-control"
                   required="required" >

            <script>  $('#sandbox-container input').datepicker({
                format: "yyyy-mm-dd"
            });
            $( "#datepicker" ).datepicker();

            </script>
            <form:input path="date"/>

        </div>
        <br/>
        <input type="submit" value="Save" class="save"/>
    </form:form>

    <p>
        <a href="${pageContext.request.contextPath}/todo/listToDo">Back to List</a>
    </p>

</div>

</body>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
<script>

</script>
<style>
    .footer {
        position: fixed;
        left: 0;
        bottom: 0;
        width: 100%;
        background-color: blue;
        color: white;
        height: 200px;
        text-align: center;
    }
</style>


<div class="footer">
    <h1>  ibm spring

    </h1>
</div>


</html>