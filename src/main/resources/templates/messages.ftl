<#include "parts/security.ftl">
<#import "parts/common.ftl" as l>

<@l.page>

<br/>
<div class="form-row ">
    <div class="form-row ">
        <div class="form-group col-md-12">
            <form method="get" action="/messages" class="form-inline">
                <input type="text" name="filter" class="form-control" value="<#if filter??>${filter}</#if>">
                <button type="submit" class="btn btn-primary ml-2" >Search</button>
            </form>
            <div/>
        <div/>
    <div class="form-group col-md-12">
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Add new Message
        </a>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form method="post" action="/messages">
                    <div class="form-group">
                        <input type="text" name="text" class="form-control" placeholder="Введите сообщение"/>
                    </div>
                    <div class="form-group">
                        <input type="text" name="tag" class="form-control" placeholder="Тег">
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary">Add</button>
                </form>
            </div>
        </div>

        <table class="tg">
            <tr>
                <th width="80">ID</th>
                <th width="120">TEXT</th>
                <th width="120">TAG</th>
                <th width="60">Author</th>
                <th width="60">Edit</th>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </tr>
            <#list messages as message>
                <tr>
                    <td><span>${message.id}</span></td>
                    <td><span>${message.text}</span></td>
                    <td><span>${message.tag}</span></td>
                    <td><span>${message.authorName}</span></td>
                    <td><span><a href="/messages/${message.id}/edit">Edit</a></span></td>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                </tr>
            <#else>
                No messages
            </#list>
        </table>
        <br>
</@l.page>