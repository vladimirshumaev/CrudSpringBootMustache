<#import "parts/common.ftl" as l>

<@l.page>
<div class="form-group col-md-12">
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Edit Message
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" action="/messages/${message.id}/edit">
                <div class="form-group">
                    <input type="text" name="text" class="form-control" placeholder="Введите сообщение"/>
                </div>
                <div class="form-group">
                    <input type="text" name="tag" class="form-control" placeholder="Тег">
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-primary">Edit</button>
            </form>
        </div>
    </div>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" action="/messages/${message.id}/delete">
                <button type="submit" class="btn btn-primary">Delete</button>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </form>
        </div>
    </div>
<br/>
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">TEXT</th>
            <th width="120">TAG</th>
            <th width="60">Author</th>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        </tr>
        <tr>
            <td><span>${message.id}</span></td>
            <td><span>${message.text}</span></td>
            <td><span>${message.tag}</span></td>
            <td><span>${message.authorName}</span></td>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        </tr>
    </table>
    <br>
</@l.page>