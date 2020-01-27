<#import "parts/login.ftl" as c>

<html>
<head>
    <title>Books Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>

<@c.logout/>
<span><a href="/user">User List</a> </span>
<br/>
<div>
    <form method="post" action="/products">
        <input type="text" name="name" placeholder="Введите название"/>
        <input type="text" name="brand" placeholder="Брэнд">
        <input type="number"  name="price" placeholder="Цена">
        <input type="number"  name="quantity" placeholder="Кол-во">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список сообщений</div>
    <form method="get" action="/products">
        <input type="text" name="filter" value="<#if filter??>${filter}</#if>">
        <button type="submit">Найти</button>
    </form>
<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">NAME</th>
        <th width="120">BRAND</th>
        <th width="120">PRICE</th>
        <th width="60">QUANTITY</th>
        <th width="60">Edit</th>
        <th width="60">Author</th>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </tr>
    <#list products as product>
        <tr>
            <td><span>${product.id}</span></td>
            <td><span>${product.name}</span></td>
            <td><span>${product.brand}</span></td>
            <td><span>${product.price}</span></td>
            <td><span>${product.quantity}</span></td>
            <td><span><a href="/products/${product.id}" >Edit</a></span></td>
            <td><span>${product.authorName}</span></td>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        </tr>
    <#else>
        No products
    </#list>
</table>
<br>
<a href="/leftovers">Page with leftovers</a>
</body>
</html>