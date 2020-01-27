<#import "parts/common.ftl" as l>

<@l.page>

<br/>
<div class="form-row ">
    <div class="form-group col-md-12">
        <form method="get" action="/products" class="form-inline">
            <input type="text" name="filter" class="form-control" value="<#if filter??>${filter}</#if>">
            <button type="submit" class="btn btn-primary ml-2" >Search</button>
        </form>
    <div/>
<div/>
<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new Product
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" action="/products">
            <div class="form-group">
                <input type="text" name="name" class="form-control" placeholder="Введите название"/>
            </div>
            <div class="form-group">
                <input type="text" name="brand" class="form-control" placeholder="Брэнд">
            </div>
            <div class="form-group">
                <input type="number"  name="price" class="form-control" placeholder="Цена">
            </div>
            <div class="form-group">
                <input type="number"  name="quantity" class="form-control" placeholder="Кол-во">
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>
</div>


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
</@l.page>