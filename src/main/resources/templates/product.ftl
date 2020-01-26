<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>User Details</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1>View Product</h1>
<br/><br/>
<#if product??>
<table border="0">
    <tr>
        <td>ID</td>
        <td>:</td>
        <td>${product.id}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>:</td>
        <td>${product.name}</td>
    </tr>
    <tr>
        <td>Brand</td>
        <td>:</td>
        <td>${product.brand}</td>
    </tr>
    <tr>
    <td>Price</td>
    <td>:</td>
    <td><#if product.quantity??>${product.price}</#if></td>
    </tr>
    <tr>
    <td>Quantity</td>
    <td>:</td>
    <td><#if product.quantity??>${product.quantity}</#if></td>
    </tr>
</table>
<br/><br/>
<#if allowDelete??>
<form action="/products/${product.id}/delete" method="POST">
    Delete this user? <input type="submit" value="Yes"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
</form>
</#if>
<#if allowDelete??>
<div>
    <a href="/products/${product.id}/edit">Edit</a> |
    <a href="/products/${product.id}/delete">Delete</a>
</div>
</#if>
</#if>
<#if errorMessage??>
<div class="error">{{errorMessage}}</div>
</#if>

</body>
</html>