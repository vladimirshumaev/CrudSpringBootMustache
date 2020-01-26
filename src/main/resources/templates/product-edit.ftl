<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title><#if add>Create new Product<#else>Edit Product</#if></title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1><#if add>Create new Product<#else>Edit Product</#if></h1>
<a href="/products">Back to Product List</a>
<br/><br/>
<#--<form action="{{#add}}/products/add{{/add}}{{^add}}/products/{{product.id}}/edit{{/add}}" name="product" method="POST">-->
<form action="<#if add>/products/add<#else>/products/${product.id}/edit</#if>" name="product" method="POST">
    <table border="0">
        <#if product.id??>
        <tr>
            <td>ID</td>
            <td>:</td>
            <td>${product.id}</td>
        </tr>
        </#if>
        <tr>
            <td>Name</td>
            <td>:</td>
            <td><input type="text" name="name" value="<#if product.name??>${product.name}</#if>" /></td>
        </tr>
        <tr>
            <td>Brand</td>
            <td>:</td>
            <td><input type="text" name="email" value="<#if product.brand??>${product.brand}</#if>" /></td>
        </tr>
        <tr>
            <td>Price</td>
            <td>:</td>
            <td><input type="text" name="phone" value="<#if product.price??>${product.price}</#if>" /></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td>:</td>
            <td><input type="text" name="address" value="<#if product.quantity??>${product.quantity}</#if>" /></td>
        </tr>
    </table>
    <input type="submit" value="<#if add>Create<#else>Update</#if>" />
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
</form>

<br/>
</body>
</html>