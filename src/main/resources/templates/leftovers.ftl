<#import "parts/common.ftl" as c>

<@c.page>
<#list leftovers as leftover>
<div>
    <span>${leftover.name}</span>
    <span>${leftover.brand}</span>
    <span>${leftover.price}</span>
    <span>${leftover.quantity}</span>
</div>
</#list>
<br>
<a href="/products">Products</a>
</@c.page>